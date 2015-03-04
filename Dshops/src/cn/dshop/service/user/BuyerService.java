package cn.dshop.service.user;

import cn.dshop.bean.user.Buyer;
import cn.dshop.service.base.DAO;

public interface BuyerService extends DAO<Buyer> {
	
	public Boolean exit(String username);
	
	public Boolean validate(String username,String password);
	
	public void setVisibleStatue(String username,boolean statue);
	
	public void updatePassword(String username, String newpassword);

}
