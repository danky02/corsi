<%
	if(session.getAttribute("username") != null)
		response.sendRedirect("courseAttendance.jsp");
	else {
		if(request.getCookies() != null){
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				if(c.getName().equals("username")){
					session.setAttribute("username", c.getValue());
					response.sendRedirect("courseAttendance.jsp");
				}
			}
		}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/validazione.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Inserisci i dati per accedere</h3>
		</header>
		<form id="form" method="post" action="/<%=application.getServletContextName()%>/loginControl" class="form-horizontal">
			<!-- Username -->
			<div class="form-group">
				<label class="col-md-2 control-label">Username</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input id="username" type="text" name="username" placeholder="Username..." class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoUsername"></div>
			</div>
			<!-- Password -->
			<div class="form-group">
				<label class="col-md-2 control-label">Codice Admin</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock"></i>
						</span>
						<input id="admincode" type="password" name="admincode" placeholder="Codice admin..." class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoAdminCode"></div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-2">
					<button type="submit" class="btn btn-primary">Login&nbsp;&nbsp;<span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%
	}
%>