<%@page import="corsi.businesscomponent.facade.AdminFacade"%>
<%@page import="corsi.businesscomponent.model.Admin"%>
<%
	if(session.getAttribute("username") != null) {
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="UTF-8">
<title>Profilo</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/validazione.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<%
		if(session.getAttribute("mod_field") != null) {
			
	%>
	<!-- Modal -->
	<div id="myModal" class="" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
		      <form method="POST" action="modificaCampo?mod_field=cancel">
		      	<button type="submit" class="close">&times;</button>
	    	  </form>
	        <h4 class="modal-title">Modifica Profilo</h4>
	      </div>
	      <div class="modal-body">
	        <p>Modifica <%= session.getAttribute("mod_field") %></p>
	        <form method="POST" action="aggiornaUtente" id="userForm">
			<div class="form-group">
				<div class="inputGroupContainer">
					<div class="input-group">
		        		<input type="<%=session.getAttribute("field_type")%>" placeholder="" name="<%=session.getAttribute("mod_field")%>" id="<%=session.getAttribute("mod_field")%>">
	        		</div>
	        	</div>
			<div id="info<%=((String)session.getAttribute("mod_field")).substring(0,1).toUpperCase() + ((String)session.getAttribute("mod_field")).substring(1)%>"></div>
	        </div>
	        <hr>
	        <button type="submit" class="btn btn-default" name="">Modifica <%= session.getAttribute("mod_field") %></button>
	        </form>
	      </div>
	    </div>
	
	  </div>
	</div>
	<%
		}
	%>
	<div class="container">
	
		<header class="page-header">
			<h3>Profilo Amministratore</h3>
		</header>
			<form method="POST" action="modificaCampo">
			<div class="table-responsive">
			<table class="table tabel-hover">
					<tr>
						<th>Nome</th>
						<th>Cognome</th>
					</tr>
				<tbody>
					<%
						Admin admin = AdminFacade.getInstance().getAdminByUsername((String)session.getAttribute("username"));
					%>
					<tr>
						<td><%= admin.getAdminName() %><button type="submit" style="margin-left: 10px;" name="mod_field" value="name"><i class="glyphicon glyphicon-pencil"></i></button></td>
						<td><%= admin.getAdminSurname() %><button type="submit" style="margin-left: 10px;" name="mod_field" value="surname"><i class="glyphicon glyphicon-pencil"></i></button></td>
					</tr>
				</tbody>
			</table>			
		</div>
		</form>
		<hr>
	</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>