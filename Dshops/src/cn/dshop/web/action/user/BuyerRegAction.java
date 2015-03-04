package cn.dshop.web.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.dshop.bean.user.Buyer;
import cn.dshop.service.user.BuyerService;


@Controller
public class BuyerRegAction extends ActionSupport {
	
	@Resource BuyerService buyerService;
	
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String realname;
	
	private String validateCode;
	
	private boolean flag=false;
	
	
	
	


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRealname() {
		return realname;
	}



	public void setRealname(String realname) {
		this.realname = realname;
	}



	public String getValidateCode() {
		return validateCode;
	}



	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}






	public String reg(){
		
		
		if(buyerService.exit(this.userName.trim())){
			
			ActionContext.getContext().put("message", "用户存在");
			return "regMessage";
			
		}else{
			
			Buyer buyer=new Buyer();
	
			buyer.setUsername(this.userName.trim());
			buyer.setPassword(this.password.trim());
			buyer.setEmail(this.email.trim());
			buyerService.save(buyer);
			ActionContext.getContext().put("message", "注册成功");
			
		}
		

		return "regMessage";
		
	}
	
	



	public String checkLogin() {
		
		this.flag=buyerService.exit(this.userName);
		
		//System.out.print(this.flag);
			
		
			
		        /*   ActionContext.getContext().put("userexit", "用户名存在");
	
			}else{
				
				ActionContext.getContext().put("userexit", "用户名可以使用");
				
				
			}*/
		
		  
		return Action.SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	

}
