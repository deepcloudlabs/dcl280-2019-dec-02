<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags"%>
<%@ attribute name="value" required="true"%>
<%@ attribute name="i18nLabel"%>
<%@ attribute name="label"%>

<tr>
	<c:choose>
		<c:when test="${not empty i18nLabel}">
			<td style="width: 120px;"><fmt:message code="${i18nLabel}" /></td>
		</c:when>
		<c:otherwise>
			<td>${label}:</td>
		</c:otherwise>
	</c:choose>
	<td>${value}<jsp:doBody /></td>
</tr>