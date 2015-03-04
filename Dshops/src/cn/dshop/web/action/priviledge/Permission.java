package cn.dshop.web.action.priviledge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 细粒度权限控制 （注解方式）
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)//注解保留阶段(保留再源代码和runtime阶段)
@Target(ElementType.METHOD )//只允许注解标准在方法上

public @interface Permission {
	
	/*模块*/
	String module();
	/*权限值*/ 
	String privilege();
	

}
