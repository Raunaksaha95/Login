package com.studentapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentapp.model.DAOservice;
import com.studentapp.model.DAOserviceimpl;
@WebServlet("/new")
public class NewRagistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewRagistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String city=request.getParameter("city");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile");
	
	DAOservice service=new DAOserviceimpl();
	service.connectDB();
	
	service.saveRagistration(name,city,email,mobile);
	
	request.setAttribute("msg", "Record is save");
	
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_ragistration.jsp");
	rd.forward(request, response);
	

	
	
	}

}
