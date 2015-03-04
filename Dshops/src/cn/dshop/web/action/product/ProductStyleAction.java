package cn.dshop.web.action.product;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.beans.BaseForm;
import cn.dshop.service.products.ProductStyleService;

@Controller
public class ProductStyleAction extends BaseForm {
	
	@Resource ProductStyleService productStyleService;
	/**
	 * 样式类型
	 */
	private Integer productId;
	

	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


     /**
      * 得到特定的产品样式
      * @return
      */
	public String getProductStyle(){
		
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();	
		orderby.put("visible", "desc");
		orderby.put("id", "desc");
		ActionContext.getContext().put("styles", productStyleService.getScrollData(-1, -1, " o.product.id=?1",new Object[]{this.productId},orderby).getResultList());
		
		
		return "productstyle";
	}
	
	
	
	
	
	
	

}
