package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dshop.bean.privilege.Department;
import cn.dshop.service.priviledge.DepartmentService;
import cn.dshop.service.user.BuyerService;

public class DepartmentServiceTest {
	
	
	
	 private static	ApplicationContext apl=null;
	 private static DepartmentService departmentService=null;
	  

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		 apl=new ClassPathXmlApplicationContext("spring.xml");
		 departmentService= (DepartmentService) apl.getBean("departmentServiceBean");

	}
	
	
	@Test
	public void getDepart(){
		
		System.out.print(((Department)departmentService.find("d6ded28b-3930-4f01-aa22-4b71720c0705")).getName());
		
		
	}

}
