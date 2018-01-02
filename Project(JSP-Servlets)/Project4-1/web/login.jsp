<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>

<% HttpSession Session = request.getSession(true);
   Session.invalidate();   
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Student registration page">
<meta name="author" content="Login form">
<title>Login form</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link href="css/mystyle.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


	<div class="container theme-showcase" role="main">

<% if(request.getAttribute("message") != null) { %>		
	<div class="alert alert-danger text-center" role="alert"><%=(String)request.getAttribute("message") %></div>
<% } %>

		<form class="form-signin" method="post" action="login">
			<h2 class="form-signin-heading">Είσοδος</h2>
			<label for="inputusername" class="sr-only">Email address</label> 
			<input type="text" name="username" id="inputusername" class="form-control" placeholder="username" required>
			<label for="inputpassword" class="sr-only">Password</label>
			<input name="password" type="password" id="inputpassword" class="form-control" placeholder="password" required>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form>

	</div>
	<!-- /container -->

	<%@ include file="footer.jsp"  %>
	
</body>
</html>
