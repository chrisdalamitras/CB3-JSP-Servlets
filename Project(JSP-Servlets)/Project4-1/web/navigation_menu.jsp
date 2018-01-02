<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="register.jsp">HOME PAGE</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li
					class="<%= (request.getRequestURI().replace(request.getContextPath() + "/","").equals("register.jsp") ? "active":"") %>"><a
					href="register.jsp">Register</a></li>
				<li
					class="<%= (request.getRequestURI().replace(request.getContextPath() + "/","").equals("viewstudents.jsp") ? "active":"") %>"><a
					href="viewstudents.jsp">View</a></li>
				<li
					class="<%= (request.getRequestURI().replace(request.getContextPath() + "/","").equals("findstudent.jsp") ? "active":"") %>"><a
					href="findstudent.jsp">Find</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li
					class="<%= (request.getRequestURI().replace(request.getContextPath() + "/","").equals("logout.jsp") ? "active":"") %>"><a
					href="logout.jsp"><span class="glyphicon glyphicon-user"></span>
						Logout</a></li>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>
        
</nav>