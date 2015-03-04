package cn.dshop.service.priviledge.imp;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import cn.dshop.bean.privilege.PrivilegeGroup;
import cn.dshop.bean.privilege.SystemPrivilege;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.priviledge.SystemPriviledgeService;

@Service
public class SystemPriviledgeServiceBean extends DAOSupport<SystemPrivilege> implements
		SystemPriviledgeService {

	/**
	 * 批量保存权限
	 */
	public void saves(List<SystemPrivilege> priviledges){
		
		for(SystemPrivilege p:priviledges){	
			super.save(p);
			
		}
		
	}

	@Override
	public QueryResult<SystemPrivilege> getScrollData() {

	
	
		QueryResult<SystemPrivilege> queryResult=new QueryResult<SystemPrivilege>();	
		String entityname=this.getEntityName(this.entityClass);
		
		Query query=em.createQuery(" select o from "+entityname+" o " );
		queryResult.setResultList(query.getResultList());
		query=em.createQuery("select count(o.name) from "+this.getEntityName(this.entityClass)+" o ");
		
		queryResult.setTotalRecord((Long)query.getSingleResult());
		
		return queryResult;
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
