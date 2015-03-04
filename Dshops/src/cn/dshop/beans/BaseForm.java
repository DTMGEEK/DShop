package cn.dshop.beans;

import com.opensymphony.xwork2.ActionSupport;

public class BaseForm extends ActionSupport {

	
	private  int page;
	
	protected String queryvalue;
	


	public String getQueryvalue() {
		return queryvalue;
	}

	public void setQueryvalue(String queryvalue) {
		this.queryvalue = queryvalue;
	}

	public int getPage() {
		return page<1?1:page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
   
	


	
}
