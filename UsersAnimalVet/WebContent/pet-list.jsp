<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet List</title>
</head>
<body>
	<h1 style="font-size:40px"> Animal vet pet's file </h1>
	<h2 style="font-size:25px"> Please choose the option to change pet's file </h2>
	<h3 style="color:red" style="font-size:10px"> Select file first then do the operation </h3>

	<form method = "post" action = "navigationServlet">	
	<table>
	<c:forEach items="${requestScope.allPets}" var="currentpet">
	<tr>
 	<td><input type = "radio" name ="id" value = "${currentpet.id}"></td>
 	<td>${currentpet.type}</td>
 	<td>${currentpet.name}</td>
 	<td>${currentpet.owner}</td>
 	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToPet">
	<input type = "submit" value = "delete" name="doThisToPet">
	<input type = "submit" value = "add" name = "doThisToPet">
	</form>
</body>
</html>