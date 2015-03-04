package cn.dshop.web.action.order;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.book.Order;
import cn.dshop.bean.privilege.Employee;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.book.OrderService;
import cn.dshop.utils.WebUtil;

@Controller
public class OrderViewAction extends BaseForm {
	
	@Resource OrderService orderService;
	
	/*订单id*/
	private String orderid;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}



	
	public String  orderView(){
		
		ActionContext.getContext().put("order",orderService.find(this.orderid));
		
		//返回到orderview。jsp 显示订单的详细信息
		return "orderview";
		
	}
	
	
	
	
	
	/**
	 * 锁定订单
	 * @return
	 */
	public String addLock(){
		
		Employee employee=WebUtil.getEmployee(ServletActionContext.getRequest());
		String username=employee.getUsername();
		Order order=orderService.addLock(this.orderid, username);
		
		if(order.getLockuser()!=null&&!order.getLockuser().equals(username)){
			
			ActionContext.getContext().put("message", "订单已经"+order.getLockuser()+"被加锁");
			return "message";

		}
		
		
	      ActionContext.getContext().put("message", "订单已经被锁定");
		
	      
		return "addlock";
		
	}
	
	

}
