<%@page import="java.text.SimpleDateFormat"%>
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
				long id = Long.parseLong(request.getParameter("code"));
				StudentBC sBC = new StudentBC();
				Student s = sBC.getByCode(id);
			%>
			<%=s.getName()%> <%=s.getSurname()%>
		</h4>
		
		<div class="table-responsive">
			<table class="table table-hover">
			<thead>
				<tr>
					<th>Nome Corso</th>
					<th>Data Inizio</th>
					<th>Data Fine</th>
					<th>Aula</th>
					<th style="width: 50px"></th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Course> courses = AdminFacade.getInstance().getCoursesByStudent(s);
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					for (Course c : courses) {
						String code = c.getCourseCode() + "";
				%>
				<tr>
					<td style="vertical-align: middle;"><%=c.getCourseName()%></td>
					<td style="vertical-align: middle;"><%=formatter.format(c.getStartDate())%></td>
					<td style="vertical-align: middle;"><%=formatter.format(c.getEndDate())%></td>
					<td style="vertical-align: middle;"><%=c.getCourseRoom()%></td>
					<td>
						<form action="courseSubscription" method="POST">
							<input type="hidden" name="_method" value="UNSUBSCRIBE" />
							
							<input type="hidden" name="student" value="<%= s.getCode() %>">
							<input type="hidden" name="course" value="<%= c.getCourseCode() %>">
							
							<input type="submit" value="Annulla Iscrizione">
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
			</table>
		</div>
		<div style="margin-top: 100px">
			<form action="courseSubscription" method="POST">
				<input type="hidden" name="_method" value="SUBSCRIBE" />
				
				<input type="hidden" name="student" value="<%= s.getCode() %>">
				<select name="course">
				<% 
				List<Course> availableCourses = AdminFacade.getInstance().getFreeCoursesByStudent(s);
				for(Course availableCourse : availableCourses) {
				%>
					<option value="<%=availableCourse.getCourseCode() %>"><%=availableCourse.getCourseName() %></option>
				<%
				} %>
				</select>
				
				<input type="submit" value="Iscrizione">
			</form>
		</div>
	</div>
</body>
</html>
<%
} else {
	response.sendRedirect("login.jsp");
}
%>