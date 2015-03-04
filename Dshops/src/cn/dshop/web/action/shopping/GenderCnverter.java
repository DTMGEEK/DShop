package cn.dshop.web.action.shopping;

import java.util.Map;

import cn.dshop.bean.privilege.Gender;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * 员工性别类型转换器
 * @author Administrator
 *
 */
public class GenderCnverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
		
		
		if(value instanceof Gender){
			
			return value;
		}
		
		try{
		    return Gender.valueOf((String) value);
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
		
		return null;
	}
	
	

}
