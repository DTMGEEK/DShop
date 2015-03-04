package cn.dshop.service.product.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.compass.core.Compass;
import org.compass.core.CompassTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductType;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.products.BrandService;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.service.products.ProductTypeService;

@Service
@Transactional
public class ProductInfoServiceBean extends DAOSupport<ProductInfo> implements ProductInfoService {

	
	@Resource private ProductTypeService productTypeService;
	
	/*@Resource Compass compass;
	
	
	private CompassTemplate compassTemplate;
	@Resource
	public void setCompass(Compass compas){
		
		compassTemplate=new CompassTemplate(compas);
	}

	@Override
	public void save(ProductInfo entity) {
		super.save(entity);
		compassTemplate.save(entity);
	}*/
	
	
	
	
	/**
	 * 是否上架销售
	 * 产品id
	 * statue ture 上架 false下架
	 */
	public void setVisibleStatue(Integer productid,boolean statue){
		
	    if(productid!=null&&productid>0){
	    	
	    	 Query q=em.createQuery(" update ProductInfo  o set o.visible=?1 where o.id =?2");
		 	    q.setParameter(1, statue);
		 		q.setParameter(2, productid);
		 		q.executeUpdate();
	    		
	    }
		  
	}
	
	
	
	
	/**
	 * 设置产品是否推荐
	 * 产品id
	 * true 推荐 false 不推荐
	 */
	
	public void setCommandStatue(Integer productid,boolean statue){
		
	    if(productid!=null&&productid>0){
	    	
	    	 Query q=em.createQuery(" update ProductInfo  o set o.commend=?1 where o.id =?2");
	 	    q.setParameter(1, statue);
	 		q.setParameter(2, productid);
	 		q.executeUpdate();

	    }
	   		
	}


	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public  List<Brand>  getBrandsByTypeId(Integer[] ids){
		
		if(ids!=null && ids.length>0){
			
			StringBuilder jpql=new StringBuilder();
			for(int i=0;i<ids.length;i++){
				
				jpql.append('?').append((i+1)).append(',');	
			}
			jpql.deleteCharAt(jpql.length()-1);

			Query qr=em.createQuery(" select o from  Brand  o where o.code in( select p.brand.code from ProductInfo p where p.type.typeid in ("+jpql.toString()+") group by p.brand.code)");
			
			for(int i=0;i<ids.length;i++){
				
				qr.setParameter(i+1, ids[i]);
			}
			
			
			
			return qr.getResultList();

			
		}
		
		return null;
		
		
		
	}
	
	
	/*public List<ProductType> getProductTypeById(Integer id){
		
		Query qr=em.createQuery(" select o from ProductType o");
		return qr.getResultList();
	}

*/

	
	
	
	/**
	 * 获取销量最多的产品
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<ProductInfo> getTopSell(Integer typeid,int maxResult){
		
		List<Integer> typeids=new ArrayList<Integer>();
		typeids.add(typeid);
		this.getTypeIds(typeids, new Integer[]{typeid});
		StringBuilder n=new StringBuilder();
		for(int i=0;i<typeids.size();i++){
			
			n.append('?').append(i+2).append(',');
			
		}
		n.deleteCharAt(n.length()-1);
		
		Query qr=em.createQuery(" select  o from ProductInfo o where o.commend=?1 and o.type.typeid in("+n.toString()+") order by o.sellcount desc");
		qr.setParameter(1, true);
		
		for(int i=0;i<typeids.size();i++){
			
			qr.setParameter((i+2),typeids.get(i));
			
		}
		qr.setFirstResult(0).setMaxResults(maxResult);
		
		return qr.getResultList();
	}
	
	/**
	 * 取得所有子类别
	 * @param outtypeids
	 * @param typeid
	 */
	
	private void getTypeIds(List<Integer> outtypeids,Integer[] typeid){
 
		
		List<Integer> subtypeids=productTypeService.getSubTypeid(typeid);
		if(subtypeids!=null&&subtypeids.size()>0){
			outtypeids.addAll(subtypeids);
			Integer[] ids=new Integer[subtypeids.size()];
			
			for(int i=0;i<subtypeids.size();i++){
				
				ids[i]=subtypeids.get(i);
				
			}
			getTypeIds(outtypeids,ids);
			
		}
		
		
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<ProductInfo> getViewHistory(Integer[] productids,int maxResult){
		
		
		StringBuilder hql=new StringBuilder();
		for(int i=0;i<productids.length;i++){
			
			hql.append('?').append(i).append(',');
			
		}
		hql.deleteCharAt(hql.length()-1);
		Query qr=em.createQuery(" select o from ProductInfo o  where o.id in ("+hql.toString()+")");
		
		for(int i=0;i<productids.length;i++){	
			qr.setParameter(i, productids[i]);
			
		}
		
		qr.setFirstResult(0).setMaxResults(maxResult);
		
		return qr.getResultList();
		
		
	}


	
	
	


	
	
	
	
	

	

}
