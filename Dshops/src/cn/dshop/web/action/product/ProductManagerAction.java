package cn.dshop.web.action.product;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.bean.product.ProductType;
import cn.dshop.beans.BaseForm;
import cn.dshop.productinfo.formbean.ProductInfoFormBean;
import cn.dshop.service.products.BrandService;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.service.products.ProductTypeService;

@Controller
public class ProductManagerAction extends BaseForm {
	
	@Resource ProductTypeService productTypeService;
	
	@Resource BrandService brandService;
	
	@Resource ProductInfoService productInfoService;
	
	/*保存从页面传过来的信息的bean*/
   private 	ProductInfoFormBean productinfobean;
   
    /*产品id*/
    private Integer productId;
    /*产品类型id*/
    private Integer typeid;
    /*产品图片*/
    private File productimg;
    /*产品图片名称*/
    private String productimgFileName;
    
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ProductInfoFormBean getProductinfobean() {
				return productinfobean;
	}
   

	public File getProductimg() {
	return productimg;
	}

	public void setProductimg(File productimg) {
		this.productimg = productimg;
	}

	public String getProductimgFileName() {
		return productimgFileName;
	}

	public void setProductimgFileName(String productimgFileName) {
		this.productimgFileName = productimgFileName;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}


	public void setProductinfobean(ProductInfoFormBean productinfobean) {
			this.productinfobean = productinfobean;
	}
	
	
	/**
	 * 得到产品类型
	 * @return
	 */
    
   public String getSelectType(){
	   
	   String hql=" o.parentType is null and o.visible=true";
	   
	   Object[] params=new Object[0];
	   if(this.getTypeid()!=null&&this.getTypeid()>0){
		   
		   hql=" o.parentType.id=?1";
		   params=new Object[]{this.getTypeid()};		   
		   ProductType type=productTypeService.find(this.getTypeid());
		   ProductType parent=type.getParentType();
		   List<ProductType> types=new ArrayList<ProductType>();
		   types.add(type);
		   while(parent!=null){
			   types.add(parent);
			   parent=parent.getParentType();
			   
		   }
		   
		   List<ProductType> showlist=new ArrayList<ProductType>();
		   ActionContext.getContext().put("menutypes", types);

	   }
	   ActionContext.getContext().put("types", productTypeService.getScrollData(-1, -1, hql.toString(), params).getResultList());
	   
	   return "selecttype";
   }
	
   
   /**
    * 得到全部品牌
    * @return
    */
   
   public String getBrandforSel(){   
	   
	   ActionContext.getContext().put("brands", brandService.getScrollData().getResultList());
	   
	   return "brandforselect";
   }
   
   
   
   
   
   
   
   
   
   
   /**
    * 增加新产品
    * @return
 * @throws IOException 
    */
   
   public String addProduct() throws IOException {
	   ProductInfo product=new ProductInfo();
	   
	   product.setName(this.productinfobean.getName());
	   product.setBaseprice(this.productinfobean.getBaseprice());
	   product.setSellprice(this.productinfobean.getSellprice());
	   product.setMarketprice(this.productinfobean.getMarketprice());
	   
	   if(this.productinfobean.getBrandid()!=null&&!"".equals(this.productinfobean.getBrandid())){
	   
		   	product.setBrand(new Brand(this.productinfobean.getBrandid()));
	   
	   }
 
	   product.setBuyeexplain(this.productinfobean.getBuyeexplain());
	   product.setCode(this.productinfobean.getCode());
	   product.setDescription(this.productinfobean.getDescription());
	   product.setModel(this.productinfobean.getModel());
	   product.setWeight(this.productinfobean.getWeight());
	   product.setType(new ProductType(this.getTypeid()));
	   String ext=this.productimgFileName.substring(this.productimgFileName.lastIndexOf('.'));
       String imgName=UUID.randomUUID().toString()+ext;
       
       product.addProductStyle(new ProductStyle(this.productinfobean.getStylename(),imgName));
	   productInfoService.save(product);
	   String saveDir = null;
	   
	   if(this.productimg!=null){
		    
           String path="/images/product/"+this.getTypeid()+"/"+product.getId()+"/prototype";
           String realPaty=ServletActionContext.getServletContext().getRealPath(path);
             
           File f=new File(new File(realPaty),imgName);
           
           if(!f.getParentFile().exists()){
        	   
        	   f.getParentFile().mkdirs();
        	   
           }

			FileUtils.copyFile(this.productimg, f);
	
           
           
	   }
	   

	   return "dealProductsuc";
	   
   }
   
   
   /**
    * 修改产品
    * @return
    */
   
   public String updateProduct(){
	   
	   ProductInfo product=productInfoService.find(this.productinfobean.getId());
	   product.setName(this.productinfobean.getName());
	   product.setBaseprice(this.productinfobean.getBaseprice());
	   product.setMarketprice(this.productinfobean.getMarketprice());
	   product.setBrand(new Brand(this.productinfobean.getBrandid()));
	   
	   productInfoService.update(product);
	   return "dealProductsuc";
	   
   }
   
   
   /**
    * 删除产品
    * @return
    */
   public String deleteProduct(){   
	   productInfoService.delete(this.productinfobean.getId());
	   return "dealProductsuc";  
	   
   }
	
   
   /**
    * 产品上架
    * @return
    */
   public String visible(){
	   
	   productInfoService.setVisibleStatue(this.getProductId(), true);
	   return "dealProductsuc";
   }
   
   /**
    * 产品下架
    * @return
    */
   
   public String unvisible(){
	   
	   productInfoService.setVisibleStatue(this.getProductId(), false);
	   return "dealProductsuc";
   }
   
   
   /**
    * 推荐产品
    * @return
    */
   public String command(){
	   
	   productInfoService.setCommandStatue(this.getProductId(), true);
	   return "dealProductsuc";   
   }
   
   
   /**
    * 不推荐产品
    * @return
    */
	
   public String uncommand(){
	      
	   productInfoService.setCommandStatue(this.getProductId(), false);
	   return "dealProductsuc";   
   }

   
   /**
    *显示增加产品列表 
    * @return
    */
   
   public String showAddProduct(){
	   
	   ActionContext.getContext().put("brands", brandService.getScrollData().getResultList());
	   
	   return "showaddproduct";
	   
	   
   }
   
   
   
   
   
}
