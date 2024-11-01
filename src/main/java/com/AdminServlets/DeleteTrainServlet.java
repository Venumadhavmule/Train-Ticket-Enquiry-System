package com.AdminServlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.TrainDao;
import com.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "deleteTrain", urlPatterns = { "/deleteTrain" })
public class DeleteTrainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		int trainno = (Integer.parseInt(request.getParameter("trainno")));
		boolean result = TrainDao.deleteTrain(trainno);
		if (!result) {
            pw.println("<h2>Train not found! Please try again with a exist train No.</h2>");
            response.setHeader("Refresh", "2; URL=ADeleteTrain.html");
        } else {
            pw.println("<h2>Train deleted successfully! Redirecting to available Trains...</h2>");
            response.setHeader("Refresh", "2; URL=/Train-Ticket-Reservation/aalltrains");
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
