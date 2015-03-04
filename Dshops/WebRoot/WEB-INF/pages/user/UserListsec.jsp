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





<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>用户列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>用户名</th>
								   <th>密码</th>
								   <th>真实姓名</th>
								   <th>电子邮件</th>
								   <th>注册日期</th>
								   <th>是否被禁用</th>
					
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <%@ include file="/WEB-INF/pages/share/userfenye.jsp"  %>
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
									            
									      
									            
									
									<td>${listvalue.username}</td>
									<td>${listvalue.password}</td>
									<td>${listvalue.realname}</td>
									<td>${listvalue.email}</td>  
									<td>${listvalue.regTime}</td>  
									<td><c:if test="${listvalue.visible==true}"><a href="#unvisible_${listvalue.username}" rel="facebox">启用</a></c:if>  <c:if test="${listvalue.visible==false}"><a href="#visible_${listvalue.username}" rel="facebox">禁用</a></c:if> </td>  
									
								</tr>
								
            

    
    
       <!--弹出确认是否禁用菜单  --><div id="unvisible_${listvalue.username}" style="display:none">               
				<h3>删除菜单</h3>
			 
					            
					
					               
					 用户名　：    　  <input  type="text" name="username" value="${listvalue.username}" disabled="disabled"/><br/>
                                                      真实姓名　　<input type="text"  name="note" value="${listvalue.realname}" maxlength="100" disabled="disabled"><br/>
                                                      注册日期　　<input type="text"  name="note" value="${listvalue.regTime}" maxlength="100" disabled="disabled"><br/>
                                                        
                                   <a href="<s:url action="dealuser_unvisible" namespace="/control/user"/>?username=${listvalue.username}&page=${pageView.currentpage}">禁用帐号</a>

	</div> <!-- End 弹出确认是否禁用菜单 -->
	
	<!--弹出确认是否启用菜单  --><div id="visible_${listvalue.username}" style="display:none">               
				<h3>删除菜单</h3>
			 
					            
					
					               
					 用户名　：    　  <input  type="text" name="username" value="${listvalue.username}" disabled="disabled"/><br/>
                                                      真实姓名　　<input type="text"  name="note" value="${listvalue.realname}" maxlength="100" disabled="disabled"><br/>
                                                      注册日期　　<input type="text"  name="note" value="${listvalue.regTime}" maxlength="100" disabled="disabled"><br/>
                                                        
                                   <a href="<s:url action="dealuser_visible" namespace="/control/user"/>?username=${listvalue.username}&page=${pageView.currentpage}">启用帐号</a>
                                   
                                   
								
				
	</div> <!-- 弹出确认是否启用菜单  -->
    
    		
								
								
								
								
			</c:forEach>
							
							</tbody>
	   </c:if>
							
						</table>
                        
					  <p>
                      		
                            
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
	
					<h4>类别查询</h4>
                        
                        <form action="${pageContext.request.contextPath}/control/user/showalluser" method="post">
     									
     									
     									<input type="hidden" name="query" value="querval"/>
							用户名　　：   <input  type="text" name="username" /><br/>   
							姓　名　　：   <input  type="text" name="realname" /><br/>   
							电子邮件　：   <input  type="text" name="email" /><br/>   

									     <input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
            
          
</body>
</html>
