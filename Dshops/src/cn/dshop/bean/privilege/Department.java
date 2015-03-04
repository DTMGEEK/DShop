package cn.dshop.bean.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * 部门实体
 * @author Administrator
 *
 */
@Entity
public class Department {
	
	/*部门id*/
	private String departmentid;
	/* 部门名称*/
	private String name;
	/*员工*/
	private Set<Employee> employees=new HashSet<Employee>();
	
	
	
	
   public Department() {
	}

public Department(String departmentid) {
		this.departmentid = departmentid;
	}

@OneToMany(mappedBy="department",cascade=CascadeType.REFRESH)
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Id @Column(length=36)
	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	@Column(length=20,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((departmentid == null) ? 0 : departmentid.hashCode());
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
		Department other = (Department) obj;
		if (departmentid == null) {
			if (other.departmentid != null)
				return false;
		} else if (!departmentid.equals(other.departmentid))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
