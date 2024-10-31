package com.UserServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.TrainDao;
import com.model.TrainBean;
import com.utility.FareCalculator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "fareEnq", urlPatterns = { "/fareEnq" })
public class FareEnquiryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String coach = request.getParameter("coach");
		int age = Integer.parseInt(request.getParameter("age"));
		int numPassengers = Integer.parseInt(request.getParameter("passengers"));
		
		
		
		if(!from.equals(to)) {
			TrainBean availableTrain = TrainDao.getFromToTrain(from, to);
			if(availableTrain!=null) {
				double fare = FareCalculator.calculateFare(coach,age,numPassengers,20);

				System.out.println("fare: "+fare);
				request.setAttribute("fare", fare);
				RequestDispatcher dispatcher = request.getRequestDispatcher("FareView.jsp");
				dispatcher.forward(request, response);
			}else {
				pw.println("<h2 style=\"color:red\">No trains available between the selected Stations.</h2>");

			    response.setHeader("Refresh", "2; URL=UFareEnquiry.jsp");
//			    return;
			}
			
		}else {
			pw.print("You need to select different \"From\" and \"To\" stations");
			response.setHeader("Refresh", "2; URL=UFareEnquiry.jsp");
			
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
	}
}
