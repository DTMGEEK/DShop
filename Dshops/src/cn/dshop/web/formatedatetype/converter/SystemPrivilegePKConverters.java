package cn.dshop.web.formatedatetype.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import cn.dshop.bean.privilege.SystemPrivilegePK;

/**
 * 权限组类型转换器
 * @author Administrator
 *
 */
public class SystemPrivilegePKConverters extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {

		
		if(values.length==1){	
		
		
			String str=values[0];
			String[] strs=str.split(",");
					
		    return  new SystemPrivilegePK[]{new SystemPrivilegePK(strs[0],strs[1])};
	
		}
		if(values.length>1){
			
			
			SystemPrivilegePK[] spk=new SystemPrivilegePK[values.length];
			
			for(int i=0;i<values.length;i++){
				
				String str=values[i];
				String [] strs=str.split(",");
				
				spk[i]=new SystemPrivilegePK(strs[0],strs[1]);
				
		
			}
			
			
			return spk;
		
			
			
			
			
		}
		
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {

		return null;
	}

}
