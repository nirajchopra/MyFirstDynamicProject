<%@ page import="com.rays.bean.MarksheetBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="MarksheetListCtl" method="post">
		<h2 style="color: darkblue" align="center">User List</h2>
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
		<table border="1">
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
				if (userList != null && !userList.isEmpty()) {
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
				<td><a href="MarksheetCtl?id=<%=bean.getId()%>">Edit</a></td>
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
