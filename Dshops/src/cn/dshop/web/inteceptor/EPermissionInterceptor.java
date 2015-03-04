package cn.dshop.web.inteceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.bean.privilege.SystemPrivilege;
import cn.dshop.bean.privilege.SystemPrivilegePK;
import cn.dshop.web.action.priviledge.Permission;
import cn.dshop.web.action.priviledge.ValidatePermission;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class EPermissionInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		ActionContext context =invocation.getInvocationContext();
		ActionProxy proxy =invocation.getProxy();
		String methodName =proxy.getMethod();
		Object action =proxy.getAction();
		
		//String auth=null;
		
		HttpServletRequest request =ServletActionContext.getRequest();
		
		if(request.getRequestURI().startsWith("/control/priviledge")){
			
			if(!validate(action.getClass(),methodName,request)){
				
				ActionContext.getContext().put("message", "您没有该操作的权限");
				
				
				return "errormessage";
			}
			
		}
		
		return invocation.invoke();
		
		
		
	}
	
	
	
	
	private boolean validate(Class clazz,String methodName,HttpServletRequest request) throws NoSuchMethodException{
		
		Permission permission =ValidatePermission.parsePermission(clazz, methodName, null);
		
		SystemPrivilege methodPrivilege = new SystemPrivilege( 
			    new SystemPrivilegePK(permission.module(), permission.privilege())); 
		
		request=ServletActionContext.getRequest();
		
		Employee employee =(Employee) request.getSession().getAttribute("employee");
		
		for(PrivilegeGroup p:employee.getGroups()){
			
			if(p.getPrivileges().contains(methodPrivilege)){
				
				return true;
			}
			
			
			
		}
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
