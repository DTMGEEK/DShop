 package cn.dshop.web.action.user;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.service.user.BuyerService;
import cn.dshop.utils.WebUtil;

@Controller
public class BuyerLogoAction {
	
	@Resource BuyerService buyerService;
	
    private String username;
	
	private String password;
	
	private String faceboxlogin;
	
		
	private String prePage;
	
	
	
	
	
	
	
	
	
	public BuyerService getBuyerService() {
		return buyerService;
	}


	public void setBuyerService(BuyerService buyerService) {
		this.buyerService = buyerService;
	}


	public String getPrePage() {
		return prePage;
	}


	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}


	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * 用户登录
	 * @return
	 */


	public String BuyerLogo(){
		
	
		
		if((this.username.trim()!=null&&!"".equals(this.username.trim()))&&(this.password.trim()!=null&&!"".equals(this.password))){
	
		
			if(buyerService.validate(this.username, this.password)){
									
				ServletActionContext.getRequest().getSession().setAttribute("user", buyerService.find(this.username));
				ActionContext.getContext().put("message", "登录成功");
				
				
				
				
				ActionContext.getContext().put("semail", WebUtil.getBuyer(ServletActionContext.getRequest()).getEmail());
				
				System.out.println((String) ActionContext.getContext().getSession().get("directUrl"));
				//System.out.print(Base64.decodeBase64(ActionContext.getContext().getSession().get("directUrl").toString().getBytes()));
				
				/*//返回到登录前的页面  用于facebox 登录
				if(ActionContext.getContext().getSession().get("directUrl")!=null){
					
 					this.prePage=(String) ActionContext.getContext().getSession().get("directUrl");
					
					ActionContext.getContext().getSession().remove("directUrl");
					
					try {
						ServletActionContext.getResponse().sendRedirect(prePage);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}*/
				
				
					
				return "message";

			}else{
			
				
				ActionContext.getContext().put("error", "用户名或密码错误");
			
				
			}
			
			
			
		}
		
		
		
		return "logoerror";
		
	}
	
	
	

}
