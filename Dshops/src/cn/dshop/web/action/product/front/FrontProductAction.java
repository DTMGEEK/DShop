package cn.dshop.web.action.product.front;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.bean.product.ProductType;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.service.products.ProductTypeService;
import cn.dshop.utils.WebUtil;
@Controller
public class FrontProductAction extends BaseForm {
	
	@Resource ProductInfoService productInfoService;
	
	@Resource ProductTypeService productTypeService;

	private String orderValue;
	
	private Integer typeid;
	
	
	private String brandId;
	
	
	
	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}

	
	
	
	
	
	/**
	 * 显示商品
	 * @return
	 */


	public String getFrontProduct(){
		
		
		StringBuilder hql=new StringBuilder(" o.visible=?1 ");
		List<Object> params=new ArrayList<Object>();
		params.add(true);
		
	
		List<Integer> typeids=new ArrayList<Integer>();
		typeids.add(this.typeid);
		this.getTypeids(typeids, new Integer[]{this.typeid});
		StringBuilder n=new StringBuilder();
		for(int i=0;i<typeids.size();i++){
			
			n.append('?').append((i+2)).append(',');
			
		}
		n.deleteCharAt(n.length()-1);
		params.addAll(typeids);
		hql.append(" and o.type.typeid in ("+n.toString()+")");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(this.brandId!=null&&!"".equals(this.brandId)){
			
			hql.append(" and o.brand.code=?"+(params.size()+1));
		    params.add(this.brandId);	
		    
		    ActionContext.getContext().put("sbrandid", this.brandId);
			
		}
		
		
		
		
		
		int maxResult=1;
		LinkedHashMap<String,String> orderby=bulidOrder(this.orderValue);
		orderby.put("createdate", "desc");
		PageView<ProductInfo> pageview=new PageView<ProductInfo>(maxResult,this.getPage());
		QueryResult<ProductInfo> qr=productInfoService.getScrollData(pageview.getFirstResult(), maxResult, hql.toString(), params.toArray(), orderby);
		pageview.setQueryResult(qr);
		 
		

		
		for(ProductInfo product : pageview.getRecords()){
			Set<ProductStyle> styles = new HashSet<ProductStyle>();
			for(ProductStyle style : product.getStyles()){
				if(style.getVisible()){
					styles.add(style);
					break;
				}
			}
			product.setStyles(styles);
			product.setDescription(WebUtil.HtmltoText(product.getDescription()));
		}
		
		   ActionContext.getContext().put("pageView",pageview);
		   
		   
		   
		   
		   Integer[] ids=new Integer[typeids.size()];
		   for(int i=0;i<typeids.size();i++){
			   ids[i]=typeids.get(i);
		   }
		   ActionContext.getContext().put("brands", productInfoService.getBrandsByTypeId(ids));
		   
		   
		   ProductType type=productTypeService.find(this.typeid);
		   List<ProductType> types=new ArrayList<ProductType>();
		   types.add(type);
		   ProductType parent=type.getParentType();
		   while(parent!=null){
			   
			   types.add(parent);
			   parent=parent.getParentType();
			   
		   }
		   
		   ActionContext.getContext().put("types", types);
		   
	       ActionContext.getContext().put("producttype", type);
		 
		   
	       //ctionContext.getContext().put("queryValue", queryvalue);

		
		
		return "frontallproduct";
	}
	
	
	/**
	 * 商城页面
	 * @return
	 */
	
	
	public String getMainShop(){

		 ProductType type=productTypeService.find(this.typeid);		
		 ActionContext.getContext().put("producttype", type);
		 ActionContext.getContext().put("topsellproducts",  productInfoService.getTopSell(this.typeid, 6));
		 
		 return "mainproduct";

	}
	
	
	
	
	
	
	
	
	/**
	 * 按价格 销量 上架时间 排序
	 * @param orderfied
	 * @return
	 */
	private LinkedHashMap<String,String> bulidOrder(String orderfied){
				
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();		
		if("sellcount".equals(orderfied)){
			orderby.put("sellcount", "desc");
			
		}else if("sellpricedesc".equals(orderfied)){			
			orderby.put("sellprice", "desc");
					
		}else if("sellpriceasc".equals(orderfied)){			
			orderby.put("sellprice", "asc");
			
		}else {
			orderby.put("createdate", "desc");
			
		}
		
		return orderby;
		
	}
	
	/**
	 * 获取类别下所有子类的id（子类及其子类都会获取的到）
	 * @param outtypesids
	 * @param typeids
	 */
	
	public void getTypeids(List<Integer> outtypesids,Integer[] typeids){		
		List<Integer> subtypeids=productTypeService.getSubTypeid(typeids);
		
		if(subtypeids!=null&&subtypeids.size()>0){			
			outtypesids.addAll(subtypeids);
			Integer[] ids=new Integer[subtypeids.size()];
			
			for(int i=0;i<subtypeids.size();i++){			
				ids[i]=subtypeids.get(i);
				
			}
     		getTypeids(outtypesids,ids);
     		
		}
		
	}
	
	
	
	
	
	
	
	

}
