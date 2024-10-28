<%@page import="com.model.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<h2>All Users Data</h2>
	<table>
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		<%
            List<com.model.UserBean> users = (List<com.model.UserBean>) request.getAttribute("users");
            if (users != null && !users.isEmpty()) {
                for (UserBean user : users) {
        %>
		<tr>
			<td><%= user.getFirstName() %></td>
			<td><%= user.getLastName() %></td>
			<td><%= user.getPhone() %></td>
			<td><%= user.getEmail() %></td>
			<td><%= user.getUsername() %></td>
			<td><%= user.getPassword() %></td>
		</tr>
		<%
                }
            } else {
        %>
		<tr>
			<td colspan="6">No users found</td>
		</tr>
		<% } %>
	</table>
</body>
</html>