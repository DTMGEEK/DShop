package cn.dshop.service.book;

import cn.dshop.bean.book.Order;
import cn.dshop.beans.BuyCart;
import cn.dshop.service.base.DAO;

public interface OrderService extends DAO<Order> {

	
	
	
	public Order createOrder(BuyCart cart,String username);
	
	
	public void updateDiliverFee(String orderid,float fee);
	
	public void cancelOrder(String orderid);
	
	public void confirmOrder(String orderid);
	
	public void confirmPayment(String orderid);
	
	public void turnWaitdeliver(String orderid);
	
	public void trunDelivered(String orderid);
	
	
	public void turnReceived(String orderid);

	public Order addLock(String orderid,String username);
	
	
	public void unlock(String...orderids);
}
