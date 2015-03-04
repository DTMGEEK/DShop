package cn.dshop.web.action.priviledge;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.bean.privilege.SystemPrivilegePK;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.priviledge.PrivilegeGroupService;
import cn.dshop.service.priviledge.SystemPriviledgeService;


/**
 * 得到全部权限组
 * @author Administrator
 *
 */
@Controller
public class PrivilegeGroupAction extends BaseForm {

	@Resource PrivilegeGroupService privilegeGroupService;

	@Resource SystemPriviledgeService priviledgeService;
	
	
	private String name;
	
	private String groupid;
	
	private SystemPrivilegePK[] privileges;

	
	
	
	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getGroupid() {
		return groupid;
	}






	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}






	public SystemPrivilegePK[] getPrivileges() {
		return privileges;
	}






	public void setPrivileges(SystemPrivilegePK[] privileges) {
		this.privileges = privileges;
	}





	@Permission(module="employee",privilege="view")//这方法必须具备设置离职权限
	public String privilegeGroup(){
		
	
			int maxResult=12;
			
			PageView<PrivilegeGroup> pageview=new PageView<PrivilegeGroup>(maxResult,this.getPage());
			
			QueryResult<PrivilegeGroup> qr=privilegeGroupService.getScrollData(pageview.getFirstResult(), maxResult);
			pageview.setQueryResult(qr);
			ActionContext.getContext().put("pageView",pageview);
			 		
			ActionContext.getContext().put("privileges", priviledgeService.getScrollData().getResultList());
		
		 
		 return "privilegegroup";
		
		
	}
	
	
	
	
	
}
