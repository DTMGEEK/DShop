package cn.dshop.web.formatedatetype.converter;

import java.util.Map;

import cn.dshop.bean.book.OrderState;
import cn.dshop.bean.book.PaymentWay;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;


/**
 * 订单状态 转换器
 * @author Administrator
 *
 */
public class OrderStateConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
	
		
		if(toType.isEnum()){
			
			
			if(value==null)
			  return null;
			
			if(value instanceof String[]){
				
				String[] ss=(String[]) value;
				
				if(ss.length==1){
					
					return Enum.valueOf(toType, ss[0]);
					
				}else{
					
					Object[] oo=new Object[ss.length];
					for(int i=0;i<ss.length;i++){
						
						oo[i]=Enum.valueOf(toType, ss[i]);
					}
					
					return oo;
				}
				
			}
			
			
			
			
		}
		return null;
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
