package cn.dshop.service.product.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dshop.bean.product.Brand;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAOSupport;
import cn.dshop.service.products.BrandService;

@Service
@Transactional
public class BrandServiceBean extends DAOSupport<Brand> implements BrandService {

	/**
	 * 用UUID生成品牌的code
	 */
	@Override
	public void save(Brand entity) {
		
		entity.setCode(UUID.randomUUID().toString());
		super.save(entity);
	}

	
		
		
		
		
	

	
	
	
	
	
	
}
