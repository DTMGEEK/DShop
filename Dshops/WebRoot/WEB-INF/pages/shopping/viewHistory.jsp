<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

	<c:forEach items="${histoty}" var="histoty" varStatus="statu">
		<li >${statu.count}.<a href='<s:url action="viewcookie" namespace="/product/list"/>?productId=${histoty.id}' target="iframe1">${histoty.name}</a></li></c:forEach>		
	
        


