package com.cruds.bms.service;

import java.util.List;

import com.cruds.bms.db.BookDAO;
import com.cruds.bms.entity.Author;
import com.cruds.bms.entity.Book;
import com.cruds.bms.entity.Student;

public class BookService {
	
	public static List<Student> getStudentUsn(String usn)
	{
		BookDAO dao = new BookDAO();
		return dao.getStudentUsn(usn);
	}
	
	public static List<Book> getISBN(String ISBN )
	{
		BookDAO dao = new BookDAO();
		return dao.getISBN(ISBN);
	}
	
	public static List<Student> getStudentData()
	{
		BookDAO dao = new BookDAO();
		return dao.getStudentData();
	}
	
	public static boolean create(Student s)
	{
		BookDAO dao = new BookDAO();
		return dao.create(s);
	}

	public static List<Book> getTitle(String title)
	{
		BookDAO dao = new BookDAO();
		return dao.getTitle(title);
	}

	public static List<Book> getCategory(String category)
	{
		BookDAO dao = new BookDAO();
		return dao.getCategory(category);
	}
	
	public static List<Book> getAuth(String authorname)
	{
		BookDAO dao = new BookDAO();
		return dao.getAuthorname(authorname);
	}
	
	public static boolean update(Book b)
	{
		BookDAO dao = new BookDAO();
		return dao.update(b);
	}
	
	public static boolean delete(String ISBN)
	{
		BookDAO dao = new BookDAO();
		return dao.delete(ISBN);
	}
	
	public static boolean deleteBook(String ISBN)
	{
		BookDAO dao = new BookDAO();
		return dao.deleteBook(ISBN);
	}
	
	public static List<Book> getAll()
	{
		BookDAO dao = new BookDAO();
		return dao.getAll();
	}
	
	public static List<Author> getAuthorDetails()
	{
		BookDAO dao = new BookDAO();
		return dao.getAuthorDetails();
	}
	
	public static boolean create(Book b)
	{
		BookDAO dao = new BookDAO();
		return dao.create(b);
	}



}
