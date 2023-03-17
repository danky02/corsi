<%@page import="corsi.businesscomponent.model.Course"%>
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
		<%
		AdminFacade af = AdminFacade.getInstance();
		%>
		<p>
			Numero di corsisti totali: <strong> <%=af.getTotStudentCount()%>
			</strong>
		</p>
		<br>
		<%
		String tmpCourse = null;
		tmpCourse = af.getPopularCourse();
		if (tmpCourse != null) {
		%>
		<p>
			Corso con maggiore frequenza: <strong> <%=af.getPopularCourse()%>
			</strong>
		</p>
		<br>
		<p>
			Data del corso con massima data d'inizio : <strong> <%
 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
 %> <%=formatter.format(af.getLatestCourseDate())%>
			</strong>
		</p>
		<br>
		<p>
			Durata media dei corsi: <strong> <%=af.getAverageDuration()%>
			</strong>
		</p>
		<br>
		<p>
			Numero di commenti totali: <strong> <%=af.getCommCount()%>
			</strong>
		</p>
		<br>
		<%
		}
		%>

		<div style="display: flex; justify-content: center; width: 100%;">
			<!-- Qua lista di tutti i corsisti -->
			<div class="table-responsive" style="display: flex;">
				<%
				ArrayList<Student> corsisti = new ArrayList<Student>(af.getAllStudents());
				if (!corsisti.isEmpty()) {
				%>
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
						Iterator<Student> iterator = corsisti.iterator();
						while (iterator.hasNext()) {
							Student studente = iterator.next();
						%>
						<tr>
							<td style="vertical-align: middle;"><a
								href="infoStudente.jsp?code=<%=studente.getCode()%>"><%=studente.getName()%>
									<%=studente.getSurname()%></a></td>

							<td style="vertical-align: middle;"><%=studente.getBackground() ? "Si" : "No"%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<%
			}
			%>
			<%
			ArrayList<Professor> professori = new ArrayList<Professor>(af.getMultiProfs());
			if (!professori.isEmpty()) {
			%>
			<div class="table-responsive">
				<table class="table tabel-hover">
					<caption>Professori multi-corso</caption>
					<thead>
						<tr>
							<th>Nome</th>
							<th>Cognome</th>
						</tr>
					</thead>
					<tbody>
						<%
						Iterator<Professor> iterator2 = professori.iterator();
						while (iterator2.hasNext()) {
							Professor professore = iterator2.next();
						%>
						<tr>
							<td style="vertical-align: middle;"><%=professore.getName()%>
							</td>
							<td style="vertical-align: middle;"><%=professore.getSurname()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<%
			}
			%>
			<%
			ArrayList<Course> corsi = new ArrayList<Course>(af.getFreeCourses());
			if (!corsi.isEmpty()) {
			%>
			<div class="table-responsive">
				<table class="table tabel-hover">
					<caption>Corsi liberi</caption>
					<thead>
						<tr>
							<th>Nome corso</th>
							<th>Posti liberi</th>
						</tr>
					</thead>
					<tbody>
						<%
						Iterator<Course> iterator3 = corsi.iterator();
						while (iterator3.hasNext()) {
							Course corso = iterator3.next();
						%>
						<tr>
							<td style="vertical-align: middle;"><%=corso.getCourseName()%></td>
							<td style="vertical-align: middle;"><%=12 - corso.getFreeSeats()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<hr>
</body>
</html>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>