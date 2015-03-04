package cn.dshop.service.products;

import java.util.List;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductType;
import cn.dshop.service.base.DAO;

public interface ProductInfoService extends DAO<ProductInfo> {
	
	public void setVisibleStatue(Integer productid,boolean statue);
	
	public void setCommandStatue(Integer productid,boolean statue);
	
	public  List<Brand>  getBrandsByTypeId(Integer[] ids);
	
	public List<ProductInfo> getTopSell(Integer typeid,int maxResult);
	
	public List<ProductInfo> getViewHistory(Integer[] productids,int maxResult);
	
/*	public List<ProductType> getProductTypeById(Integer id);*/
	

	

}
