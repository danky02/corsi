<%
	if(session.getAttribute("username") != null) {
		response.sendRedirect("login.jsp");
	} else {
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="CDN.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troppi tentativi</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Hai eseguito troppi tentativi di login sbagliati.</h3>
		</header>
		
		<div class="panel panel-danger">
			
			<div class="panel-heading">
				<h3>Aspetta qualche minuto e riprova.</h3>
			</div>
			
			<div class="panel-body">
				<p>Per accedere nuovamente:</p>
				<p><a href="login.jsp">Log-In</a></p>
			</div>
		
		</div>
		
	</div>
</body>
</html>
<%
	}
%>