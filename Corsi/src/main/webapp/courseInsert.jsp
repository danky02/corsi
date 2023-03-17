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
</head>
<body>

	<jsp:include page="navbar.jsp"/>
	<div class="container">
	<h1>Inserimento corso</h1>
	<form action="processa_dati.jsp" method="post">
		<label for="nome_corso">Nome del corso:</label>
		<input type="text" name="nome_corso" id="nome_corso"><br><br>
		<label for="inizio_corso">Inizio del corso:</label>
		<input type="date" name="inizio_corso" id="inizio_corso"><br><br>
		<label for="fine_corso">Fine del corso:</label>
		<input type="date" name="fine_corso" id="fine_corso"><br><br>
		<label for="costo_corso">Costo del corso:</label>
		<input type="number" name="costo_corso" id="costo_corso"><br><br>
		<label for="commenti_corso">Commenti:</label><br>
		<textarea name="commenti_corso" id="commenti_corso" rows="5" cols="50"></textarea><br><br>
		<label for="stanze_corso">Stanze:</label><br>
		<input type="checkbox" name="stanze_corso" id="stanza_1" value="Stanza 1"><label for="<%
					List<Course> c = AdminFacade.getInstance().getAllCourses();
					for (int i = 0; i < c.size(); i++) {
					%>">Stanza 1</label><br>/>
		<input type="submit" value="Inserisci corso">
	</form>
	</div>
</body>
</html>
<%
					}
}else{
response.sendRedirect("login.jsp");
}%>