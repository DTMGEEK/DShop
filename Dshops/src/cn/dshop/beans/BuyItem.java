package cn.dshop.beans;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;

public class BuyItem {
	
	
	/*所购买商品*/
	private ProductInfo product;
	/*购买数量*/
	private int amount;
	
	

	
	public BuyItem(ProductInfo product) {
		this.product = product;
	}


	public BuyItem(ProductInfo product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	
	public ProductInfo getProduct() {
		return product;
	}

	public void setProduct(ProductInfo product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		
		String buyitemid=product.hashCode()+"-";
		if(product.getStyles().size()>0){
			buyitemid+=product.getStyles().iterator().next().getId();

		}
		
		return buyitemid.hashCode();
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuyItem other = (BuyItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		
		if(product.getStyles().size()!=other.product.getStyles().size()){
			return false;

		}
		
		if(product.getStyles().size()>0){
		
			ProductStyle style=product.getStyles().iterator().next();
			ProductStyle otherstyle=other.product.getStyles().iterator().next();
			if(!style.equals(otherstyle)){
				return false;
			}
		}
		
		
		return true;
	}
	
	
	
	

}
