<%@page import="com.model.StationBean"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fare View</title>
<link rel="stylesheet" href="User.css">
</head>
<body>
	<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("Login.html");
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

	<form action="logout">
		<div class="navv">
			<a href="UHome.jsp" title="Home">Home</a> <a
				href="/Train-Ticket-Reservation/alltrains" title="Available Trains">Available
				Trains</a> <a href="UFareEnquiry.jsp" title="Fare Enquiry">Fare
				Enquiry</a> <a href="UGallery.jsp" title="Gallery">Gallery</a> <a
				href="UContactUs.jsp" title="Contact Us">Contact Us</a> <a
				href="UProfile.jsp" title="Profile">Profile</a>
			<button type="submit" title="Logout">Logout</button>
		</div>
	</form>
	<br>
	<div class="credd-extension" style="background-color: #FFFAE6;padding: 10px">
        <div class="profile-data">
            <h1>Fare 💰💰</h1>
            <table class="vertical-table">
        <tr>
            <th>From</th>
            <td><%= request.getParameter("from") %></td>
        </tr>
        <tr>
            <th>To</th>
            <td><%= request.getParameter("to") %></td>
        </tr>
        <tr>
            <th>Coach</th>
            <td><%= request.getParameter("coach") %></td>
        </tr>
        <tr>
            <th>Age</th>
            <td><%= request.getParameter("age") %></td>
        </tr>
        <tr>
            <th>No of Passengers</th>
            <td> <%= request.getParameter("passengers") %></td>
        </tr>
        <tr>
            <th>Fare</th>
            <td style="color: red"><%= request.getAttribute("fare") %></td>
        </tr>
    </table><br>
            <a href="UFareEnquire.jsp">
              <button type="button">Enquire New</button>
            </a>
        </div>
    </div>
</body>
</html>
