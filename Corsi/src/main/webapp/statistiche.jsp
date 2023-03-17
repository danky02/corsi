<%@page import="corsi.businesscomponent.model.Professor"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="corsi.businesscomponent.facade.AdminFacade"%>
<%@page import="corsi.businesscomponent.model.Student"%>
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
<title>Statistiche</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">
		<header class="page-header">
			<h3>Statistiche</h3>
		</header>
		<% AdminFacade af = AdminFacade.getInstance(); %>
		<p>
			Numero di corsisti totali:
			<strong>
			<%= af.getTotStudentCount() %>
			</strong>
		</p>
		<br>
		<% 
			String tmpCourse = null;
			tmpCourse = af.getPopularCourse();
			if(true) {
		%>
		<p>
			Corso con maggiore frequenza:
			<strong>
			<%= af.getPopularCourse() %>
			</strong>
		</p>
		<br>
		<p>
			Data del corso con massima data d'inizio :
			<strong>
			<% 
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	        %>
			<%= formatter.format(af.getLatestCourseDate())%>
			</strong>
		</p>
		<br>
		<p>
			Durata media dei corsi:
			<strong>
			<%= af.getAverageDuration()%>
			</strong>
		</p>
		<br>
		<p>
			Numero di commenti totali:
			<strong>
			<%= af.getCommCount()%>
			</strong>
		</p>
		<br>
		<% 
		}
		%>
		
		<!-- Qua lista di tutti i corsisti -->
		<div style="display: flex;">
			<div class="table-responsive">
				<table class="table tabel-hover">
				<caption>Corsisti</caption>
					<thead>
						<tr>
							<th>Nome e cognome</th>
							<th>Precedenti formativi</th>
						</tr>
					</thead>
					<tbody>
						<%
						ArrayList<Student> corsisti = new ArrayList<Student>(af.getAllStudents());
						Iterator<Student> iterator = corsisti.iterator();
						while(iterator.hasNext()) {
							Student studente = iterator.next();
						%>
						<tr>
							<td style="vertical-align: middle;"> <a href="infoStudente.jsp?code=<%= studente.getCode() %>"><%= studente.getName()%> <%= studente.getSurname()%></a>  </td>

							<td style="vertical-align: middle;"><%= studente.getBackground() ? "Si" : "No" %></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<div class="table-responsive">
				<table class="table tabel-hover">
				<caption>Professori eclettici</caption>
					<thead>
						<tr>
							<th>Nome</th>
							<th>Cognome</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
						ArrayList<Professor> professori = new ArrayList<Professor>(af.getMultiProfs());
						Iterator<Professor> iterator2 = professori.iterator();
						while(iterator2.hasNext()) {
							Professor professore = iterator2.next();
						%>
						<tr>
							<td style="vertical-align: middle;"> <a href="infoStudente.jsp?code=<%= professore.getCode() %>"><%= professore.getName()%></a>  </td>
							<td style="vertical-align: middle;"> <a href="infoStudente.jsp?code=<%= professore.getCode() %>"><%= professore.getSurname()%></a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<hr>
	</div>
</body>
</html>
<%
} else {
	response.sendRedirect("accessonegato.jsp");
}
%>