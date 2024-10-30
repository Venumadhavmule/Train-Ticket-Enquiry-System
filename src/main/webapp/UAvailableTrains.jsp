<%@page import="com.model.TrainBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Trains</title>
<link rel="stylesheet" href="User.css">
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
            <a href="UHome.html" title="Home">Home</a>
            <a href="/Train-Ticket-Reservation/alltrains" title="Available Trains">Available Trains</a>
            <a href="UFareEnquiry.html" title="Fare Enquiry">Fare Enquiry</a>
            <a href="UGallery.html" title="Gallery">Gallery</a>
            <a href="UContactUs.html" title="Contact Us">Contact Us</a>
            <a href="UProfile.html" title="Profile">Profile</a>
            <button type="submit" title="Logout">Logout</button>
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
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="5">There is no available trains</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>