package cn.dshop.web.action.shopping;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.BuyCart;
import cn.dshop.beans.BuyItem;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.utils.WebUtil;

@Controller
public class CartAction extends BaseForm {
	
	
	@Resource ProductInfoService productInfoService;
	/*产品id*/
	private Integer productid;
	/*样式id*/
	private Integer styleid;
	

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	
	public Integer getStyleid() {
		return styleid;
	}


	public void setStyleid(Integer styleid) {
		this.styleid = styleid;
	}


	
	/**
	 * 判断购物车是否存在， 不存在创建购物车
	 * @return
	 */
	

	public String CareSession(){
		
		
		BuyCart buycat=(BuyCart) ServletActionContext.getRequest().getSession().getAttribute("buycart");
		if(buycat==null){
			
			 String sid=WebUtil.getCookieByName(ServletActionContext.getRequest(), "buyCartID");
			 
			 if(sid!=null){
				 
				 HttpSession session=SiteSessionListener.getSession(sid);
				 
				 if(session!=null){
					 
				     buycat = (BuyCart) session.getAttribute("buycart");
				     
				     if(buycat!=null){
	
				    	 SiteSessionListener.reomveSession(sid);
					     ServletActionContext.getRequest().getSession().setAttribute("buycart", buycat);
					     WebUtil.addCookie(ServletActionContext.getResponse(), "buyCartID", ServletActionContext.getRequest().getSession().getId(), 60*5*30);
				     }
				 }	 
				 
			 }
			
		}
		
		/**
		 * 购物车不存在  创建新的购物车
		 */
		if(buycat==null){
			
			buycat=new BuyCart();
			ServletActionContext.getRequest().getSession().setAttribute("buycart", buycat);
			WebUtil.addCookie(ServletActionContext.getResponse(), "buyCartID", ServletActionContext.getRequest().getSession().getId(), 60*5*30);
		}
	
		
		/**
		 * 在购物车中放入商品
		 */
		if(this.productid!=null&&this.productid>0){
			ProductInfo product=productInfoService.find(this.productid);
			
			if(product!=null){	   
				ProductStyle currentstyle=null;
				
					for(ProductStyle style:product.getStyles()){
					
						if(style.getId().equals(this.styleid)){				
							currentstyle=style;
							
						}
					}
					
					
					product.getStyles().clear();
					if(currentstyle!=null) product.addProductStyle(currentstyle);
					buycat.addItem(new BuyItem(product,1));
					
			}
			
		}

		ActionContext.getContext().put("buycart", buycat);
	
		return "cart";
	}
	
	

}
