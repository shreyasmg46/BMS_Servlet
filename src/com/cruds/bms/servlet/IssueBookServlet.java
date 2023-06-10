package com.cruds.bms.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.bms.entity.Issue;
import com.cruds.bms.entity.Student;
import com.cruds.bms.service.IssueService;

/**
 * Servlet implementation class IssueBookServlet
 */
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IssueBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Issue> list = IssueService.getIssuedBooks();
		request.setAttribute("ISSUEBOOKS", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/issuebook.jsp");
		rd.forward(request, response);	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		request.removeAttribute("MESSAGE");
		
		String action = request.getParameter("ACTION");
		
	//if i use action.equals("CREATE") ==> nullpointer	
		if("CREATEISSUE".equals(action))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			Date date = new Date();
			System.out.println(formatter.format(date));
			
			String issueISBN = request.getParameter("ISBN");
			String issueUSN = request.getParameter("usn");
			
			if(IssueService.issueBook(new Student(issueUSN), date, issueISBN))
			{
				session.setAttribute("MESSAGE", "Book Issued successfully");
			}
			else
			{
				session.setAttribute("MESSAGE", "Error");
			}

		
		
/*		if("SEARCH".equals(action))
		{
			String searchISBN = request.getParameter("ISBN");
			if(BookService.getISBN((searchISBN)) != null)
			{
				session.setAttribute("MESSAGE", "Book found");
			}
			else
			{
				session.setAttribute("MESSAGE", "error while searching");
			}
		}
		else if("SEARCHUSN".equals(action))
		{
			String searchUSN = request.getParameter("usn");
		//	List<Student> list = (List<Student>) session.getAttribute("STUDENTLIST");
			if(BookService.getStudentUsn(searchUSN) != null)
			{
				session.setAttribute("MESSAGE", "Student found");
			}
			else
			{
				session.setAttribute("MESSAGE", "error while searching");
			}
		}
		else if("ISSUE".equals(action))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			Date date = new Date();
			System.out.println(formatter.format(date));
			
			String issueISBN = request.getParameter("ISBN");
			String issueUSN = request.getParameter("usn");
			
		//	List<Book> list = (List<Book>) session.getAttribute("isbn");
			
			List<Issue> issue = IssueService.listBooks(issueUSN);
			request.setAttribute("ISSUE", issue);
						
			if(IssueService.issueBook(new Student(issueUSN), date, issueISBN))
			{
				session.setAttribute("MESSAGE", "Book Issued successfully");
			}
			else
			{
				session.setAttribute("MESSAGE", "error while Issueing");
			}
			
*/		}

		response.sendRedirect("/bms-servlet/IssueBookServlet");
	}	

}
