package cn.dshop.web.action.priviledge;

import java.lang.reflect.Method;


/**
 * 注释解析器
 * @author Administrator
 *
 */
public class ValidatePermission {

	public static Permission parsePermission(Class clazz,String methodName,Class...parameterTypes)throws NoSuchMethodException {
		
		Method method=clazz.getMethod(methodName, parameterTypes);
		
		if(method!=null&&method.isAnnotationPresent(Permission.class)){
			
			Permission permission=method.getAnnotation(Permission.class);
		 
			if(null!=permission){
				
				return permission;
			}
				
			
		}
		
		return null;
		
	
	}
	
	
	
	
	
	
	
}
