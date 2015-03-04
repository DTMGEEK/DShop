package cn.dshop.service.priviledge.imp;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.priviledge.EmployeeService;
import cn.dshop.utils.MD5;

@Service
public class EmployeeServiceBean extends DAOSupport<Employee> implements
		EmployeeService {

	@Override
	public void save(Employee entity) {
		entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		super.save(entity);
	}

	
	/**
	 * 判断用户是否存在  
	 * @param name
	 * @return
	 */
	public boolean exist(String name){

		Long count=(Long) em.createQuery(" select count(o) from Employee o where o.username=?1").setParameter(1, name).getSingleResult();
		
		return count>0;
		
	}
	
	
	
	


	@Override
	public void delete(Serializable... entitydids) {
		
		
		if(entitydids !=null && entitydids.length>0){
			
			StringBuilder hql=new StringBuilder();
			for(int i=0;i<entitydids.length;i++){
				
				hql.append('?').append(i+2).append(',');	
			}
			
			hql.deleteCharAt(hql.length()-1);
						
			Query query=em.createQuery(" update Employee o set o.visible=?1 where o.username in ("+hql.toString()+")");
			query.setParameter(1, false);
			
			for(int i=0;i<entitydids.length;i++){
				
				query.setParameter(i+2, entitydids[i]);
				
			}
			
			query.executeUpdate();
		
		}
		
		
	}
	
	
	
	/**
	 * 校验用户名和密码是否正确
	 */
	public boolean validate(String username,String password){
		
		String passwords =MD5.MD5Encode(password);
		Long count=(Long) em.createQuery(" select count(o) from Employee o where o.username=?1 and o.password=?2 and o.visible=?3")
		.setParameter(1, username).setParameter(2, passwords).setParameter(3, true).getSingleResult();
		
		return count>0;
		
	}
	
	
	
	
	
	
}
