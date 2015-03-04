package cn.dshop.web.action.product.front;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductType;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.utils.WebUtil;


@Controller
public class ViewProductAction {
	
	
	@Resource ProductInfoService productInfoService;
	
	private Integer productId;
	
	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}




	public  String ProductCookie(){	
		ProductInfo product=productInfoService.find(this.productId);
		
		ActionContext.getContext().put("product", product);
		
	    /* if(product==null){
			
			ActionContext.getContext().put("message", "参数错误");
			
			return "errorprod";
		}*/
		
		
		WebUtil.addCookie(ServletActionContext.getResponse(), "productViewHistory", this.buildViewHistory(ServletActionContext.getRequest(),this.productId), 30*24*60*60);
		List<ProductType> stypes=new ArrayList<ProductType>();
		ProductType parent=product.getType();
		while(parent!=null){
			stypes.add(parent);
			parent=parent.getParentType();
				
		}
		ActionContext.getContext().put("viewproduct", product);
		ActionContext.getContext().put("stypes", stypes);
		
		
		return "cookiehis";
	}
	
	
	
	/**
	 * 设定cookie
	 * 1.id存在 移到最前面
	 * 2.满10就删除最新进入的产品id
	 * @param request
	 * @param currentProductId
	 * @return
	 */
	
	public String buildViewHistory(HttpServletRequest request,Integer currentProductId){
		
		//1-3-2
		String cookieValue=WebUtil.getCookieByName(request, "productViewHistory");
		LinkedList<Integer> productids=new LinkedList<Integer>();
			if(cookieValue!=null&&!"".equals(cookieValue.trim())){				
	             String[] ids=cookieValue.split("-");
	
			     for(String id:ids){		    	 
			    	 productids.offer(new Integer(id.trim()));
			    	 
			     }
		    
			     if(productids.contains(currentProductId)){		    	 
			    	 currentProductId.reverse(currentProductId);

			     }
			     
			     if(productids.size()>=10){
			    	 
			    	 productids.poll();
			    	 
			     }

			}
			
			productids.offer(currentProductId);
			
			StringBuilder out=new StringBuilder();
			for(Integer id:productids){
				
				out.append(id).append('-');
			}
			out.deleteCharAt(out.length()-1);
			
			return out.toString();
			

	}
	
	
	
	
	
	
	

}
