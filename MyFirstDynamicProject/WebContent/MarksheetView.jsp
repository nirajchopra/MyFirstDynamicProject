<%@page import="com.rays.bean.MarksheetBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marksheet Form</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="MarksheetCtl" method="post">
		<%
			String msg = (String) request.getAttribute("msg");
			MarksheetBean bean = (MarksheetBean) request.getAttribute("bean");
		%>

		<h2><%=(bean != null) ? "Update Marksheet" : "Add Marksheet"%></h2>

		<%
			if (msg != null) {
		%>
		<p style="color: green; text-align: center;"><%=msg%></p>
		<%
			}
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
					placeholder="Enter First Name" required></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastName"
					value="<%=(bean != null) ? bean.getLastName() : ""%>"
					placeholder="Enter Last Name" required></td>
			</tr>
			<tr>
				<th>Roll No</th>
				<td><input type="text" name="rollNo"
					value="<%=(bean != null) ? bean.getRollNo() : ""%>"
					placeholder="Enter Roll No" required></td>
			</tr>
			<tr>
				<th>Physics</th>
				<td><input type="text" name="physics"
					value="<%=(bean != null) ? bean.getPhysics() : ""%>"
					placeholder="Enter Physics Marks" required></td>
			</tr>
			<tr>
				<th>Chemistry</th>
				<td><input type="text" name="chemistry"
					value="<%=(bean != null) ? bean.getChemistry() : ""%>"
					placeholder="Enter Chemistry Marks" required></td>
			</tr>
			<tr>
				<th>Maths</th>
				<td><input type="text" name="maths"
					value="<%=(bean != null) ? bean.getMaths() : ""%>"
					placeholder="Enter Maths Marks" required></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" name="operation"
					value="<%=(bean != null) ? "update" : "save"%>"></td>
			</tr>
		</table>
	</form>
</body>
</html>
