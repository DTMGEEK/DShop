package cn.dshop.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.bean.privilege.SystemPrivilege;
import cn.dshop.bean.privilege.SystemPrivilegePK;
import cn.dshop.utils.WebUtil;


/**
 * 权限自定义标签
 * @author Administrator
 *
 */
public class PermissionTag extends TagSupport {
	
	/*部门*/
	private String module;
	/*权限*/
	private String privilege;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	
	
	@Override
	public int doStartTag() throws JspException {
		boolean result=false;
		
		Employee employee=WebUtil.getEmployee(ServletActionContext.getRequest());
		SystemPrivilege privilege =new SystemPrivilege(new SystemPrivilegePK(this.module,this.privilege));
		
		for(PrivilegeGroup group:employee.getGroups()){
			
			if(group.getPrivileges().contains(privilege)){
				
				result=true;
				
				break;
	
			}
			
		}
	
		return result?EVAL_BODY_AGAIN:SKIP_BODY;
	}
	
	
	
	
	

}
