<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>

<% HttpSession Session = request.getSession(true);

   if (Session.getAttribute("loginUserName") == null) {
        RequestDispatcher loginFirst = request.getRequestDispatcher("/login.jsp");
        request.setAttribute("message", "You need to login first in order to access application's interfaces.");
        loginFirst.forward(request, response);
    }

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
        <meta name="author" content="sofos@aueb.gr">    
        <title>Log Out</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
        <!-- Custom styles for this template -->
        <link href="css/mystyle.css" rel="stylesheet">  

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <%@ include file="navigation_menu.jsp"  %>

        <div class="container theme-showcase" role="main">

            <div class="alert alert-success" role="alert">
                <p class="text-center">You logged out successfully!!!</p>
            </div>

        </div> <!-- /container -->

        <%@ include file="footer.jsp"  %>

    </body>
</html>    