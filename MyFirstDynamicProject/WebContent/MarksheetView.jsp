<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="MarksheetCtl.do" method="post">
<%
			String msg = (String) request.getAttribute("msg");
			UserBean bean = (UserBean) request.getAttribute("bean");
		%>
		<%
			if (bean != null) {
		%>
		<h2 style="color: darkblue" align="center">Update User</h2>
		<%
			} else {
		%>
		<h2 style="color: darkblue" align="center">Add User</h2>
		<%
			}
		%>

		<%
			if (msg != null) {
		%>

		<table>
			<tr>
				<td><input type="hidden" name="id"
					value="<%=(bean != null) ? bean.getId() : ""%>"></td>

			</tr>
			<tr>

				<th>First Name</th>
				<td><input type="text" name="firstName"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"
					placeholder="Enter FName"></td>

			</tr>
			<tr>

				<th>Last Name</th>
				<td><input type="text" name="lastName"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"
					placeholder="Enter LName"></td>

			</tr>
			<tr>

				<th>Roll No</th>
				<td><input type="text" name="rollNo"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"
					placeholder="Enter RollNo"></td>

			</tr>
			<tr>

				<th>Physics</th>
				<td><input type="text" name="physics"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"
					placeholder="Enter Pmarks"></td>

			</tr>
			<tr>

				<th>Chemistry</th>
				<td><input type="text" name="chemistry"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"
					placeholder="Enter Cmarks"></td>

			</tr>
			<tr>

				<th>Maths</th>
				<td><input type="text" name="maths"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"
					placeholder="Enter Mmarks"></td>

			</tr>
			<tr>

				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(bean != null)? "update" : "save"%>"></td>

			</tr>
		</table>
	</form>

</body>
</html>