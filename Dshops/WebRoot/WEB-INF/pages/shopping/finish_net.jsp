<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>订单完成 </TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META http-equiv=Content-Language content=zh-CN>
<LINK href="/css/new_cart.css" rel="stylesheet" type="text/css">
<link href="/css/global/header01.css" rel="stylesheet" type="text/css">
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
</HEAD>
<BODY>

<BR>
<h1>订单号:${order.orderid },应付金额:${order.payablefee }元</h1>
<br>
你选择的付款方式为"网上支付",现在你就可以进行<a href="?orderid=${order.orderid }"><font color="red">网上支付</font></a>.
<br/>

<a href='<s:url action="goshopindex" namespace="/product/list" />'>返回首页</a>
</BODY>
</HTML>
