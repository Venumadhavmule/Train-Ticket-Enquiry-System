package com.AdminServlets;

import java.io.IOException;

import com.dao.AdminDao;
import com.dao.TrainDao;
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
		int tno = Integer.parseInt(request.getParameter("trainno"));
		String tname = request.getParameter("trainname");
		String from  = request.getParameter("from");
		String to = request.getParameter("to");
		
		TrainBean train = new TrainBean(tno,tname,from,to);
		
		int count = TrainDao.addTrain(train);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
