package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dshop.bean.book.Order;
import cn.dshop.service.book.OrderService;

public class OrderServiceTest {

	private static ApplicationContext ap=null;
	private static OrderService orderService=null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ap=new ClassPathXmlApplicationContext("spring.xml");
		orderService=(OrderService) ap.getBean("orderServiceBean");
		
	}
	
	@Test
	public void OrderTeste(){
		Order order=orderService.createOrder(null, null);
		System.out.print(order.getOrderid());
		
		
		
	}

}
