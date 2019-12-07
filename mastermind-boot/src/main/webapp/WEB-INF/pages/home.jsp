<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mastermind</title>
<c:url value="/" var="ctx" />
<style type="text/css">
@import url("${ctx}resources/css/game.css");
</style>
</head>
<body>
	<c:url value="/game/play" var="urlAction" />
	<fmt:message code="buttonLabel.play" var="btnLabel" />
	<fmt:message code="table.column.message" var="columnMessage" />
	<fmt:message code="table.column.guess" var="columnGuess" />
	<div class="div-center">
		<jsp:include page="lang-home.jsp" />
		<util:form action="${urlAction}" cssStyle="border: 0px; width: 650px;">
			<util:outputText i18nLabel="label.nickname"
				value="${player.nickname}" />
			<util:outputText i18nLabel="label.email" value="${player.email}" />
			<util:outputText i18nLabel="label.gameLevel"
				value="${game.level}" />
			<util:inputText name="guess" i18nLabel="label.guess">
				<input type="submit" value="${btnLabel}" />
			</util:inputText>
		</util:form>
		<p style="color: red;">${errorMessage}</p>

		<util:table items="${game.history}" css="zebra hover header"
			columns="${columnGuess},${columnMessage}" properties="guess,message" />
	</div>
</body>
</html>