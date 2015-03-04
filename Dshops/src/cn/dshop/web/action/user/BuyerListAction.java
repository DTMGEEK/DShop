package cn.dshop.web.action.user;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.user.Buyer;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.user.BuyerService;

@Controller
public class BuyerListAction extends BaseForm {

	@Resource BuyerService buyerService;
	
	private String query;
	
	private String username;
	
	private String realname;
	
	private String email;
	
	
	

	
	
	public String getQuery() {
		return query;
	}






	public void setQuery(String query) {
		this.query = query;
	}






	public String getUsername() {
		return username;
	}






	public void setUsername(String username) {
		this.username = username;
	}






	public String getRealname() {
		return realname;
	}






	public void setRealname(String realname) {
		this.realname = realname;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}




/**
 * 查询出全部用户和条件查询
 * @return
 */

	public String showAllUser(){
		
	   int maxResult=12;
	   QueryResult<Buyer> qr = null;
	   StringBuilder whql=new StringBuilder();
	   List<Object> params=new ArrayList<Object>();
	   LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
	   orderby.put("regTime", "desc");
	   PageView<Buyer> pageview=new PageView<Buyer>(maxResult,this.getPage());
	   
	   //查询
	   if(this.getQuery()!=null){
		   
		   
	       ActionContext.getContext().put("queryvalue", "queryvalue");
	       
	       
		  
		   
		   if(this.username.trim()!=null&&!"".equals(this.username.trim())){
			   
			     params.add("%"+this.username.trim()+"%");
			     whql.append(" o.username like ?").append(params.size());
			     ActionContext.getContext().put("qusername", this.username);
			   
			 
			   
		   }
		   
		   if(this.email.trim()!=null&&!"".equals(this.email.trim())){
			   
			   if(!(params.isEmpty())) {
				   whql.append(" and ");
			   }
			   params.add("%"+this.email.trim()+"%");
			   whql.append(" o.email like ?").append(params.size());
			   
			   ActionContext.getContext().put("qemail", this.email);
			   
			   
		   }
		   
		   if(this.realname!=null&&!"".equals(this.realname)){
			   
			   if(!(params.isEmpty())){
				   
				   whql.append(" and ");
			   }
			   params.add("%"+this.realname.trim()+"%");
			   whql.append(" o.realname like ?").append(params.size());
			   ActionContext.getContext().put("qrealname", this.realname);
			   
			   
		   }
  
	       qr= buyerService.getScrollData(pageview.getFirstResult(), maxResult, whql.toString(), params.toArray(), orderby);
		   
	   }else{
		   
		   qr=buyerService.getScrollData(pageview.getFirstResult(), maxResult, orderby);
		   
	   }
	  
	   pageview.setQueryResult(qr);
	   ActionContext.getContext().put("pageView",pageview);
      
       return "allUser";
	   

	}
	
	
	
	
	
	
	

}
