<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ attribute name="items" type="java.util.Collection"
	rtexprvalue="true" required="true"%>
<%@ attribute name="columns" required="true"%>
<%@ attribute name="properties" required="true"%>
<%@ attribute name="css"%>

<c:if test="${not empty items}">
	<table class="${css}">
		<thead>
			<tr>
				<c:forEach items="${fn:split(columns,',')}" var="columnName">
					<th>${columnName}</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
			    <c:set scope="request" var="loopVar" value="${item}"></c:set>
				<tr>
					<c:forEach items="${fn:split(properties,',')}" var="propertyName">
						<td>${item[propertyName]}</td>
					</c:forEach>
					<jsp:doBody />
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>