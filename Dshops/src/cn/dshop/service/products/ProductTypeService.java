package cn.dshop.service.products;

import java.util.List;

import cn.dshop.bean.product.ProductType;
import cn.dshop.service.base.DAO;

public interface ProductTypeService extends DAO<ProductType> {
	
	/**
	 * 取得下类别id
	 * @param parentid 父类id
	 * @return
	 */
	
	public List<Integer> getSubTypeid(Integer[] parentid);

}
