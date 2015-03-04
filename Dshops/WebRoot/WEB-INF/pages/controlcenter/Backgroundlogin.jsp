<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<title>DSHOP 后台登陆</title>
		
		<!--                       CSS                       -->
	  
		<!-- Reset Stylesheet -->
		<!--<link rel="stylesheet" href="/css/bgreset.css" type="text/css" media="screen" />-->
        <link rel="stylesheet"  href="/css/bgreset.css" type="text/css" media="screen"/>
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="/css/bgstyle.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="/css/bginvalid.css" type="text/css" media="screen" />	
		
	
	
		
		<!--                       Javascripts                       -->
	  
		<!-- jQuery -->
		<script type="text/javascript" src="/js/jquery-1.3.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="/js/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="/js/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="/js/jquery.wysiwyg.js"></script>
		
		<!-- Internet Explorer .png-fix -->
	
		
	</head>
  
	<body id="login">
	
	      ${logoerr }
		
		<div id="login-wrapper" class="png_bg">
           <img id="logo" src="/images/logo.png" alt="Simpla Admin logo" />
	    <div id="login-top">
	      <img id="myimg" src="/images/welcome.png"/>
	      <!-- Logo (221px width) -->
        </div> 
	    <!-- End #logn-top -->
			
			
			
			<div id="login-content">
				
                	
				<form action="${pageContext.request.contextPath}/control/main/tab" method="post">
				
				
						<div>
						
						</div>
					
					
					<p>
						<label>&#29992;&#25143;&#21517;</label>
						<input name="username" class="text-input" type="text" maxlength="15" />
					</p>
					<div class="clear"></div>
					<p>
						<label>&#23494;&#30721;</label>
						<input name="password" class="text-input" type="password" maxlength="20"/>
					</p>
					<div class="clear"></div>
				  <div class="clear"></div>
					<p>
						<input class="button" type="submit" value="登录" />
					</p>
					
				</form>
			</div> <!-- End #login-content -->
			
		</div> <!-- End #login-wrapper -->
		
  </body>
  </html>
