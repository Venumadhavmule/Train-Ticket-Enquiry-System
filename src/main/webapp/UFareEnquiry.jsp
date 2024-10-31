<%@page import="com.model.StationBean"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fare Enquiry</title>
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

    List<StationBean> allStations = (List<StationBean>) session.getAttribute("allStations");
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
        <div class="navv">
            <a href="UHome.jsp" title="Home">Home</a>
            <a href="/Train-Ticket-Reservation/alltrains" title="Available Trains">Available Trains</a>
            <a href="UFareEnquiry.jsp" title="Fare Enquiry">Fare Enquiry</a>
            <a href="UGallery.jsp" title="Gallery">Gallery</a>
            <a href="UContactUs.jsp" title="Contact Us">Contact Us</a>
            <a href="UProfile.jsp" title="Profile">Profile</a>
            <button type="submit" title="Logout">Logout</button>
        </div>
    </form>
    <br>
    
    <form action="fareEnq" class="fare-enquiry-form">
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
        <label for="coach">Select Coach</label>
        <select id="coach" name="coach" required>
            <option value="Ac">AC</option>
            <option value="Sleeper">Sleeper</option>
            <option value="General">General</option>
        </select>
        
        <label for="age">Age:</label>
        <input type="number" min="0" max="99" name="age" required id="age">
             
        <label for="passengers">No of Passengers:</label>
        <select id="passengers" name="passengers" required>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
            <option value="4">Four</option>
            <option value="5">Five</option>
            <option value="6">Six</option>
        </select>
        
        <button type="submit">Get Fare 🔃</button>
    </form>
</body>
</html>
