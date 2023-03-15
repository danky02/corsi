<%
	if(session.getAttribute("username") == null)
		response.sendRedirect("login.jsp");
	else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/validazione.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h4>Cookies: <%= request.getCookies() != null ? request.getCookies().length : 0 %></h4>
</body>
</html>
<% 
	} 
%>