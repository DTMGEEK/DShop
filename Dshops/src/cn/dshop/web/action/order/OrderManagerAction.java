package cn.dshop.web.action.order;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.book.Order;
import cn.dshop.bean.book.OrderContactInfo;
import cn.dshop.bean.book.OrderState;
import cn.dshop.bean.book.PaymentWay;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.book.OrderContactInfoService;
import cn.dshop.service.book.OrderService;

@Controller
public class OrderManagerAction extends BaseForm {
	
	 @Resource OrderContactInfoService orderContactInfoService;
	 
	 @Resource OrderService orderService;
	 
	/*订单id*/
	private String orderid;
	/*联系信息id*/
	private Integer contactid;
	/*用户姓名*/
	private String buyer;
	/*用户地址*/
	private String buyer_address;
	/*用户邮编*/
	private String buyer_postalcode;
	/*用户电话*/
	private String buyer_tel;
	/*修改后的配送费*/
	private float deliverFee;

	
	


	public float getDeliverFee() {
		return deliverFee;
	}




	public void setDeliverFee(float deliverFee) {
		this.deliverFee = deliverFee;
	}




	public String getOrderid() {
		return orderid;
	}




	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}




	public Integer getContactid() {
		return contactid;
	}




	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}




	public String getBuyer() {
		return buyer;
	}




	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}




	public String getBuyer_address() {
		return buyer_address;
	}




	public void setBuyer_address(String buyerAddress) {
		buyer_address = buyerAddress;
	}




	public String getBuyer_postalcode() {
		return buyer_postalcode;
	}




	public void setBuyer_postalcode(String buyerPostalcode) {
		buyer_postalcode = buyerPostalcode;
	}




	public String getBuyer_tel() {
		return buyer_tel;
	}




	public void setBuyer_tel(String buyerTel) {
		buyer_tel = buyerTel;
	}



//显示修改用户联系信息 为修改jsp显示
	public String showModifyContactorInfo(){
		
		OrderContactInfo contact=orderContactInfoService.find(contactid);
		
		ActionContext.getContext().put("contactInfo", contact);
	
	   return "showmodifyContactinfo";
			
	}
	
	
	
	//修改用户联系信息后同步回数据库	
	public String modifyContactorInfo(){
		
		OrderContactInfo contact=orderContactInfoService.find(contactid);
		
		contact.setBuyerName(this.buyer);
		contact.setAddress(this.buyer_address);
		contact.setPostalcode(this.buyer_postalcode);
		contact.setTel(this.buyer_tel);
		
		orderContactInfoService.update(contact);
		
		//ActionContext.getContext().put("mcontectid", this.contactid);
		
		
		return "modifyContactinfo";
		
	}
	
	
	//修改配送费
	public String modifyDeliverFee(){
		
		
		orderService.updateDiliverFee(this.orderid, this.deliverFee);
		
		
		//返回到订单浏览界面
		return "showorderform";
		
	}
	
	
	/**
	 * 打印订单
	 * @return
	 */

	public String printOrder(){
		
	    ActionContext.getContext().put("order", orderService.find(this.orderid));
	    
	   return "print";
		
	
	}
	
	
	/*订单流转*/
	
	/**
	 * 取消订单
	 * @return
	 */
	
	public String cancelOrder(){
		
		orderService.cancelOrder(this.orderid);
		
		ActionContext.getContext().put("message", "订单取消成功");
		
		//返回待审核状态列表
		return "orderlist";
	
	}
	
	
	/**
	 * 审核通过订单
	 * @return
	 */
	public String confirmOrder(){
		
		orderService.confirmOrder(this.orderid);
		
		ActionContext.getContext().put("message", "订单确认成功");
		
		
		//返回待审核状态列表
		return "orderlist";
	}
	
	
	
	
	
	
	
	/**
	 * 财务确认已付款
	 * @return
	 */
	public String confirmPayment(){
		
		orderService.confirmPayment(this.orderid);
		
       ActionContext.getContext().put("message", "订单已经设为已付款状态");
				
		//返回等待付款列表
		return "waitpay";

	}
	
	
	
	
	/**
	 * 把订单设置为等待发货状态
	 * @return
	 */
	
	public String trunWaitdeliver(){
		
		
		orderService.turnWaitdeliver(this.orderid);
		
		 ActionContext.getContext().put("message", "订单已经设为待发货状态");
		 
		 ActionContext.getContext().put("constate", OrderState.RECEIVED);
		 
		 //返回正在配货 加入state状态
		 return "turndeliver";
		
	}
	
	
	
	
	
	/**
	 * 设置为已发货
	 * @return
	 */

	public String trunDelivered(){
		
		orderService.trunDelivered(this.orderid);
		
		 ActionContext.getContext().put("message", "订单已经设为已经发货状态");
	 
		//返回待审核状态列表
			return "delivered";

	}
	
	
	/**
	 * 设置为已收货状态
	 * @return
	 */
	public String turnReceived(){
		
		orderService.turnReceived(this.orderid);
		
		orderService.trunDelivered(this.orderid);
		
		ActionContext.getContext().put("message", "订单已经设为已收货状态");
	 
		//返回待审核状态列表
	     return "received";
		
	}
	
	
	/*订单流转*/
	
	
	
	/**
	 * 解锁订单
	 */
	public String unlock(String...orderids){
		
	
		orderService.unlock(this.orderid);
		
		return "unlock";
		
		
	}
	

}
