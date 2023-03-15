<%
if (session.getAttribute("username") != null) {
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="UTF-8">
<title>Student Courses</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h2>Student Courses Registration</h2>
		</header>
	</div>
</body>
</html>
<%
} else {
response.sendRedirect("login.jsp");
}
%>