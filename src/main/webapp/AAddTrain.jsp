<%@page import="com.model.StationBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Train</title>
<link rel="stylesheet" href="Admin.css">
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies

	if (session.getAttribute("username") == null) {
		response.sendRedirect("Admin.html");
	}
	List<StationBean> allStations = (List<StationBean>)session.getAttribute("allStations");
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
    
	
	<form action="addTrain" class="addTrainForm">
	    <h1><u>Add</u> <u>Train</u></h1>
	    
	    <label for="trainno">Train No</label>
        <input type="number" id="trainno" name="trainno" title="trainno" required>
            
        <label for="trainname">Train Name</label>
        <input type="text" id="trainname"  name="trainname" title="trainname" required>
        
        <label for="from">From:</label>
        <select id="from" name="from" required>
            <option value="" disabled selected>Select from</option>
            <%
            if (allStations != null) {
                for (StationBean station : allStations) {
            %>
                <option value="<%=station.getStation()%>"><%=station.getStation()%></option>
            <%
                }
            }
            %>
        </select>
        
        <label for="to">To:</label>
        <select id="to" name="to" required>
            <option value="" disabled selected>Select To</option>
            <%
            String selectedFromStation = request.getParameter("from");
            if (allStations != null) {
                for (StationBean station : allStations) {
                    if (selectedFromStation == null || !station.getStation().equals(selectedFromStation)) {
            %>
                <option value="<%=station.getStation()%>"><%=station.getStation()%></option>
            <%
                    }
                }
            }
            %>
        </select>
        
        <label for="km">Km</label>
        <input type="number" id="km" name="km" min="20" max="5000" required>
        <button type="submit">Add Train</button>
    </form>
</body>
</html>