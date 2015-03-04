package junit.test;


import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.beans.BuyItem;

public class BuyCartTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Test
	public void BuyCartTest(){
		
		
		ProductInfo p1=new ProductInfo(1);
		p1.addProductStyle(new ProductStyle(56));
		
		ProductInfo p2=new ProductInfo(1);
		p2.addProductStyle(new ProductStyle(6));
		
		BuyItem a=new  BuyItem(p1,4);
		BuyItem b=new  BuyItem(p1,10);
		
		Assert.assertTrue("不相等", a.equals(b));
		System.out.print(a.equals(b));
		
		
		
	}
	
	
}
