package cn.dshop.service.priviledge;

import java.util.List;

import cn.dshop.bean.privilege.SystemPrivilege;
import cn.dshop.service.base.DAO;

public interface SystemPriviledgeService extends DAO<SystemPrivilege> {

	
	public void saves(List<SystemPrivilege> priviledges);
}
