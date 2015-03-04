package cn.dshop.web.action.shopping;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.beans.BuyCart;
import cn.dshop.beans.BuyItem;

@Controller
public class CartManagerAction {
	
    /*商品id*/
	private Integer productId;
	/*样式id*/
	private Integer styleId;
	/*标识*/   //商品id-样式id
	private String buyItemid;
	/*地址参数*/
	private String directUrl;
	
	
	
	public String getDirectUrl() {
		return directUrl;
	}

	public void setDirectUrl(String directUrl) {
		this.directUrl = directUrl;
	}

	public String getBuyItemid() {
		return buyItemid;
	}

	/**
	 * 为商品id和样式id赋值
	 * @param buyItemid
	 */
	public void setBuyItemid(String buyItemid) {		
		this.buyItemid = buyItemid;
		
		if(this.buyItemid!=null){
			String[] values=this.buyItemid.split("-");

			if(values.length==2){				
				this.productId=new Integer(values[0]);
				this.styleId=new Integer(values[1]);
			}
			
		}
		
	}
	
	


	public Integer getProductId() {
		return productId;
	}

	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	
	public Integer getStyleId() {
		return styleId;
	}


	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	
	


	/**
	 * 取得购物车
	 * @param request
	 * @return
	 */
	
	private BuyCart getBuyCart(HttpServletRequest request){		
		
		return (BuyCart) request.getSession().getAttribute("buycart");
	}
	
	/**
	 * 删除指定购物项
	 * @return
	 */
	
	public String delCartItem(){
		
		BuyCart buyCart=this.getBuyCart(ServletActionContext.getRequest());
		if(buyCart!=null){
			ProductInfo product=new ProductInfo(this.productId);
			product.addProductStyle(new ProductStyle(this.styleId));
			buyCart.removeBuyItem(new BuyItem(product));
			
		}
		
		return "delitem";
		
		
	}
	
	
	/**
	 * 删除所有购物项
	 * @return
	 */
	public String delAllCartItem(){
		
		BuyCart buyCart=this.getBuyCart(ServletActionContext.getRequest());
		if(buyCart!=null){
			buyCart.removeAll();
			
		}
		return "delitem";
	}
	

	/**
	 * 批量更新数量
	 * @return
	 */
	
	
	
	public String updateAllAmout(){
		
		BuyCart buyCart=this.getBuyCart(ServletActionContext.getRequest());
		if(buyCart!=null){
			
			for(BuyItem item:buyCart.getItems()){
				StringBuilder key=new StringBuilder("amount_");
					
				key.append(item.getProduct().getId()).append('_');
				
				if(item.getProduct().getStyles().size()>0){
					
					key.append(item.getProduct().getStyles().iterator().next().getId());
					
				}	
				
				String amoutnStr=ServletActionContext.getRequest().getParameter(key.toString());
				
				if(amoutnStr!=null&&!"".equals(amoutnStr)){
					try {
						int amount=Integer.parseInt(amoutnStr);
						if(amount>0) item.setAmount(amount);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			
			
		}
		
		return "updateamount";
		
			
	}
	
	
	

	
	
	
	
	
}
