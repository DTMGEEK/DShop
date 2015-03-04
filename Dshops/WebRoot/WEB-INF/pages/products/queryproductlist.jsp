<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>DSOP商城</title>    
	<link href="/css/global/header01.css" rel="stylesheet" type="text/css">
	<link href="/css/product/list.css" rel="stylesheet" type="text/css" />	
	<link href="/css/global/topsell.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<SCRIPT language=JavaScript src="/js/xmlhttp.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
<!--
	function getViewHistory(){
		var viewHistoryUI = document.getElementById('viewHistory');		
		if(viewHistoryUI){
			viewHistoryUI.innerHTML= "数据正在加载...";
			send_request(function(value){viewHistoryUI.innerHTML=value},
					 "<html:rewrite action="/product/switch"/>?method=getViewHistory", true);
		}
	}
	function pageInit(){
		getViewHistory();
	}
	
	function topage(pagenum){
		var form = document.forms["productquery"];
		form.page.value= pagenum;
		form.submit();
	}
//-->
</SCRIPT>
</head>

<body class="ProducTypeHome2" onload="javascript:pageInit()">

    <div id="position">您现在的位置: <a href="/" name="linkHome">DSHOP</a> &gt;&gt; <em>产品查询结果</em> （${pageView.totalrecord}个）
	</div>

   
    <!--页面右侧分类列表部分开始-->
    <div class="browse_right">
	     <div id="divNaviTop" class="number">
	          <div class="number_l">以下查询到<span class='number_white'>${pageView.totalrecord}</span>条结果　每页显示<span class="number_white">${pageView.maxresult}</span>条</div>
		      <div class="turnpage">
                <div><em>第${pageView.currentpage}页</em></div>
		      </div>
	     </div>
<!---------------------------LOOP START------------------------------>
<c:forEach items="${pageView.records}" var="entry">	
		<div class="goodslist">
          <div class="goods" style="cursor:hand;background:url(<c:forEach items="${entry.styles}" var="pic">${pic.imageFullPath}</c:forEach>) center center no-repeat"><a href="###" target="_blank">
            <img src="/images/global/product_blank.gif" alt="${entry.name}" width="140" height="168"  border="0"/></a></div>
          <div class="goods_right">
                <h2><a href="###" target="_blank" title="${entry.name}">${entry.name}</a></h2>
	           <div class="message"><ul>
			  <c:if test="${!empty entry.brand}"> <li>品牌：${entry.brand.name}</li></c:if>
			   </ul></div>
	           <div class="content">&nbsp;&nbsp;&nbsp;<c:out value="${fn:substring(entry.description,0,200)}" escapeXml="false"/></div>
	           <div class="message_bottom">
	                <div class="save"><s>￥${entry.marketprice}</s>　<strong><em>￥${entry.sellprice}</em></strong>　节省：${entry.marketprice-entry.sellprice}</div>
			        <div class="buy"><a href="###"><img src='/images/purchbtn.png' width='84' height='24' border='0' /></a></div>
	           </div>
          </div>
          <div class="empty_box"></div>
        </div>
</c:forEach>


</body>
</html>