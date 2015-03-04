package cn.dshop.web.action.priviledge;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.bean.privilege.SystemPrivilege;
import cn.dshop.bean.privilege.SystemPrivilegePK;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.priviledge.PrivilegeGroupService;
import cn.dshop.service.priviledge.SystemPriviledgeService;

/**
 * 权限组CRUD
 * @author Administrator
 *
 */
@Controller
public class PrivilegeGroupManagerAction extends BaseForm {
	
	@Resource PrivilegeGroupService privilegeGroupService;
	
	@Resource SystemPriviledgeService priviledgeService;
	
	
	private String name;
	
	private SystemPrivilegePK[] privileges;
	
	private String groupid;
	
	

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public SystemPrivilegePK[] getPrivileges() {
		return privileges;
	}

	public void setPrivileges(SystemPrivilegePK[] privileges) {
		this.privileges = privileges;
	}

	/**
	 * 增加新权限组 并添加权限
	 * @return
	 */
	@Permission(module="employee",privilege="privilege")//这方法必须具备设置离职权限
	public String add(){
		
	
	
		
		PrivilegeGroup group=new PrivilegeGroup();
		
		group.setName(this.name);
		
		
		for(SystemPrivilegePK id:this.privileges){
			
			group.addSystemPrivilege(new SystemPrivilege(id));
			
		}

		privilegeGroupService.save(group);
		
		ActionContext.getContext().put("message", "权限组添加成功");
		
		return "dealprivilege";
		
	}
	
	
	/**
	 * 显示权限修改界面
	 * @return
	 */
	@Permission(module="employee",privilege="privilege")//这方法必须具备设置离职权限
	public String showedit(){
				
		PrivilegeGroup group=privilegeGroupService.find(groupid);
		ActionContext.getContext().put("egroupid", this.groupid);
		ActionContext.getContext().put("groupname", group.getName());
		ActionContext.getContext().put("selectprivileges", group.getPrivileges());
		ActionContext.getContext().put("privileges", priviledgeService.getScrollData().getResultList());
		
		return "showedit";
	
	}
	
	
	
	/**
	 * 修改权限组
	 * @return
	 */
	@Permission(module="employee",privilege="privilege")//这方法必须具备设置离职权限
	public String edit(){
		
		
		PrivilegeGroup group=privilegeGroupService.find(groupid);
		
		group.setName(this.name);
		group.getPrivileges().clear();
		
		for(SystemPrivilegePK id: this.privileges)
			
			group.addSystemPrivilege(new SystemPrivilege(id));
			
		privilegeGroupService.update(group);
		
		ActionContext.getContext().put("message", "权限组修改成功");
       
	
		return "dealprivilege";
	
	}
	
	
	
	
	
	
/**
 * 删除权限组
 * @return
 */
	@Permission(module="employee",privilege="privilege")//这方法必须具备设置离职权限
	public String deletePriGuoup(){
		
	   
		privilegeGroupService.delete(this.groupid);
		
		ActionContext.getContext().put("message", "权限删除成功");

    	return "dealprivilege";
		
	}
	
	
	
	
	
	
	

}
