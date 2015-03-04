package cn.dshop.service.priviledge.imp;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.bean.privilege.SystemPrivilege;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.priviledge.PrivilegeGroupService;

/**
 * 权限业务bean
 * @author Administrator
 *
 */
@Service
public class PrivilegeGroupServiceBean extends DAOSupport<PrivilegeGroup> implements
		PrivilegeGroupService {

	@Override
	public void save(PrivilegeGroup entity) {
		
		
		//PrivilegeGroup  group=(PrivilegeGroup)entity;
		
		entity.setGroupid(UUID.randomUUID().toString());
		super.save(entity);
	}
	
	

	@Override
	public void delete(Serializable... entitydids) {

		for(Serializable id:entitydids){
			
			PrivilegeGroup group=find(id);
						
			
			for(Employee employee:group.getEmployees()){
				
				employee.getGroups().remove(group);
				
			}
			em.remove(group);
		}
		

	}






	
	
	
	
	
	
	
	
	
	
	
	

	
}
