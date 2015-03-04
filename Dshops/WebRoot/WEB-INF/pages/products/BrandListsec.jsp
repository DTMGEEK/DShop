<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  
         <link rel="stylesheet" href="/css/bginvalid.css" type="text/css" media="screen" />
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="/css/bgreset.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="/css/bgliststyle.css" type="text/css" media="screen" />	
        
        <!-- jQuery -->
		<script type="text/javascript" src="/js/jquery-1.5.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="/js/simpla.jquery.configuration.js"></script>
		
		<script type="text/javascript" src="/js/jquery.wysiwyg.js"></script>
		<!-- Facebox jQuery Plugin -->
		
		
	
		<script type="text/javascript" src="/js/checkForm.js"></script>
		
		<script type="text/javascript" src="/js/facebox.js"></script>
	
	
        
        <script type="text/javascript">
   			 jQuery(document).ready(function($) {
      			$('a[rel*=facebox]').facebox() 
    		 })
		</script>
		
		
		
		
		
        
        
        
        
</head>
<body>

	<s:fielderror/>


<!--弹出增加新父类型  --><div id="addparentdiv" style="display:none">               
				<h3>增加新品牌</h3>
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/product/dealbrand_Addbrand" method="post" onsubmit="return checkfm(this)" enctype="multipart/form-data">
				
			
					
					<h4>增加新品牌</h4>
                                   <input type="hidden" name="page" value="${pageView.totalpage}"/>
					 品牌名称　：　    　   <input type="text" name="brandName" maxlength="40"/><br/>
                    LOGO图片 ：　　 <input type="file" name="logoimg" ><br/>
                  
					            <input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->


<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>品牌列表</h3>  <s:fielderror/>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>品牌id</th>
								   <th>名称</th>
								   <th>LOGO图片</th>
								   <th>操作</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <%@ include file="/WEB-INF/pages/share/brandfenye.jsp"  %>
                                        </div>
                                         </center> <!-- End .pagination -->
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
						 
							<tbody>
								<c:if test="${empty pageView.records}"><font size="14px" color="red">对不起 ，没有相关记录</font></c:if>
					<c:if test="${!empty pageView.records}">
							<c:forEach  items="${pageView.records}" var="listvalue">
								<tr>
									            
									        
									            
									
									<td>${listvalue.code}</td>
							
									<td>${listvalue.name}</td>
									<td>   <c:if test="${!empty listvalue.logopath}"><img src="${listvalue.logopath}" width="100px" /></c:if> <c:if test="${empty listvalue.logopath}"><img src="/没有图片.img"></c:if></td>  
									<td>
										<!-- Icons -->
										 <a href="#mydiv_${listvalue.code}" title="修改"  rel="facebox" ><img src="/images/icons/pencil.png" alt="修改" /></a>                  
										 <a href="#deleteconfirmdiv_${listvalue.code}" title="删除" rel="facebox"><img src="/images/icons/cross.png" alt="删除" /></a> 
									
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv_${listvalue.code}" style="display:none">               
				<h3>修改菜单</h3>
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/product/dealbrand_updateBrand" method="post" onsubmit="return checkfm(this)" enctype="multipart/form-data" >
				                    <input type="hidden" name="page" value="${pageView.currentpage}"/>
                                    <input type="hidden" name="code" value="${listvalue.code}">
                                    
					 品牌名称　：    　  <input id="brandName" type="text" name="brandName" value="${listvalue.name}"/><br/>
					 新LOGO图片 ：             <input id="logoimg" type="file" name="logoimg" > <br/>
                                                       旧LOGO图片     ：       <c:if test="${!empty listvalue.logopath}"><img src="${listvalue.logopath}" width="100px" /></c:if> <c:if test="${empty listvalue.logopath}">该品牌没有图片</c:if><br/>
                                    
									<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->

    
    
       <!--弹出确认是否删除菜单  --><div id="deleteconfirmdiv_${listvalue.code}" style="display:none">               
				<h3>删除菜单</h3>
			 
				
					
					<h4>是否删除</h4>
					            
					
					               
					 品牌名称　：    　  <input  type="text" name="name" value="${listvalue.name}" disabled="disabled"/><br/>
                                                      品牌LOGO　：　      <c:if test="${!empty listvalue.logopath}"><img src="${listvalue.logopath}" width="100px" /></c:if> <c:if test="${empty listvalue.logopath}">该品牌没有图片</c:if><br/>
                                                        
                                  <a href="<s:url action="dealbrand_delBrand" namespace="/control/product"/>?code=${listvalue.code}">删除</a>
                                   
                                   
                                   
								
				
	
								
								
								
								
			</c:forEach>
						
							</tbody>
       </c:if>
							
						</table>
                        
					  <p>
                      		 <a  class="shortcut-button" style="display:inline" href="#addparentdiv" title="修改"  rel="facebox"><img src="/images/icons/image_add_48.png" alt="icon" />
                                                                                         增加新品牌
                            </a>
                            
                              <a  class="shortcut-button" style="display:inline" href="#querydiv" title="修改"  rel="facebox"><img src="/images/icons/comment_48.png" alt="icon" />
                                                                                           查询
                            </a>
       
					  </p>
                  </div> 
					<!-- End #tab1 -->
						
				</div> <!-- End .content-box-content -->
				
			</div>
			
			</div> <!-- End 弹出确认是否删除菜单 -->
    
    					
             <!--弹出查询菜单  --><div id="querydiv" style="display:none">               
				<h3>查询页</h3>
	
					<h4>品牌查询</h4>
                        
                        <form action="${pageContext.request.contextPath}/control/product/showbrandlist" onsubmit="return checkquery(this)" method="post">
     									
     									
     									<input type="hidden" name="query" value="querval"/>
							品牌名称　：   <input  type="text" name="queryvalue" /><br/>   

									     <input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
            
          

</body>
</html>
