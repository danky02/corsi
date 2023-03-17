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
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
.table-responsive table {
	display: block;
	margin-right: 4em;
	margin-left: 4em;
}
</style>
<%@ include file="CDN.html"%>
<meta charset="UTF-8">
<title>Statistiche</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">

		<%
		AdminFacade af = AdminFacade.getInstance();
		%>

		<div style="display: flex;">
			<div style="width: 50%;">
			<header class="page-header">
				<h3>Statistiche</h3>
			</header>
				<p>
					Numero di corsisti totali: <strong> <%=af.getTotStudentCount()%>
					</strong>
				</p>
				<%
				String tmpCourse = null;
				tmpCourse = af.getPopularCourse();
				if (tmpCourse != null) {
				%>
				<p>
					Corso con maggiore frequenza: <strong> <%=af.getPopularCourse()%>
					</strong>
				</p>
				<p>
					Data del corso con massima data d'inizio : <strong> <%
					 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					 %> <%=formatter.format(af.getLatestCourseDate())%>
					</strong>
				</p>
				<p>
					Durata media dei corsi: <strong> <%=af.getAverageDuration()%>
					</strong>
				</p>
				<p>
					Numero di commenti totali: <strong> <%=af.getCommCount()%>
					</strong>
				</p>
				<br>
				<%
				}
				%>
			</div>

			<%
			ArrayList<Course> corsi2 = new ArrayList<Course>(af.getFreeCourses());
			if (!corsi2.isEmpty()) {
			%>
			<div
				style="width: 30%; margin-top:2em;">
				<h4 style="text-align: center;">Posti occupati nei corsi</h4>
				<canvas id="freeseats-chart"></canvas>
			</div>
			<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
			<script>
			var freeseatsData = {
				labels: [<%Iterator<Course> iterator3 = corsi2.iterator();
					while (iterator3.hasNext()) {
						Course corso = iterator3.next();%> "<%=corso.getCourseName()%>", <%}%>],
							
				datasets: [{
					data: [<%Iterator<Course> iterator4 = corsi2.iterator();
						while (iterator4.hasNext()) {
							Course corso = iterator4.next();%><%=corso.getFreeSeats()%>,<%}%>],
							
					backgroundColor: [
						'rgba(255, 99, 132, 0.6)',
						'rgba(54, 162, 235, 0.6)',
						'rgba(255, 206, 86, 0.6)',
						'rgba(75, 192, 192, 0.6)',
						'rgba(153, 102, 255, 0.6)',
						'rgba(255, 159, 64, 0.6)'
					],
				
					borderColor: [
						'rgba(255, 99, 132, 1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
				
					borderWidth: 1
				}]
		
			};
		
			var freeseatsOptions = {
				title: {
					display: true,
					text: 'Posti liberi per corso'
				},
				
				cutoutPercentage: 50,
				
				legend: {
					position: 'bottom',
					labels: {
						fontColor: 'black',
						boxWidth: 10,
						padding: 15
					}
				}
			};
		
			var freeseatsChart = new Chart(document.getElementById('freeseats-chart'), {
				type: 'doughnut',
				data: freeseatsData,
				options: freeseatsOptions
			});
		
	</script>
			<%
			}
			%>
			<hr>
		</div>





		<div style="display: flex; justify-content: left; width: 100%; margin-top: 3em;">
			<!-- Qua lista di tutti i corsisti -->
			<div class="table-responsive">
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


</body>
</html>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>