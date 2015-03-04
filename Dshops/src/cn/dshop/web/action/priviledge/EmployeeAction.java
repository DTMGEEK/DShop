package cn.dshop.web.action.priviledge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.priviledge.DepartmentService;
import cn.dshop.service.priviledge.EmployeeService;

/**
 * 员工分页显示
 * @author Administrator
 *
 */
@Controller
public class EmployeeAction extends BaseForm {
	
	@Resource EmployeeService employeeService;
	
	@Resource DepartmentService departmentService;
	
	/*用户名*/
	private String username;
	
	/*部门id*/
	private String departmentid;

	/*真实姓名*/
	private String realname;
	
	/*标识*/
	private String query;

	
	
	
	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Permission(module="employee",privilege="view")//这方法必须具备查看权限
	public String allEmployee(){
		
		int maxResult=12;
		
		PageView<Employee> pageview=new PageView<Employee> (maxResult,this.getPage());
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
		orderby.put("realname", "desc");
		
		
		if(this.query!=null&&!"".equals(this.query)){
		
			StringBuilder hql=new StringBuilder();
			List<Object> params=new ArrayList<Object>();
			
			//员工用户名查询
			if(this.username.trim()!=null&& !"".equals(this.username.trim())){
				
				params.add("%"+this.username.trim()+"%");
				hql.append(" o.username like ?").append(params.size());

				ActionContext.getContext().put("eusername", this.username);
			}
			//员工真实姓名查询
			if(this.realname.trim()!=null&&!"".equals(this.realname.trim())){
				
				if(!params.isEmpty()) hql.append(" and ");
				
				params.add("%"+this.realname.trim()+"%");
				hql.append(" o.realname like ?").append(params.size());
				
				ActionContext.getContext().put("erelname", this.realname);
				
			}
			//员工部门查询
			if(this.departmentid!=null&&!"".equals(this.departmentid)){
				
				if(!params.isEmpty()) hql.append(" and ");
				
				params.add(this.departmentid);
				hql.append(" o.department.departmentid=?").append(params.size());
				
				ActionContext.getContext().put("edepartmentid", this.departmentid);
				
			}
			
			QueryResult<Employee> qr=employeeService.getScrollData(pageview.getFirstResult(), maxResult, hql.toString(), params.toArray(), orderby);
			pageview.setQueryResult(qr);
			

		}else{
			
			QueryResult<Employee> qr=employeeService.getScrollData(pageview.getFirstResult(), maxResult,  orderby);
			pageview.setQueryResult(qr);
			
		}
		
				
		ActionContext.getContext().put("pageView",pageview);
	    
		ActionContext.getContext().put("departments", departmentService.getScrollData().getResultList());
		
		return "allemployee";
		
		
		
	}
	
	
	
	
	
	
	
	
}
