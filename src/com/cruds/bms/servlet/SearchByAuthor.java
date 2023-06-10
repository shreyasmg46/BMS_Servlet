package com.cruds.bms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.bms.entity.Book;
import com.cruds.bms.service.BookService;

/**
 * Servlet implementation class SearchByAuthor
 */
public class SearchByAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByAuthor() {
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
		String authorname = request.getParameter("authorname");
		
		List<Book> b = BookService.getAuth(authorname);
		
		session.setAttribute("AUTHORNAME", b);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/searchAuthor.jsp");
		rd.forward(request, response);
	}

}
