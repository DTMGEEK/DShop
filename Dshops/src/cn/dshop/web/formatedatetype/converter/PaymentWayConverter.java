package cn.dshop.web.formatedatetype.converter;

import java.util.Map;
import cn.dshop.bean.book.PaymentWay;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;


/**
 * 支付方式类型转换器
 * @author Administrator
 *
 */
public class PaymentWayConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
	
		if(value instanceof PaymentWay){
			
			return value;
			
		}
		
		try {
			return PaymentWay.valueOf((String) value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	

}
