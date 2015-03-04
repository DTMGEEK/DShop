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
        
        <script language="JavaScript">
function checkfm(form){
	if (trim(form.stylename.value)==""){
		alert("样式名称不能为空！");
		form.stylename.focus();
		return false;
	}
	var imagefile = form.imagefile.value;
	if(trim(imagefile)!=""){
		var ext = imagefile.substring(imagefile.length-3).toLowerCase();
		if (ext!="jpg" && ext!="gif" && ext!="bmp" && ext!="png"){
			alert("只允许上传gif、jpg、bmp、png！");
			return false; 
		}
	}else{
		alert("请上传产品图片！");
		return false;
	}
	return true;
}
</script>
        
        
        <script type="text/javascript">
			jQuery(document).ready(function($) {
			  $('a[rel*=facebox]').facebox() 
			})
			
		</script>
		
		
        
        
        
        
</head>
<body>



<!--弹出增加新父类型  --><div id="addparentdiv" style="display:none">               
				<h3>增加新类型</h3>
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/product/dealtype_addType" onsubmit="return checkfm(this)" method="post">
				
		
                                   
					 类别名称　：    　  <input type="text"name="name"/><br/>
                                                      备注(100字)　　<input type="text" name="note" maxlength="100"><br/>
                  
					<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->


<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>产品样式列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>样式id</th>
								   <th>样式名称</th>								   
								   <th>是否在售</th>
								   <th>样式图片</th>
								   <th>操作</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                      
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
						 
						<tbody>
						   <c:if test="${empty styles}"><font size="14" color="red">对不起，没有相关记录</font></c:if>
					        <c:if test="${!empty styles}">
							<c:forEach  items="${styles}" var="listvalue">
								<tr>
									           
									        
									            
									
									<td>${listvalue.id}</td>
									<td>${listvalue.name}</td>
		                            <td><c:if test="${listvalue.visible==true}"><a href="#unvisiblediv_${listvalue.id}" rel="facebox">在售</a></c:if> <c:if test="${listvalue.visible!=true}"><a href="#visiblediv_${listvalue.id}" rel="facebox">不在售</a></c:if></td>
									<td><img src="${listvalue.imageFullPath }" width="100" /> </td>  
									<td>
										<!-- Icons -->
										 <a href="#mydiv_${listvalue.id}" title="修改"  rel="facebox" ><img src="/images/icons/pencil.png" alt="修改" /></a>                  
									     <a href="#delete_${listvalue.id}" title="删除" rel="facebox"><img src="/images/icons/cross.png" alt="删除" /></a> 
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv_${listvalue.id}" style="display:none">               
				<h3>修改菜单</h3>
			 
			 
			   <form action="${pageContext.request.contextPath}/control/product/dealproductstyle_updateStyle" method="post" enctype="multipart/form-data">
     									
     									
     									<input type="hidden" name="productId" value="${param.productId}"/>
     									<input type="hidden" name="productStyleId" value="${listvalue.id}"/>
							样式名称　：   <input  type="text" name="styleName" value="${listvalue.name}" /><br/> 
							新样式图片：     <input  type="file" name="logoImage" /><br/>
							旧样式图片：    <img src="${listvalue.imageFullPath }"   width="100px"> <br/>
							           

									     <input class="button" type="submit" value="提交" />		
					</form>
					
				
	</div> <!-- End  弹出修改 -->

    
    
       <!--弹出确认是否样式下架菜单  --><div id="unvisiblediv_${listvalue.id}" style="display:none">               
				<h3>样式下架菜单</h3>
	
     									<input type="hidden" name="productStyleId" value="${listvalue.id}"/>
							样式名称　：   <input  type="text" name="styleName" value="${listvalue.name }" disabled="disabled"/><br/> 
							样式图片：    <img src="${listvalue.imageFullPath }"   width="100px"><br/>
	
					  <a href="<s:url action="dealproductstyle_unvisible" namespace="/control/product"/>?productStyleId=${listvalue.id}&productId=${param.productId}">样式下架</a>
					      
                                   
								
				
	</div> <!-- End 弹出确认是否样式下架菜单 -->
    
    
    
    <!--弹出确认是否样式上架菜单  --><div id="visiblediv_${listvalue.id}" style="display:none">               
				<h3>样式上架菜单</h3>
		
     								
							样式名称　：   <input  type="text" name="styleName" value="${listvalue.name }" disabled="disabled"/><br/> 
							样式图片：    <img src="${listvalue.imageFullPath }"   width="100px"> <br/>

                                    <a href="<s:url action="dealproductstyle_visible" namespace="/control/product"/>?productStyleId=${listvalue.id}&productId=${param.productId}">样式上架</a>
								   
				
	</div> 
	
	<!-- End  弹出删除确定 -->
	<div id="delete_${listvalue.id}" style="display:none">               
				<h3>删除确定</h3>
			 

							样式名称　：   <input  type="text" name="styleName" value="${listvalue.name }" disabled="disabled"/><br/> 
							样式图片：    <img src="${listvalue.imageFullPath }"   width="100px"> <br/>
							
							   <a href="<s:url action="dealproductstyle_deletstyle" namespace="/control/product"/>?productStyleId=${listvalue.id}&productId=${param.productId}">确定删除</a>
                  
					
				</form>
				
	</div> <!-- End  弹出删除确定 -->
								
								
			</c:forEach>
							
							</tbody>
	   </c:if>
							
						</table>
                        
					  <p>
                      		 <a  class="shortcut-button" style="display:inline" href="#addnewstyle" title="修改"  rel="facebox"><img src="/images/icons/paper_content_pencil_48.png" alt="icon" />
                                                                                         增加新样式
                            </a>
                            
                           
					  </p>
                  </div> 
					<!-- End #tab1 -->
						
				</div> <!-- End .content-box-content -->
				
			</div>
			
			</div> <!-- End 弹出确认是否删除菜单 -->
    
    		
	
	</div> <!-- End 弹出确认是否删除菜单 -->
    
    					
             <!--弹出查询菜单  --><div id="addnewstyle" style="display:none">               
				<h3>添加新样式</h3>
	
					
                        
                        <form action="${pageContext.request.contextPath}/control/product/dealproductstyle_addStyle" method="post" enctype="multipart/form-data">
     									
     									
     									<input type="hidden" name="productId" value="${param.productId}"/>
							样式名称　：   <input  type="text" name="styleName" /><br/> 
							样式图片　：     <input type="file" name="logoImage" >  <br/>

									     <input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
            
          
</body>
</html>
