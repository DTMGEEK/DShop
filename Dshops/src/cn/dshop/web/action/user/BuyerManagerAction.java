package cn.dshop.web.action.user;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import cn.dshop.beans.BaseForm;
import cn.dshop.service.user.BuyerService;




@Controller
public class BuyerManagerAction extends BaseForm {

	
	@Resource BuyerService buyerService;

	private String username;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 启用用户帐号
	 * @return
	 */
	public String visible(){
	
		buyerService.setVisibleStatue(this.username, true);	
		return "dealUser";
		
	}
	
	/**
	 * 禁用用户帐号
	 * @return
	 */
	public String unvisible(){
		
		buyerService.setVisibleStatue(this.username, false);
		return "dealUser";
		
	}
	
	
	
	
	
}
