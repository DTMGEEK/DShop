<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

	<c:forEach items="${topsellproducts}" var="topsellproduct" varStatus="statu">
		<li >${statu.count}.<a target="iframe1" href='<s:url  action="viewcookie" namespace="/product/list"/>?productId=${topsellproduct.id}'>${topsellproduct.name}</a></li></c:forEach>		



