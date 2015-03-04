package cn.dshop.web.action.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.bean.privilege.Gender;
import cn.dshop.bean.privilege.IDCard;
import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.bean.privilege.SystemPrivilege;
import cn.dshop.service.priviledge.EmployeeService;
import cn.dshop.service.priviledge.PrivilegeGroupService;
import cn.dshop.service.priviledge.SystemPriviledgeService;

/**
 * 系统初始化 (目前仅对部门管理和员工管理模块添加该功能)
 * @author Administrator
 *
 */
@Controller
public class SystemInitAction {

	@Resource SystemPriviledgeService systemPriviledgeService;	
	@Resource PrivilegeGroupService groupService;
	@Resource EmployeeService  employeeService;
 	
	
	/**
	 * 初始化系统
	 * @return
	 */
	public String initSystem(){
		
		
		this.initPriviledge();
		this.initPrivilegeGroup();
		this.initAdmin();
			
		ActionContext.getContext().put("message", "系统初始化成功");
	
		return "logo";
	}
	
	
	
	
	
	

	/**
	 * 初始化管理员
	 */	
	private void initPrivilegeGroup(){
		
		
		//if(groupService.getCount()==0){
			
			PrivilegeGroup group=new PrivilegeGroup();
			group.setName("系统权限组");
			group.getPrivileges().addAll(systemPriviledgeService.getScrollData().getResultList());
			groupService.save(group);
		
		//}

	}
	
	
	
	
	
	/**
	 * 初始化管理员
	 */
	private void initAdmin(){
		
		//if(employeeService.getCount()==0){
			
			Employee employee=new Employee();
			employee.setUsername("admin");
			employee.setPassword("123456");
			employee.setRealname("系统管理员");
			employee.setGender(Gender.MAN);
			employee.setIdCard(new IDCard("331378","深圳",new Date()));
			employee.getGroups().addAll(groupService.getScrollData().getResultList());
			employeeService.save(employee);	
			
			
			
		//}
		
	}
	
	
	
	/**
	 * 系统初始化权限
	 */
	private  void  initPriviledge(){
				
	
		//只允许执行一次
		//if(systemPriviledgeService.getCount()==0){
			
			List<SystemPrivilege> privileges=new ArrayList<SystemPrivilege>();
			privileges.add(new SystemPrivilege("department","view","部门查看"));
			privileges.add(new SystemPrivilege("department","insert","部门添加"));
			privileges.add(new SystemPrivilege("department","update","部门修改"));
			privileges.add(new SystemPrivilege("department","delete","部门删除"));
			
			
			
			privileges.add(new SystemPrivilege("employee","view","员工查看"));
			privileges.add(new SystemPrivilege("employee","insert","员工添加"));
			privileges.add(new SystemPrivilege("employee","update","员工修改"));
			privileges.add(new SystemPrivilege("employee","leave","员工离职"));
			privileges.add(new SystemPrivilege("employee","privilege","员工权限分配"));
			
					
			systemPriviledgeService.saves(privileges);
			

			

			
			
		//}
		//return null;
		
		
		
	}
	
	
	
	
	
}
