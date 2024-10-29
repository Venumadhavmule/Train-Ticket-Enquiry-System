package com.AdminServlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.AdminDao;
import com.dao.TrainDao;
import com.dao.UserDao;
import com.model.TrainBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "addTrain", urlPatterns = { "/addTrain" })
public class AddTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int tno = Integer.parseInt(request.getParameter("trainno"));
		String tname = request.getParameter("trainname");
		String from  = request.getParameter("from");
		String to = request.getParameter("to");
		
		TrainBean train = new TrainBean(tno,tname,from,to);
		
		int count = TrainDao.addTrain(train);
		if (count==0) {
            pw.println("<h2>Train not updated! Please try again to add...</h2>");
            response.setHeader("Refresh", "2; URL=AAddTrain.html");
        } else {
            pw.println("<h2>Train updated successfully! Redirecting to Home Page...</h2>");
            response.setHeader("Refresh", "2; URL=AHome.html");
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
