<%
	if(session.getAttribute("username") != null) {
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("username")){
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		session.invalidate();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="CDN.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Logout</h3>
		</header>
		
		<div class="panel panel-danger">
			
			<div class="panel-heading">
				<h3>Hai appena effettuato il Logout.</h3>
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
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>