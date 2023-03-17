<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="UTF-8">
<title>Error 403</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Autorizzazione negata.</h3>
		</header>
		
		<div class="panel panel-default">
			
			<div class="panel-heading">
				<h3>Impossibile caricare la risorsa richiesta.</h3>
			</div>
			
			<div class="panel-body">
				<p>
					<button onclick="window.history.back()" class="btn btn-default">Indietro</button>
				</p>
			</div>
		
		</div>
		
	</div>
</body>
</html>