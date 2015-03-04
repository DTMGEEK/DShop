package cn.dshop.web.action.priviledge;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.privilege.Department;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.priviledge.DepartmentService;

/**
 * 部门管理
 * @author Administrator
 *
 */

@Controller

public class DeparetmentManagerAction extends BaseForm {

	
	@Resource DepartmentService departmentService;
	
	private String departmentid;
	
	
	
	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}



	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * 增加新部门
	 * @return
	 */
	@Permission(module="department",privilege="insert")//这方法必须具备添加权限
	public String addDepartment(){
		
		
		Department department=new Department();
		department.setName(this.name);
		departmentService.save(department);
		
		ActionContext.getContext().put("message", "增加新部门成功");
		
		return "dealdepart";
		
	}
	
	
	
	/**
	 * 修改部门名称
	 * @return
	 */	
	@Permission(module="department",privilege="update")//这方法必须具备更新权限
	public String editDepartment(){
		
		
		Department department = departmentService.find(this.departmentid);
		department.setName(this.name);

		departmentService.update(department);
		ActionContext.getContext().put("message", "修改部门成功");
		
		return "dealdepart";
				
	}
	
	
	
	/**
	 * 删除部门
	 * @return
	 */
	@Permission(module="department",privilege="delete")//这方法必须具备删除权限
	public String delDepartmetn(){
		
		
		departmentService.delete(this.departmentid);	
		ActionContext.getContext().put("message", "删除部门成功");
		
		return "dealdepart";
				
		
	}
	
	
	
	
	
	
	
	
}
