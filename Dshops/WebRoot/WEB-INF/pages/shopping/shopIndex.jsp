<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK" />
  <link type="text/css" href="/css/style.css" rel="stylesheet">
  <link type="text/css" href="/css/banner.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" media="screen" href="/css/all-examples.css">

 


	<script src="/js/swfobject_modified.js" type="text/javascript"></script>
	
		<script type="text/javascript" src="/js/jquery.jmpopups-0.5.1.js"></script>
		<script type="text/javascript" src="/js/mmodewin.js"></script>

<noscript>
		<style type="text/css">
			#dock { top: 0; left: 100px; }
			a.dock-item { position: relative; float: left; margin-right: 10px; }
			.dock-item span { display: block; }
			.stack { top: 0; }
			.stack ul li { position: relative; }
		</style>
	</noscript>
	<script type="text/javascript" src="/js/slides.min.jquery.js"></script>
	<script type="text/javascript" src="/js/jquery.min.js"></script>
	<script type="text/javascript" src="/js/fisheye-iutil.min.js"></script>
	<script type="text/javascript" src="/js/dock-example1.js"></script>
	<script type="text/javascript" src="/js/jquery.jqDock.min.js"></script>
	<script type="text/javascript" src="/js/stack-1.js"></script>
	<script type="text/javascript" src="/js/stack-2.js"></script>
	<script type="text/javascript">
		$(function(){
			var jqDockOpts = {align: 'left', duration: 200, labels: 'tc', size: 48, distance: 85};
			$('#jqDock').jqDock(jqDockOpts);
		});
	</script>
	
	<SCRIPT src="/js/flashobj.js" type=text/javascript></SCRIPT>
	
	
<script type="text/javascript" src="/js/jquery.cycle.js"></script>
<script type="text/javascript">
	$(function(){
		$('#banner').cycle({ 
				fx:'scrollLeft',
				pager:'#btn'
		});
	})
</script>





	

</head>
<body>
	   
 
<div id="dock">
		       <div id="logo">logo</div>
			<div class="dock-container">
				
				<a class="dock-item" href='<s:url action="goshopindex" namespace="/product/list"/>'><span >首页</span><img src="/images/dock/home.png" alt="首页" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=1'><span>手机</span><img src="/images/dock/email.png" alt="手机" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=2'><span>笔记本</span><img src="/images/dock/portfolio.png" alt="笔记本" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=3'><span>DIY硬件</span><img src="/images/dock/music.png" alt="DIY硬件" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=4'><span>MP3/MP4</span><img src="/images/dock/video.png" alt="MP3/MP4" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=5'><span>台式电脑</span><img src="/images/dock/history.png" alt="台式电脑" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=6'><span>服务器</span><img src="/images/dock/calendar.png" alt="服务器" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=7'><span>一体电脑</span><img src="/images/dock/link.png" alt="一体电脑" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=8'><span>数码相机</span><img src="/images/dock/rss.png" alt="数码相机" /></a> 
				<a class="dock-item" href='<s:url action="allproducts" namespace="/product/list"/>?typeid=9'><span>智能电视</span><img src="/images/dock/rss2.png" alt="智能电视" /></a> 
		</div><!-- end div .dock-container -->
	 </div>
	<div id="banner"> <img  src="/images/banner1.png" width="980" height="210" /> <img  src="/images/banner2.png" width="980" height="210" /> <img  src="/images/banner3.png" width="980" height="210" /> <img  src="/images/banner4.png" width="980" height="210" /> </div>
>
	
	
	 <div id="types">
	      <div id="discount">
	      	 <h1>Ttitle</h1>
	      	 
	      </div>	
	      
	      
	      <div id="sellservice">
	      	   <div id=""></div>
	
	      </div>
	 	
	 </div>
	 
	 <div id="prodcuts">
	 	    <h1>Title</h1>
	 	    
	 	     <c:forEach  items="${topsellproducts}" var="entry">
		 	    <dl style="border:none; margin-left:30px;">
		 	     <c:forEach items="${entry.styles}" var="pic">
		 	       <a href='<s:url action="viewcookie" namespace="/product/list"/>?productId=${entry.id}'><dt><img src="${pic.imageFullPath}" width="200"></dt></a>
		 	     </c:forEach>
			 	  <dd style="margin-top:30px"><a href='<s:url action="viewcookie" namespace="/product/list"/>?productId=${entry.id}'>名称：${entry.name }</a></dd>	
		 	      <dd style="margin-top:30px">销售价：${entry.sellprice}</dd>
			 	
		 	    </dl>
	 	    
	 	     </c:forEach>
	 	   
	 	   
	 	    
	 	    
	 	

	 </div>

	 
   <div id="footer">
   	     <div id="abuotus">
   	     	
   	     	 <img src="/images/letter.png"> 
   	     	<p>电话：00000-0000-000</p>  
   	     	<p>邮件地址：124@wp.com</p>
   	     	<p>地址：中国深圳南山</p>     
   	     	<p>Copyright @copyright All rights reserved</p>   
   	     	       <ul>
   	     	          <li>公司简介 |</li>
   	     	          <li>诚证英才 |</li>	
   	     	          <li>网站联盟 |</li>
   	     	          <li>交易条款 |</li>
   	     	       </ul>
   	     	</div>
   	     <div id="copyright"></div>
   	
   	</div>
   	
   	
   	
   	
   
   	
   	

</body>
</html>
