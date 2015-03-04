package cn.dshop.web.action.shopping;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.dshop.beans.BuyCart;
import cn.dshop.utils.WebUtil;

import com.opensymphony.xwork2.ActionContext;

@Controller
public class EditDeliverInfo {
	
	
private String recipients;
	
	private String address;
	
	private String email;
	
	private String postalcode;
	
	private String tel;
	/*参数地址*/
	private String directUrl;
	
	public String getRecipients() {
		return recipients;
	}
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDirectUrl() {
		return directUrl;
	}
	public void setDirectUrl(String directUrl) {
		this.directUrl = directUrl;
	}
	
	
public String diliverInfo(){
		



		ActionContext.getContext().put("semail", WebUtil.getBuyer(ServletActionContext.getRequest()).getEmail());

		BuyCart cart=WebUtil.getBuyCart(ServletActionContext.getRequest());
		
	
		
		
		if(cart.getDeliverInfo()!=null){
			
		   this.setRecipients(cart.getDeliverInfo().getRecipients());
		   this.setPostalcode(cart.getDeliverInfo().getPostcode());
		   this.setEmail(cart.getDeliverInfo().getEmail());
		   this.setAddress(cart.getDeliverInfo().getAddress());
		   this.setTel(cart.getDeliverInfo().getTel());
			
		}
		
	
		
 
		return "deliverinfo";
		
	}

}
