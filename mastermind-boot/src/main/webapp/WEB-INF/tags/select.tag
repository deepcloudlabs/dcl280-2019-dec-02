<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags"%>
<%@ attribute name="options" type="java.util.Collection"
	rtexprvalue="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="label"%>
<%@ attribute name="i18nLabel"%>
<%@ attribute name="labelProperty"%>
<%@ attribute name="valueProperty"%>
<%@ attribute name="begin"%>
<%@ attribute name="end"%>
<%@ attribute name="step"%>
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
		<c:when test="${not empty options}">
			<td><select name="${name}">
					<c:forEach items="${options}" var="opt">
						<c:choose>
							<c:when test="${not empty valueProperty}">
								<c:set var="val" value="${opt[valueProperty]}" />
							</c:when>
							<c:otherwise>
								<c:set var="val" value="${opt}" />
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${val eq param[name]}">
								<option label="${val}" selected="selected" value="${val}">${val}</option>
							</c:when>
							<c:otherwise>
								<option label="${val}" value="${val}">${val}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select> <jsp:doBody /></td>
		</c:when>
		<c:otherwise>
			<td><select name="${name}">
					<c:forEach begin="${begin}" end="${end}" var="n">
						<option label="${n}" value="${n}">${n}</option>
					</c:forEach>
			</select><jsp:doBody /></td>
		</c:otherwise>
	</c:choose>
</tr>