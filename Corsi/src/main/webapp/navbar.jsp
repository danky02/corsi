<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    	<div class="navbar-header">
		      	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mioMenu">
		        	<span class="icon-bar"></span>
		        	<span class="icon-bar"></span>
		        	<span class="icon-bar"></span>
		      	</button>
		      	<a class="navbar-brand" href="login.jsp">Admin Home</a>
		    </div>
		    <div class="collapse navbar-collapse" id="mioMenu">
		    	<%
		    		String username = (String) session.getAttribute("username");
		    		if(username == null) {
		    	%>
		    	<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="login.jsp">
						<span class="glyphicon glyphicon-log-in"></span>
						Login
						</a>
					</li>
		    	</ul>
		    	<%
		    		} else {
		    	%>
		    	<ul class="nav navbar-nav">
			        <li><a href="statistiche.jsp"><span class="glyphicon glyphicon-stats"></span>&nbsp;Statistiche</a></li>
					<li class="dropdown">
						<a href="#" class="btn btn-inverse dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-wrench"></span>&nbsp;Gestione&nbsp;<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="studentInsert.jsp">Inserisci Corsista</a>
							</li>
							<li>
								<a href="#" data-toggle="modal" data-target="#editModal_0">Gestione Corsi</a>
							</li>
						</ul>
					</li>
		        </ul>
	        	<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="profilo.jsp">
						<span class="glyphicon glyphicon-user"></span>
							<%= username %>
						</a>
					</li>
					<li>
						<a href="logout.jsp">
							<span class="glyphicon glyphicon-off"></span>&nbsp;Logout
						</a>
					</li>
			    </ul>
			    <%
		    		}
			    %>
		    </div>
	  </div>
</nav>
<%--<jsp:include page="editArticoloModal.jsp">
	<jsp:param value="0" name="id"/>
</jsp:include>--%>