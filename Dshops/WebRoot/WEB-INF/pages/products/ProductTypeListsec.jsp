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
		
		<!-- Facebox jQuery Plugin -->
			<script type="text/javascript" src="/js/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="/js/facebox.js"></script>
		

		
		<!-- jQuery Datepicker Plugin -->
		
		
        
        <script type="text/javascript" src="/js/producttypecheckForm.js"></script>
        
        
        
        <script type="text/javascript">
			jQuery(document).ready(function($) {
			  $('a[rel*=facebox]').facebox() 
			})
			
		</script>
		
		
        
        
        
        
</head>
<body>



<!--弹出增加新父类型  --><div id="addparentdiv" style="display:none">               
				<h3>增加新父类型</h3>
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/product/dealtype_addType" onsubmit="return checkfm(this)" method="post">
				
			
					
		
                                   <input type="hidden" name="page" value="${pageView.totalpage}"/>
					 类别名称　：    　  <input type="text"name="name"/><br/>
                                                      备注(100字)　　<input type="text" name="note" maxlength="100"><br/>
                  
					<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->


<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>产品类型列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>商品类型id</th>
								   <th>名称</th>
								   <th>描述</th>
								   <th>所属父类</th>
								   <th>操作</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <%@ include file="/WEB-INF/pages/share/fenye.jsp"  %>
                                        </div>
                                         </center> <!-- End .pagination -->
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
						 
						<tbody>
						   <c:if test="${empty pageView.records}"><font size="14" color="red">对不起，没有相关记录</font></c:if>
					        <c:if test="${!empty pageView.records}">
							<c:forEach  items="${pageView.records}" var="listvalue">
								<tr>
									            
									        
									            
									
									<td>${listvalue.typeid}</td>
									<td><c:if test="${fn:length(listvalue.childrenType) >0}"><a href='<s:url action="showprodutlist" namespace="/control/product"/>?typeid=${listvalue.typeid}' title="title">${listvalue.name}</a></c:if><c:if test="${fn:length(listvalue.childrenType) ==0}">${listvalue.name}</c:if></td>
									<td>${listvalue.note}</td>
									<td><c:if test="${!empty listvalue.parentType}">${listvalue.parentType.name}</c:if> <c:if test="${empty listvalue.parentType}">该类是顶级类别(有${fn:length(listvalue.childrenType)}个子类) </c:if>   </td>  
									<td>
										<!-- Icons -->
										 <a href="#mydiv_${listvalue.typeid}" title="修改"  rel="facebox" ><img src="/images/icons/pencil.png" alt="修改" /></a>                  
										 <a href="#deleteconfirmdiv_${listvalue.typeid}" title="删除" rel="facebox"><img src="/images/icons/cross.png" alt="删除" /></a> 
										 <a href="#addchilderndiv_${listvalue.typeid}" title="增加子类"  rel="facebox"><img src="/images/icons/hammer_screwdriver.png" alt="增加子类" /></a>
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv_${listvalue.typeid}" style="display:none">               
				<h3>修改菜单</h3>
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/product/dealtype_updateType"  onsubmit="return checkfm(this)" method="post">
				                    <input type="hidden" name="page" value="${pageView.currentpage}"/>
                                    <input type="hidden" name="typeid" value="${listvalue.typeid}">
					 类别名称　：    　  <input type="text" name="name" value="${listvalue.name}"/><br/>
                                                      备注(100字)　　<input type="text" name="note" value="${listvalue.note}" maxlength="100"><br/>
                  
									<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->

    
    
       <!--弹出确认是否删除菜单  --><div id="deleteconfirmdiv_${listvalue.typeid}" style="display:none">               
				<h3>删除菜单</h3>
	
					            				
					               
					 类别名称　：    　  <input  type="text" name="name" value="${listvalue.name}" disabled="disabled"/><br/>
                                                      备注(100字)　　<input type="text"  name="note" value="${listvalue.note}" maxlength="100" disabled="disabled"><br/>
                                                        
                                   <a href="<s:url action="dealtype_delType" namespace="/control/product"/>?typeid=${listvalue.typeid}&page=${pageView.currentpage}">删除</a>
                                   
                                   
								
				
	</div> <!-- End 弹出确认是否删除菜单 -->
    
    					
             <!--弹出增加子类  --><div id="addchilderndiv_${listvalue.typeid}" style="display:none">               
				<h3>增加子类</h3>
                        
                        <form action="${pageContext.request.contextPath}/control/product/dealtype_addType.action" onsubmit="return checkfm(this)" method="post">
                        
                                            
							              <input type="hidden" name="page" value="${pageView.currentpage}"/>
							               <input type="hidden" name="typeid" value="${listvalue.typeid}"/>
							类别名称　：    　  <input id="name"  type="text"name="name" /><br/>
		                                                      备注(100字)　　<input   type="text" name="note"  maxlength="100"><br/>       

									<input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End  弹出增加子类-->
								
								
								
								
			</c:forEach>
							
							</tbody>
	   </c:if>
							
						</table>
                        
					  <p>
                      		 <a  class="shortcut-button" style="display:inline" href="#addparentdiv" title="修改"  rel="facebox"><img src="/images/icons/paper_content_pencil_48.png" alt="icon" />
                                                                                         增加新类
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
				<h3>查询</h3>
                        
                        <form action="${pageContext.request.contextPath}/control/product/showprodutlist" method="post">
     									
     									
     									<input type="hidden" name="query" value="querval"/>
							类别名称　：   <input  type="text" name="queryvalue" /><br/>   

									     <input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
            
          
</body>
</html>
