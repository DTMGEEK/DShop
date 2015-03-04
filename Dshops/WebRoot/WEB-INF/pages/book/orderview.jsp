<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>订单查看</title>
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<style type="text/css">
<!--
body {font-size: 12px;line-height:16px}
a:link { color: #3300FF; 
     text-decoration: underline;  }    
    
a {color: #3300FF; 
     text-decoration: underline; }
     
a:hover { color: #FF6600; 
           text-decoration: underline; }

A.subnav:link {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: none
}
A.subnav:visited {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: none
}
A.subnav:active {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: none
}
A.subnav:hover {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: underline
}
-->
</style>


<SCRIPT LANGUAGE="JavaScript">
<!--
function ActionEvent(methodname, orderid){
	window.location.href = '<s:url action="ordermanager_'+methodname+'" namespace="/control/order"/>?orderid='+orderid;
}
function deleteOrderItem(orderItemid, orderid){
	if(confirm('\n您确认删除该项吗?')){
		window.location.href ="<html:rewrite action="/control/order/manage"/>?method=deleteOrderItem&orderitemid="+ orderItemid+"&orderid="+orderid;
	}
}
//-->
</SCRIPT>


</head>
<body>






<br>
<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#333333">
  <tr>
    <td><table width="100%" height="25" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="59%"><strong>订单号:</strong>${order.orderid } <font color="red">(${order.state.name })</font></td>
        <td width="41%" align="right"><strong>订购时间:</strong>${order.createDate }</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" cellpadding="3" cellspacing="2">
        <tr>
          <td colspan="4" bgcolor="#FFFFFF"><strong>订购者信息 </strong> </td>
          <td align="center" bgcolor="#FFFFFF">支付方式</td>
          <td colspan="2" bgcolor="#FFFFFF">${order.paymentWay.name } </td>
        </tr>
       
       
        <tr>
          <td colspan="4" bgcolor="#FFFFFF"><strong></strong> </td>
          <td align="center" bgcolor="#FFFFFF">送货方式</td>
          <td colspan="2" bgcolor="#FFFFFF">${order.orderDeliverInfo.deliverWay.name }  </td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">姓名</td>
          <td bgcolor="#FFFFFF">${order.orderDeliverInfo.recipients }</td>
          <td align="center" bgcolor="#FFFFFF">联系电话</td>
          <td bgcolor="#FFFFFF">${order.orderDeliverInfo.tel }</td>
          
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">地址</td>
          <td colspan="3" bgcolor="#FFFFFF">${order.orderDeliverInfo.address }</td>
          <td align="center" bgcolor="#FFFFFF">邮编</td>
          <td colspan="2" bgcolor="#FFFFFF">${order.orderDeliverInfo.postcode }</td>
        </tr>
         <tr>
          <td align="center" bgcolor="#FFFFFF">其他要求</td>
          <td colspan="6" bgcolor="#FFFFFF">${order.note}</td>
        </tr>
      
        <tr>
          <td colspan="4" bgcolor="#FFFFFF"><strong>订购的商品</strong></td>
          <td align="center" bgcolor="#FFFFFF"></td>
          <td colspan="2" bgcolor="#FFFFFF">
		  </td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">商品编号</td>
          <td colspan="3" align="center" bgcolor="#FFFFFF">商品名称</td>
          <td align="center" bgcolor="#FFFFFF">单价</td>
          <td width="16%" align="center" bgcolor="#FFFFFF">数量</td>
          <td width="5%" align="center" bgcolor="#FFFFFF">&nbsp;</td>
        </tr>
<c:forEach items="${order.items}" var="item">
        <tr>
          <td align="center" bgcolor="#FFFFFF">${items.productid }</td>
          <td colspan="3" align="center" bgcolor="#FFFFFF">${item.productName } <font color="red">[${item.styleName }]</font></td>
          <td align="center" bgcolor="#FFFFFF">￥${item.productPrice }</td>
          <td align="center" bgcolor="#FFFFFF">${item.amount } </td>
          <td align="center" bgcolor="#FFFFFF"></td>
        </tr>
</c:forEach>
        <tr>
          <td colspan="7" align="right" bgcolor="#FFFFFF"><p>商品合计：￥${order.productTotalPrice }元&nbsp;&nbsp;配送费：￥${order.deliverFee }元 &nbsp;&nbsp;订单合计：￥${order.totalPrice+10 }元<br />
            
			&nbsp;&nbsp;<strong>应付金额：</strong>￥${order.payablefee+10 }元</p>          </td>
        </tr>
      </table></td>
  </tr>
</table>
<br />
<table width="90%" border="0" align="center" cellpadding="0" cellspacing="2">
  <tr> 
    <td width="15%" bgcolor="#FFFFFF">
    <c:if test="${order.state!='RECEIVED' && order.state!='CANCEL'}">
	<a href='<s:url action="ordermanager_cancelOrder" namespace="/control/order"/>?orderid=${order.orderid }' target="iframe1">取消此订单</a>&nbsp;
     </c:if>
     <c:if test="${order.state=='WAICONFIRM'}">
         <input type="button" value="审核通过" onclick="JavaScript:ActionEvent('confirmOrder', '${order.orderid  }')"/>
         <a href='<s:url action="ordermanager_confirmOrder" namespace="/control/order"/>?orderid=${order.orderid }' target="iframe1">审核通过</a>&nbsp;	
    </c:if>
    <c:if test="${order.state=='WAITPAYMENT' || (order.state=='DELIVER' && order.paymentWay=='COD')}">
    <a href='<s:url action="ordermanager_confirmPayment" namespace="/control/order"/>?orderid=${order.orderid }' target="iframe1">财务确认已付款</a>&nbsp;	
    </c:if>
    <c:if test="${order.state=='ADMEASUREPRODUCT'}">
   <a href='<s:url action="ordermanager_trunWaitdeliver" namespace="/control/order"/>?orderid=${order.orderid }' target="iframe1">等待发货</a>&nbsp;	
    </c:if>
    <c:if test="${order.state=='WAITDELIVER'}">
   <a href='<s:url action="ordermanager_trunDelivered" namespace="/control/order"/>?orderid=${order.orderid }' target="iframe1">已经发货</a>&nbsp;	
    </c:if>
    <c:if test="${order.state=='DELIVER' && order.paymentWay!='COD'}">
    <a href='<s:url action="ordermanager_turnReceived" namespace="/control/order"/>?orderid=${order.orderid }' target="iframe1">已经收货</a>&nbsp;	
    </c:if>
    <input type="button" value="打印订单" onclick="JavaScript:winOpen('<s:url namespace="/control/order" action="printorderform"/>?orderid=${order.orderid }','打印',700,450)"/>&nbsp;
<a href='<s:url action="lockorder" namespace="/control/order"/>?orderid=${order.orderid }'>锁定订单</a>
	</td>
  </tr>
</table>
<br />
<table width="90%" border="0" align="center" cellpadding="2" cellspacing="2">
  <tr>
    <td colspan="2"  bgcolor="6f8ac4"><FONT COLOR="#FFFFFF">客服留言</FONT> &nbsp; <input type="button" value="客服留言" onclick="JavaScript:window.location.href='<html:rewrite action="/control/order/manage"/>?method=addMessageUI&orderid=${order.orderid}'"/></td>
  </tr>
  <tr>
    <td width="30%" align="center" bgcolor="#FFFFCC">留言者/时间</td>
    <td width="70%" align="center" bgcolor="#FFFFCC">内容</td>
  </tr>
  <c:forEach items="${order.msgs}" var="msg">
  <tr>
    <td>${msg.username } / ${msg.createtime }</td>
    <td >${msg.content }</td>
  </tr>
  <tr><td colspan="2" height="1" bgcolor="#BBC9FF"></td></tr></c:forEach>
</table>
<p>&nbsp;</p>
</body>
</html>