<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>


  
  <link type="text/css" href="/css/good.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" media="screen" href="/css/all-examples.css">
  
    
     <script type="text/javascript" src="/js/jquery-1.5.2.js"></script>

	<script type="text/javascript" src="/js/mz-packed.js"></script>
	<script type="text/javascript" src="/js/cartadd.js"></script>
	
	
<script  type="text/javascript" >

	function styleEvent(styleid){
		var productImage = document.getElementById('productPrototypeImage_'+ styleid);
		if(productImage){
		    var main_image = document.getElementById("productimg");
			
			main_image.src=productImage.value;
		}
	}
	
</script>















	

</head>

<body>

 
<c:set  var="imagecount" value="0" />

<c:forEach items="${viewproduct.styles}" var="style">
            <c:set  var="imagecount" value="${imagecount+1}" />
    <c:if test="${style.visible==true}">
       <c:set var="creentImage"  value="${style}"/>
    </c:if>
 </c:forEach>   
	      <c:set var="out" value="${viewproduct.name}"/>
		 	        <c:forEach items="${stypes}" var="type" >
		 	   
		 	            <c:set var="out" value=" &gt; &gt; <a href='/product/list/viewcookie?productId=${viewproduct.id }'/>${viewproduct.name}</a>"/>
		 	             
		 	        </c:forEach>
		 	                      您现在的位置：<c:out value="${out}" escapeXml="false"></c:out>
		 	            
      <div id="good">
	 	    <h1>Title</h1>
	 	    <div id="goodimg">
	 	    	<form action="${pageContext.request.contextPath}/product/list/cartsession" method="get">
                         <input type="hidden" id="productid"  name="productid" value="${viewproduct.id}"/>

 			 	    			
	 	    	 <a href="###"><img id="productimg" src="${creentImage.imageFullPath}"/ width="200"></a>



                      <c:if test="${imagecount==1}">
	 	    			              颜色：${creentImage.name}
	 	    			     <input type="hidden" id="styleid" name="styleid" value="${creentImage.id}"/> 
	 	    			     <input type="hidden"  id="productImage_${creentImage.id}"  value="${creentImage.imageFullPath}"/>             
	 	    			</c:if>	
	 	    			
	 	    			<c:if test="${imagecount>1}">
	 	    			      <select id="styleid" name="styleid" onchange="styleEvent(this.value)">
	 	    			      
		 	    			      <c:forEach items="${viewproduct.styles}" var="style">
		 	    			           <c:if test="${style.visible}">
		 	    		                       <option value="${style.id}" selected>${style.name}</option>	
		 	    		               </c:if>
		 	    			      </c:forEach>
	 	    			         
	 	    			      </select>
	 	    			      
	 	    			           <c:forEach items="${viewproduct.styles}" var="style">
		 	    			             <c:if test="${style.visible}">
		 	    			          
											<INPUT TYPE="hidden" id="productImage_${style.id}" value="${style.image140FullPath}">
										    <INPUT TYPE="hidden" id="productPrototypeImage_${style.id}" value="${style.imageFullPath}">
										 </c:if>
								   </c:forEach>            
	 	    			     
	 	    			</c:if>
	 	    			
	 	    			
	 	    </div>
	 	 
	 	    			
	 	    
	 	    <div id="gooddescri">
	 	    	  <ul>
	 	    	      <li>商品名称:${viewproduct.name}</li>
	 	    	      <li>品牌：${viewproduct.brand.name}</li>		
	 	    	      <li>市场价：${viewproduct.marketprice}</li>	
	 	    	      <li><p>本站价：${viewproduct.sellprice}</p></li>	
	 	    	      <li><p>节省：${viewproduct.marketprice-viewproduct.sellprice}</li>
	 	    	      <li><img id="buyitem" type="image" src="/images/purchbtn.png" onclick="getjsoninfo()"></li>	
	 	    	      
	 	    	  	
	 	    	  </ul>

	 	     </div>
	 	     
   
         
         
         <div id="prodes">
               <h1>产品说明</h1>	
               <p>${viewproduct.description }</p>
         	
         </div>
         
 </form> 
 
 
   
         <!--为加入评论 页面和css-->
         <div id="comment">
         	   <h1>网友评论</h1>

         	</div>
          <!--为加入评论-->
          
         
         

	 </div>
	 
	  
  
       
       
</body>
</html>
