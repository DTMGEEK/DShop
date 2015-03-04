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
		<script type="text/javascript" src="/js/facebox.js"></script>
				
		<!-- jQuery Datepicker Plugin -->
			<script type="text/javascript" src="/js/jquery.wysiwyg.js"></script>
		
		
       <script type="text/javascript" src="/js/utils.js"></script> 
       
 
 
        
        
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
					
					<h3>产品列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>

								   <th>商品id</th>
								   <th>货号</th>
								   <th>名称</th>
								   <th>所属分类</th>
								   <th>底价</th>
								   <th>销售价</th>
								   <th>销售量</th>
								   <th>是否在售</th>
								   <th>是否推荐</th>
								   <th>操作</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <%@ include file="/WEB-INF/pages/share/productfenye.jsp"  %>
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
									<td>${listvalue.code}</td>
									<td>${listvalue.name}</td>
									<td>${listvalue.type.name}</td>
									<td>${listvalue.baseprice}</td>
									<td>${listvalue.sellprice}</td>
									<td>${listvalue.sellcount}</td>
									<td><c:if test="${listvalue.visible==true}"><a href="#unvisible_${listvalue.id}" rel="facebox">在售</a></c:if> <c:if test="${listvalue.visible==false}"><a href="#visible_${listvalue.id}" rel="facebox">不在售</a></c:if></td>
									<td><c:if test="${listvalue.commend==true}"><a href="#uncommand_${listvalue.id}" rel="facebox">推荐</a></c:if><c:if test="${listvalue.commend==false}"><a href="#command_${listvalue.id}" rel="facebox"></>不推荐</a></c:if></td>
									  
									<td>
										<!-- Icons -->
										 <a href="#mydiv_${listvalue.id}" title="修改"  rel="facebox" ><img src="/images/icons/pencil.png" alt="修改" /></a>                  
										 <a href="#deleteconfirmdiv_${listvalue.id}" title="删除" rel="facebox"><img src="/images/icons/cross.png" alt="删除" /></a> 
										 <a href="<s:url action="prostyles" namespace="/control/product" />?productId=${listvalue.id}" title="产品样式"  ><img src="/images/icons/hammer_screwdriver.png" alt="产品样式" /></a>
										 
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv_${listvalue.id}" style="display:none">               
				<h3>修改菜单</h3>
			 
			           
		
				<form action="${pageContext.request.contextPath}/control/product/dealproduct_updateProduct"  onsubmit="return checkfm(this)" method="post">
				                    <input type="hidden" name="page" value="${pageView.currentpage}"/>
                                    <input type="hidden" name="productinfobean.id" value="${listvalue.id}">
					 类别名称　：    　  <input type="text" name="productinfobean.name" value="${listvalue.name}"/><br/>
					 底　　价　：    　  <input type="text" name="productinfobean.baseprice" value="${listvalue.baseprice}"/><br/>
					  销售价　　：    　  <input type="text" name="productinfobean.marketprice" value="${listvalue.marketprice}"/><br/>              
					  品　牌　　：         　     <select name="productinfobean.brandid" >
									               <c:forEach items="${brands}" var="brandvalue"></tr>
									                  <c:if test="${brandvalue.name==listvalue.brand.name}"><option value="${brandvalue.code }" label="${brandvalue.name}" selected="selected"></option></c:if>
									                   <option value="${brandvalue.code }" label="${brandvalue.name}"></option>
									           	    </c:forEach>					           	          
					                 </select>  
					                 
					                 
					                 
                                                
						    <input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->

    
    
    
    					
             <!--弹出上架选择框  --><div id="visible_${listvalue.id}" style="display:none">               
				
	
					<h4>上架</h4>			
     								<h1>你是否确定决定此商品上架</h1>	
     									<input type="hidden" name="query" value="querval"/>
							名　称　：   <input  type="text" name="name" value="${listvalue.name}" disabled="disabled"/><br/>
						          货　号	              ：　 <input  type="text" name="code" value="${listvalue.code}" disabled="disabled"/><br/>
                           	销售价　： <input  type="text" name="code" value="${listvalue.sellprice}" disabled="disabled"/><br/>

							        <a href="<s:url action="dealproduct_visible" namespace="/control/product"/>?productId=${listvalue.id}&page=${pageView.currentpage}">上架</a>
	
	            </div> <!-- 弹出上架选择框-->
	
    <!--弹出下架选择框  --><div id="unvisible_${listvalue.id}" style="display:none">               
				
	
					<h4>下架</h4>			
     								<h1>你是否确定决定此商品下架</h1>	
     									<input type="hidden" name="query" value="querval"/>
							名称　：   <input  type="text" name="name" value="${listvalue.name}" disabled="disabled"/><br/>
						          货号	              ： <input  type="text" name="code" value="${listvalue.code}" disabled="disabled"/><br/>
                           	销售价： <input  type="text" name="code" value="${listvalue.sellprice}" disabled="disabled"/><br/>

							        <a href="<s:url action="dealproduct_unvisible" namespace="/control/product"/>?productId=${listvalue.id}&page=${pageView.currentpage}">下架</a>
	
	            </div> <!-- 弹出下架选择框-->
	
	
	
	
              <!--弹出推荐选择框  --><div id="command_${listvalue.id}" style="display:none">               
				
	
					<h4>推荐</h4>			
     								<h1>你是否确定决定此商品为推荐商品</h1>	
     									<input type="hidden" name="query" value="querval"/>
							名称　：   <input  type="text" name="name" value="${listvalue.name}" disabled="disabled"/><br/>
						          货号	              ： <input  type="text" name="code" value="${listvalue.code}" disabled="disabled"/><br/>
                           	销售价： <input  type="text" name="code" value="${listvalue.sellprice}" disabled="disabled"/><br/>

							        <a href="<s:url action="dealproduct_command" namespace="/control/product"/>?productId=${listvalue.id}&page=${pageView.currentpage}">推荐</a>
	
	            </div> <!-- 弹出推荐选择框-->
    
     <!--弹出不推荐选择框  --><div id="uncommand_${listvalue.id}" style="display:none">               
				
	
					<h4>推荐</h4>			
     								<h1>你是否确定决定此商品为不推荐商品</h1>	
     									<input type="hidden" name="query" value="querval"/>
							名称　：   <input  type="text" name="name" value="${listvalue.name}" disabled="disabled"/><br/>
						          货号	              ： <input  type="text" name="code" value="${listvalue.code}" disabled="disabled"/><br/>
                           	销售价： <input  type="text" name="code" value="${listvalue.sellprice}" disabled="disabled"/><br/>

							        <a href="<s:url action="dealproduct_uncommand" namespace="/control/product"/>?productId=${listvalue.id}&page=${pageView.currentpage}">不推荐</a>
	
	            </div> <!-- 弹出不推荐选择框-->
    
    
    
    
    
    
       <!--弹出确认是否删除菜单  --><div id="deleteconfirmdiv_${listvalue.id}" style="display:none">               
				<h3>删除菜单</h3>
			 
		
					               
					 类别名称　：    　  <input type="text" name="productinfobean.name" value="${listvalue.name}" disabled="disabled"  　/><br/>
                                                     品　牌　　：         　     <select name="productinfobean.brandid"  disabled="disabled">
									               <c:forEach items="${brands}" var="brandvalue"></tr>
									                  <c:if test="${brandvalue.name==listvalue.brand.name}"><option value="${brandvalue.code }" label="${brandvalue.name}" selected="selected"></option></c:if>
									                   <option value="${brandvalue.code }" label="${brandvalue.name}"></option>
									           	    </c:forEach>					           	          
					                 </select><br/>
					                 
					                 
	       <a href="<s:url action="dealproduct_deleteProduct" namespace="/control/product"/>?productinfobean.id=${listvalue.id}">删除</a>
                                   
                                   
								
				
	</div> 
								
								
								
								
			</c:forEach>
							
							</tbody>
	   </c:if>
							
						</table>
                        
 					  <p>                    
                      		 <a  class="shortcut-button" style="display:inline" href="<s:url action="showaddproductform" namespace="/control/product" />?page=${pageView.currentpage}" title="增加新产品"  ><img src="/images/icons/paper_content_pencil_48.png" alt="icon" />
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
	
                        
                        <form action="${pageContext.request.contextPath}/control/product/allproduct" method="post">
     									
     									
     							    <input type="hidden" name="query" value="querval"/>
							名　称　：   <input  type="text" name="name" /><br/>
						          货　号　  ： <input  type="text" name="code" /><br/>
                           	销售价　：<br/>
                           	开始价　：<input  type="text" name="startsellprice" /><br/>  
                         结束价　：<input  type="text" name="endsellprice" /><br/>   
                           	                                                                
							品　牌		   ：   <select name="brandid" >
							                           <option value="">无</option>
									               <c:forEach items="${brands}" var="brandvalue"></tr>
									                   <option value="${brandvalue.code }" label="${brandvalue.name }"></option>
									           	    </c:forEach>					           	          
					                    </select>  <br/>	    
							
							
							
							 <input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
	
	
	
            
          
</body>
</html>
