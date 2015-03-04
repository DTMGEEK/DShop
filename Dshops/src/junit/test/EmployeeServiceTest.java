package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dshop.service.priviledge.EmployeeService;
import cn.dshop.service.user.BuyerService;

public class EmployeeServiceTest {

	
	

	 private static	ApplicationContext apl=null;
	  private static EmployeeService employeeService=null;
	  
	  
	  
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		 apl=new ClassPathXmlApplicationContext("spring.xml");
		 employeeService= (EmployeeService) apl.getBean("employeeServiceBean");
	}
	
	
	@Test
	public void exitTest(){
		
		try {
			System.out.println(employeeService.exist("dfd"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
