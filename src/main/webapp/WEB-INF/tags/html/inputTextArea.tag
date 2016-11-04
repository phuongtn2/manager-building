<%@ tag isELIgnored="false" body-content="empty" dynamic-attributes="options" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="object" required="true"%>
<spring:bind path="${object}">
	<textarea name="${status.expression}"
		<c:forEach items="${options}" var="option">
			${option.key}="${option.value}"
		</c:forEach>>${fn:escapeXml(status.value)}</textarea>
	<span style="color:#A00000">${status.errorMessage}</span>
</spring:bind>