package junit.test;


import java.util.Date;
import java.util.LinkedHashMap;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.dshop.bean.product.ProductType;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.base.DAO;
import cn.dshop.service.products.ProductTypeService;



public class productTypeTests {

  private static	ApplicationContext apl=null;
  private static ProductTypeService producttypeserice=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	   apl=new ClassPathXmlApplicationContext("spring.xml");
	   producttypeserice= (ProductTypeService) apl.getBean("productTypeServiceBean");
		
	}
	
	
	/*@Test
	public void RunTest(){

				ProductTypeService service=(ProductTypeService) apl.getBean("productTypeServiceBean");

	}
	*/
	
	@Test
	public void SaveTest(){
				
		producttypeserice.save(new ProductType("手机","手机"));
		producttypeserice.save(new ProductType("笔记本电脑","笔记本电脑"));
		producttypeserice.save(new ProductType("硬件DIY","硬件DIY"));
		producttypeserice.save(new ProductType("MP3/MP4","MP3/MP4"));
		producttypeserice.save(new ProductType("台式电脑","台式电脑"));
		producttypeserice.save(new ProductType("服务器","服务器"));
		producttypeserice.save(new ProductType("一体电脑","一体电脑"));
		producttypeserice.save(new ProductType("相机","相机"));
		producttypeserice.save(new ProductType("智能电视","智能电视"));
	
	}
	
	
	

	/*@Test
	public void deleteTest(){
		
		producttypeserice.delete(4);

	}
	
	
	*/
	/*@Test
	public void updatTest(){
		ProductType a=(ProductType) producttypeserice.find(5);
		a.setNote("XPS 15");
		producttypeserice.update(a);

	}*/
	
	
	
	
	/*@Test
	
	public void findTest(){

		System.out.print(((ProductType)producttypeserice.find(4)).getName());


	}*/
	
	
	/*@Test
	public void getScrollDataTest(){
		
      
		QueryResult<ProductType> rlist;

			LinkedHashMap<String,String> orderby=new LinkedHashMap<String,String>();
			orderby.put("typeid", "desc");
			rlist = producttypeserice.getScrollData(5, 10, " o.visible=?1", new Object[]{true}, orderby);
			//rlist = producttypeserice.getScrollData(5, 10, " o.visible=?1", new Object[]{true});
			
			//rlist = producttypeserice.getScrollData(5, 10, orderby);
			
			//rlist = producttypeserice.getScrollData(5, 10);
			rlist = producttypeserice.getScrollData();
			
	
		
		for(ProductType type:rlist.getResultList()){
			
			System.out.println(type.getName()+type.getTypeid());
			
		}

		
	}*/
	
	
	
	
	/*@Test
	public void addFile(){
		
		UploadFile a=new UploadFile();
		a.setFilename("test");
		a.setFilepath("testpath");
		a.setUploadtime(new Date());
		
		UploadFileService s=(UploadFileService) apl.getBean("fileUploadServiceBean");
		s.save(a);
		
		
		
		
	}*/
}


