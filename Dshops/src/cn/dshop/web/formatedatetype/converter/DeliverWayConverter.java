package cn.dshop.web.formatedatetype.converter;

import java.util.Map;

import cn.dshop.bean.book.DeliverWay;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;


/**
 * 送货方式类型转换器
 * @author Administrator
 *
 */
public class DeliverWayConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
		
		   if(value instanceof DeliverWay){			   
			   return value;
 
		   }

		try {
			return DeliverWay.valueOf((String) value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	

}
