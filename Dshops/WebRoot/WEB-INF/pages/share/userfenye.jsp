<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>



<s:hidden value="page"/>
 <center>
       当前页：第${pageView.pageindex.startindex }页  总记录:${pageView.totalrecord } 每页显示:${pageView.maxresult} 条记录 总页数${pageView.totalpage }<br/>

       <c:forEach  begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
		    <c:if test="${pageView.currentpage==wp}"><a href="#" class="number current">${wp}</a></c:if>                      
		    <c:if test="${pageView.currentpage!=wp}"><a href='<s:url action="showalluser" namespace="/control/user"/>?page=${wp}<c:if test="${!empty queryvalue}">&query=${queryvalue}&<c:if test="${!empty qusername}"></c:if>&username=${qusername}</c:if><c:if test="${!empty qrealname}">&realname=${qrealname}</c:if><c:if test="${!empty qemail}">&email=${qemail}</c:if>' class="number">${wp}</a></c:if> 
	  </c:forEach>   

</center> 




