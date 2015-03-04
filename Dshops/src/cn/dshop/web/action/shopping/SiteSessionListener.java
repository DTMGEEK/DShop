package cn.dshop.web.action.shopping;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * Sesion监听器  使购物车可以在新开的浏览器 使用
 * @author Administrator
 *
 */
public class SiteSessionListener implements HttpSessionListener {

	private static Map<String,HttpSession> session=new HashMap<String,HttpSession>();
	
	/**
	 * 创建session
	 */
	public void sessionCreated(HttpSessionEvent sessionEvent) {
      //System.out.print(sessionEvent.getSession().getId());
		session.put(sessionEvent.getSession().getId(), sessionEvent.getSession());

	}
    
	/**
	 * 销毁session
	 */
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		session.remove(sessionEvent.getSession().getId());
	}

	
	/**
	 * 取得session 
	 * @param sessionID
	 * @return
	 */
	public static HttpSession getSession(String sessionID){		
		return session.get(sessionID);

	}
	
	/**
	 * 销毁session
	 * @param sessionID
	 */
	
	public static void reomveSession(String sessionID){
		
		if(session.containsKey(sessionID)) session.remove(sessionID);
		
	
	
	}
	
	
}
