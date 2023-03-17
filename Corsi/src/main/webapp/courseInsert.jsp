<%@page import="corsi.businesscomponent.facade.AdminFacade"%>
<%@page import="corsi.businesscomponent.model.Course"%>
<%@page import="java.util.List"%>
<%
if (session.getAttribute("username") != null) {
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Inserimento corso</title>
	

<%@include file="CDN.html"%>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<script src="js/validazione.js"></script>
<script>
	$(function() {
		$('#dp').datepicker({ 
			format: 'dd/mm/yyyy', 
			autoclose: 'true', 
			startDate: '01/01/1900', 
			endDate: '01/01/2026'
		}).on('changeDate', function(e){
			$('#form').bootstrapValidator('revalidateField', 'startdate');
		});
	});
</script>
<script>
	$(function() {
		$('#dp2').datepicker({ 
			format: 'dd/mm/yyyy', 
			autoclose: 'true', 
			startDate: '01/01/1900', 
			endDate: '01/01/2026'
		}).on('changeDate', function(e){
			$('#form').bootstrapValidator('revalidateField', 'enddate');
		});
	});
</script>
</head>
<body>
	<jsp:include page="navbar.jsp"/>
	<div class="container">
		<header class="page-header">
			<h3>Inserisci nuovo corso</h3>
		</header>

		<form id="form" action="/<%=application.getServletContextName()%>/courseInsert" method="post" class="form-horizontal">
			<!-- Name -->
			<div class="form-group">
				<label class="col-md-2 control-label">Nome Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-list-alt"></i>
						</span>
						<input type="text" placeholder="Nome..." name="course_name" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoStudentName"></div>
			</div>
			<!-- Start Date -->
			<div class="form-group">
				<label class="col-md-2 control-label">Data Inizio</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="dp">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-calendar"></i>
						</span>
						<input type="text" placeholder="Data inizio..." name="startdate" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoStartDate"></div>
			</div>
			<!-- End Date -->
			<div class="form-group">
				<label class="col-md-2 control-label">Data Fine</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="dp2">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-calendar"></i>
						</span>
						<input type="text" placeholder="Data fine..." name="enddate" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoEndDate"></div>
			</div>
			<!-- Cost -->
			<div class="form-group">
				<label class="col-md-2 control-label">Costo</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-euro"></i>
						</span>
						<input type="number" min="0" placeholder="Costo..." name="cost" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoCost"></div>
			</div>
			<!-- Classroom -->
			<div class="form-group">
				<label class="col-md-2 control-label">Classe</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-home"></i>
						</span>
						<input type="text" placeholder="Aula..." name="classroom" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoClassroom"></div>
			</div>
			<!-- Professor -->
			<div class="form-group">
				<label class="col-md-2 control-label">Professore</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input type="number" min="0" placeholder="Codice Professore..." name="profcode" class="form-control">
					</div>
				</div>
				<div class="col-md-6 error" id="infoProfCode"></div>
			</div>
						
			<!-- Submit button -->
			<div class="row">
				<div class="col-md-4 col-md-offset-2">
					<button type="submit" class="btn btn-primary">Registra corso&nbsp;&nbsp;<span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%					
}else{
response.sendRedirect("login.jsp");
}%>