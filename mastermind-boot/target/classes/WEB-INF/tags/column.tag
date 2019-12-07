<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="propertyName"%>

<c:choose>
	<c:when test="${not empty propertyName}">
		<td>${requestScope.loopVar[propertyName]}</td>
	</c:when>
	<c:otherwise>
		<td><jsp:doBody /></td>
	</c:otherwise>
</c:choose>
