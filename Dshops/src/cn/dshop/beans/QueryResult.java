package cn.dshop.beans;

import java.util.List;

/**
 * 保存数据
 * @author ken lian
 *
 * @param <T>
 */
public class QueryResult<T> {
	
	/*数据集合*/
	private List<T> resultList;
	/*总页数*/
	private Long totalRecord;
	
	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

	
	
	
	

	

}
