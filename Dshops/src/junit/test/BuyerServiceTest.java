package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dshop.bean.user.Buyer;
import cn.dshop.service.products.BrandService;
import cn.dshop.service.user.BuyerService;
import cn.dshop.utils.MD5;


public class BuyerServiceTest {

	 private static	ApplicationContext apl=null;
	  private static BuyerService buyerService=null;
	  
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		  apl=new ClassPathXmlApplicationContext("spring.xml");
		  buyerService= (BuyerService) apl.getBean("buyerServiceBean");
	}
/*	
	@Test
	public void saveBuyer(){
		
		Buyer a=new Buyer();
		a.setUsername("test1");
		System.out.println(MD5.MD5Encode("test"));
		a.setPassword("test");
		
		a.setEmail("www.toty@qq.com");
		buyerService.save(a);

	}

	*/
	
	
	/*@Test
	public void exitTest(){
		
		System.out.print(buyerService.exit("a1"));
		
		
	}*/
	
	
  /* @Test
	public void getUserTest(){
		
		System.out.println(buyerService.validate("test1", "test"));
		
	      
	}
	
	*/
	
}
