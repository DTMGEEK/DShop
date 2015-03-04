package cn.dshop.web.action.priviledge;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.dshop.bean.privilege.Department;
import cn.dshop.beans.BaseForm;
import cn.dshop.beans.PageView;
import cn.dshop.beans.QueryResult;
import cn.dshop.service.priviledge.DepartmentService;

@Controller
public class DeparetmentAction extends BaseForm {

  @Resource	DepartmentService departmentService;
	
  @Permission(module="department",privilege="view")//这方法必须具备查看权限
  public String showAllDepart(){
	  
	  int maxResult=12;
	  
	  PageView<Department> pageview=new PageView<Department>(maxResult,this.getPage());
	  QueryResult<Department> qr=departmentService.getScrollData(pageview.getFirstResult(), maxResult);
	  pageview.setQueryResult(qr);  
	  ActionContext.getContext().put("pageView",pageview);

	  return "alldepartmetn";
  }
  
  
	
	
	
}
