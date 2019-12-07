<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="i18nLabel"%>
<%@ attribute name="label"%>
<%@ attribute name="password"%>

<tr>
	<c:choose>
		<c:when test="${not empty i18nLabel}">
			<td style="width: 120px;"><fmt:message code="${i18nLabel}" /></td>
		</c:when>
		<c:otherwise>
			<td>${label}:</td>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${empty password}">
			<td><input type="text" name="${name}" value="${param[name]}" /><jsp:doBody /></td>
		</c:when>
		<c:otherwise>
			<td><input type="password" name="${name}" value="${param[name]}" /><jsp:doBody /></td>
		</c:otherwise>
	</c:choose>
</tr>