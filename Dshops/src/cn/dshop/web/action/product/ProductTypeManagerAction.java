package cn.dshop.web.action.product;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import cn.dshop.bean.product.ProductType;
import cn.dshop.service.products.ProductTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * 产品类别管理类
 * @author ken lian
 *
 */


@Controller
public class ProductTypeManagerAction extends ActionSupport{
	
	@Resource ProductTypeService productTypeService;
	
	/*类别名称*/
	private String name;
	/*描述*/
	private String note;
	/*类型id*/
	private Integer typeid;
	private Integer page;
	
	
	public Integer getPage() {
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public Integer getTypeid() {
		return typeid;
	}


	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}


/**
 *   增加产品
 * @return
 */

	public String addType(){
		
		ProductType type=new ProductType(this.getName(),this.getNote());
		if(this.getTypeid()!=null&&this.getTypeid()>0){
			type.setParentType(new ProductType(this.getTypeid()));
		}
		productTypeService.save(type);
		ActionContext.getContext().put("message", "添加成功");
		return "dealtypesuccess";
	}
	
	/**
	 *  删除产品类型
	 * @return
	 */
	
	
	public String delType(){
		
		productTypeService.delete(this.getTypeid());
		ActionContext.getContext().put("message","删除成功");
		return "dealtypesuccess";
		
	}
	
	/**
	 * 更新产品类型
	 * @return
	 */
	
	public String updateType(){		
		
		ProductType type=new ProductType();
		type=productTypeService.find(this.getTypeid());
		type.setName(this.getName());
		type.setNote(this.getNote());
		productTypeService.update(type);
		ActionContext.getContext().put("message", "更新成功");
		return "dealtypesuccess";
	}
	
	
	
}
