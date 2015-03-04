package junit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.products.ProductSearchService;

public class ProductSearchServiceTest {

	static ProductSearchService  c=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		 c=(ProductSearchService) cxt.getBean("productSearchServiceBean");
		
		
		
		
	}

	@Test
	public void testQuery() {
		
		try {
			QueryResult<ProductInfo> q=c.query("刀锋", 0, 5);
			
			for(ProductInfo a:q.getResultList()){
				
				System.out.println(a.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
