package cn.dshop.web.action.order;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.book.Order;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.service.book.OrderService;


/**
 * 已经锁定订单列表
 * @author Administrator
 *
 */
@Controller
public class LoadOrderListAction extends BaseForm {

	@Resource OrderService orderService;
	
	private int maxResult=12; 
	
	
	public String allLockBook(){
		
		PageView<Order> pageView=new PageView<Order>(maxResult,this.getPage());
		LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
		orderby.put("createDate", "asc");
		pageView.setQueryResult(orderService.getScrollData(pageView.getFirstResult(), maxResult, "o.lockuser is  not null", null, orderby));
		
		ActionContext.getContext().put("pageView", pageView);
		
		return "lockerlist";
		
	}
	
	
	
}
