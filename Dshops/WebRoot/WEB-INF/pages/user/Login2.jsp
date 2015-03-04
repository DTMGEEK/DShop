<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link type="text/css" href="/css/login.css" rel="stylesheet">
  <script src="/js/jquery-1.4.4.min.js" type="text/javascript"></script>
  <script src="/js/formValidator-4.0.1.js" type="text/javascript" charset="UTF-8"></script>
	<script src="/js/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
	<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
	<script type="text/javascript">
    $(document).ready(function(){
		//第一组校验组，默认组号为"1"
    $.formValidator.initConfig({submitButtonID:"Submit1",debug:true,onSuccess:function(){alert("校验组1通过验证，不过我不给它提交");},onError:function(){alert("具体错误，请看网页上的提示")}});
		$("#password").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码不能为空,请确认"});
		$("#password2").formValidator({onShow:"输再次输入密码",onFocus:"至少1个长度",onCorrect:"密码一致"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"重复密码两边不能有空符号"},onError:"重复密码不能为空,请确认"}).compareValidator({desID:"password1",operateor:"=",onError:"2次密码不一致,请确认"});
	
		$("#nl").formValidator({autoModify:true,onShow:"请输入验证码（1-99之间）",onFocus:"只能输入1-99之间的数字哦"}).inputValidator({min:1,max:99,type:"value",onErrorMin:"你输入的值必须大于等于1",onError:"年龄必须在1-99之间，请确认"});
		$("#username").formValidator({onShow:"请输用户名",onFocus:"至少1个长度"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"用户名不能有空符号"},onError:"用户名为空,请确认"});
		
	})
    </script>
</head>
<body>
  
  

<div id="login" style="margin-top:250px">
				${error }
 <form action="${pageContext.request.contextPath}/buyer/list/buyerlogo" method="post">
      <table>
      	
      	<tr><td>

        		<table border="0px" style="font-size:12px" width="630px">
        			
        <tr> 
				  <td align="right" style="width:120px">用户名:</td>
				  <td><input type="text" id="username" name="username"  /></td>
				  <td><div id="usernameTip" style="width:250px"></div></td>
				</tr>
				<tr> 
				  <td align="right">密码:</td>
				  <td><input type="password" id="password" name="password"  /></td>
				  <td><div id="password1Tip" style="width:250px"></div></td>
				</tr>
		
			   <tr><a href='<s:url action="forgetpas" namespace="/buyer/list"/>'>忘记密码</a></tr>
	
			   
				<tr><td colspan="3"><input  type="submit" value="登录" /><a href='<s:url action="goReg" namespace="/buyer/list"/>'>免费注册</a></td></tr>
				
				
				</table>
				</td>
				<td class="bord">
				         <embed width="500" height="200" wmode="transparent" src="/flash/falshbanner.swf"></embed>             
        </td>
				</tr>
				
			</table>
	</form>
</div>
<script type="text/javascript">
<!--
swfobject.registerObject("FlashID");
//-->
</script>
</body>
</html>
