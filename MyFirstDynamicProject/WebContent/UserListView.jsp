<%@page import="com.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	<form action="UserListCtl" method="post">

		<%
			int pageNo = (int) request.getAttribute("pageNo");
			int index = ((pageNo - 1) * 5) + 1;

			List nextList = (List) request.getAttribute("nextList");

			List userList = (List) request.getAttribute("userList");
		%>

		<table border="1px" width="100%">

			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>LoginId</th>
				<th>password</th>
				<th>Address</th>
				<th>Action</th>
				<th>Next</th>
			</tr>
			<%
				Iterator<UserBean> it = userList.iterator();
				while (it.hasNext()) {
					UserBean bean = it.next();
			%>
			<tr align="center">
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getAddress()%></td>
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td style="text-align: right;"><input type="submit"
					name="operation" value="next"
					<%=(nextList.size() != 0) ? "" : "disabled"%>></td>
			</tr>
			<%
				}
			%>
			</tr>

		</table>
		<input type="submit" name="operation" value="Delete">
	</form>

</body>
</html>