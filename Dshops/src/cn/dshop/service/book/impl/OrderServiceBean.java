package cn.dshop.service.book.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import cn.dshop.bean.book.Order;
import cn.dshop.bean.book.OrderContactInfo;
import cn.dshop.bean.book.OrderItem;
import cn.dshop.bean.book.OrderState;
import cn.dshop.bean.book.PaymentWay;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.bean.user.Buyer;
import cn.dshop.bean.user.ContactInfo;
import cn.dshop.beans.BuyCart;
import cn.dshop.beans.BuyItem;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.book.OrderService;

@Service 
public class OrderServiceBean extends DAOSupport<Order> implements OrderService {

	//线程锁 防止多个用户同时生成同一个订单号
	public synchronized Order createOrder(BuyCart cart,String username){
		
		/*从购物车中获取商品信息*/
		
		Order order=new Order();
		Buyer buyer=em.find(Buyer.class, username);
		order.setBuyer(buyer);
		order.setDeliverFee(cart.getDeliveFee());
		order.setNote(cart.getNote());
		
		
		cart.setContactInfo(new OrderContactInfo());
		cart.getContactInfo().setAddress(cart.getDeliverInfo().getAddress());
		cart.getContactInfo().setBuyerName(cart.getDeliverInfo().getRecipients());
		cart.getContactInfo().setEmail(cart.getDeliverInfo().getEmail());
		cart.getContactInfo().setPostalcode(cart.getDeliverInfo().getPostcode());
		cart.getContactInfo().setTel(cart.getDeliverInfo().getTel());
		
		order.setOrderContactInfo(cart.getContactInfo());
		
		
		
		order.setOrderDeliverInfo(cart.getDeliverInfo());
		order.setState(OrderState.WAITDELIVER);
		order.setPaymentWay(cart.getPaymentWay());
		order.setTotalPrice(cart.getTotalPrice());
		order.setProductTotalPrice(cart.getTotalPrice());
		order.setPayablefee(cart.getTotalPrice());
		order.setOrderid(this.buildOrderid(order.getCreateDate()));
		

		
		
		for(BuyItem item:cart.getItems()){
			
			ProductStyle style=item.getProduct().getStyles().iterator().next();
			
			OrderItem orditem=new OrderItem(item.getProduct().getName(),item.getProduct().getId(),item.getProduct().getSellprice(),item.getAmount(),style.getName(),style.getId());
			
			order.addOrderItem(orditem);
		}
		
		//用户注册是没填写完整资料  在订单中获取填入
		if(buyer.getContactInfo()==null){

		
		    buyer.setContactInfo(new ContactInfo())	;
			buyer.getContactInfo().setAddress(cart.getDeliverInfo().getAddress());
			buyer.getContactInfo().setPostalcode(cart.getDeliverInfo().getPostcode());
			buyer.getContactInfo().setPhone(cart.getDeliverInfo().getTel());
			buyer.getContactInfo().setMobile(cart.getDeliverInfo().getTel());
	
			
			if(buyer.getRealname()==null){
				
				buyer.setRealname(cart.getDeliverInfo().getRecipients());
				
			}
				
				//buyer.getContactInfo().setAddress(order.getOrderDeliverInfo().getAddress());
				buyer.getContactInfo().setAddress("ContactInfo Address");
				
			
		
		}
		order.setOrderid(buildOrderid(order.getCreateDate()));
		
		
		this.save(order);
		
		return order;
		
	}
	
	
	
	/**
	 * 生成订单号，订单号组成 :两位年份 +两位月份+两位日期+(当天订单总数+1)    如果不够前面补0
	 * @return
	 */
	public String buildOrderid(Date date){
		
       SimpleDateFormat dateFormat=new SimpleDateFormat("yyMMdd");		 
	   StringBuilder sb=new StringBuilder(dateFormat.format(date));
	   dateFormat =new SimpleDateFormat("yyyy-MM-dd");
	try {
		   
		Date now=dateFormat.parse(dateFormat.format(date));
		Query query=em.createQuery(" select count(o) from Order o where o.createDate>?1 ");
		query.setParameter(1, now);
		
		Long  count=(Long) query.getSingleResult();
	    sb.append(fillZero(8,String.valueOf(count+1)));		
		

	} catch (ParseException e) {

	      throw new RuntimeException("生成订单错误");
	}
	   
		return sb.toString();
	
	
	}

/**
 * 补零
 * @param length 补零长度
 * @param source 需要补零的字符串
 * @return
 */
	private String fillZero(int length, String source) {
		
		StringBuilder result=new StringBuilder(source);
		for(int i=result.length();i<length;i++){	
			result.insert(0, '0');
			
		}
		return result.toString();
		

	}
	

   /**
    * 修改配送费	
    * @param orderid
    * @param fee
    */
	public void updateDiliverFee(String orderid,float fee){
		
		Order order=this.find(orderid);
		order.setDeliverFee(fee);
		order.setTotalPrice(order.getProductTotalPrice()+order.getDeliverFee());
		order.setPayablefee(order.getTotalPrice());

	}
	
	
	
	/**
	 * 取消订单
	 * @param orderid
	 */
	
	public void cancelOrder(String orderid){
		
		Order order=this.find(orderid);
		
		if(!OrderState.RECEIVED.equals(order.getState())){
			
			order.setState(OrderState.CANCEL);
				
		}
		
		order.setLockuser(null);
		
	}
	
	/**
	 * 确认订单
	 * @param orderid
	 */	
	public void confirmOrder(String orderid){
		
		Order order=this.find(orderid);
		
		if(OrderState.WAICONFIRM.equals(order.getState())){
		//支付方式不是货到付款并且未支付 转入等待付款状态	
			if(PaymentWay.COD.equals(order.getPaymentWay())&& order.getPaymentstate()){
				
				order.setState(OrderState.WAITPAYMENT);
				
			//支付方式是货到付款	 转入等待发货状态
			}else{ 
				
				order.setState(OrderState.ADMEASUREPRODUCT);
				
			}
			
			
		}
		order.setLockuser(null);
		
	}
	
	
	/**
	 * 财务确认付款
	 * @param orderid
	 */
	public void confirmPayment(String orderid){
		
		Order order=this.find(orderid);
		order.setPaymentstate(true);
		
		//订单处于等待付款状态  转换为正在配货状态
		if(OrderState.WAITPAYMENT.equals(order.getState())){
			
			order.setState(OrderState.ADMEASUREPRODUCT);
			
	    // 当订单状态为已发货时   并且支付方式为货到付款 订单设置为已收货 
		}else if(OrderState.DELIVER.equals(order.getState())&& PaymentWay.COD.equals(order.getPaymentWay())){
			
			
			order.setState(OrderState.RECEIVED);
			
		}

		
	}
	
	/**
	 * 把订单设置为等待发货状态
	 * @param orderid
	 */
	public void turnWaitdeliver(String orderid){
		
		Order order=this.find(orderid);
		
		//订单是否处于已付款状态  转换为发货状态
		if(OrderState.ADMEASUREPRODUCT.equals(order.getState())){
			
			order.setState(OrderState.WAITDELIVER);
			
		}
		
	}
	
	
	/**
	 * 把订单设置为已发货状态
	 * @param orderid
	 */	
	public void  trunDelivered(String orderid){
		
		Order order=this.find(orderid);
		
		//订单是否处于等待发货状态  转换为以发货状态
		if(OrderState.WAITDELIVER.equals(order.getState())){
			
			order.setState(OrderState.DELIVER);
			
		}
		
		

	}
	
	
	
	/**
	 * 把订单设置为已收货状态
	 * @param orderid
	 */

	public void turnReceived(String orderid){
		
		Order order=this.find(orderid);
		
		//订单是否处于已发货   转换为已收货状态
		if(OrderState.DELIVER.equals(order.getState())){
			
			order.setState(OrderState.RECEIVED);
		
		}
		
		
	}
	
	
	
	
	
	/**
	 *订单加锁
	 *即使提交回数据库
	 */
	public Order addLock(String orderid,String username){
		
		Query qrery=em.createQuery(" update Order o set o.lockuser=?1 where o.orderid=?2 and o.lockuser is null and o.state=?3");
		qrery.setParameter(1, username);
		qrery.setParameter(2, orderid);
		qrery.setParameter(3, OrderState.WAICONFIRM);
		qrery.executeUpdate();
		em.flush();
		return this.find(orderid);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	/**
	 * 解锁订单
	 * @param orderids
	 */
	public void unlock(String...orderids){
	
		if(orderids!=null&&orderids.length>0){
			
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<orderids.length;i++){
				
				sb.append('?').append(i+2).append(',');
								
			}
			
			sb.deleteCharAt(sb.length()-1);
			Query query=em.createQuery("update Order o set o.lockuser=?1 where o.orderid in("+ sb +")");
			query.setParameter(1, null);
			for(int i=0;i<orderids.length;i++){
				
				query.setParameter(i+2, orderids[i]);
				
			}
			
			query.executeUpdate();
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
