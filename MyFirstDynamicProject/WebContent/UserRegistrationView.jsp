<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">
	<center>
		<form action="UserRegistrationCtl" method="post">
			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<%
				if (msg != null) {
			%>
			<%=msg%>
			<%
				}
			%>
			<h1 align="center">SignUp</h1>
			<table>
				<tr>

					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="Enter FName"></td>

				</tr>
				<tr>

					<th>Last Name</th>
					<td><input type="text" name="lastName"
						placeholder="Enter LName"></td>

				</tr>
				<tr>

					<th>LoginId</th>
					<td><input type="text" name="email" placeholder="Enter Email"></td>

				</tr>
				<tr>

					<th>Password</th>
					<td><input type="password" name="password"
						placeholder="Enter Password"></td>

				</tr>
				<tr>

					<th>Address</th>
					<td><input type="text" name="address"
						placeholder="Enter address"></td>

				</tr>
				<tr>

					<th></th>
					<td><input type="submit" name="operation" value="save"></td>

				</tr>
			</table>

		</form>
	</center>

</body>
</html>