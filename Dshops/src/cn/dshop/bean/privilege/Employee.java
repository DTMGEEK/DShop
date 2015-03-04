package cn.dshop.bean.privilege;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**'
 * 员工实体
 * @author Administrator
 *
 */
@Entity
public class Employee {
	
	/* 用户名*/
	private String username;
	/*密码*/
	private String password;
	/*真实姓名*/
	private String realname;
	/*性别*/
	private Gender gender;
	/*身份证*/
	private IDCard idCard;
	/*毕业学校*/
	private String school;
	/*电话*/
	private String phone;
	/*照片*/
	private String imageName; //UUID 生成
	/*员工状态*/
	private Boolean visible=true;
	/*所属部门*/
	private Department department;
	/*学历*/
	private String degree;
	/*电子邮件*/
	private String email;
	/*员工具有的权限组*/
	private Set<PrivilegeGroup>  groups=new HashSet<PrivilegeGroup>();
	

	/**
	 * 添加权限组
	 * @param group
	 */
	
	public void addPrivilegeGroup(PrivilegeGroup group){
		
		this.groups.add(group);
		
	}
	
	
	
	
	
	//取得员工照片
	@Transient
	public String getImagePath(){
		
		if(this.username!=null&&this.imageName!=null) return "/images/employee/"+this.username+"/"+this.imageName;
		
		return null;
	}
	
	
	@Id @Column(length=20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
	@Column(length=60,nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	@Column(length=8,nullable=false)
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Enumerated(EnumType.STRING) @Column(length=5,nullable=false)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="card_id")
	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

	@Column(length=20)
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(length=18)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length=41)
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name="eg",inverseJoinColumns=@JoinColumn(name="group_id"),joinColumns=@JoinColumn(name="username"))
	public Set<PrivilegeGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<PrivilegeGroup> groups) {
		this.groups = groups;
	}

    @Column(length=10)
	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	@Column(length=40)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
    



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
