<%@page import="com.model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="User.css">
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies
	
	if (session.getAttribute("username") == null) {
		response.sendRedirect("Login.html");
		return;
	}
	UserBean user = (UserBean) session.getAttribute("aUser");
	%>
	<header>
        <div class="hdt">
            <div class="hd">
                <img class="logo" src="railLogo.png" alt="Rail Logo" width="150px" height="200px">
                <h1>Train Ticket Booking Spot</h1>
            </div>
        </div>
    </header>
    <br>
    <form action="logout">
        <div class="navv ">
            <a href="UHome.jsp" title="Home">Home</a>
            <a href="/Train-Ticket-Reservation/alltrains" title="Available Trains">Available Trains</a>
            <a href="UFareEnquiry.jsp" title="Fare Enquiry">Fare Enquiry</a>
            <a href="UGallery.jsp" title="Gallery">Gallery</a>
            <a href="UContactUs.jsp" title="Contact Us">Contact Us</a>
            <a href="UProfile.jsp" title="Profile">Profile</a>
            <button type="submit" title="Logout">Logout</button>
        </div>
    </form><br>
    <div class="credd-extension" style="background-color: #FFFAE6;padding: 10px">
        <div class="profile-data">
            <h1><%= user.getFirstName() %>👋👋</h1>
            <table class="vertical-table">
        <tr>
            <th>First Name</th>
            <td><%= user.getFirstName() %></td>
        </tr>
        <tr>
            <th>Last Name</th>
            <td><%= user.getLastName() %></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><%= user.getPhone() %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= user.getEmail() %></td>
        </tr>
        <tr>
            <th>Username</th>
            <td> <%= user.getUsername() %></td>
        </tr>
        <tr>
            <th>Password</th>
            <td>•••••••</td>
        </tr>
    </table><br>
            <a href="UUpdate.jsp">
              <button type="button">Update</button>
            </a>
        </div>
    </div>
</body>
</html>