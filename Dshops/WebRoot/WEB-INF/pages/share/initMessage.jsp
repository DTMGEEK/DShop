<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'message.jsp' starting page</title>
    
	

  </head>
  
  <body>
         ${message}
          
          <a href='<s:url action="bglogo" namespace="/control/main"/>'>确定</a>
  </body>
</html>
