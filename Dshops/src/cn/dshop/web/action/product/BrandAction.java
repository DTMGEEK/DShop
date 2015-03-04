package cn.dshop.web.action.product;


import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductType;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.products.BrandService;

/**
 *  品牌查询
 * @author ken lian
 *
 */


@Controller
public class BrandAction extends BaseForm {
	
	@Resource   BrandService  brandService;	
	
	/*查询标记*/
	private String query;
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

/**
 * 查询全部或部分品牌
 * @return
 */

	public String showAllBrand(){
		
		int maxResult=4;
		StringBuilder whql=new StringBuilder(" o.visible=?1 ");
		List<Object> params=new ArrayList<Object>();
		params.add(true);		
		if("querval".equals(this.getQuery())){
			
			whql.append(" and o.name like ?"+(params.size()+1));
			params.add("%"+this.getQueryvalue()+"%");	
		}			
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
		orderby.put("code", "desc");
		PageView<Brand> pageview=new PageView<Brand>(maxResult,this.getPage());
		QueryResult<Brand>  qr = brandService.getScrollData(pageview.getFirstResult(), maxResult, whql.toString(), params.toArray(),orderby);
		pageview.setQueryResult(qr);
	    ActionContext.getContext().put("pageView",pageview);
	    ActionContext.getContext().put("queryValue", queryvalue);
	    
		return "allbrand"; 
	}
	
	
}
