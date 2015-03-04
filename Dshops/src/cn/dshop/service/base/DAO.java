package cn.dshop.service.base;

import java.io.Serializable;
import java.util.LinkedHashMap;

import cn.dshop.beans.QueryResult;

public interface DAO<T> {
	
	public void clear();
	
	public void save(T entity);
	
	public void delete(Serializable ...entitydids);
	
	public void update (T entity);
	
	public T find(Serializable entityid);
	
	public Long getCount();
	
	public QueryResult<T> getScrollData(int firstResulst,int maxResult,String wheresql,Object[] queryParams,LinkedHashMap<String,String> orderby);
	
	public QueryResult<T> getScrollData(int firstResulst,int maxResult,String wheresql,Object[] queryParams);
	
	public QueryResult<T> getScrollData(int firstResulst,int maxResult,LinkedHashMap<String,String> orderby);
		
	public QueryResult<T> getScrollData(int firstResulst,int maxResult);
	
	public QueryResult<T> getScrollData();
}
