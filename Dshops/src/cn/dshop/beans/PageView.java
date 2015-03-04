package cn.dshop.beans;

import java.util.List;



public class PageView<T>{
	
	/*分页数据*/
	private List<T> records;
	/*页码开始索引和结束索引*/
	private PageIndex pageindex;
	/*总页数*/
	private long totalpage=1;
	/*每页记录数*/
	private int maxresult=12;
	/*当前页*/
	private int currentpage=1;
	/*总记录数*/
	private long totalrecord;
	/*页面数量*/
	private int pagecode=10;
	
	
	
	public PageView(int maxresult, int currentpage) {
		this.maxresult = maxresult;
		this.currentpage = currentpage;
	}
	
	/**
	 * 设置记录
	 * @param qr
	 */
	
	public void setQueryResult(QueryResult<T> qr){		
		this.setRecords(qr.getResultList());
		this.setTotalrecord(qr.getTotalRecord());
	}
	
	
	/**
	 * 设置开始索引
	 * @return
	 */
	public int getFirstResult(){
		
		return (currentpage-1)*maxresult;
	}
	
	
	
	

	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public PageIndex getPageindex() {
		return pageindex;
	}

	public void setPageindex(PageIndex pageindex) {
		this.pageindex = pageindex;
	}

	public long getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
		this.pageindex = PageIndex.getPageIndex(pagecode, currentpage, totalpage);
	}

	public int getMaxresult() {
		return maxresult;
	}

	public void setMaxresult(int maxresult) {
		this.maxresult = maxresult;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public long getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
		setTotalpage(this.totalrecord%this.maxresult==0? this.totalrecord/this.maxresult : this.totalrecord/this.maxresult+1 );
	}

	
	
	
	

}
