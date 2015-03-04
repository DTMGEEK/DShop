package cn.dshop.web.action.product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.products.BrandService;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.service.products.ProductTypeService;

@Controller
public class ProductAction extends BaseForm {
	
	@Resource ProductInfoService productInfoService;
	
	@Resource BrandService brandService;
	/*查询标记*/
	private String query;
	/*产品名称*/
	private String name;
	/*产品货号*/
	private String code;
	/*产品销售价*/
	private Float sellprice;
	/*产品品牌id*/
	private String brandid;
	/*开始价*/
	private Float startsellprice;
	/*结束价*/
	private Float endsellprice;
	

	public Float getStartsellprice() {
		return startsellprice;
	}


	public void setStartsellprice(Float startsellprice) {
		this.startsellprice = startsellprice;
	}


	public Float getEndsellprice() {
		return endsellprice;
	}


	public void setEndsellprice(Float endsellprice) {
		this.endsellprice = endsellprice;
	}


	public String getBrandid() {
		return brandid;
	}


	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Float getSellprice() {
		return sellprice;
	}


	public void setSellprice(Float sellprice) {
		this.sellprice = sellprice;
	}


	public String getQuery() {
		return query;
	}

	
	public void setQuery(String query) {
		this.query = query;
	}


	
	/**
	 * 查询全部的品牌
	 * @return
	 */
	public String showAllProducts(){
		
		int maxResult=12;	
		StringBuilder hql=new StringBuilder("1=1");
		List<Object> params=new ArrayList<Object>();

		if(this.getQuery()!=null){	
			
			if(this.name!=null&&!"".equals(this.name)){
			
					hql.append(" and o.name like ?"+(params.size()+1));
					params.add("%"+this.getName()+"%");
			}
			
			if(this.startsellprice!=null&&this.startsellprice>0){
				
				hql.append(" and o.sellprice >=?"+(params.size()+1));
                params.add(this.getStartsellprice());				
			}
			
			if(this.endsellprice!=null&&this.endsellprice>0){
				hql.append(" and o.sellprice <=?"+(params.size()+1));
				params.add(this.endsellprice);
				
			}
			
			if(this.code!=null&&!"".equals(this.getCode())){
				
				hql.append(" and o.code=?"+(params.size()+1));
				params.add(this.getCode());				
			}
			
			if(this.brandid!=null&&!"".equals(this.brandid)){
				
				hql.append(" and o.brand.code =?"+(params.size()+1));
				params.add(this.brandid);
				
			}
	
		}
		
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
		orderby.put("id", "asc");
		PageView<ProductInfo> pageview=new PageView<ProductInfo>(maxResult,this.getPage());
		QueryResult<ProductInfo> qr=productInfoService.getScrollData(pageview.getFirstResult(), maxResult, hql.toString(), params.toArray(), orderby);
		pageview.setQueryResult(qr);
		
		 ActionContext.getContext().put("pageView",pageview);
		 ActionContext.getContext().put("queryValue", queryvalue);
		 ActionContext.getContext().put("brands", brandService.getScrollData().getResultList());
		 
	
		 
		 return "allproduct";
		
	}
	
	
}
