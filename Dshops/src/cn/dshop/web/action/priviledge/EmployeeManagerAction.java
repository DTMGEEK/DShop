package cn.dshop.web.action.priviledge;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import cn.dshop.bean.privilege.Department;
import cn.dshop.bean.privilege.Employee;
import cn.dshop.bean.privilege.Gender;
import cn.dshop.bean.privilege.IDCard;
import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.priviledge.EmployeeService;
import cn.dshop.service.priviledge.PrivilegeGroupService;


@Controller
public class EmployeeManagerAction extends BaseForm {
	
	
	@Resource EmployeeService employeeService;
	
	@Resource PrivilegeGroupService privilegeGroupService; 
	

	/*用户名*/
	private String username;
	/*密码*/
	private String password;
	/*真实姓名*/
	private String realname;
	/*性别*/
	private Gender gender;
	/*身份证号码*/
	private String cardno;
	/*生日*/
	private Date birthday;
	/*地址*/
	private String address;
	/*电话*/
	private String phone;
	/*电子邮件*/
	private String email;
	/*学历*/
	private String degree;
	/*毕业学校*/
	private String school;
	/*部门id*/
	private String departmentid;
    /*图片*/
	private File picture;
	/*图片名称*/
	private String pictureFileName;
	/*图片类型*/
	private String pictureContentType;
	
	/*员工权限组id*/
	private String[] groupids;
	
	/*用户名是否存在标识*/
	private boolean flag=false;
	
	

	
	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public String[] getGroupids() {
		return groupids;
	}


	public void setGroupids(String[] groupids) {
		this.groupids = groupids;
	}


	public String getPictureFileName() {
		return pictureFileName;
	}


	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}


	public String getPictureContentType() {
		return pictureContentType;
	}


	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}


	public File getPicture() {
		return picture;
	}


	public void setPicture(File picture) {
		this.picture = picture;
	}
	
	
	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getCardno() {
		return cardno;
	}


	public void setCardno(String cardno) {
		this.cardno = cardno;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}



	public String getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}


	/**
	 * 添加员工
	 * @return
	 */
	@Permission(module="employee",privilege="insert")//这方法必须具备添加权限
	public String addEmployee(){
		
		
		Employee employee =new Employee();
		
		employee.setUsername(this.username);
		employee.setPassword(this.password);
		employee.setGender(this.gender);
		employee.setRealname(this.realname);
		employee.setDegree(this.degree);
		employee.setEmail(this.email);
		employee.setPhone(this.phone);
		employee.setSchool(this.school);
	
		if(this.departmentid!=null&&!"".equals(this.departmentid)){
					
			employee.setDepartment(new Department(this.departmentid.trim()));

		}
		
		employee.setIdCard(new IDCard(this.cardno,this.address,this.birthday));
		
		if(picture!=null){
			
			String ext=this.pictureFileName.substring(this.pictureFileName.lastIndexOf('.'));
		    String imgName=UUID.randomUUID().toString()+ext;
		    String savedir="images/employee/"+this.username;
		    
		    String realpath=ServletActionContext.getServletContext().getRealPath(savedir);
		    
		    File f=new File(new File(realpath),imgName);
		    
		    if(!f.getParentFile().exists()){
		    	
		    	f.getParentFile().mkdirs();
		    	
		    }
		    try {
		        FileUtils.copyFile(this.picture, f);
		    }catch (IOException e) {
		    	e.printStackTrace();
		    }
			
		    employee.setImageName(imgName);
			
			
		}
		
		
		

		employeeService.save(employee);
		ActionContext.getContext().put("message", "员工资料已经保存成功");
		
		
		
		
		return "dealemployee";
		
	}
	
	
	
	
	/**
	 * 判断用户名是否存在 
	 * @return
	 */

	
	public String esixt(){
		
		if(employeeService.exist(this.username)){
			
			ActionContext.getContext().put("tname", "用户名已经存在");
			
		}else{
			
			ActionContext.getContext().put("tname", "用户名可以使用");
			
		}
		
		return "tname";
		
	}
	
	
	
	
	
	
	
	/**
	 * 员工用户名检查
	 * @return
	 */
	public String checkEmployeName(){
		
		this.flag=employeeService.exist(this.username);
		
		
		return "cemployeeres";
	}
	
	
	
	
	
	
	
	/**
	 * 修改员工信息
	 * @return
	 */
	@Permission(module="employee",privilege="update")//这方法必须具备修改权限
	public String editEmployee(){
		
		Employee employee = employeeService.find(this.username);
		
		
		employee.setGender(this.gender);
		employee.setRealname(this.realname);
		employee.setDegree(this.degree);
		employee.setEmail(this.email);
		employee.setPhone(this.phone);
		employee.setSchool(this.school);
		
		if(this.departmentid!=null&&!"".equals(this.departmentid)){
			
			employee.setDepartment(new Department(this.departmentid.trim()));
		}

		employee.getIdCard().setCardno(this.cardno);
		employee.getIdCard().setAddress(this.address);
		employee.getIdCard().setBirthday(this.birthday);
		
		if(picture!=null){
			
			String ext=this.pictureFileName.substring(this.pictureFileName.lastIndexOf('.'));
		    String imgName=UUID.randomUUID().toString()+ext;
		    String savedir="images/employee/"+this.username;
		    
		    String realpath=ServletActionContext.getServletContext().getRealPath(savedir);
		    
		    File f=new File(new File(realpath),imgName);
		    
		    if(!f.getParentFile().exists()){
		    	
		    	f.getParentFile().mkdirs();
		    	
		    }
		    try {
		        FileUtils.copyFile(this.picture, f);
		    }catch (IOException e) {
		    	e.printStackTrace();
		    }
			
			
		    employee.setImageName(imgName);
			
		}
		

		employeeService.save(employee);
		ActionContext.getContext().put("message", "员工保持成功");
		
		
		
		
		return "dealemployee";
		
		
		
	}
	
	
	
	/**
	 * 设置员工离职
	 * @return
	 */
	@Permission(module="employee",privilege="leave")//这方法必须具备设置离职权限
	public String leave(){
		
		
		employeeService.delete(this.username);
		
		ActionContext.getContext().put("message", "离职设置成功");
		
		return "dealemployee";
			
	}
	
	
	
	/**
	 * 显示员工权限组选择界面
	 * @return
	 */
	@Permission(module="employee",privilege="privilege")//这方法必须具备设置离职权限
	public String setEmpPrivilege(){
		
		ActionContext.getContext().put("gusername", this.username);
		ActionContext.getContext().put("groups", privilegeGroupService.getScrollData().getResultList());
		ActionContext.getContext().put("usergroups", employeeService.find(this.username).getGroups());
		
        
		return "selprivilege";
	}
	
	
	/**
	 * 设置员工权限
	 * @return
	 */
	@Permission(module="employee",privilege="privilege")//这方法必须具备设置离职权限
	public String privilegeGroupSet(){
		
		
			Employee employee=employeeService.find(this.username);
			
			employee.getGroups().clear();
			
			for(String groupid:this.groupids){
				
				employee.addPrivilegeGroup(new PrivilegeGroup(groupid));
			
			}
			employeeService.update(employee);
			
			
			ActionContext.getContext().put("message", "员工权限设置成功");
			
				return "dealemployee";
		
	}
	                                  
	                                  
	
	
	
	
	
	
	
}
