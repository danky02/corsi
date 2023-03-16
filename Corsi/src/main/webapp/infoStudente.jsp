<%@page import="corsi.businesscomponent.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="corsi.businesscomponent.StudentBC"%>
<%@page import="corsi.businesscomponent.model.Student"%>
<%@page import="corsi.businesscomponent.facade.AdminFacade"%>
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
<title>Info Corsi Per Studente</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h2>Info Corsi Studente</h2>
		</header>
		
		<h4>Studente: 
			<%
			long id = Long.parseLong(request.getParameter("id"));
			StudentBC sBC = new StudentBC();
			Student s = sBC.getByCode(id);
			%>
			<%=s.getName()%>
		</h4>
		
		<div class="table-responsive">
			<table class="table table-hover">
			<thead>
				<tr>
					<th>Nome Corso</th>
					<th>Data Inizio</th>
					<th>Data Fine</th>
					<th>Aula</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Course> c = AdminFacade.getInstance().getCoursesByStudent();
					for (int i = 0; i < c.size(); i++) {
				%>
				<tr>
					<td style="vertical-align: middle;"><%=c.get(i).getCourseName()%></td>
					<td style="vertical-align: middle;"><%=c.get(i).getStartDate()%></td>
					<td style="vertical-align: middle;"><%=c.get(i).getEndDate()%></td>
					<td style="vertical-align: middle;"><%=c.get(i).getCourseRoom()%></td>
				</tr>
			</tbody>
			</table>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>
<%
} else {
	response.sendRedirect("login.jsp");
}
%>