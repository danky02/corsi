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
<title>Student Insert</title>

<link rel="stylesheet" href="css/style.css">
<script src="js/validazione.js"></script>

</head>
<body>

	<jsp:include page="navbar.jsp" />
	<div class="container">
		
		<header class="page-header">
			<h3>Inserisci nuovo corsista</h3>
		</header>

		<form id="form" action="/<%=application.getServletContextName()%>/createStudent" method="post" class="form-horizontal">
			<!-- Name -->
			<div class="form-group">
				<label class="col-md-2 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<input type="text" placeholder="Nome..." name="name" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoStudentName"></div>
			</div>
			<!-- Surname -->
			<div class="form-group">
				<label class="col-md-2 control-label">Cognome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<input type="text" placeholder="Cognome..." name="surname" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoStudentSurname"></div>
			</div>
			<!-- Background checkbox -->
			<div class="form-group">
				<label class="col-md-2 control-label">Precedenti Formativi</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<input id='backgroundCheckbox' 			type='checkbox' value='true' name='background' class="form-control">
						<input id='backgroundCheckboxHidden' 	type='hidden' 	value='false' name='background'>
					</div>
				</div>
			</div>
						
			<!-- Submit button -->
			<div class="row">
				<div class="col-md-4 col-md-offset-2">
					<button type="submit" class="btn btn-primary">Registra corsista&nbsp;&nbsp;<span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
	const form = document.getElementById('form');
	const backgroundCheckbox = document.getElementById("backgroundCheckbox");
	const backgroundCheckboxHidden = document.getElementById('backgroundCheckboxHidden');
	
	form.addEventListener('submit', () => {
		backgroundCheckboxHidden.disabled = backgroundCheckbox.checked;
	}
	</script>

</body>
</html>

<%
} else {
response.sendRedirect("login.jsp");
}
%>