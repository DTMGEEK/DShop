package junit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dshop.bean.product.Brand;
import cn.dshop.service.products.BrandService;
import cn.dshop.service.products.ProductTypeService;

public class BrandServiceTest {

	
	 private static	ApplicationContext apl=null;
	  private static BrandService brandService=null;
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			
		   try {
			apl=new ClassPathXmlApplicationContext("spring.xml");
			   brandService= (BrandService) apl.getBean("brandServiceBean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
		
	/*	@Test
		public void runTest(){
			
			try {
				System.out.print("dddd");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}*/
		
		
	
	/*@Test
	public void testSave() {
		
		brandService.save(new Brand("","/images/2011/11/01/OrndaTest.gif"));
		brandService.save(new Brand("歌美","/images/2011/11/01/GMTest.gif"));
		brandService.save(new Brand("蓝魔","/images/2011/11/01/BLueTest.gif"));
		brandService.save(new Brand("酷比魔方","/images/2011/11/01/CoolTest.gif"));
		brandService.save(new Brand("台电","/images/2011/11/01/TaidianTest.gif"));
		
	}*/

}
