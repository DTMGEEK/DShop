package cn.dshop.web.action.order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.book.Order;
import cn.dshop.bean.book.OrderState;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.book.OrderService;


/**
 * 订单分页列表
 * @author Administrator
 *
 */
//传递了state 就查询该状态订单 否则 查询待审核订单
@Controller
public class OrderListAction extends BaseForm {
	
	@Resource OrderService orderService;
	
	/*订单id*/
	private String orderid;
	/*用户姓名*/
	private String username;
	/*收货人姓名*/
	private String recipients;
	/*查询标识*/
	private String query;
	/*订单状态*/
	private OrderState state;
	
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}


	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}
	
	
	public String showOrderForm(){
		

		int maxResult=12;
		
	    
		PageView<Order> pageview=new PageView<Order>(maxResult,this.getPage());
		OrderState tstate=this.state!=null?this.getState():OrderState.WAICONFIRM;
		

		
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
		orderby.put("createDate", "asc");
		QueryResult<Order> qr=null;
		
		
		/*查询*/
		if(this.query!=null&&!"".equals(this.query)){
			
		    StringBuilder hql=new StringBuilder();
		    List<Object> params=new ArrayList<Object>();
		    
		   
		    
		    
			
			//订单号
		    if(this.orderid!=null&&!"".equals(this.orderid)){
		    	
		    	params.add("%"+this.orderid.trim()+"%");
		    	hql.append("o.orderid like ?").append((params.size()));
		    	ActionContext.getContext().put("qorderid", this.orderid);
		    	
		    }
		    //订单状态
		    if(this.state!=null){
		        if(!params.isEmpty()) hql.append(" and ");
		    	
		    	params.add(this.state);
		    	hql.append(" o.state=?").append(params.size());
		    	ActionContext.getContext().put("qstate", this.state);

		    }
		    //用户名
		    if(this.username.trim()!=null&&!"".equals(this.username.trim())){
		    	
		    	if(!params.isEmpty()) hql.append(" and ");
		    	
		    	params.add("%"+this.username+"%");
		    	hql.append(" o.buyer.username like ?").append(params.size());
		    	ActionContext.getContext().put("qousername", this.username);
		   
		    }
		    //收件人姓名
		    if(this.recipients.trim()!=null&&!"".equals(this.recipients.trim())){
		    
		    	if(!params.isEmpty()) hql.append(" and ");
		    	
		    	params.add("%"+this.recipients.trim()+"%");
		    	hql.append(" o.orderDeliverInfo.recipients like ?").append(params.size());
		    	ActionContext.getContext().put("qoreceptients", this.recipients);
		    }
		    
		    
		
		    qr=orderService.getScrollData(pageview.getFirstResult(), maxResult, hql.toString(), params.toArray(), orderby);
		    
			
			
			
			
		}else{
			
			qr=orderService.getScrollData(pageview.getFirstResult(), maxResult, "o.state=?1", new Object[]{tstate}, orderby);
			
		}

		
		
		
		
	

		pageview.setQueryResult(qr);
		ActionContext.getContext().put("pageView", pageview);
		
		
		return "allroder";
		
		
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
	

}
