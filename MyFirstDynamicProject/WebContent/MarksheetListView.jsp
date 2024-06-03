<%@ page import="com.rays.bean.MarksheetBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marksheet List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="MarksheetListCtl.do" method="post">
		<h2 style="color: darkblue" align="center">Marksheet List</h2>
		<%
			List<MarksheetBean> userList = (List<MarksheetBean>) request.getAttribute("userList");
			String msg = (String) request.getAttribute("msg");
		%>
		<%
			if (msg != null) {
		%>
		<p class="center" style="color: green;"><%=msg%></p>
		<%
			}
		%>
		<center>
			<table>
				<tr>
					<td><label for="firstName">First Name:</label> <input
						type="text" name="firstName" placeholder="Enter First Name">
					</td>
					<td><input type="submit" name="operation" value="search">
					</td>
				</tr>
			</table>
		</center>
		<br>
		<table border="1" align="center">
			<tr>
				<th>Select</th>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Roll No</th>
				<th>Physics</th>
				<th>Chemistry</th>
				<th>Maths</th>
				<th>Edit</th>
			</tr>
			<%
				if (userList != null) {
					Iterator<MarksheetBean> it = userList.iterator();
					while (it.hasNext()) {
						MarksheetBean bean = it.next();
			%>
			<tr>
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getRollNo()%></td>
				<td><%=bean.getPhysics()%></td>
				<td><%=bean.getChemistry()%></td>
				<td><%=bean.getMaths()%></td>
				<td><a href="MarksheetCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
				} else {
			%>
			<tr>
				<td colspan="9" class="center">No users found.</td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<center>
			<input type="submit" name="operation" value="delete">
		</center>
	</form>
</body>
</html>
