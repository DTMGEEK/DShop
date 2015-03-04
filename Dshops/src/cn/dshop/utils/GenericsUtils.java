package cn.dshop.utils;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

/**
 * 抽象工具类
 * @author ken lian
 *
 */
public class GenericsUtils {
	
	/**  
     * 通过反射,获得指定类的父类的泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>  
     *  
     * @param clazz clazz 需要反射的类,该类必须继承范型父类
     * @param index 泛型参数所在索引,从0开始.  
     * @return 范型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */  
	public  static Class getSuperClassGenricType(Class clazz,int index){
		
		Type genTyp=clazz.getGenericSuperclass();//�õ����͸���
		if(!(genTyp instanceof ParameterizedType)){
			
			return Object.class;
		}
		
		Type[] params=((ParameterizedType)genTyp).getActualTypeArguments();
		if(index>params.length||index<0){
			
			throw new RuntimeException(index+"Խ��,����ò�����±�");
		}
		
		if(!(params[index] instanceof Class)){	
			return Object.class;
			
		}
		
		return (Class)params[index];

		
	}
	
	/**  
     * 通过反射,获得指定类的父类的第一个泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>  
     *  
     * @param clazz clazz 需要反射的类,该类必须继承泛型父类
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */  
	
	public  static Class getSuperClassGenricType(Class clazz){
		
		return getSuperClassGenricType(clazz,0);
		
	}
	
	
	/**  
     * 通过反射,获得方法返回值泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
     *  
     * @param Method method 方法
     * @param int index 泛型参数所在索引,从0开始.
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
	
	public static Class getMdthodGenericReturnType(Method method,int index){
		
		Type[] typeArguments=null;
		Type returnType=method.getGenericReturnType();
		if(returnType instanceof ParameterizedType){
			
			ParameterizedType type=(ParameterizedType) returnType;
			typeArguments=type.getActualTypeArguments();
			if(index>typeArguments.length||index<0){
				
				throw new RuntimeException(index+"Խ��,����ò�����±�");
			}
		}
		return (Class)typeArguments[index];
		
	}
	
	
	/**  
     * 通过反射,获得方法返回值第一个泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
     *  
     * @param Method method 方法
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
	
	public static Class getMdthodGenericReturnType(Method method){
		return getMdthodGenericReturnType(method,0);
		
	}
	

	/**  
     * 通过反射,获得方法输入参数第index个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String, Buyer> maps, List<String> names){}
     *  
     * @param Method method 方法
     * @param int index 第几个输入参数
     * @return 输入参数的泛型参数的实际类型集合, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回空集合
     */ 
	
	
	
	public static List<Class> getMethodGenericParameterTypes(Method method,int index){
		
		 List<Class> results=new ArrayList<Class>();
		 Type[] genericParameterTypes=method.getGenericParameterTypes();
		 if(index>genericParameterTypes.length||index<0){
			 
			 throw new RuntimeException(index+"Խ��,����ò�����±�");		 
		 }
		 
		 Type genericParameterType=genericParameterTypes[index];
		 if(genericParameterType instanceof ParameterizedType){
			 
			 ParameterizedType aType=(ParameterizedType) genericParameterType;
			 Type[] parameterArgTypes=aType.getActualTypeArguments();
			 for(Type paramterArgType:parameterArgTypes){
				 Class parameterArgClass=(Class) paramterArgType;
				 results.add(parameterArgClass);		 
			 }
			 return results;
		 }
		 return results;
	}
	
	/**  
     * ͨ����,��÷�����������һ�������������з��Ͳ����ʵ������. ��: public void add(Map<String, Buyer> maps, List<String> names){}
     *  
     * @param Method method ����
     * @return �������ķ��Ͳ����ʵ�����ͼ���, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��ؿռ���
     */ 
	
	public static List<Class> getMethodGenericParameterTypes(Method method){
		return getMethodGenericParameterTypes(method,0);
		
	}
	
	
	/**  
     * ͨ����,���Field���Ͳ����ʵ������. ��: public Map<String, Buyer> names;
     *  
     * @param Field field �ֶ�
     * @param int index ���Ͳ�����������,��0��ʼ.
     * @return ���Ͳ����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ���<code>Object.class</code>
     */ 
	
	
	
	public static Class getFieldGenericType(Field field,int index){
		Type genericFieldType=field.getGenericType();
		
		 if(genericFieldType instanceof ParameterizedType){
			 ParameterizedType aType=(ParameterizedType) genericFieldType;
			 Type[] fieldArgTypes=aType.getActualTypeArguments();
			 if(index>fieldArgTypes.length||index<0){
				 
				 throw new RuntimeException(index+"Խ��,����ò�����±�");
			 }
			 return (Class)fieldArgTypes[index]; 
		 }
		 return Object.class;

	}
	
	/**  
     * ͨ����,���Field���Ͳ����ʵ������. ��: public Map<String, Buyer> names;
     *  
     * @param Field field �ֶ�
     * @param int index ���Ͳ�����������,��0��ʼ.
     * @return ���Ͳ����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ���<code>Object.class</code>
     */ 
	
	public static Class getFieldGenericType(Field field){
		return getFieldGenericType(field,0);
		
	}
	
	

}
