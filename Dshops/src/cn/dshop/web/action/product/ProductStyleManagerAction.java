package cn.dshop.web.action.product;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.product.ProductInfo;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.products.ProductInfoService;
import cn.dshop.service.products.ProductStyleService;
import cn.dshop.utils.ImageSizer;


@Controller
public class ProductStyleManagerAction extends BaseForm {
	
	@Resource ProductStyleService productStyleService;
	@Resource ProductInfoService productInfoService;
	
	/*样式图片*/
	private File logoImage;
	/*图片名称*/
	private String logoImageFileName;
	/*图片类型*/
	private String logoImageContentType;
	/*样式名称*/
	private String styleName;
	/*产品id*/
	private Integer productId;
	/*样式id*/
	private Integer productStyleId;
	
	

	public Integer getProductStyleId() {
		return productStyleId;
	}

	public void setProductStyleId(Integer productStyleId) {
		this.productStyleId = productStyleId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public File getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(File logoImage) {
		this.logoImage = logoImage;
	}

	public String getLogoImageFileName() {
		return logoImageFileName;
	}

	public void setLogoImageFileName(String logoImageFileName) {
		this.logoImageFileName = logoImageFileName;
	}

	public String getLogoImageContentType() {
		return logoImageContentType;
	}

	public void setLogoImageContentType(String logoImageContentType) {
		this.logoImageContentType = logoImageContentType;
	}
	
	/**
	 * 增加新样式
	 * @return
	 */
	public String addStyle(){
		
		ProductInfo produt=productInfoService.find(this.productId);
		
		
		if(this.logoImage!=null){
				
			String ext=this.logoImageFileName.substring(this.logoImageFileName.lastIndexOf('.'));
			String imgName=UUID.randomUUID().toString()+ext;
			String savedir="/images/product/"+produt.getType().getTypeid()+"/"+produt.getId()+"/prototype";
		
			String realpath=ServletActionContext.getServletContext().getRealPath(savedir);
			
		    
			File f=new File(new File(realpath),imgName);
			if(!f.getParentFile().exists()){
				
				f.getParentFile().mkdirs();

			}			
			
				try {
					FileUtils.copyFile(this.logoImage, f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

				
			   //压缩图片
				String savedir140="/images/product/"+produt.getType().getTypeid()+"/"+produt.getId()+"/140x";
				String realpath140=ServletActionContext.getServletContext().getRealPath(savedir140);
				File savefile140=new File(realpath140);
				
				if(!savefile140.exists()) savefile140.mkdirs();
				File file140=new File(new File(realpath140),imgName);
				try {
					ImageSizer.resize(this.logoImage, new File(new File(realpath140),imgName), 200, "gif");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				

				
				ProductStyle style=new ProductStyle();
				style.setName(this.styleName);
				style.setProduct(produt);
				style.setImagesname(imgName);
				productStyleService.save(style);
		}
		
		ActionContext.getContext().put("message", "添加成功");

		
		return "dealstyel";
		
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 更新样式
	 * @return
	 */
	
	
	public String updateStyle(){
		
		ProductInfo produt=productInfoService.find(this.productId);
		ProductStyle style=productStyleService.find(this.productStyleId);
		style.setName(this.styleName);
	    
		if(this.logoImage!=null){

			String ext=this.logoImageFileName.substring(this.logoImageFileName.lastIndexOf('.'));
			String imgName=UUID.randomUUID().toString()+ext;
			String savedir="/images/product/"+produt.getType().getTypeid()+"/"+produt.getId()+"/prototype";
			String realpath=ServletActionContext.getServletContext().getRealPath(savedir);
		
			
			File f=new File(new File(realpath),imgName);
			if(!f.getParentFile().exists()){				
				f.getParentFile().mkdirs();

			}			
				try {
					FileUtils.copyFile(this.logoImage, f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
				
				   //压缩图片
					String savedir140="/images/product/"+produt.getType().getTypeid()+"/"+produt.getId()+"/140x";
					String realpath140=ServletActionContext.getServletContext().getRealPath(savedir140);
					File savefile140=new File(realpath140);
					
					if(!savefile140.exists()) savefile140.mkdirs();
					File file140=new File(new File(realpath140),imgName);
					try {
						ImageSizer.resize(this.logoImage, new File(new File(realpath140),imgName), 200, "gif");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				
				
				
								
				style.setProduct(produt);
				style.setImagesname(imgName);
				
		}
		
		
		 
		
		
		     style.setName(this.styleName);
		     productStyleService.update(style);		     
		     ActionContext.getContext().put("message", "修改成功");

		
		return "dealstyel";
	}
	
	
	/**
	 * 删除样式
	 * @return
	 */
	
	public String deletstyle(){
		
		productStyleService.delete(this.productStyleId);
		
		return "dealstyel";
		
	}
	
	
	/**
	 * 样式是否上架销售
	 * 产品id
	 * statue ture 上架 false下架
	 */
	
	public String visible(){
		
		productStyleService.setVisibleStatue(this.productStyleId, true);		
		return "dealstyel";

	}
	
	/**
	 * 样式是否上架销售
	 * 产品id
	 * statue ture 上架 false下架
	 */
	
	public String unvisible(){
		
		productStyleService.setVisibleStatue(this.productStyleId, false);
		return "dealstyel";
		
		
	}
		

}
