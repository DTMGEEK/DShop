package cn.dshop.service.user.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dshop.bean.user.Buyer;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.user.BuyerService;
import cn.dshop.utils.MD5;

@Service
@Transactional
public class BuyerServiceBean extends DAOSupport<Buyer> implements BuyerService {
	
	/**
	 * 判断用户是否存在
	 */
	public Boolean exit(String username){
		
		long count = (Long)em.createQuery(" select count(o) from Buyer o where o.username=?1").setParameter(1, username)
		.getSingleResult();
		
	    return count>0;

	}
	
	/**
	 * 用户注册
	 */
	@Override
	public void save(Buyer entity) {
		
        entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		super.save(entity);
	}
	
	
	/**
	 * 用户登录
	 */
	
	public Boolean validate(String username,String password){
		
		
		
		long count=(Long) em.createQuery(" select count(o) from Buyer o where o.username=?1 and o.password=?2 ")
		.setParameter(1, username).setParameter(2, MD5.MD5Encode(password)).getSingleResult();
		
		
		
		if(count>0){
			
			return true;
			
		}else{
			
		   return false;
		}
		
		
	}
	
	/**
	 * 禁用用户帐号
	 * @param username
	 * @param statue
	 */	
	public void setVisibleStatue(String username,boolean statue){
		
		if(username!=null&&!"".equals(username)){
			
			Query q=em.createQuery(" update Buyer o set o.visible=?1 where o.username=?2");
			q.setParameter(1, statue);
			q.setParameter(2, username);
			q.executeUpdate();
		
		}

	}
	
	
	public void updatePassword(String username, String newpassword){
		 em.createQuery("update Buyer o set o.password=?1 where o.username=?2")
		.setParameter(1, MD5.MD5Encode(newpassword)).setParameter(2, username).executeUpdate();
	}
	
	
	
	
	

	
		
	

}
