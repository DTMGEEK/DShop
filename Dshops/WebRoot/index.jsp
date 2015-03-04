<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>欢迎来到DSOP商城</title>
   
  </head>
  
  <body>
        <form id="form" action="${pageContext.request.contextPath}/product/list/goshopindex" method="get">
               <input type="hidden" name="typeid" value="1">
        </form>
        
        <script>
            document.getElementById("form").submit();
        </script>
        
        
  </body>
</html>
