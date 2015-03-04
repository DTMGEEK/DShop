<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>


<script src="/js/logosub.js" type="text/javascript"></script>




<div class="popup">
	<div class="popup-header">
		<h2>欢迎登录</h2>
		<a href="javascript:;" onclick="$.closePopupLayer('mySecondPopup')" title="Close" class="close-link">关闭</a>
		<br clear="both" />
	</div>
	<div class="popup-body">
	
		<form id="logoform" action="${pageContext.request.contextPath}/buyer/list/buyerlogo">
			<fieldset>
				<legend>登录</legend>
				
				<label>用户名</label>
				<input style="line-height:20px" type="text" id="username" name="username" onblur="checkUsernameEmp()" /><span id="fusername"></span><br/>
				
				<label>密码</label>
				<input type="text" id="password" name="password" onblur="checkPasswordEmp()"/><span id="fpassword"></span><br/>
				
				<label>验证码</label>
				<input onblur="checkNlEmp()" type="text" id="nl"  name="nl"/><img src="images/logincode.png" ><span id="fnl" ></span> 
				<br/>
				<a href="###">重新获取验证码</a>
				<input type="button" value="提交"  onclick="getlogoinfo()">
				<a href="###">免费注册</a>
				
				
				
				
			</fieldset>
		</form>
	</div>
</div>