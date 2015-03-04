package cn.dshop.service.priviledge;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.service.base.DAO;

public interface EmployeeService extends DAO<Employee> {

	
	public boolean exist(String name);
	
	public boolean validate(String username,String password);
	
	
}
