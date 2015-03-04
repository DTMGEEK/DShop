package cn.dshop.service.products;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.beans.QueryResult;


/**
 * 搜索
 * @author Administrator
 *
 */
public interface ProductSearchService {

	public abstract QueryResult<ProductInfo> query(String keyword,
			int firstResult, int maxResult);

}