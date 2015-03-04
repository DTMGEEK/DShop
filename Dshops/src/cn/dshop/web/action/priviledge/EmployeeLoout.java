package cn.dshop.web.action.priviledge;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;


@Controller
public class EmployeeLoout {

	
	public String backgroundLogOut(){
		
		
		ServletActionContext.getRequest().getSession().removeAttribute("employee");
		
		
		return "logosuccess";
		
		
	}
	
	
	
}
