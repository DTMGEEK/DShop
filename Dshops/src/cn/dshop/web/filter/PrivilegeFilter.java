package cn.dshop.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.utils.WebUtil;

/**
 * 后台登录过滤器
 * @author Administrator
 *
 */
public class PrivilegeFilter implements Filter {

	public void destroy() {
	

	}

	/**
	 *  检测用户是否登录
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) req;
		Employee employee=WebUtil.getEmployee(request);
		if(employee==null){
			HttpServletResponse response=(HttpServletResponse) res;
			response.sendRedirect("/control/main/bglogo");
			

		}else{
			
			chain.doFilter(req, res);
			
			
		}
		
	}
	
	
	

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
