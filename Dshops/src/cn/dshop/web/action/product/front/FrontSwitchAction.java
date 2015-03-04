package cn.dshop.web.action.product.front;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.beans.BaseForm;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.utils.WebUtil;

@Controller
public class FrontSwitchAction extends BaseForm {
	
	
	 @Resource ProductInfoService productInfoService;
	 
	 private Integer typeid;
	 
	 public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}



	/**
	 * 获取10个最畅销产品
	 * @return
	 */
	public String getTopSale(){				 
		
		
	  ActionContext.getContext().put("topsellproducts",  productInfoService.getTopSell(this.typeid, 10));
	  
	  return "topsale";
		 
	 }
	
	
	
	/**
	 * 取得用户的浏览历史
	 * @return
	 */
		
	public String getViewHistory(){
		
		
	String cookieValue=WebUtil.getCookieByName(ServletActionContext.getRequest(), "productViewHistory");
		
	if(cookieValue!=null&&!"".equals(cookieValue.trim())){
		
		String[] ids=cookieValue.split("-");
		Integer[] productids=new Integer[ids.length];
			
		StringBuilder hql=new StringBuilder();
		for(int i=0;i<ids.length;i++){
			
			productids[i]=new Integer(ids[i].trim());
			hql.append('?').append(i).append(',');
			
		}
		hql.deleteCharAt(hql.length()-1);
		
		
		ActionContext.getContext().put("histoty",  productInfoService.getViewHistory(productids, 10));
			
	}
	
		return "viewhis";
	}
	

}
