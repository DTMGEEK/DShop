package cn.dshop.web.inteceptor;

import org.apache.struts2.ServletActionContext;

import cn.dshop.bean.privilege.Employee;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 后台登录拦截器
 * @author Administrator
 *
 */
public class BgPermissionInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2917169444617240472L;

	public void destroy() {


	}

	public void init() {


	}

	public String intercept(ActionInvocation invocation) throws Exception {

		
		Employee employee=(Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
		
		if(employee!=null){
			
			invocation.invoke();
			
			
			
		}
		
		
		return "bglogoerro";
	}

}
