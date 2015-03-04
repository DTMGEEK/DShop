<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link type="text/css" href="/css/accounts.css" rel="stylesheet">
  <link type="text/css" href="/css/banner.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" media="screen" href="/css/all-examples.css">
  <SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
 
  
  <SCRIPT language=JavaScript src="/js/mmodewin.js"></SCRIPT>
  
  
  
 
</head>





<div id="accountcart" style="background:url(/images/fbg.png)" >
	 			
	 			<form id="buycart" name="buycart" metod="post" action="${pageContext.request.contextPath}/product/list/updateamoutn">
	 			           <input type="hidden" name="directUrl" value="${directUrl}" />
		 			<h1>Title</h1>
		 			<ul>
		 		
		 			  
		 			   <li class="goingshop"><a href="javascript:;" onclick="$.closePopupLayer('mySecondPopup')" title="Close" class="close-link"><img src="/images/conshopbtn.png"></a></li>
		 			   <li class="coucent"><a href='<s:url action="cartsession" namespace="/product/list"/>'><img src="/images/countcent.png"></a></li>
		 			</ul>
		 		                
		 		 <div id="shopcartgoods">

		 		 	
		 		 	    <table>
		 		 	         <th width="30%">商品</th>	
		 		 	         <th width="30%">价格</th>	
		 		 	         <th width="20%">数量</th>
		 		 	         <th width="20%">操作</th>		
		 		 	         
		 		 	    <c:forEach items="${buycart.items}" var="item">
		 		 	         <tr>
		 		 	            <td>${item.product.name}<span>[颜色/样式：<c:forEach items="${item.product.styles}" var="style">${style.name}</c:forEach>]</span></td>
		 		 	            <td><font>${item.product.sellprice}</font>元</td>		
		 		 	            <td><input type="text" disabled="disabled" size="3px" maxlength="3" id="gamount"  value=${item.amount} name="amount_${item.product.id}_<c:forEach items="${item.product.styles}" var="style">${style.id}</c:forEach>" onkeypress="javascript:InputIntNumberCheck()">个</td>	
		 		 	            <td><a href='<s:url action="CartManager_delCartItem" namespace="/product/list"/>?buyItemid=${item.product.id}-<c:forEach items="${item.product.styles}" var="style">${style.id}</c:forEach>'><img src="/images/delbtn.png"></a></td>
		 		 	        
		 		 	         </tr>
		 		 	         
		 		 	    </c:forEach>
		 		 	         
		 		 	         

		 		 	    </table>
		 		 	      
	 		 	</form>
	 		 	 
	 		 	 <div id="total">
	 		 	     <p> 总计：<font>${buycart.totalPrice}</font>元</p>
	 		 	   
	 		 	      	
	 		 	 	
	 		 	 </div>          
	 		 	
	 		 	
	 		 </div>
	 	
	 	
	 </div>




