<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<%@ taglib uri="/struts-tags" prefix="s" %>



<s:hidden value="page"/>
 <center>
       

       <c:forEach  begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
		    <c:if test="${pageView.currentpage==wp}"><a href="#" class="number current">${wp}</a></c:if> 
		    <c:if test="${pageView.currentpage!=wp}"><a href='<s:url action="allproducts" namespace="/product/list"/>?page=${wp}&queryvalue=${queryValue}' class="number">${wp}</a></c:if> 
	  </c:forEach>   

</center> 




