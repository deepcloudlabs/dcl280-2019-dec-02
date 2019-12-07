<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logon Page</title>
<c:url value="/" var="ctx" />
<style type="text/css">
@import url("css/game.css");
</style>
</head>
<body>
	<c:url value="/game/logon" var="urlAction" />
	<fmt:message code="buttonLabel.logon" var="btnLabel" />
	<div class="div-center">
		<jsp:include page="lang.jsp" />
		<util:form action="${urlAction}" cssStyle="border: 0px; width: 800px;">
			<util:inputText name="nickname" i18nLabel="label.nickname">
				<util:error items="${errors}" field="nickname" style="color: red;" />
			</util:inputText>
			<util:inputText name="email" i18nLabel="label.email">
				<util:error items="${errors}" field="email" style="color: red;" />
			</util:inputText>
			<util:inputText name="identityNo" i18nLabel="label.identityNo">
				<util:error items="${errors}" field="identityNo" style="color: red;" />
			</util:inputText>
			<util:inputText name="iban" i18nLabel="label.iban">
				<util:error items="${errors}" field="iban" style="color: red;" />
			</util:inputText>
			<util:inputText name="password" i18nLabel="label.password" password="true">
				<util:error items="${errors}" field="password" style="color: red;" />
			</util:inputText>
			<util:select name="level" i18nLabel="label.gameLevel" begin="3" end="8">
			    <input type="submit" value="${btnLabel}" />
			</util:select>
		</util:form>
		<c:if test="${not empty errorMessage}">
			<h3>
      			<span class="error">${errorMessage}</span>
     		</h3>	
 		</c:if>		
	</div>
</body>
</html>