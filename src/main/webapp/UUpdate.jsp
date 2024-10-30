<%@page import="com.model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update details</title>
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
    </form>
    <div class="credd-extension">
        <form action="uProfileUp" method="post">
            <h1><span><u>Update</u> <u>Details</u></span></h1>

            <label for="firstname">First Name</label><br>
            <input type="text" id="firstname" name="firstname" title="firstname"  value="<%= user.getFirstName() %>" required><br><br>

            <label for="lastname">Last Name</label><br>
            <input type="text" id="lastname" name="lastname" title="lastname" value="<%= user.getLastName() %>" required><br><br>

            <label for="phone">Phone</label><br>
            <input type="tel" id="phone" name="phone" title="phone" value="<%= user.getPhone() %>" required><br><br>

            <label for="email">Email</label><br>
            <input type="email" id="email" name="email" title="email" value="<%= user.getEmail() %>" required><br><br>

            <label for="username">Username</label><br>
            <input type="text" id="username" name="username" title="username"  value="<%= user.getUsername() %>" required><br><br>

            <label for="password">Password</label><br>
            <input type="password" id="password" name="password" title="password" value="<%= user.getPassword()%>" required><br><br>

            <button type="submit">Update</button>
        </form>
    </div>
</body>
</html>