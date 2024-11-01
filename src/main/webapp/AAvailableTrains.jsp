<%@page import="com.model.TrainBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Trains</title>
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
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies
	
	if (session.getAttribute("username") == null) {
		response.sendRedirect("Admin.html");
		return;
	}
	%>
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
	<form action="aLogout">
        <div class="navv ">
            <a href="AHome.jsp" title="Home">Home</a>
            <a href="AAddTrain.jsp" title="Add train">Add Train</a>
            <a href="/Train-Ticket-Reservation/usersList" title="View All Users">View All Users</a>
            <a href="AUpdateUser.jsp" title="Update User">Update User</a>
            <a href="ADeleteUser.jsp" title="Delete User">Delete User</a>
            <a href="AAddAdmin.jsp" title="Add Admin">Add Admin</a>
            <a href="AContactUs.jsp" title="Contact Us">Contact Us</a>
            <button type="submit" title="logout">Logout</button>
        </div>
    </form>
	<h2>Available Trains</h2>
	<table class="styled-table">
		<tr>
			<th>Train no</th>
			<th>Train name</th>
			<th>From</th>
			<th>To</th>
			<th>Km</th>
		</tr>
		<%
		List<TrainBean> trains = (List<TrainBean>) request.getAttribute("trains");
		if (trains != null && !trains.isEmpty()) {
			for (TrainBean train : trains) {
		%>
		<tr>
			<td><%=train.getTrainNo()%></td>
			<td><%=train.getTrainName()%></td>
			<td><%=train.getTrainFrom()%></td>
			<td><%=train.getTrainTo()%></td>
			<td><%=train.getKm()%>Km</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="6">There is no available trains</td>
		</tr>
		<%
		}
		%>
	</table>
	<div class="button-container">
	<button type="submit"  onclick="location.href='AAddTrain.jsp'" style="background-color: green" >Add Train</button>
	<button type="submit"  onclick="location.href='ADeleteTrain.html'" style="background-color: red"  >Delete Train</button>
	</div>
</body>
</html>