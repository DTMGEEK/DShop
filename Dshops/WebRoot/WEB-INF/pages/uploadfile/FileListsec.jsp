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
		<script type="text/javascript" src="/js/jquery-1.3.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="/js/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="/js/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="/js/jquery.wysiwyg.js"></script>
		
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
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/file/dealfile_addFile" onsubmit="return checkfm(this)" method="post" enctype="multipart/form-data">
				
			
					
					<h4>上传新文件</h4>
                                   <input type="hidden" name="page" value=""/>
	
                                                      文件　　<input type="file" name="uploadfile"><br/>
                  
					<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->


<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>文件管理列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>文件id</th>
								   <th>文件名称</th>
								   <th>上传时间</th>
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
									            
									        
									            
									
									<td>${listvalue.id}</td>
									<td>${listvalue.filename}</td>
									<td>${listvalue.uploadtime}</td>
									
							  
									<td>
										<!-- Icons -->
										 <a href="#mydiv_${listvalue.id}" title="下载"  rel="facebox" ><img src="/images/icons/pencil.png" alt="下载" /></a>                  
										 <a href="#deleteconfirmdiv_${listvalue.id}" title="删除" rel="facebox"><img src="/images/icons/cross.png" alt="删除" /></a> 
										 
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv_${listvalue.id}" style="display:none">               
				<h3>下载菜单</h3>
			 
			 
			 
				<form action=""  onsubmit="return checkfm(this)" method="post">
				                   
                                    <input type="hidden" name="id" value="${listvalue.id}">
                                    <input type="hidden" name="uploadfileContentType" value="${listvalue.fileContentType}">
					 文件名称　：    　  <input type="text" name="filename" value="${listvalue.filename}"/><br/>

                  
									<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->

    
    
       <!--弹出确认是否删除菜单  --><div id="deleteconfirmdiv_${listvalue.id}" style="display:none">               
				<h3>删除菜单</h3>
			 
				
					
					<h4>是否删除</h4>
					            
					
			                       文    件id　　               <input type="text"  name="fileid" value="${listvalue.id}" maxlength="100" disabled="disabled"><br/>
					 文件名称　：    　  <input  type="text" name="name" value="${listvalue.filename}" disabled="disabled"/><br/>
                       
                                   <a href="<s:url action="dealfile_deleteFile" namespace="/control/file"/>?fileid=${listvalue.id}&page=${pageView.currentpage}">删除</a>
                                   
                                   
								
	
								
								
								
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
				<h3>查询页</h3>
	
					<h4>类别查询</h4>
                        
                        <form action="" method="post">
     									
     									
     									<input type="hidden" name="query" value="querval"/>
							类别名称　：   <input  type="text" name="queryvalue" /><br/>   

									     <input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
            
          
</body>
</html>
