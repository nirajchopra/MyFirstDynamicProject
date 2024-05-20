<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserRegistrationCtl" method = "post"></form>

	<table>

		<tr>
			<th>First Name :</th>
			<td><input type="text" name="firstName"
				placeholder="Enetr FistName"></td>
		</tr>
		<tr>
			<th>Last Name :</th>
			<td><input type="text" name="lastName"
				placeholder="Enetr LastName"></td>
		</tr>
		<tr>
			<th>LoginID :</th>
			<td><input type="text" name="loginId"
				placeholder="Enetr LoginId"></td>
		</tr>
		<tr>
			<th>Password :</th>
			<td><input type="password" name="password"
				placeholder="Enetr Password"></td>
		</tr>
		<tr>
			<th>Address :</th>
			<td><input type="text" name="address"
				placeholder="Enetr Address"></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" value="save"></td>
		</tr>


	</table>

</body>
</html>