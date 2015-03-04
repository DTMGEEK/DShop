<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'Message.jsp' starting page</title>
    
	

  </head>
  
  <body> 
           ${message } 
           
           <a href="<s:url action="prostyles" namespace="/control/product"/>?productId=${productId}">确定</a>
  </body>
</html>
