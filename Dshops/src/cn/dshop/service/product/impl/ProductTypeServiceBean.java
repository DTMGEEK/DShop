package cn.dshop.service.product.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dshop.bean.product.ProductType;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.products.ProductTypeService;

@Service
@Transactional
public class ProductTypeServiceBean extends DAOSupport<ProductType> implements
		ProductTypeService {

	@Override
	public void delete(Serializable... entitydids) {
		
		if(entitydids!=null&&entitydids.length>0){
			
			StringBuffer hql=new StringBuffer();
			for(int i=0;i<entitydids.length;i++){
				
				hql.append("?").append(i+2).append(",");
		
			}
			hql.deleteCharAt(hql.length()-1);
			
			Query q=em.createQuery(" update ProductType o set o.visible=?1 where o.typeid in ("+hql.toString()+")");
			
			q.setParameter(1, false);
			
			for(int i=0;i<entitydids.length;i++){
				
				q.setParameter(i+2, entitydids[i]);
			}

			q.executeUpdate();
			
		}
	
		
		
	}

	
	
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<Integer> getSubTypeid(Integer[] parentid){
		
		if(parentid!=null&&parentid.length>0){
			
			StringBuilder hql=new StringBuilder();
			
			for(int i=0;i<parentid.length;i++){
				hql.append('?').append((i+1)).append(',');
				
				
			}
			hql.deleteCharAt(hql.length()-1);
			Query qr=em.createQuery(" select o.typeid from ProductType o where o.parentType.typeid in("+hql.toString()+")");
			
			for(int i=0;i<parentid.length;i++){
				
				qr.setParameter(i+1, parentid[i]);	
			}

			return qr.getResultList();
			
		}else{
		
			return null;
		}
		
	}


	

}
