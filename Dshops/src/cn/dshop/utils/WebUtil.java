package cn.dshop.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dshop.bean.privilege.Employee;
import cn.dshop.bean.user.Buyer;
import cn.dshop.beans.BuyCart;


/**
 * 
 * @author Administrator
 *
 */
public class WebUtil {
	/**
	 * 获取登录员工
	 */
	public static Employee getEmployee(HttpServletRequest request){
		return (Employee) request.getSession().getAttribute("employee");
	}
	/**
	 * 获取购物车ﳵ
	 * @param request
	 * @return
	 */
	public static BuyCart getBuyCart(HttpServletRequest request){
		return (BuyCart)request.getSession().getAttribute("buycart");
	}
	/**
	 * 获取登录用户
	 */
     public static Buyer getBuyer(HttpServletRequest request){
		return (Buyer) request.getSession().getAttribute("user");
	}
	/**
	 * 删除购物车
	 */
	public static void deleteBuyCart(HttpServletRequest request){
		request.getSession().removeAttribute("buycart");
	}
    /***
     * 
     * @param request
     * @return
     */
    public static String getRequestURI(HttpServletRequest request){     
        return request.getRequestURI();
    }
    /**
     *得到转发的地址 包括参数
     * @param request
     * @return
     */
    public static String getRequestURIWithParam(HttpServletRequest request){     
        return getRequestURI(request) + (request.getQueryString() == null ? "" : "?"+ request.getQueryString());
    }
    /**
     * ���cookie
     * @param response
     * @param name cookie
     * @param value cookieֵ
     * @param maxAge 
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {        
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge>0) cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
    
    /**
     * ��ȡcookie��ֵ
     * @param request
     * @param name cookie�����
     * @return
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
    	Map<String, Cookie> cookieMap = WebUtil.readCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie.getValue();
        }else{
            return null;
        }
    }
    
    protected static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (int i = 0; i < cookies.length; i++) {
                cookieMap.put(cookies[i].getName(), cookies[i]);
            }
        }
        return cookieMap;
    }
    /**
     * 除去html代码
     * @param inputString
     * @return
     */
    public static String HtmltoText(String inputString) {
        String htmlStr = inputString; //含html代码的字符串
        String textStr ="";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;          
        java.util.regex.Pattern p_ba;
        java.util.regex.Matcher m_ba;
        
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script{��<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style{��<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; //定义html代码的表达式
            String patternStr = "\\s+";
            
            p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); 

            p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); 
         
            p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); 
            
            p_ba = Pattern.compile(patternStr,Pattern.CASE_INSENSITIVE);
            m_ba = p_ba.matcher(htmlStr);
            htmlStr = m_ba.replaceAll(""); 
         
         textStr = htmlStr;
         
        }catch(Exception e) {
                    System.err.println("Html2Text: " + e.getMessage());
        }          
        return textStr;
     }
}
