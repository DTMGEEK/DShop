package cn.dshop.service.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

import cn.dshop.beans.QueryResult;
import cn.dshop.utils.GenericsUtils;


/**
 *  DAO基类
 * @author ken lian
 *
 * @param <T> 泛型使用时决定
 */
@Transactional
public abstract class DAOSupport<T> implements DAO<T> {
	
	@PersistenceContext protected EntityManager em;

	public void clear(){
		em.clear();
	}
	
	
	
	protected Class<T> entityClass=GenericsUtils.getSuperClassGenricType(this.getClass());
	
	/**
	 * 删除
	 */
	public void delete(Serializable... entitydids) {
		
		for(Object id:entitydids){		
			em.remove(em.getReference(this.entityClass, id));

		}
		
	}

	
	/**
	 * 查找
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T find(Serializable entityid) {
		if(entityid==null) throw new RuntimeException(this.getClass().getName()+" can not find ");
		
		return em.find(this.entityClass, entityid);
		
	}

	
	/**
	 * 保存
	 */
	public void save(T entity) {	
		em.persist(entity);
		
	}
	
	/**
	 * 
	 * 更新
	 */

	public void update(T entity) {
		
		em.merge(entity);
		
	}
	
	
	/**
	 * 得到总记录数
	 * @return
	 */
	public Long getCount(){
		
  	 Long totalrecord =(Long) em.createQuery(" select count(o) from "+getEntityName(this.entityClass)+" o ").getSingleResult();
	
		return totalrecord;		
	}
	
	
	
	/**
	 * 数据库分页
	 * @param firstResulst 开始查找记录数
	 * @param maxResult    每页显示记录数
	 * @param wheresql     条件语句
	 * @param queryParams  条件
	 * @param orderby      排序
	 * @return
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResulst,int maxResult,String wheresql,Object[] queryParams,LinkedHashMap<String,String> orderby){
		
		QueryResult<T> queryResult=new QueryResult<T>();	
		String entityname=this.getEntityName(this.entityClass);
		Query query = em.createQuery("select o from "+ entityname+ " o "+(wheresql==null || "".equals(wheresql.trim())? "": "where "+ wheresql)+ buildOrderBy(orderby));
	    if(queryParams!=null&&queryParams.length>0) setQueryParam(query, queryParams);
		if(firstResulst!=-1&&maxResult!=-1){
			query.setFirstResult(firstResulst) ;
			query.setMaxResults(maxResult);
			
		}
		queryResult.setResultList(query.getResultList());
	    query=em.createQuery("select count (o) from "+getEntityName(this.entityClass)+" o "+(wheresql==null? "":" where "+wheresql));
		this.setQueryParam(query, queryParams);
		queryResult.setTotalRecord((Long)query.getSingleResult());
		
		return queryResult;
	}
	
	/**
	 * 数据库分页
	 * @param firstResulst 开始查找记录数
	 * @param maxResult    每页显示记录数
	 * @param wheresql     条件语句
	 * @param queryParams  条件
	 * @return
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResulst,int maxResult,String wheresql,Object[] queryParams){
		
		return getScrollData(firstResulst, maxResult, wheresql, queryParams, null);
		
	}
	
	
	/**
	 * 数据库分页
	 * @param firstResulst 开始查找记录数
	 * @param maxResult    每页显示记录数
	 * @param orderby      排序
	 * @return
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResulst,int maxResult,LinkedHashMap<String,String> orderby){
		
		return getScrollData(firstResulst, maxResult, null, null, orderby);
	}
	
	

	/**
	 * 数据库分页
	 * @param firstResulst 开始查找记录数
	 * @param maxResult    每页显示记录数
	 * @return
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstResulst,int maxResult){
		
		return this.getScrollData(firstResulst, maxResult, null, null, null);
		
	}
	
	/**
	 * 数据库分页
	 * @return
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(){
		return this.getScrollData(-1,-1);
	}
	

	/**
	 * 得到注释的名字
	 * @param <E> 实体类
	 * @param clazz 
	 * @return  
	 */
	protected static <E> String getEntityName(Class<E> clazz){
		String entityname=clazz.getSimpleName();
		return entityname;

	}
	
		
	/**
	 * 设置条件
	 * @param query
	 * @param queryParams
	 */
	protected static void setQueryParam(Query query,Object[] queryParams){	
		if(queryParams!=null&&queryParams.length>0){
			for(int i=0;i<queryParams.length;i++){
				query.setParameter(i+1, queryParams[i]);
			}
		}
	}
	
	
	
	
	/**
	 * 设置排序条件
	 * @param orderby 
	 * @return
	 */
	protected  static String  buildOrderBy(LinkedHashMap<String,String> orderby){
		StringBuffer torderby=new StringBuffer();
		if(orderby!=null&&orderby.size()>0){
			torderby.append(" order by ");
			for(String key:orderby.keySet()){
				torderby.append(" o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			torderby.deleteCharAt(torderby.length()-1);
		}
		return torderby.toString();
	}
	

	
}
