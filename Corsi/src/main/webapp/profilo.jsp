<%@page import="corsi.businesscomponent.facade.AdminFacade"%>
<% 
	if(session.getAttribute("username") != null) {
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="UTF-8">
<title>Profilo</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/validazione.js"></script>
<script src="js/modificaProfilo.js"></script>
</head> 
<body>
	<jsp:include page="navbar.jsp"/>
	<div class="container">
	<header class="page-header">
		<h3>Dati del tuo profilo</h3>
	</header>
	<form action="/<%=application.getServletContextName()%>/profilo" method="post" id="form" class="form-horizontal">
	 <!-- --------------------------Nome -->
	 <div class="form-group">
	 	<label class="col-md-1 control-label">Nome</label>
	 	<div class="col-md-4 inputGroupContainer">
	 		<div class="input-group">
	 			<span class="input-group-addon">
	 				<i class="glyphicon glyphicon-user"></i>
	 			</span>
	 			<input class="form-control" type="text" readonly value= "<%= AdminFacade.getInstance().getAdminByUsername((String)session.getAttribute("username")).getAdminName()%>"
	 			id="name" name="name">
	 			<input type="hidden" name="username" value="<%=session.getAttribute("username") %>">
	 		</div>
			 	<div class="col-md-7 error" id="infoStudentName"></div>
	 	</div>
		<button class="btn btn-primary" type="button" onclick="modifica('nome')">
			<i class="glyphicon glyphicon-pencil"></i>
		</button>
	</div>
	<div class="form-group">
	 	<label class="col-md-1 control-label">Cognome</label>
		 <div class="col-md-4 inputGroupContainer">
		 	<div class="input-group">
		 		<span class="input-group-addon">
		 			<i class="glyphicon glyphicon-user"></i>
		 		</span>
		 		<input class="form-control" type="text" readonly value= "<%= AdminFacade.getInstance().getAdminByUsername((String)session.getAttribute("username")).getAdminSurname()%>"
		 			id="surname" name="surname">
		 		<input type="hidden" name="username" value="<%=session.getAttribute("username") %>">
		 	</div>
			 	<div class="col-md-7 error" id="infoStudentSurname"></div>
		 </div>
	 		<button class="btn btn-primary" type="button" onclick="modifica('cognome')">
	 			<i class="glyphicon glyphicon-pencil"></i>
	 		</button>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-off-set-1">
			<button type="submit" class="btn btn-info">
		 		Modifica&nbsp;&nbsp;<span class="glyphicon glyphicon-send"></span>
		 	</button>
		</div>
	</div>
</form>
</div>
</body>
</html>
<% 
	}else{
		response.sendRedirect("courseAttendance.jsp");
	}
%>