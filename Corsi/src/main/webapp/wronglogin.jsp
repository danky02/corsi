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
<title>Dati Errati</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<%
			Integer attempts = 0;
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				if(c.getName().equals("attempts")){
					attempts = 5 - Integer.parseInt(c.getValue());
				}
			}
		%>
		<header class="page-header">
			<h3>Hai inserito i dati sbagliati.</h3>
			<p>Hai a disposizione ancora: <%=attempts%> tentativi</p>
		</header>
		
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Riprova.</h3>
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