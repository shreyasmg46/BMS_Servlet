package com.cruds.bms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.bms.entity.Issue;
import com.cruds.bms.service.IssueService;

/**
 * Servlet implementation class ListStudentBooks
 */
public class ListStudentBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudentBooks() {
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
		
		String usn = request.getParameter("usn");
		
		List<Issue> list = IssueService.listBooks(usn);
		request.setAttribute("STUDENTBOOKS", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/liststudentbooks.jsp");
		rd.forward(request, response);
		
	}

}
