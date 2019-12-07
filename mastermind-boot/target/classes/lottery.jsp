<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lottery Page</title>
<style type="text/css">
   	tbody tr:NTH-CHILD(2n) {
      background-color: #e0e0e0;
   	}
   	tbody tr:NTH-CHILD(2n+1) {
      background-color: #d0d0d0;
  	 }
   	tbody tr:HOVER {
      background-color: yellow;
   	}
   	tbody > tr > td {
		text-align: center;	 
	}
</style>
</head>
<body>
   <form action="draw" method="post">
   	  <label for="n">n:</label>
   	  <input type="text" id="n" name="n" value="${param.n}"/>	
      <button name="action" value="draw">Draw</button>
      <button name="action" value="reset">Reset</button>
   </form>
   <c:if test="${not empty lottery.numbers}">
   <table>
	   <thead>
	   		<tr>
				<c:forEach begin="1" end="6" var="i">
					<th>Number ${i}</th>				  
				</c:forEach>
			</tr>	   
	   </thead>
	   <tbody>
	      <c:forEach var="numbers" items="${lottery.numbers}">
	      		<tr>
		          <c:forEach var="num" items="${numbers}">
		          	<td>${num}</td>
		          </c:forEach>
	          	</tr>
	      </c:forEach>
	   </tbody>
   </table>
   </c:if>
</body>
</html>