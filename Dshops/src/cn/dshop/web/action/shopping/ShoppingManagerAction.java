package cn.dshop.web.action.shopping;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.book.DeliverWay;
import cn.dshop.bean.book.Order;
import cn.dshop.bean.book.OrderDeliverInfo;
import cn.dshop.bean.book.PaymentWay;
import cn.dshop.beans.BuyCart;
import cn.dshop.service.book.OrderService;
import cn.dshop.utils.WebUtil;

@Controller
public class ShoppingManagerAction  {
	
	
	@Resource OrderService orderService;
	
	
	
	private OrderDeliverInfo delinfo;
	
	private String directUrl;
	
	/*附言*/
	private String note;
	

	
	



	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getDirectUrl() {
		return directUrl;
	}


	public void setDirectUrl(String directUrl) {
		this.directUrl = directUrl;
	}


	public OrderDeliverInfo getDelinfo() {
		return delinfo;
	}


	public void setDelinfo(OrderDeliverInfo delinfo) {
		this.delinfo = delinfo;
	}
	


/**
 * 保存配送信息到购物车中
 * @return
 */
	public String saveDeliInfo(){
		
		
		BuyCart cart=WebUtil.getBuyCart(ServletActionContext.getRequest());
		            
		if(cart.getDeliverInfo()==null) cart.setDeliverInfo(this.delinfo);

		cart.getDeliverInfo().setRecipients(delinfo.getRecipients());
		cart.getDeliverInfo().setPostcode(delinfo.getPostcode());
		cart.getDeliverInfo().setEmail(delinfo.getEmail());
		cart.getDeliverInfo().setAddress(delinfo.getAddress());
		cart.getDeliverInfo().setTel(delinfo.getTel());
		
		
		if(!"".equals(this.directUrl)){
			
			return "backtoconfirm";
			
		}
		
		return "payway";
		
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 保存用户选择的送货与支付方式
	 * @return
	 */
	public String savePaymentWay(){
			
		
		
		
		
		BuyCart cart=WebUtil.getBuyCart(ServletActionContext.getRequest());
		
		if("".equals(cart.getDeliverInfo().getRecipients())){	
			ActionContext.getContext().put("nonedelinfo", "请输入送货信息");
			return "payway";
			
		}
		
	
		cart.getDeliverInfo().setDeliverWay(delinfo.getDeliverWay());
		cart.setPaymentWay(delinfo.getPaymentWay());
		
		
		
		String url="/buyer/list/savepayway.action";
		ActionContext.getContext().put("directUrl",new String(Base64.encodeBase64(url.getBytes())));
		
		
    

		return "confirminfo";
		
	   
	}
	
	/**
	 * 返回修改购物车里购买数量和物品
	 * @return
	 */
	
	
	/*public String backEditCartItem(){
		
		
		String url="/buyer/list/savepayway.action";
		ActionContext.getContext().put("directUrl",new String(Base64.encodeBase64(url.getBytes())));
		
		return "edititm";
		
		
		
	}
	
	*/
	
	/**
	 * 保存订单信息 
	 */
	
	
	public String  saveOrder(){
		
		
		
		BuyCart cart=WebUtil.getBuyCart(ServletActionContext.getRequest());
		cart.setNote(this.note);
		
		Order order=orderService.createOrder(cart, WebUtil.getBuyer(ServletActionContext.getRequest()).getUsername());
	
		ActionContext.getContext().put("order", order);
		WebUtil.deleteBuyCart(ServletActionContext.getRequest());


		if(PaymentWay.COD.equals(cart.getPaymentWay())){
			
			return "cod";
			
		}
		
		if(PaymentWay.NET.equals(cart.getPaymentWay())){
			
			return "net";
		}
		
		if(PaymentWay.BANKREMITTANCE.equals(cart.getPaymentWay())){
			
			
			return "bankremittance";
		}
		
		if(PaymentWay.POSTOFFICEREMITTANCE.equals(cart.getPaymentWay())){
			
			return "postofficeremittance";
		}
		
		

		
		return "error";
		

	}
	

	
	
	
	
	

}
