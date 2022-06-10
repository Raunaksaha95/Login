package com.studentapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.studentapp.model.DAOservice;
import com.studentapp.model.DAOserviceimpl;
@WebServlet("/update")
public class UpdateRegestrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateRegestrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
		rd.forward(request, response);


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		DAOservice service =new DAOserviceimpl();
		service.connectDB();
		
		service.updateReg(email, mobile);
		
		ResultSet result=service.getAllReg();
		request.setAttribute("res", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_registration.jsp");
		rd.forward(request, response);
	
	}

}
