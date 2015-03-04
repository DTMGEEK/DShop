package cn.dshop.service.product.impl;

import javax.annotation.Resource;

import org.compass.core.Compass;
import org.compass.core.CompassTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.products.ProductSearchService;


@Service @Transactional
public class ProductSearchServiceBean implements ProductSearchService  {
	
	private CompassTemplate compassTemplate;
	
	
	@Resource
	public void setCompass(Compass compass){
		
		this.compassTemplate=new CompassTemplate(compass);
		
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see cn.dshop.service.product.impl.ProductSearchService#query(java.lang.String, int, int)
	 */
	public QueryResult<ProductInfo> query(String keyword,int firstResult,int maxResult){
		
		return compassTemplate.execute(new QueryCallBack(keyword,firstResult,maxResult));

	}
	
	
	
	
	
	

}
