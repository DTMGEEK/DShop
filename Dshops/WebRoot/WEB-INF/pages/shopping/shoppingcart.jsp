<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link type="text/css" href="/css/accounts.css" rel="stylesheet">
  <link type="text/css" href="/css/banner.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" media="screen" href="/css/all-examples.css">
  <SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
  <SCRIPT LANGUAGE="JavaScript">
<!--
/** 获取以指定字符串为前缀的输入字段集合 **/
/** 数字输入格式是否正确(长度1-4位，第一个数字必须是1-9) **/
function numericFormat(strNumber){   
  var newPar=/^[1-9]\d{0,3}$/;
  return newPar.test(strNumber);
} 

function getInputsByname(name, etype){//
	var inputs = document.getElementsByTagName("input");
	var texts = new Array();
	var y = 0;
	for (var i = 0; i < inputs.length; i++) {
	  if (inputs[i].type == etype && inputs[i].name!=null && inputs[i].name.substring(0, name.length) == name) {
			texts[y] = inputs[i];
			y++;
		}
	}
	return texts;
}

function modifyAmount(){
	if(validateAmount()){		
		var form = document.forms["buycart"];
		form.submit();
	}
}

/** 验证购买数量字段 **/
function validateAmount(){
	var amounts = getInputsByname("amount_", "text");
	if(amounts.length==0){
		alert("您还没有购买商品");
		return false;
	}else{
		for (var i = 0; i < amounts.length; i++) {
			var amount = amounts[i];
			if(amount.value==null || amount.value.trim()==""){
				alert("\n您购买的商品中,有的商品购买数量为空,请填写购买数量");
				amount.focus();
				return false;
			}else if(amount.value=="0"){
				alert("\n您购买的商品中,有的商品购买数量为0,如果您不需要该商品,可以删除它");
				amount.select();
				return false;
			}else if(!numericFormat(amount.value)){
				alert("\n购买数量含有非数字数据,请更正");
				amount.select();
				return false;
			}
		}
	}
	return true;
}
//-->
</SCRIPT>
  
</head>
<body >

<div id="accountcart">
	 			
	 			<form id="buycart" name="buycart" metod="post" action="${pageContext.request.contextPath}/product/list/updateamoutn">
	 			           b<input type="hidden" name="directUrl" value="${directUrl}" />
		 			<h1>Title</h1>
		 			<ul>
		 			
		 			   <li class="updatecart">改变数量请单击：<img src="/images/updatebtn.png"  onClick="javascript:modifyAmount()"></li>
		 			   <li class="clearcart"><a href="<s:url action="CartManager_delAllCartItem" namespace="/product/list"/>"><img src="/images/clearcart.png"></a></li>	
		 			   <li class="goingshop"><a href='<s:url action="goshopindex" namespace="/product/list"/>?typeid=1'><img src="/images/conshopbtn.png"></a></li>
		 			   <li class="coucent"><a href='<s:url action="deliverInfo" namespace="/buyer/list"/>?directUrl=${param.directUrl}'><img src="/images/countcent.png"></a></li>
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
		 		 	            <td><input type="text" size="3px" maxlength="3"  value=${item.amount} name="amount_${item.product.id}_<c:forEach items="${item.product.styles}" var="style">${style.id}</c:forEach>" onkeypress="javascript:InputIntNumberCheck()">个</td>	
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
	 



</body>
</html>
