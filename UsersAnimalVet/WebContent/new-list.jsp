<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>

  function checkForm(form)
  {
    if(form.ownerPNum.value == "") {
      alert("Error: Owner Phone Number is empty!");
      form.ownerPNum.focus();
      return false;
    }

    var re = /^[\w ]+$/;

    if(!re.test(form.ownerPNum.value)) {
      alert("Error: Phone number contains invalid characters ");
      form.ownerPNum.focus();
      return false;
    }

    // validation was successful
    return true;
  }

</script>
<body>
	<form action = "createNewListServlet" method="post" onsubmit = "return checkForm(this);">
	List Name: <input type ="text" name = "listName"><br />
	Visit date: <input type ="text" name = "month" placeholder="mm" size="4"> 
				<input type ="text" name = "day" placeholder="dd" size="4">, 
				<input type ="text" name = "year" placeholder="yyyy" size="4">
	Owner phone number: <input type = "text" name = "ownerPNum"><br />

	Available Pets:<br />

	<select name="allPetsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allPets}" var="currentpet">
   	<option value = "${currentpet.id}">${currentitem.type} | ${currentpet.name} | ${currentpet.owner}</option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value="Create List and Add Pets">
	</form>
	<a href = "index.html">Go add new pets instead.</a>
</body>
</html>