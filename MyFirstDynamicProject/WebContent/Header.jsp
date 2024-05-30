<%@ page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<style>
body {
	background-image: url('C:\Users\niraj\OneDrive\Pictures\background.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	height: 100vh;
	margin: 0;
}
</style>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body bgcolor="skyblue">

	<%
		UserBean user = (UserBean) session.getAttribute("user");
		String welcome = "Hii ";
	%>

	<div class="container" style="padding: 0px">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Niraj(Admin)</a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<%
						if (user != null) {
					%>
					<li class="nav-item"><span class="navbar-text"> <%=welcome + user.getFirstName()%>
					</span></li>
					<li class="nav-item"><a class="nav-link"
						href="LoginCtl?operation=logout">Logout</a></li>
					<li class="nav-item"><a class="nav-link" href="UserListCtl.do">User
							List</a></li>
					<li class="nav-item"><a class="nav-link" href="UserCtl.do">Add
							User</a></li>
					<li class="nav-item"><a class="nav-link" href="MarksheetCtl">Marksheet
							User</a></li>
					<li class="nav-item"><a class="nav-link"
						href="MarksheetListCtl">Marksheet List</a></li>
					<%
						} else {
					%>
					<li class="nav-item"><span class="navbar-text"> <%=welcome + "Guest"%>
					</span></li>
					<li class="nav-item"><a class="nav-link" href="LoginCtl">Login</a>
						|</li>
					<li class="nav-item"><a class="nav-link"
						href="UserRegistrationCtl">Sign Up</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</nav>
	</div>

	<hr>
</body>
</html>
