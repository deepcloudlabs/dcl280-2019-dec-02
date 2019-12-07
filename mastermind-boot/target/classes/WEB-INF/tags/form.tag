<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="action" required="true"%>
<%@ attribute name="method"%>
<%@ attribute name="cssStyle"%>
<c:if test="${empty method}">
	<c:set var="method" value="post" />
</c:if>
<form action="${action}" method="${method}">
	<table style="${cssStyle}">
		<tbody>
			<jsp:doBody />
		</tbody>
	</table>
</form>