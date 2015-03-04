package cn.dshop.web.action.product.front;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.service.products.ProductInfoService;

@Controller
public class GetTopSalltoShopIndex {

	
     @Resource ProductInfoService productInfoService;
	 
	 private Integer typeid;
	 
	 
	 public Integer getTypeid() {
		return typeid;
	}



	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}




	public String getTolSall(){
		 
		  ActionContext.getContext().put("topsellproducts",  productInfoService.getTopSell(this.typeid, 6));
		 	 
		 return "shopindex";
		 
	 }
	 
	 
	
}
