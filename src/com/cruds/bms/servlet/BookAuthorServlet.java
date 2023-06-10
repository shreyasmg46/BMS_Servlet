package com.cruds.bms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.bms.entity.Author;
import com.cruds.bms.entity.Book;
import com.cruds.bms.service.BookService;

/**
 * Servlet implementation class BookAuthorServlet
 */
public class BookAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> listbook = BookService.getAll();
		request.setAttribute("BOOKLIST", listbook);
		
		List<Author> listAuthor = BookService.getAuthorDetails();
		request.setAttribute("AUTHORLIST", listAuthor);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/book.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("MESSAGE");

		String action = request.getParameter("ACTION");

		if("CREATE".equals(action))
		{
			String ISBN = request.getParameter("ISBN");
			String title = request.getParameter("title");
			String category = request.getParameter("category");
		//	String NoOfBooks = request.getParameter("noOfBooks");
			int NoOfBooks = Integer.parseInt(request.getParameter("NoOfBooks"));
			
			String authorname = request.getParameter("authorname");
			String mailId = request.getParameter("mailId");

			session.setAttribute("isbn", ISBN);
			Author a = new Author(authorname, mailId);
			//System.out.println(bId);
			//System.out.println(bName);
			
			Book b = new Book(ISBN,title, category,NoOfBooks,a);
			
			System.out.println(b);
			if(BookService.create(b))
//			if(BookService.create(new Book(Integer.parseInt(ISBN),title, category,Integer.parseInt(NoOfBooks),a)))
			{
				session.setAttribute("MESSAGE", "Book created");
			}
			else
			{
				session.setAttribute("MESSAGE", "error while creating");
			}
		}
		else if("DELETE".equals(action))
		{
			String delISBN = request.getParameter("delISBN");
			System.out.println(delISBN + "deleted");
			if(BookService.delete(delISBN))
			{
				session.setAttribute("MESSAGE", "Book deleted successfully");
			}
		}
		else if("DELETEBOOK".equals(action))
		{
			String delISBN = request.getParameter("delISBN");
			System.out.println(delISBN + "deleted");
			if(BookService.deleteBook(delISBN))
			{
				session.setAttribute("MESSAGE", "Book deleted successfully");
			}
		}

/*		else if("UPDATE".equals(action))
		{
			String ISBN = request.getParameter("ISBN");
			String title = request.getParameter("title");
			System.out.println("Action is updated to "+ title);
			if(BookService.update(new Book(Integer.parseInt(ISBN), title)));
			{
				session.setAttribute("MESSAGE", "Book updated successfully");
			}
		}

*/		
		response.sendRedirect(request.getContextPath() + "/BookAuthorServlet");
	}	
	
	

}
