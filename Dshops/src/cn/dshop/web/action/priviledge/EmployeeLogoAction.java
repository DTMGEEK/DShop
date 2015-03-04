package cn.dshop.web.action.priviledge;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.service.priviledge.EmployeeService;


@Controller
public class EmployeeLogoAction {

@Resource	EmployeeService employeeService;
	
	
	
	
	private String username;
	
	private String password;
	

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
 * 后台用户登录
 * @return
 */

	public String backgroundLogo(){
		
		
		if((this.username.trim()!=null&&!"".equals(this.username.trim()))&&(this.password.trim()!=null&&!"".equals(this.password.trim()))){
			
			if(employeeService.validate(this.username, this.password)){
				
				ServletActionContext.getRequest().getSession().setAttribute("employee", employeeService.find(this.username));
			
				return "logosuccess";
				
			}
		
		}
		
		ActionContext.getContext().put("logoerr", "用户名或密码错误");
		return "logoerr";
		
	
	}
	
	
	
}
