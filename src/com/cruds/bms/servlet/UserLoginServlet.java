package com.cruds.bms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.bms.entity.User;
import com.cruds.bms.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("MESSAGE");
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		
		session.setAttribute("USERNAME", userName);
		RequestDispatcher rd = null;
		
		User user = UserService.authenticate(userName, pwd);
		
		if (user !=null)
		{
			session.setAttribute("USER", user);
			rd = request.getRequestDispatcher("home.jsp");
		}
		else
		{
			session.setAttribute("ERROR", "Invalid User Credentials");
			rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		}
		rd.forward(request, response);
		
	}

}
