<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="dshop" uri="http://www.dshop.cn" %>


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
		<!--
	    <script type="text/javascript" src="/js/jquery.dynDateTime.js"></script>
		<script type="text/javascript" src="/js/calendar-en.js"></script>
		<script type="text/javascript" src="/js/checkEmployee.js"></script>
		-->
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
		
		<script type="text/javascript">
					jQuery(document).ready(function() {
						jQuery("#birthday").dynDateTime(); //defaults
					});
	   </script>
        
        
        
        
</head>
<body>



<!--弹出增加新员工  --><div id="addparentdiv" style="display:none">               
				<h3>增加新员工</h3>
			 
			 
			 
				<form action="${pageContext.request.contextPath}/control/priviledge/dealemployee_addEmployee"    method="post" enctype="multipart/form-data" >
				
	
                                   <input type="hidden" name="page" value="${pageView.totalpage}"/>
					 登录帐号　：    　  <input type="text" id="rusername" name="username" size="20" maxlength="32" onblur="getinfo()"/>（必须大于6位 不能为中文）<div id="checkResult" style="display: none"></div><br/>
				   	登录密码　：    　  <input type="password" id="password" name="password"  size="20" maxlength="32" onblur="checkPasswordLength()" />（必须大于6位 不能为中文）<div id="checklength" style="display: none"></div><br/>
					重复密码　：    　  <input type="password" id="repassword" name="password2" size="20" maxlength="20" onblur="checkPassword()" /><br/>
					 员工姓名　：    　  <input type="text" name="realname" size="20" maxlength="10" /><br/>
					 性　　别  ：           　　           <input type="radio" value="MAN" title="男" name="gender" checked="checked">男   <input type="radio" value="WOMAN" title="女" name="gender">女<br/> 
					 员工照片　：    　  <input type="file" name="picture" size="20"/><br/>
					 身份证号码　：  <input type="text" id="idcardno" name="cardno" size="20" maxlength="18" onblur="checkIdcardno()"/><div id="cardno" style="display: none"></div><br/>
					 出生日期　：  　    <input type="text" id="birthday" name="birthday" size="20" maxlength="18"/><br/>
					 出生地址　：　<input type="text" name="address" size="35" maxlength="100" /><br/>
					 联系电话　：    　  <input type="text" name="phone" size="20" maxlength="18"/><br/>
					 电子邮件　：    　  <input type="text" name="email" size="20" maxlength="18" /><br/>
					 学　　历　：    　  <input type="text" name="degree" size="20" maxlength="5" /><br/>
					 毕业院校　：    　  <input type="text" name="school"/><br/>
					 所在部门　：    　<c:forEach items="${departments}" var="department" varStatus="statu">

					                     <input type="radio" name="departmentid" value="${department.departmentid }" />${department.name}
					                     <c:if test="${statu.count%8==0}"><br></c:if>
					               </c:forEach>
					<br/>
                  
					<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  增加新员工 -->


<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>员工列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>用户名</th>
								   <th>设置权限</th>
								   <th>真实姓名</th>
								   <th>性别</th>
								   <th>联系电话</th>
								   <th>电子邮件</th>
								   <th>身份证号</th>
								   <th>图片</th>
								   <th>所属部门</th>
								   <th>标志为离职</th>
								   <th>操作</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <%@ include file="/WEB-INF/pages/share/Employeefenye.jsp"  %>
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
									
								        <td> <c:if test="${listvalue.visible}"><a href='<s:url action="showseleprivilege" namespace="/control/priviledge"/>?username=${listvalue.username}' >设置权限</a></c:if> <c:if test="${!listvalue.visible}"><font color=red>无法设置权限</font></c:if></td>
								
									<td>${listvalue.realname}</td>
									<td>${listvalue.gender.name}</td>  
									<td>${listvalue.phone}</td>  
									<td>${listvalue.email}</td>  
									<td>${listvalue.idCard.cardno}</td>  
									<td><c:if test="${!empty listvalue.imagePath}"><img src="${listvalue.imagePath}" width="80" border="0"></c:if></td>  
									<td>${listvalue.department.name}</td>
									<td>
									
									   <c:if test="${listvalue.visible}">
     										 <a href='<s:url action="dealemployee_leave" namespace="/control/priviledge"/>?username=${listvalue.username}'>标志为离职</a>
      								   </c:if> <c:if test="${!listvalue.visible}"><font color=red>已离职</font></c:if>
                                    
									</td>  
		
									<td>
										<!-- Icons -->
										 <c:if test="${listvalue.visible}">
										 <a href="#mydiv_${listvalue.username}" title="修改"  rel="facebox" ><img src="/images/icons/pencil.png" alt="修改" /></a>                  
										</c:if>
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv_${listvalue.username}" style="display:none">               
				<h3>修改菜单</h3>
			 
			 
				<form action="${pageContext.request.contextPath}/control/priviledge/dealemployee_editEmployee"   method="post"  enctype="multipart/form-data">
				
				            登录帐号　：    　  <input type="text" name="username" size="20" maxlength="20" value='${listvalue.username}'  />（必须大于6位 不能为中文）<br/>
				           员工姓名　：    　  <input type="text" name="realname" value='${listvalue.realname}' size="20" maxlength="10" /><br/>
				
					 性　　别  ：                      <input type="radio"  <c:if test="${listvalue.gender.name=='MAN'}"> checked='checked'</c:if> value="MAN"   title="男" name="gender">男   <input type="radio"  <c:if test="${listvalue.gender.name=='WOMAN'}"> checked='checked'</c:if> value="WOMAN" title="女" name="gender">女<br/> 
					 员工照片　：    　  <input type="file" name="picture" size="20"/> <img src="${listvalue.imagePath}" width="80" border="0"><br/>
					身份证号码　：      <input type="text" name="cardno" value='${listvalue.idCard.cardno}' size="20" maxlength="20" /><br/>
					出生日期　：    　  <input type="text" name="birthday" value='${listvalue.idCard.birthday}'  size="20" maxlength="20"/><br/>
					 出生地址　：    　  <input type="text" name="address" value='${listvalue.idCard.address }'  size="35" maxlength="100" /><br/>
					 联系电话　：    　  <input type="text" name="phone" size="20" value='${listvalue.phone}'  maxlength="20"/><br/>
					 电子邮件　：    　  <input type="text" name="email" size="20"  value='${listvalue.email}'  maxlength="20" /><br/>
					 学　　历　：    　       <input type="text" name="degree" size="20"  value='${listvalue.degree}'  maxlength="20" /><br/>
					 毕业院校　：    　  <input type="text" name="school" value='${listvalue.school}'  /><br/>
					 原来所在部门 :　 <input type="text" name="school" disabled="disabled" value='${listvalue.department.name }'  /><br/>
					 所在部门　：    　<c:forEach items="${departments}" var="department" varStatus="statu">
					                     <input type="radio"   name="departmentid" value="${department.departmentid }" />${department.name}
					                     <c:if test="${statu.count%8==0}"><br></c:if>
					               </c:forEach><br/>
					
                  
									<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->

    
    
    
    					
           
								
								
								
								
			</c:forEach>
							
							</tbody>
	   </c:if>
							
						</table>
                        
					  <p>
                      		 <a  class="shortcut-button" style="display:inline" href="#addparentdiv" title="修改"  rel="facebox"><img src="/images/icons/paper_content_pencil_48.png" alt="icon" />
                                                                                         增加新员工
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
                        
                        <form action="${pageContext.request.contextPath}/control/priviledge/allemployees" method="post">
     									
     									
     									<input type="hidden" name="query" value="querval"/>
							      用户名　：   <input  type="text" name="username" /><br/>
							      姓　名　：   <input  type="text" name="realname" /><br/>
							     
                                                                                 部　门 　：       <select name="departmentid" >
									               <c:forEach items="${departments}" var="departmentvalue"></tr>
									                   <option value="${departmentvalue.departmentid }" label="${departmentvalue.name }"></option>
									           	    </c:forEach>					           	          
					                 </select>  <br/>
						 	     <input class="button" type="submit" value="提交" />		
					</form>
					
					
  
		
				
	</div> <!-- End 弹出查询菜单-->
            
          
</body>
</html>
