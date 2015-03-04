package cn.dshop.web.action.user;

import java.io.StringWriter;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.dshop.bean.user.Buyer;
import cn.dshop.mail.EmailSender;
import cn.dshop.service.user.BuyerService;
import cn.dshop.utils.MD5;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.opensymphony.xwork2.ActionContext;


/**
 * 找回密码
 * @author Administrator
 *
 */
@Controller
public class FindPasswrodAction {

	 @Resource  BuyerService buyerService;
	
	
	private String username;
	
	
	private String password;
	
	
	private String validateCode;
	
	
	
	
	
	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getValidateCode() {
		return validateCode;
	}




	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getpassword() throws ResourceNotFoundException, ParseErrorException, Exception{
		
		if(this.username!=null&&!"".equals(this.username.trim())){
		
			if(buyerService.exit(this.username.trim())){
				
				Buyer buyer=buyerService.find(this.username);
				Template template=Velocity.getTemplate("mailContent.html");
				VelocityContext context=new VelocityContext();
				context.put("username", buyer.getUsername());
				context.put("validateCode", MD5.MD5Encode(buyer.getUsername()+buyer.getPassword()));
				StringWriter writer=new StringWriter();
				template.merge(context, writer);
				String content=writer.toString();
				 EmailSender.send(buyer.getEmail().toString(),"DSHOP找回密码",content,"text/html");
				 return "password2";
			     
				
			}
			
			
			
		}else{
			
			ActionContext.getContext().put("message", "用户名不存在");
			
			
		}
		return "findpassword";
		
		
		
	}
	
	
	
	/**
	 * 显示密码修改界面
	 * @return
	 */
	
	public String update(){
		
		if(this.username!=null&&!"".equals(this.username.trim())){
			
			if(buyerService.exit(this.username.trim())){
				
				Buyer buyer=buyerService.find(this.username);
				String code=MD5.MD5Encode(this.username+this.password);
				if(code.equals(this.validateCode)){
					
					return "findPassword3";
				}
				
				
				
			}
			
			
			
		}
		
		return "errorresult";
		
	}
	
	
	/**
	 * 更新 新密码
	 * @return
	 */
	
	public String changepassword(){
		
		if(this.username!=null&&!"".equals(this.username.trim())){
			
			Buyer buyer=buyerService.find(this.username);
			String code=MD5.MD5Encode(this.username+this.password);
			if(code.equals(this.validateCode)){
				
				buyerService.updatePassword(buyer.getUsername(), buyer.getPassword().trim());
				ActionContext.getContext().put("message", "密码修改成功");
				return "logo";//返回登录界面
				
			}
			
			
		}
		return "errorresult";
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
