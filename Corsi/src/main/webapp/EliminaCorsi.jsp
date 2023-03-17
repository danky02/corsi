<%
	if(session.getAttribute("username") == null){
		response.sendRedirect("error403.jsp");
	}
%>
<%@page import="corsi.businesscomponent.CourseBC"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="corsi.businesscomponent.model.Course" %>
<%
CourseBC cBC = new CourseBC();
Date today = new Date();
List<Course> courses = cBC.getAll();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<%@ include file="CDN.html" %>
        <meta charset="UTF-8">
		<link rel="stylesheet" href="css/style.css">
        <title>RiepilogoCorsi</title>
    </head>
    <body>
    <jsp:include page="navbar.jsp" />
    <div class="container">
        <h2>Elimina Corsi</h2>

    <% if (!courses.isEmpty()) { %>
		<div class="container">
			<header class="page-header">
        		<h4>Corsi disponibili con data maggiore alla data odierna:</h4>
			</header>
		</div>
		<div class="form-group">
        <form action="/<%=application.getServletContextName()%>/rimuoviCorsi" method="post">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nome Corso</th>
                        <th>Data Inizio</th>
                        <th>Cancella</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Course course : courses) { %>
                        <% if (course.getStartDate().after(today)) { %>
                            <tr>
                                <td><%= course.getCourseName() %></td>
                                <td><%= course.getStartDate()%></td>
                                <td><button type="submit" name="coursecode" value="<%= course.getCourseCode() %>">&times;</button></td>
                            </tr>
                        <% } %>
                    <% } %>
                </tbody>
            </table>
        </form>
       </div>

    <% } else { %>

        <p>Nessun corso disponibile.</p>

    <% 
    
    } 
      %>
</div>
</body>
</html>