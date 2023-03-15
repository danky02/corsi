<%@page import="corsi.businesscomponent.model.Student"%>
<%@page import="java.util.List"%>
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
<title>Student List</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h2>Student Courses Registration</h2>
		</header>
		
		<h3>Student: </h3>
		
		<div class="table-responsive">
			<table class="table table-hover">
			<thead>
				<tr>
					<th>Student Name</th>
					<th>Student Surname</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Student> s = AdminFacade.getInstance().getAllStudents();
					for (int i = 0; i < s.size(); i++) {
				%>
				<tr>
					<td style="vertical-align: middle;"><%=s.get(i).getName()%></td>
					<td style="vertical-align: middle;"><%=s.get(i).getSurname()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<form style="float: right;"
			action="/<%=application.getServletContextName()%>/studentInsert.jsp"
			method="post">
			<button type="submit" class="btn btn-primary btn-xs">
				Add Student</button>
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