<%@ tag isELIgnored="false" body-content="empty" dynamic-attributes="options" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="object" required="true"%>
<c:set var="url" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/bizreg"/>
<spring:bind path="${object}">
	<textarea name="${status.expression}" id="${status.expression}"
		<c:forEach items="${options}" var="option">
			${option.key}="${option.value}"
		</c:forEach>>${status.value}</textarea>
	<!--<span style="color:#A00000">${status.errorMessage}</span>-->
	<c:if test="${status.errorMessage != ''}">
		<img src="${url}/images/warning.gif">
	</c:if>
</spring:bind>