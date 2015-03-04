package cn.dshop.service.products;

import cn.dshop.bean.product.ProductStyle;
import cn.dshop.service.base.DAO;

public interface ProductStyleService extends DAO<ProductStyle> {
	
	
    public void setVisibleStatue(Integer styleid,boolean statue);
	

}
