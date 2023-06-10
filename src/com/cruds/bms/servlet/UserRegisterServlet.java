package com.cruds.bms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.bms.entity.User;
import com.cruds.bms.service.UserService;

/**
 * Servlet implementation class UserRegisterServlet
 */
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/user.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = "";
		String password = "";
		String phoneNo = "";
		String email = "";
		String role = "";
		
		userName = (String) request.getParameter("userName");
		password = (String) request.getParameter("pwd");
		phoneNo = (String) request.getParameter("phoneNo");
		email = (String) request.getParameter("email");
		role = (String) request.getParameter("role");
		
		UserService.addUser(new User(userName, password, phoneNo, email,"U"));
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
		rd.forward(request, response);
	}

}
