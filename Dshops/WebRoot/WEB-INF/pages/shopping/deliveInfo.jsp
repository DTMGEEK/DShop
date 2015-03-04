<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta   name="save"   content="history">
<title>noteform</title>
 <link type="text/css" href="/css/diliverInfo.css" rel="stylesheet">

<script src="/js/jquery-1.4.4.js"></script>
<script>

$(function(){
		   $("div").click(function(){
		   $(this).addClass("select");		
    });
})
</script>



</head>

<body>


${nonedelinfo}
${message }

<div class="exlist">
    <div class="exlist_title"><img src="/images/paper-clip.png" /></div>
       <div id="title"><legend>配送信息单</legend></div>
       <form method="post" action="${pageContext.request.contextPath}/buyer/list/shopmanager">
           <fieldset>
           <legend>收件信息</legend>
                   <div class="row">
                   <label>1. 收货人:</label>
                   <input style="width:100px; behavior:url(#default#savehistory)"   class="txt" type="text"  name="delinfo.recipients" value='<s:property value="recipients"/>'  />
                   </div>
                   <div class="row">    
                   <label>2.邮政编码:</label><input class="txt" style="behavior:url(#default#savehistory)" type="text" name="delinfo.postcode" value='<s:property value="postalcode"/>'   />
                   
                   </div>
                   <div class="row">
                   <label>3. 联系电话:</label><input class="txt" style="behavior:url(#default#savehistory)" type="text" name="delinfo.tel" value='<s:property value="tel"/>' />
                   </div>
                   <div class="row">
                   <label>4. 电子邮件:</label><input class="txt" style="width:400px; behavior:url(#default#savehistory)" value='<s:property value="email"/>'  type="text" name="delinfo.email"  />
                   </div>
                   <div class="row">
                   <label>5. 详细地址:</label><input class="txt" style="width:400px; behavior:url(#default#savehistory)"  type="text" name="delinfo.address" value='<s:property value="address"/>' />
                   </div>
                   <center>
                   <input type="hidden" name="directUrl" value="${param.directUrl}"/>
                <input type="submit" value="下一步">
           </center>
           
           </fieldset>
           
        </form>
        
</div>
</body>
</html>
