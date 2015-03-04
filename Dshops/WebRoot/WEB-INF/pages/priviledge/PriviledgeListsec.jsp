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
			 
				<form action="${pageContext.request.contextPath}/control/priviledge/dealprivilege_add"  method="post">
				
			
					
					<h4>增加新权限组</h4>
                                   <input type="hidden" name="page" value="${pageView.totalpage}"/>
					 权限组名称名称　：    　  <input type="text" name="name"/><br/>
                                                      选择权限:　　<c:forEach items="${privileges}" var="privilege" varStatus="statu">
									<input type="checkbox" name="privileges" value="${privilege.id.module},${privilege.id.privilege}">
										${privilege.name}　<c:if test="${statu.count%4==0}"><br></c:if>
	                            </c:forEach><br/>
                  
					<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->


<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>权限组列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>代号</th>
								   <th>名称</th>
								   <th>操作</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <%@ include file="/WEB-INF/pages/share/Privilegefenye.jsp"  %>
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
									            
									        
									            
									
									<td>${listvalue.groupid}</td>
									<td>${listvalue.name}</td>

									<td>
										<!-- Icons -->
										 <a href='<s:url action="showedit" namespace="/control/priviledge"/>?groupid=${listvalue.groupid}' title="修改" ><img src="/images/icons/pencil.png" alt="修改" /></a>                  
										 <a href="#deleteconfirmdiv_${listvalue.groupid}" title="删除" rel="facebox"><img src="/images/icons/cross.png" alt="删除" /></a> 
										
									</td>
								</tr>
								
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             

    
    
       <!--弹出确认是否删除菜单  --><div id="deleteconfirmdiv_${listvalue.groupid}" style="display:none">               
				<h3>删除菜单</h3>
			 
				
					
					<h4>是否删除</h4>
					            
					
					                  
					 权限组名称　：    　  <input  type="text" name="name" value="${listvalue.name }" disabled="disabled"/><br/>
                                        
                                                        
                                   <a href="<s:url action="dealprivilege_deletePriGuoup" namespace="/control/priviledge"/>?groupid=${listvalue.groupid }">删除</a>
                                   
                                   
								
				
	</div> <!-- End 弹出确认是否删除菜单 -->
    
    					
             <!--弹出增加子类  --><div id="addchilderndiv_${listvalue.groupid}" style="display:none">               
				<h3>增加子类菜单</h3>
	
					<h4>增加子类</h4>
                        
                        <form action="${pageContext.request.contextPath}/control/product/dealtype_addType.action" onsubmit="return checkfm(this)" method="post">
                        
                                            
							              <input type="hidden" name="page" value="${pageView.currentpage}"/>
							               <input type="hidden" name="typeid" value="${listvalue.groupid}"/>
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
                                                                                         增加新权限组
                            </a>
                            
                             
       
					  </p>
                  </div> 
					<!-- End #tab1 -->
						
				</div> <!-- End .content-box-content -->
				
			</div>
			
			</div> <!-- End 弹出确认是否删除菜单 -->
    
    					
             
            
          
</body>
</html>
