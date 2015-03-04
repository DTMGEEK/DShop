package cn.dshop.service.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.compass.core.CompassCallback;
import org.compass.core.CompassException;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.beans.QueryResult;



public class QueryCallBack implements CompassCallback<QueryResult<ProductInfo>> {

	private String keyword;
	
	private int firstResult;
	
	private int maxResult;
	

	public QueryCallBack(String keyword, int firstResult, int maxResult) {
		
		this.keyword = keyword;
		this.firstResult = firstResult;
		this.maxResult = maxResult;
	}






	public QueryResult<ProductInfo> doInCompass(CompassSession session) throws CompassException {
		
		CompassHits hits=session.find(this.keyword);
		QueryResult<ProductInfo> qr=new QueryResult<ProductInfo>();
		System.out.print(hits.length());
		String slength=String.valueOf(hits.length());
		qr.setTotalRecord(Long.parseLong(slength));
		
		int length=this.maxResult+this.firstResult;
		if(length>hits.length()) length=hits.length();
		List<ProductInfo> products=new ArrayList<ProductInfo>();
		
		for(int i=this.firstResult;i<length;i++){
		
			ProductInfo product=(ProductInfo) hits.data(i);
			
			if(hits.highlighter(i).fragment("productName")!=null);
			   product.setName(hits.highlighter(i).fragment("productName"));
			if(hits.highlighter(i).fragment("description")!=null)
				product.setDescription(hits.highlighter(i).fragment("description"));
			
			products.add(product);
			
		}
		
		qr.setResultList(products);
		return qr;
	}

}
