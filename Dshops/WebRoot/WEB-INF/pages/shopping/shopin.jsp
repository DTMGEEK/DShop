<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link type="text/css" href="/css/style.css" rel="stylesheet">
  <link type="text/css" href="/css/banner.css" rel="stylesheet">
  <link type="text/css" href="/css/shop.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" media="screen" href="/style/all-examples.css">
	<script src="/Scripts/swfobject_modified.js" type="text/javascript"></script>
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
	<SCRIPT type="text/javascript" src="/js/xmlhttp.js"></SCRIPT>
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
<body style="background:none">
	
	
		 <div id="products">
	 	   
	 	   <div id="hotproduct">
	 	   	 <ul> 
	 	   	         <c:if test="${'sellcount'!=param.orderValue}">
	 	        	     <li><a href='<s:url action="inproducts" namespace="/product/list"/>?orderValue=sellcount&typeid=${param.typeid}&brandId=${sbrandid}'>销量多到少</a></li>
	 	        	 </c:if>
	 	        	 
	 	        	 <c:if test="${'sellcount'==param.orderValue}">
	 	        	     <li style="color:black;font-weight:bold">销量多到少</li>    
	 	        	 </c:if>
	 	        	 
	 	        	 <c:if test="${'sellpricedesc'!=param.orderValue}">
	 	        	 	<li><a href='<s:url action="inproducts" namespace="/product/list"/>?orderValue=sellpricedesc&typeid=${param.typeid}&brandId=${sbrandid}'>价格高到低</a></li>
	 	        	 </c:if>
	 	        	 
	 	        	 <c:if test="${'sellpricedesc'==param.orderValue}">
	 	        	      <li style="color:black;font-weight:bold">价格高到低</li>
	 	        	 </c:if>
	 	        	 
	 	        	 <c:if test="${'sellpriceasc'!=param.orderValue}">
	 	        	 	  <li><a href='<s:url action="inproducts" namespace="/product/list"/>?orderValue=sellpriceasc&typeid=${param.typeid}&brandId=${sbrandid}'>价格低到高</a></li>
	 	        	 </c:if>
	 	        	 
	 	        	 <c:if test="${'sellpriceasc'==param.orderValue}">
	 	        	           <li style="color:black;font-weight:bold">价格低到高</li>
	 	        	 </c:if>
	 	        	 
	 	        	 <c:if test="${'createdate'!=param.orderValue}">
	 	        	 	  <li><a href='<s:url action="inproducts" namespace="/product/list"/>?orderValue=createdate&typeid=${param.typeid}&brandId=${sbrandid}'>最近上架</a></li>
	 	        	 </c:if>
	 	        	 
	 	        	 <c:if test="${'createdate'==param.orderValue}">
	 	        	       <li style="color:black;font-weight:bold">最近上架</li>
	 	        	 </c:if>
	 	        </ul>
	 	        
	 	        
	 	        
	 	        <div style=" float:left; margin-top:25px;margin-left:10px">
	 	        
		 	        <c:set var="out" value=""/>
		 	        <c:forEach items="${types}" var="type" varStatus="statu">
		 	                <c:if test="${statu.count==1}"> <c:set var="out" value=" &gt; &gt; <em>${type.name}</em> ${out}"/>  </c:if>
		 	               <c:if test="${statu.count>1}"> <c:set var="out" value=" &gt; &gt; <a href='/product/list/inproducts?typeid=${type.typeid }'/>${type.name}</a> ${out}"/></c:if>
		 	             
		 	        </c:forEach>
		 	                      您现在的位置：<em name="linkHome">Dshop</em> <c:out value="${out}" escapeXml="false"></c:out>
		 	                      
		 	   </div>                 
	 	                      
	 	                      
	 	                      
	 	                      
	 	                      
	 	                   
	 	        <h1>Title</h1>		 	       
	 	        <h2>Titleborde</h2>
	 	        <div id="choice">
	 	        	 <p>按品牌选择</p>
	 	        	 	
	 	      
	 	        	 	
	 	        	 	<ul>
	 	        	 	   <c:forEach items="${brands}" var="brand">

	 	        	 	     <li><a href="<s:url action="inproducts" namespace="/product/list"/>?orderValue=${param.orderValue}&typeid=${param.typeid}&brandId=${brand.code}">${brand.name}</a></li>
	 	        	 	     	 	        	 	     
	 	        	 	    </c:forEach>
	 	        	    </ul> 
	 	        	 	
	 	        	 	
	 	        
	 	        </div>
	 	        <h2>Titleborde</h2>
	 	        
	 	        
	 	        
	 	        
	 	        <div id="prodctlists">
	 	        	
	 	        	
	 	        	   <c:if test="${empty pageView.records}"><font size="14" color="red">对不起，没有相关记录</font></c:if>
					   <c:if test="${!empty pageView.records}">
				       <c:forEach  items="${pageView.records}" var="entry">
				       
		 	        	  <dl>
		 	        	  <c:forEach items="${entry.styles}" var="pic">
		 	        	    <a href='<s:url action="viewcookie" namespace="/product/list"/>?productId=${entry.id}'><dt><img src="${pic.imageFullPath}" width="170"></dt></a>
		 	        	   </c:forEach>
		 	        	     <dd style="margin"><a href='<s:url action="viewcookie" namespace="/product/list"/>?productId=${entry.id}'>名称：${entry.name }</a></dd>	
		 	        	  	 <dd>销售价：${entry.sellprice}</dd>
		 	        	  </dl>
	 	        	  
	 	        	  
	 	        	 </c:forEach>
	 	            </c:if>
	 	        	  
	                
	 	        </div>
	 	        
	 	      
	 	      
	 	   	 <center>
	 	   	 
			       <c:forEach  begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
					    <c:if test="${pageView.currentpage==wp}"><a href="#" class="number current" >${wp}</a></c:if>              
					    <c:if test="${pageView.currentpage!=wp}"><a href='<s:url action="inproducts" namespace="/product/list"/>?page=${wp}&orderValue=${param.orderValue}&typeid=${param.typeid}&brandId=${param.brandId}' class="number">${wp}</a></c:if> 
				  </c:forEach>
				  
				 <div style="float:right">&nbsp;&nbsp;</div>跳转到第
						<select name="selectPage" class="kuang" onChange="javaScript:topage(this.value)">
								<c:forEach begin="1" end="${pageView.totalpage}" var="wp">
								<option value="${wp}" <c:if test="${pageView.currentpage==wp}">selected</c:if>> ${wp} </option></c:forEach>
						</Select>页
						<SCRIPT LANGUAGE="JavaScript">
						<!--
						function topage(pagenum,orderby){
							window.location.href='<s:url action="inproducts" namespace="/product/list"/>?typeid=${param.typeid}&brandId=${param.brandId}&orderValue=${param.orderValue}&page='+ pagenum;
						}
						//-->
						</SCRIPT>
				         </div>
					     </div>
   				 </div>
			
			</center> 
			
			
			
			
			
	 	   </div>
	 	

	 	
	 	</div>
	 
	 

</body>
</html>
