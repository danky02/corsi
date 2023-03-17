<%@page import="corsi.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="UTF-8">
<title>Error Page</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
</head> 
<body>
	<jsp:include page="navbar.jsp"/>
	<div class="container">
		<header class="page-header">
			<h3>Pagina di errore</h3>
		</header>
	<%
		if(exception instanceof ClassNotFoundException) {
	%>
	<div class="panel panel-danger">
			<div class="panel-heading">
				<h5>Tipo eccezione: <%=exception.getClass().getName() %></h5>
			</div>
			
			<div class="panel-body">
				 <p>Message: <%= exception.getMessage() %></p>
				 <p>
					 <button onclick="window.history.back()" class="btn btn-default">Indietro</button>
				 </p>
			</div>
		</div>
		<%
			}else if (exception instanceof DAOException){	
		%>
		
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h5>Tipo eccezione: <%=exception.getClass().getName() %></h5>
			</div>
			
			<div class="panel-body">
				 <p>Message: <%= exception.getMessage() %></p>
				 <p>
					 <button onclick="window.history.back()" class="btn btn-default">Indietro</button>
				 </p>
			</div>
		</div>
		
		<%
			} else {
		%>
		
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h5>Tipo eccezione: <%= exception.getClass().getName() %></h5>
			</div>
			
			<div class="panel-body">
				 <p>Message: <%= exception.getMessage() %></p>
				 <p>StackTrace: <% exception.printStackTrace(new PrintWriter(out)); %></p>
				 <p>
					 <button onclick="window.history.back()" class="btn btn-default">Indietro</button>
				 </p>
			</div>
		</div>
		
		<%
			}
		%>
</div>
</body>
</html>