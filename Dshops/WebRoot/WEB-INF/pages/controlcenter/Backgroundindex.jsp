<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<title>DSHOP 后台管理系统</title>
		
		<!--                       CSS                       -->
	  
		<!-- Reset Stylesheet -->
		<link rel="stylesheet" href="/css/bginvalid.css" type="text/css" media="screen" />
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="/css/bgreset.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="/css/bgstyle.css" type="text/css" media="screen" />	
        
      
		
		
		<!--                       Javascripts                       -->
  
		<!-- jQuery -->
		<script type="text/javascript" src="/js/jquery-1.5.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="/js/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="/js/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="/js/jquery.wysiwyg.js"></script>
		
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="/js/jquery.datePicker.js"></script>
		<script type="text/javascript" src="/js/jquery.date.js"></script>
	
	
		
	</head>
  
	<body>
	
	<div id="body-wrapper"> 
		
		<div id="sidebar"><div id="sidebar-wrapper">
			
			<h1 id="sidebar-title"><a href="#">DS</a></h1>
		  
			<!-- Logo (221px wide) -->
			<div id="logoup"><img id="logo" src="/images/Logoup.png" /></div>
		  
			<!-- Sidebar Profile links -->
			
			
			<ul id="main-nav">  
				
				<!-------------------------订单管理START------------------------------->
				
				<li> 
					<a href="#" class="nav-top-item"> 
					    订单管理
					</a>
					<ul>
						<li><a  href="ProductTypeList.html" target="iframe1">订单查询</a></li>
						<li><a href='<s:url action="orderform" namespace="/control/order"/>' target="iframe1">待审核订单</a></li> 
						<li><a href='<s:url action="orderform" namespace="/control/order"/>?state=WAITPAYMENT' target="iframe1">等待付款订单</a></li>
						<li><a href='<s:url action="orderform" namespace="/control/order"/>?state=ADMEASUREPRODUCT' target="iframe1">正在配货订单</a></li>
                        <li><a href='<s:url action="orderform" namespace="/control/order"/>?state=WAITDELIVER' target="iframe1">等待发货订单</a></li>
                        <li><a href='<s:url action="orderform" namespace="/control/order"/>?state=DELIVER' target="iframe1">已发货订单</a></li>
                        <li><a href='<s:url action="orderform" namespace="/control/order"/>?state=RECEIVED' target="iframe1">已收货订单</a></li>
                        <li><a href='<s:url action="orderform" namespace="/control/order"/>?state=CANCEL' target="iframe1">已取消订单</a></li>
                        <li><a href='<s:url action="orderform" namespace="/control/order"/>?state=' target="iframe1">已锁定订单</a></li>
                        
					</ul>
				</li>
                
                
				<!-------------------------订单管理END------------------------------->
                <!-------------------------产品管理START------------------------------->
				<li>
					<a href="#" class="nav-top-item">
						产品管理
					</a>
					<ul>
					   
					   
						<li><a href='<s:url action="showprodutlist" namespace="/control/product"/>' target="iframe1">产品类别管理</a></li>
						<li><a href='<s:url action="showbrandlist" namespace="/control/product"/>' target="iframe1">产品品牌管理</a></li>
                        <li><a href='<s:url action="allproduct" namespace="/control/product"/>'  target="iframe1">产品管理</a></li>
                        
					</ul>
				</li>
				
                <!-------------------------产品管理END------------------------------->

				<!-------------------------文件管理START------------------------------->
				<li>
					<a href="#" class="nav-top-item">
						部门员工管理
					</a>
					<ul>
						<li><a href='<s:url action="alldepartmentlist" namespace="/control/priviledge"/>' target="iframe1">部门管理</a></li>
						<li><a href='<s:url action="allemployees" namespace="/control/priviledge"/>' target="iframe1">员工管理</a></li>
						<li><a href='<s:url action="privilegegroup" namespace="/control/priviledge"/>'  target="iframe1">权限组管理</a></li>
					</ul>
				</li>
				
				<!-------------------------网站用户管理END------------------------------->

		·		<!-------------------------部门员工管理START------------------------------->
				<li>
					<a href="#" class="nav-top-item">
						用户管理
					</a>
					
					<ul>
						<li><a href='<s:url action="showalluser" namespace="/control/user"/>' target="iframe1">用户</a></li>
						
					</ul>
				</li>
				<!-------------------------部门员工管理END------------------------------->
				<li>
					<a href='<s:url action="logoout" namespace="/control/main"/>' class="nav-top-item">
						退出系统
					</a>
					
					
					<ul>
						<li><a href='<s:url action="logoout" namespace="/control/main"/>' >退出系统</a></li>
						
					</ul>
					
				</li>      
				
			</ul> <!-- End #main-nav -->
			
		
		</div></div> <!-- End #sidebar -->
		
		<div id="main-content"><!-- Main Content Section with everything -->
			
	      <div id="flashclock"><embed src="/images/bgClock.swf" wmode="transparent"></embed></div>
			
	    <!-- Page Head -->
			<h2>欢迎 <font color="#00FFFF">${employee.username }</font> 的登录</h2>

			
			<ul class="shortcut-buttons-set">
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="/images/icons/pencil_48.png" alt="icon" /><br />
					待定</span></a></li>
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="/images/icons/paper_content_pencil_48.png" alt="icon" /><br />
					待定
				</span></a></li>
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="/images/icons/image_add_48.png" alt="icon" /><br />
					待定
				</span></a></li>
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="/images/icons/clock_48.png" alt="icon" /><br />
					待定
				</span></a></li>
				
				<li><a class="shortcut-button" href="#messages" rel="modal"><span>
					<img src="/images/icons/comment_48.png" alt="icon" /><br />
					待定
				</span></a></li>
				
			</ul><!-- End .shortcut-buttons-set -->
            
            
         	
         	　　　
              <iframe src='<s:url action="loginfla" namespace="/control/main"/>' name=iframe1 width="100%" height="1500px" marginwidth=0 marginheight=0 scrolling=no id="iframe1"  border=0 frameBorder=0></iframe>
        
            <!-- End .content-box --><!-- End .content-box --><!-- End .content-box -->
	   
			
			
			<!-- Start Notifications -->
			<!-- End Notifications -->
			
<div id="footer">
				<small> <!-- Remove this notice or replace it with whatever you want -->
						&#169; Copyright 2011 WP Studio| Powered by 
				</small>
		  </div><!-- End #footer -->
			
	  </div> <!-- End #main-content -->
		
	</div></body>
  

<!-- Download From www.exet.tk-->
</html>
