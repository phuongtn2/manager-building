<%@ tag isELIgnored="false" body-content="empty" dynamic-attributes="options" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="object" required="true"%>
<%@ attribute name="fields" required="false"%>
<spring:hasBindErrors name="${object}">
	<div style="color:#A00000">
		<!--<p>Please correct the following errors:</p>-->
		<ul>
			<spring:bind path="${object}">
				<c:forEach items="${status.errorMessages}" var="error">
					<li>${error}</li>
				</c:forEach>
			</spring:bind>
			<c:if test="${fields}">
				<spring:bind path="${object}.*">
					<c:forEach items="${status.errorMessages}" var="error">
						<li>${error}</li>
					</c:forEach>
				</spring:bind>
			</c:if>
		<ul>
	</div>
</spring:hasBindErrors>