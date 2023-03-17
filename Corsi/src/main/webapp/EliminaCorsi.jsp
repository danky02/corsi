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
        <h1>Elimina Corsi</h1>

    <% if (!courses.isEmpty()) { %>
		<div class="container">
			<header class="page-header">
        		<h2>Corsi disponibili con data maggiore alla data odierna:</h2>
			</header>
		</div>
		<div class="form-group">
        <form action="/<%=application.getServletContextName()%>/rimuoviCorsi" method="post">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th></th>
                        <th>Nome corso</th>
                        <th>Data corso</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Course course : courses) { %>
                        <% if (course.getStartDate().after(today)) { %>
                            <tr>
                                <td style="vertical-align: middle;"><input type="checkbox" name="coursecode" value="<%= course.getCourseCode() %>"></td>
                                <td><%= course.getCourseName() %></td>
                                <td><%= course.getStartDate()%></td>
                            </tr>
                        <% } %>
                    <% } %>
                </tbody>
            </table>
            <br>
            <input type="submit" value="Elimina selezionati">
            
        </form>
       </div>

    <% } else { %>

        <p>Nessun corso disponibile.</p>

    <% 
    
    } 
      %>

</body>
</html>