package cn.dshop.service.product.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.products.ProductStyleService;

@Service
@Transactional
public class ProductStyleServiceBean extends DAOSupport<ProductStyle> implements
		ProductStyleService {

	/**
	 * 样式是否上架销售
	 * 产品id
	 * statue ture 上架 false下架
	 */
	
	


	public void setVisibleStatue(Integer styleid, boolean statue) {
		
		
		  if(styleid!=null&&styleid>0){
		    	
		    	 Query q=em.createQuery(" update ProductStyle  o set o.visible=?1 where o.id =?2");
			 	    q.setParameter(1, statue);
			 		q.setParameter(2, styleid);
			 		q.executeUpdate();
		    	
		    	
		    }
			  
		
	}

	
	
	
	
	
	
	
}
