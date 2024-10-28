<%@page import="com.model.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
<link rel="stylesheet" href="Admin.css">
<style type="text/css">
h2 {
    color: #cc0066;
    font-size: 24px;
    font-weight: bold;
    text-align: center;
    margin-top: 20px;
    margin-bottom: 15px;
    background-color: rgba(255, 255, 204, 0.8);
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    width: 50%;
    max-width: 400px;
    margin-left: auto;
    margin-right: auto;
}

table {
    width: 67%;
    margin: 30px auto;
    border-collapse: collapse;
    background-color: #F9F9F9;
    border-radius: 12px;
    overflow: hidden;
    font-size: 14px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 12px 15px;
    text-align: left;
    color: #4B4B4B;
    border-bottom: 1px solid #E3E3E3;
}

th {
    background-color: #3A8FB7;
    color: #FFFFFF;
    font-weight: bold;
    font-size: 16px;
}

tbody tr:nth-child(even) {
    background-color: #EDF2F4;
}

tbody tr:hover {
    background-color: #D3E1E8;
    cursor: pointer;
}

tbody tr:last-child td {
    border-bottom: none;
}

</style>
</head>
<body>
	<header>
		<div class="hdt">
			<div class="hd">
				<img class="logo" src="railLogo.png" alt="Rail Logo" width="150px"
					height="200px">
				<h1>Train Ticket Booking Spot</h1>
			</div>
		</div>
	</header>
	<br>
	<form action="logout">
		<div class="navv ">
			<a href="AHome.html" title="Home">Home</a> <a href="AAddTrain.html"
				title="Add train">Add Train</a> <a
				href="/Train-Ticket-Reservation/usersList" title="View All Users">View
				All Users</a> <a href="AUpdateUser.html" title="Update User">Update
				User</a> <a href="ADeleteUser.html" title="Delete User">Delete User</a>
			<a href="AAddAdmin.html" title="Add Admin">Add Admin</a> <a
				href="AContactUs.html" title="Contact Us">Contact Us</a>
			<button type="submit" title="logout">Logout</button>
		</div>
	</form>
	<h2>All Users Data</h2>
	<table class="styled-table">
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