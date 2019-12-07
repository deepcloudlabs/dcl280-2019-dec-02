<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<c:url var="englishLocaleUrl" value="/game/play">
		<c:param name="locale" value="en" />
	</c:url>
	<c:url var="turkishLocaleUrl" value="/game/play">
		<c:param name="locale" value="tr" />
	</c:url>
	<a href="${englishLocaleUrl}"><img src="images/en.png" /></a>
	<a href="${turkishLocaleUrl}"><img src="images/tr.png" /></a>
</div>