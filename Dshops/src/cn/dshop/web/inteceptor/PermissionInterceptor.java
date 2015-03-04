package cn.dshop.web.inteceptor;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

import cn.dshop.bean.user.Buyer;
import cn.dshop.utils.WebUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class PermissionInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
	
		
		Buyer buyer=WebUtil.getBuyer(ServletActionContext.getRequest());
		
		String url=WebUtil.getRequestURIWithParam(ServletActionContext.getRequest());
		
		
		ActionContext.getContext().getSession().put("directUrl", url);
		
		if(buyer!=null){
			
			return invocation.invoke();
		}
		
		
		return "logoerror";//返回登录界面
	}

}
