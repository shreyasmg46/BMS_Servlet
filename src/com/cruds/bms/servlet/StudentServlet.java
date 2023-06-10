package com.cruds.bms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.bms.entity.Student;
import com.cruds.bms.service.BookService;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		List<Student> list = BookService.getStudentData();
		session.setAttribute("STUDENTLIST", list);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/student.jsp");
		rd.forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String usn = request.getParameter("usn");
		String name = request.getParameter("name");	

		if(BookService.create(new Student(usn, name)))
		{
			session.setAttribute("MESSAGE", "Book created");
		}
		else
		{
			session.setAttribute("MESSAGE", "error while creating");
		}

		response.sendRedirect("/bms-servlet/StudentServlet");

	}

}
