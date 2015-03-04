package cn.dshop.web.formatedatetype.converter;

import java.util.Map;

import cn.dshop.bean.privilege.SystemPrivilegePK;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;


/**
 * 权限组转换器
 * @author Administrator
 *
 */
public class SystemPrivilegePKConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
	
		
	
		
		if(toType==SystemPrivilegePK.class){
		
			
			SystemPrivilegePK id=(SystemPrivilegePK) value;
			return id.getModule()+","+id.getPrivilege();
			
			
		}
		
		if(toType==String.class){
		
			
			try {
				String idstr=(String) value;
				String[] ids=idstr.split(",");
				if(ids.length==2){
				
					return new SystemPrivilegePK(ids[0],ids[1]);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		return null;
		
		
		
		
		
		
		
	}
	
	
	

}
