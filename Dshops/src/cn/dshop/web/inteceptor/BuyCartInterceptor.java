package cn.dshop.web.inteceptor;

import org.apache.struts2.ServletActionContext;

import cn.dshop.bean.user.Buyer;
import cn.dshop.beans.BuyCart;
import cn.dshop.utils.WebUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 检验购物车里是否有商品 拦截器
 * @author Administrator
 *
 */
public class BuyCartInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {

		
		BuyCart cart=WebUtil.getBuyCart(ServletActionContext.getRequest());
		
		if(cart==null||cart.getItems().isEmpty()){
			
			ActionContext.getContext().put("message", "目前你的购物车中没有商品，请购买商品后再执行该操作");
			
			return "carterror";
			
		}else{
			
			return invocation.invoke();
			
			
		}
	}

}
