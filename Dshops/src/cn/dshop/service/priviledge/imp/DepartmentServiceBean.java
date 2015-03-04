package cn.dshop.service.priviledge.imp;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cn.dshop.bean.privilege.Department;
import cn.dshop.bean.privilege.Employee;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.priviledge.DepartmentService;

/**
 * 部门业务bean
 * @author Administrator
 *
 */
@Service
public class DepartmentServiceBean extends DAOSupport<Department> implements
		DepartmentService {

	@Override
	public void save(Department entity) {
		
		entity.setDepartmentid(UUID.randomUUID().toString());
		super.save(entity);
	}
	
	/**
	 *删除部门 
	 */

	@Override
	public void delete(Serializable... entitydids) {
		
		for(Serializable id :entitydids){
			
			Department department=this.find(id);
			
			for(Employee employee:department.getEmployees()){
				
				employee.setDepartment(null);
				
				
			}
			em.remove(department);
		}
		
		
	}
	
	
	

	
}
