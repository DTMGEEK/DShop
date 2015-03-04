package cn.dshop.web.action.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.service.products.ProductSearchService;



/**
 * 产品查询Action
 * @author Administrator
 *
 */
@Controller
public class ProducSearchAction extends BaseForm {
	
	@Resource ProductSearchService productSearchService;
	
	
	/*查询关键字*/
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
	public String serachProduct(){
		

		
		
		PageView<ProductInfo> pageView=new PageView<ProductInfo>(12, this.getPage());
		
		pageView.setQueryResult(productSearchService.query(this.word, pageView.getFirstResult(), pageView.getMaxresult()));
		
		ActionContext.getContext().put("pageView", pageView);
		
		
		return "searchresult";
		
	}
	
	
	

	
	
	
	
	
	
}
