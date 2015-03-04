package junit.test;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.bean.product.ProductType;
import cn.dshop.service.products.BrandService;
import cn.dshop.service.products.ProductInfoService;

public class ProductInfoServiceBeanTest {

	 private static	ApplicationContext apl=null;
	  private static ProductInfoService productInfoService=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		   apl=new ClassPathXmlApplicationContext("spring.xml");
		   productInfoService= (ProductInfoService) apl.getBean("productInfoServiceBean");
			
		
		
	}
	
	@Test
	public void test(){
		
		System.out.print("dddd");
		
	}
	
	/*@Test
	public void saveTest(){
		
		
			try {
				ProductInfo a=new ProductInfo();
				a.setName("三星9");
				a.setBaseprice(100f);
				a.setBrand(new Brand("2980a475-978d-459b-bc68-da9d9cc43a49"));
				a.setCode("UT002");
				a.setDescription("android MP4");
				a.setMarketprice(250f);
				a.setModel("UT");
				a.setSellprice(400f);
				a.addProductStyle(new ProductStyle("黑色","ssd.gif"));
			
				a.setType(new ProductType(2));
				a.setWeight(50f);
				productInfoService.save(a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}*/
	
	
	/*@Test
	public void getCommandG(){
		
		List<ProductInfo> a=productInfoService.getTopSell(1, 2);	
		
		for(ProductInfo p:a){
		
			System.out.println(p.getName());
			
		}
	}
	*/
	
	/*@Test
	public void getViewHistory(){
		
		List<ProductInfo> a=productInfoService.getViewHistory(new Integer[]{1,3}, 3);
		
		for(ProductInfo b:a){
			
               System.out.print(b.getName());
			
		}
		
	}*/
	
	

}
