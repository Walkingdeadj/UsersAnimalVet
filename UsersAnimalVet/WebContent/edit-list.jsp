<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
	<form action = "editListDetailsServlet" method="post">
	<input type ="hidden" name = "id" value= "${listToEdit.id}">
	List Name: <input type ="text" name ="listName" value="${listToEdit.listName}"><br />
	Visit date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name= "year" placeholder="yyyy" size="4" value= "${year}">
	Owner phone number: <input type = "text" name = "ownerPNum" value= "${listToEdit.owner.ownerPNum}"><br />
	
	Available Pets:<br />
	
	<select name="allPetsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allPets}" var="currentpet">
	<option value = "${currentpet.id}">${currentpet.type} |${currentpet.name} |${currentpet.owner}</option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value="Edit List and Add Pets">
	</form>
	<a href = "index.html">Go add new pets instead.</a>
</body>
</html>