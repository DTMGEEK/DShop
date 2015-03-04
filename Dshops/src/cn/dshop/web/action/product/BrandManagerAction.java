package cn.dshop.web.action.product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.dshop.bean.product.Brand;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.products.BrandService;

@Controller
public class BrandManagerAction extends ActionSupport {
	
	
	@Resource BrandService brandService;
	/*品牌名称*/
	private String brandName;
	/*品牌图片*/
	private File logoimg;
	/*品牌图片名称*/
	private String logoimgFileName;
	/*品牌代号*/
	private String code;
	/*品牌图片类型*/
	private String logoimgContentType;
	public String getLogoimgContentType() {
		return logoimgContentType;
	}


	public void setLogoimgContentType(String logoimgContentType) {
		this.logoimgContentType = logoimgContentType;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public File getLogoimg() {
		return logoimg;
	}


	public void setLogoimg(File logoimg) {
		this.logoimg = logoimg;
	}

	public String getLogoimgFileName() {
		return logoimgFileName;
	}

	public void setLogoimgFileName(String logoimgFileName) {
		this.logoimgFileName = logoimgFileName;
	}

/**
 * 增加新品牌
 * @return
 * @throws IOException
 */
	public String Addbrand() throws IOException {
		
		Brand brand=new Brand();
		brand.setName(this.getBrandName());
		
		if(this.logoimg!=null){
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd/HH/");
			String logopath="/images/brand/"+sdf.format(new Date());
			String realpath=ServletActionContext.getServletContext().getRealPath(logopath);
			String ext=this.logoimgFileName.substring(this.logoimgFileName.lastIndexOf('.'));
			String imgName=UUID.randomUUID().toString()+ext;
			String savedir="/images/brand/"+sdf.format(new Date())+"/"+imgName;
			brand.setLogopath(savedir);		
			File f=new File(new File(realpath),imgName);
			if(!f.getParentFile().exists()){				
				f.getParentFile().mkdirs();

			}			
				FileUtils.copyFile(this.logoimg, f);	
				brandService.save(brand);	
				
		}
		
		ActionContext.getContext().put("message", "添加成功");

		        return "crudbrand";
	}
	
	
	
	/**
	 * 更新品牌
	 * @return
	 * @throws IOException
	 */
	
	public String updateBrand() throws IOException{
		
		Brand brand=null;
		brand=brandService.find(this.getCode());
		brand.setName(this.getBrandName());
		
		if(this.logoimg!=null){
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd/HH/");
			String logopath="/images/brand/"+sdf.format(new Date());
			String realpath=ServletActionContext.getServletContext().getRealPath(logopath);
			String ext=this.logoimgFileName.substring(this.logoimgFileName.lastIndexOf('.'));
			String imgName=UUID.randomUUID().toString()+ext;
			String savedir="/images/brand/"+sdf.format(new Date())+"/"+imgName;
			brand.setLogopath(savedir);	
			
			File f=new File(new File(realpath),imgName);
			if(f.getParentFile().exists()){				
				f.getParentFile().mkdirs();

			}			
				FileUtils.copyFile(this.logoimg, f);	
				brandService.update(brand);	
				
		}

		 return "crudbrand";
		
	}
	
	
	
	/**
	 * 删除品牌
	 * @return
	 */
	
	public String delBrand(){
		
		brandService.delete(this.getCode());
		ActionContext.getContext().put("message", "删除成功");
		
		return "crudbrand";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
