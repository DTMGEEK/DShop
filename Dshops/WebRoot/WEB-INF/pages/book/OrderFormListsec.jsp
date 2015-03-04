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
					
					<h3>订单列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>订单号</th>
								   <th>订单金额</th>
								   <th>订单总金额</th>
								   <th>配送费</th>
								   <th>应付费</th>
								   <th>下单时间</th>
								   <th>支付状态</th>
								   <th>支付方式</th>
								   <th>顾客</th>
								   <th>状态</th>
								   <th>订单操作</th>
								   <th>订单状态</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <%@ include file="/WEB-INF/pages/share/orderfenye.jsp"  %>
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
									            
									        
									            
									
									
									<td>${listvalue.orderid}</td>
									<td>${listvalue.productTotalPrice }</td>
									<td>${listvalue.totalPrice}</td>
									<td>${listvalue.deliverFee}</td>  
									<td>${listvalue.payablefee}</td>  
									<td>${listvalue.createDate}</td>  
									<td><c:if test="${listvalue.paymentstate}">已支付</c:if><c:if test="${!listvalue.paymentstate}">未支付</c:if></td>  
									<td>${listvalue.paymentWay.name}</td> 
									<td>${listvalue.buyer.username}</td> 
									<td>${listvalue.state.name}</td>  
									<td>
									    <c:if test="${empty listvalue.lockuser ||listvalue.lockuser==employee.username}"><a href='<s:url namespace="/control/order"  action="showorderview"/>?orderid=${listvalue.orderid}' target="iframe1" >载入订单</a></c:if>
									    <c:if test="${!empty listvalue.lockuser ||listvalue.lockuser!=employee.username}"><a href='###'>订单已锁定</a></c:if>
									
									</td>  
									<td>
										 <c:if test="${!empty listvalue.lockuser ||listvalue.lockuser!=employee.username}"><a href='###'>订单已锁定</a></c:if>
										 <c:if test="${empty listvalue.lockuser &&listvalue.lockuser==employee.username}"><a href='###'>订单未锁定</a></c:if>
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv_" style="display:none">               
				<h3>修改菜单</h3>
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/product/dealtype_updateType"  onsubmit="return checkfm(this)" method="post">
				                    <input type="hidden" name="page" value="${pageView.currentpage}"/>
                                    <input type="hidden" name="typeid" value="">
					 类别名称　：    　  <input type="text" name="name" value=""/><br/>
                                                      备注(100字)　　<input type="text" name="note" value="" maxlength="100"><br/>
                  
									<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->

    
    
       <!--弹出确认是否删除菜单  --><div id="deleteconfirmdiv_" style="display:none">               
				<h3>删除菜单</h3>
			 
				
					
					<h4>是否删除</h4>
					            
					
					               
					 类别名称　：    　  <input  type="text" name="name" value="" disabled="disabled"/><br/>
                                                      备注(100字)　　<input type="text"  name="note" value="" maxlength="100" disabled="disabled"><br/>
                                                        
                                   <a href="<s:url action="dealtype_delType" namespace="/control/product"/>">删除</a>
                                   
                                   
								
				
	
								
								
								
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
	
					<h4>订单查询</h4>
                        
                        <form action="${pageContext.request.contextPath}/control/order/orderform" method="post">
     									
     									
     									<input type="hidden" name="query" value="querval"/>
							订单号　：   <input  type="text" name="orderid" /><br/>   
							订单状态 ：       <select name="state">
							                 <option value="CANCEL" >已取消</option>
							                 <option value="WAICONFIRM" selected="selected">待审核</option>
							                 <option value="WAITPAYMENT">等待付款</option>
							                 <option value="ADMEASUREPRODUCT">正在配货</option>
							                 <option value="WAITDELIVER">等待发货</option>
							                 <option value="DELIVER">已发货</option>
							                 <option value="RECEIVED">已收货</option>
							            
							            </select> <br/> 
							用户名　：   <input  type="text" name="username" /><br/>   
							收货人姓名　：   <input  type="text" name="recipients" /><br/>   
	

									     <input class="button" type="submit" value="查询" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
            
          
</body>
</html>
