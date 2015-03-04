<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<meta   name="save"   content="history">
<META http-equiv="pragma" content="no-cache">
<META http-equiv="Cache-Control" content="no-cache, must-revalidate">
<META http-equiv="expires" content="Wed, 26 Feb 2006 08:21:57 GMT">
<META http-equiv="Content-TYPE" content="text/html; charset=UTF-8">
<TITLE>结算中心：选择支付方式 </TITLE>
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<link href="/css/paymentway.css" rel="stylesheet" type="text/css">
<SCRIPT LANGUAGE="JavaScript">
<!--
// 表单验证
function validateForm(){
	var form = document.forms[0];
	if(""==getradiovalue(form.deliverway)){
		alert("\n请选择 '送货方式'");
		window.location="#deliverway";
		return false;
	}
	if(""==getradiovalue(form.paymentway)){
		alert("\n请选择 '支付方式'");
		window.location="#paymentway";
		return false;
	}
	return true;
}
function sendForm(){
	var form = document.forms[0];
	if(validateForm()) form.submit();
}
/*
 * 功能：取单选框的值
 */
function getradiovalue(obj){
	var result = "";
	try{		
		if (obj!=null){
			result = obj.value;
			if(typeof(result)=="undefined"){
				result="";
				for (i=0;i<obj.length;i++){
					if (obj[i].checked){
						result = obj[i].value;
						break;
					}
				}
			}
		}
	}catch(e){result="";}
	return result;
}

function paymentwaySelect(paymentwayValue){
	var paymentway_COD = document.getElementById('paymentway_COD');
	var timerequirement = document.getElementById('timerequirement');
	if(paymentway_COD!=null){
		if("GENERALPOST"==paymentwayValue || "EMS"==paymentwayValue){
			paymentway_COD.style.display="none";
			timerequirement.style.display="none";
			try{
				var form = document.forms[0];
				for (var i=0; i<form.paymentway.length; i++){
					if(form.paymentway[i].checked && "COD"==form.paymentway[i].value){
						if(i>0) form.paymentway[0].checked=true;
						form.paymentway[i].checked=false;						
						break;
					}
				}
			}catch(e){;}
		}else{
			paymentway_COD.style.display="block";
			timerequirement.style.display="block";
		}
	}
}

function showcashticket(){
	var cashticketlib = document.getElementById('cashticketlib');
	if(cashticketlib.style.display!="none"){
		cashticketlib.style.display="none";
	}else{
		cashticketlib.style.display="block";
	}
}

function selectcashticket(cardno, cardpwd){
	document.forms[0].cardno.value = cardno;
	document.forms[0].cardpassword.value = cardpwd;
	showcashticket();
	checkCashticket();//代金券验证
}

/** 根据值设置对象checked状态为true **/
	function setSelectRadioByValue(radioObject, value){
		if(typeof(radioObject.value)=="undefined"){
			for(var i=0;i<radioObject.length;i++){
				if(radioObject[i].value==value){
					radioObject[i].checked=true;
					break;
				}
			}
		}else{
			if(radioObject.value==value) radioObject.checked=true;
		}
	}

function pageinit(){	
	var form = document.forms[0];
	var deliverway = getradiovalue(form.deliverway);
	if(""!=deliverway){
		var timerequirement = document.getElementById('timerequirement');
		if("EXPRESSDELIVERY"==deliverway || "EXIGENCEEXPRESSDELIVERY"==deliverway){
			timerequirement.style.display="block";
		}
		var requirement = getradiovalue(form.requirement);
		if(""==requirement){
			if(form.delivernote.value.trim()!="") setSelectRadioByValue(form.requirement, "other");
		}else if("other"!=requirement){
			form.delivernote.value="";
		}
	}
}

//-->
</SCRIPT>
</HEAD>

<BODY onload="pageinit()">
<TABLE cellSpacing=0 cellPadding=0 align=center border=0>
  <TBODY>
  <TR>
    <TD><IMG src="/images/logo.png" > 

	</TD>
  </TR>
  </TBODY>
</TABLE>
<BR>
<form action="${pageContext.request.contextPath}/buyer/list/savepayway" method="post">
<INPUT TYPE="hidden" NAME="method" value="savePaymentway">
<TABLE cellSpacing=0 cellPadding=0 width="90%" align="center" border=0>
  <TBODY>
  <TR>
    <TD>
<SPAN class=h1><STRONG>请选择您的送货与支付方式:</STRONG></SPAN> 
      <TABLE height=31 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD>
            <DIV align=right><IMG onClick="javascript:sendForm()" height="22" src="/images/buy/az-sfl-shipping-to-this-boo.gif" vspace=5 border=0 style="CURSOR: hand;">
        </DIV></TD></TR>
	 </TBODY></TABLE>
<A name="deliverway"></A>
      <TABLE cellSpacing=1 cellPadding=1 width="100%" bgColor="#eeeecc" border=0><TBODY>
        <TR>
          <TD bgColor="#ffffff">
            <TABLE cellSpacing=0 cellPadding=4 width="100%" border=0>
              <TBODY>
              <TR bgColor="#eeeecc">
                <TD colSpan=2><STRONG>&nbsp;送货方式</STRONG></TD></TR>  
				<tr>
				 <TD class="big14" vAlign="middle" align="right" width="10%"><input  type="radio" name="delinfo.deliverWay" style="behavior:url(#default#savehistory)" value="GENERALPOST" checked="checked" onclick="javascript:paymentwaySelect(this.value)"/></TD>
				 <TD vAlign="middle" ><B>平邮</B> (费用:0.0元)&nbsp;&nbsp;不支持货到付款，注:费用最低，需要到附近邮局自提，时间稍长</TD>
				</tr>
				<tr>
				<TD class="big14" vAlign="middle" align="right" width="10%"><input type="radio" name="delinfo.deliverWay" style="behavior:url(#default#savehistory)"  value="EXPRESSDELIVERY" onclick="javascript:paymentwaySelect(this.value)"/></TD>
				 <TD vAlign="middle" ><B>快递送货上门 </B> (费用:0.0元)&nbsp;&nbsp;支持货到付款 &nbsp;&nbsp;注:200个城市可以到达，部分城市不能到达</TD>
				</tr>
				<tr>
				<TD class="big14" vAlign="middle" align="right" width="10%"><input type="radio" name="delinfo.deliverWay" style="behavior:url(#default#savehistory)"  value="EXIGENCEEXPRESSDELIVERY" onclick="javascript:paymentwaySelect(this.value)" /></TD>
				 <TD vAlign="middle" ><B>加急快递送货上门</B> (费用:0.0元)&nbsp;&nbsp;支持货到付款&nbsp;&nbsp;注:200个城市可以到达，部分城市不能到达</TD>
				</tr>
				<tr>
				 <TD class="big14" vAlign="middle" align="right" width="10%"><input type="radio" name="delinfo.deliverWay" style="behavior:url(#default#savehistory)"  value="EMS" onclick="javascript:paymentwaySelect(this.value)"/></TD>
				 <TD vAlign="middle" ><B>国内特快专递EMS</B> (费用:0.0
				 元)&nbsp;&nbsp;不支持货到付款&nbsp;&nbsp;注:适合其他快运无法到达的城市，时间3-5个工作日</TD>
				</tr>
				<tr>
				  <TD colspan="2" vAlign="middle" class="big14">
				  
			      </TD>
				  </tr>
			</TBODY></TABLE>
		  </TD>
		</TR>
	 </TBODY></TABLE>
<br><A name="paymentway"></A>
      <TABLE cellSpacing=1 cellPadding=1 width="100%" bgColor=#eeeecc border=0><TBODY>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=4 width="100%" border=0>
              <TBODY>
              <TR bgColor=#eeeecc>
                <TD colSpan=2><STRONG>&nbsp;支付方式</STRONG></TD>
			 </TR>
			 <TR>
                <TD class="big14" vAlign="middle" align="right" width="10%"><input type="radio" checked="checked" style="behavior:url(#default#savehistory)" name="delinfo.paymentWay"  value="NET" /> </TD>
                <TD vAlign="middle" ><B>网上支付</B>  易宝支付</TD>
			  </TR>
              <TR id="paymentway_COD" >
                <TD class="big14" vAlign="middle" align="right" width="10%"><input type="radio" style="behavior:url(#default#savehistory)" name="delinfo.paymentWay" value="COD"/> </TD>
                <TD><B>货到付款</B></TD>
			  </TR>
			  <TR>
                <TD class="big14" vAlign="middle" align="right" width="10%"><input type="radio" style="behavior:url(#default#savehistory)"  name="delinfo.paymentWay" value="BANKREMITTANCE"/> </TD> 
                <TD><B>银行电汇</B>  开户名: 深圳飞翔科技<BR>开户行名称: 
                  交通银行南山支行<BR>银行帐号: 110060974018001084072</TD></TR>
              <TR>
                <TD class="big14" vAlign="middle" align="right" width="10%"><input type="radio"  style="behavior:url(#default#savehistory)" name="delinfo.paymentWay" value="POSTOFFICEREMITTANCE"/></TD> 
                <TD><B>邮局汇款</B><BR>收款人地址：<FONT COLOR="#FF9900"></FONT>&nbsp;&nbsp;收款人姓名：<FONT COLOR="#FF9900">赵跳芳</FONT>&nbsp;&nbsp;收款人邮编：<FONT COLOR="#FF9900">518000</FONT><BR>请在汇款人简短留言中注明您的订单号/用户名(非常重要)<BR></TD></TR>
			 </TBODY></TABLE>
  </TABLE>
			</TD></TR></TBODY></TABLE><BR>
      <TABLE height=31 cellSpacing=0 cellPadding=0 width="90%" border=0 align="center">
        <TBODY>
        <TR>
          <TD>
          <input type="submit" value="提交" /><!-- 最后修改是删除 -->
            <DIV align=right><IMG onClick="javascript:sendForm()" height="22" src="/images/buy/az-sfl-shipping-to-this-boo.gif" vspace=5 border=0 style="CURSOR: hand;"> 
        </DIV></TD></TR></TBODY></TABLE>
</form>

</BODY></HTML>