package cn.dshop.web.formatedatetype.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;


/**
 * 日期类型转换器
 * @author Administrator
 *
 */

public class DateConverter extends DefaultTypeConverter {

	
	
	
	
	
	
	
	
	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
		
		SimpleDateFormat  dateFromat=new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			if(toType==Date.class){
				
				String[] params=(String[]) value;
				
				return dateFromat.parse(params[0]);
				
			}else if(toType==String.class){
				
				Date date=(Date) value;
				
				return dateFromat.format(date);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}
	
	
	

}
