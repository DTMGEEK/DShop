package cn.dshop.web.action.product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import cn.dshop.bean.product.ProductType;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.product.impl.ProductTypeServiceBean;
import cn.dshop.service.products.ProductTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 产品类型管理
 * @author ken lian
 *
 */


@Controller
public class ProductTypeAction extends BaseForm {
	@Resource
	ProductTypeService productTypeServiceBean;
	
	/*产品类型Id*/
	private Integer typeid;	
	   /*查询标识*/
	private String query;
	
	public String getQueryvalue() {
		return queryvalue;
	}

	public void setQueryvalue(String queryvalue) {
		this.queryvalue = queryvalue;
	}
   	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Integer getTypeid() {
		return typeid;
	}
	
	public void setTypeid(Integer typeid) {	
		this.typeid = typeid;
	}
	
	
/**
 *  展示类型列表
 * @return
 */

	public String showAllProductType(){	
		int maxResult=12;
		StringBuffer whql = new StringBuffer(" o.visible=?1");
		List<Object> params = new ArrayList<Object>();
		params.add(true);

	    if("querval".equals(this.getQuery())){
	    		    	
	    	 if(this.queryvalue!=null){		    	
			    	whql.append(" and o.name like ?"+(params.size()+1));
			    	params.add("%"+this.getQueryvalue()+"%");
			    }
	    }else{
	    	    	
	    	  if(this.getTypeid()!=null&&this.getTypeid()>0){
			    	whql.append(" and o.parentType.typeid=?"+(params.size()+1));
			    	params.add(this.getTypeid());
			    }else{	    	
			    	whql.append(" and o.parentType is null");
			    }
	    		   
	    }
	   
	    LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
		orderby.put("typeid ", " asc ");
		PageView<ProductType> pageview=new PageView<ProductType>(maxResult,this.getPage());
		QueryResult<ProductType>  qr = productTypeServiceBean.getScrollData(pageview.getFirstResult(), maxResult, whql.toString(), params.toArray(), orderby);
		pageview.setQueryResult(qr);
        ActionContext.getContext().put("pageView",pageview);
        ActionContext.getContext().put("queryValue", queryvalue);
		return "allproduttype";
	}
	
	
}
