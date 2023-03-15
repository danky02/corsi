<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creazione studente</title>
</head>
<body>

<!--  jsp:include page="navbar.jsp" /--->

<form action="/createStudent" method="post" >

	<input type="text" placeholder="Your Name" name="name">
	<label>Name</label>
	<input type="text" placeholder="Your Surname" name="surname">
	<label>Surname</label>

</form>

</body>
</html>