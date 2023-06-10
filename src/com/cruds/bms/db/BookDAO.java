package com.cruds.bms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.bms.entity.Author;
import com.cruds.bms.entity.Book;
import com.cruds.bms.entity.Student;
import com.cruds.bms.exception.BMSException;


public class BookDAO {
	
	public List<Student> getStudentData()
	{
		String sql ="select usn ,name from student ";
		List<Student> list = new ArrayList<Student>();
		Student s = null;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs != null && rs.next())
			{
				s = new Student(rs.getString(1), rs.getString(2));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Student> getStudentUsn(String usn)
	{
		String sql ="select usn ,name from student where usn = ?";
		List<Student> list = new ArrayList<Student>();
		Student s = null;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,usn);
			ResultSet rs = ps.executeQuery();

			while(rs != null && rs.next())
			{
				s = new Student(rs.getString(1), rs.getString(2));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public boolean create(Student s)
	{
		String sql = "insert into student(Usn,name) values (?,?)";
		int rows = 0;	    	
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUsn());
			ps.setString(2, s.getName());

			rows =ps.executeUpdate();

		} catch (SQLException e) {
			if(e.getMessage().contains("Duplicate"))
			{                          //primary key violation
				throw new BMSException("Usn already exists");
			}
			else
			{                          //general msg
				throw new BMSException("DB Error during create,contact admin");
			}

		}
		return rows > 0;
	}

	public List<Book> getAll()
	{
		String sql =" select b.ISBN, b.title, b.category, b.NoOfBooks , a.authorname , a.mailID from book b ,author a where b.ISBN = a.ISBN ";
		List<Book> list = new ArrayList<Book>();
		Book b = null;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs != null && rs.next())
			{
				Author a = new Author(rs.getString(5),rs.getString(6));
				b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), a);
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Author> getAuthorDetails()
	{
		String sql =" select a.authorname , a.mailID from author a ";
		List<Author> list = new ArrayList<Author>();
		Book b = null;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs != null && rs.next())
			{
				Author a = new Author(rs.getString(1),rs.getString(2));
				/*b = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), a);*/
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<Book> getISBN(String ISBN ) 
	{
		String sql = "select b.ISBN, b.title, b.category, b.NoOfBooks , a.authorname , a.mailID from book b ,author a where b.ISBN = a.ISBN and b.ISBN LIKE ?  ";
		Book b = null;
		List<Book> list = new ArrayList<Book>();

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+ISBN+"%");

			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next())
			{
				Author a = new Author(rs.getString(5), rs.getString(6));
				b = new Book( rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), a);
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Book> getTitle(String title) 
	{
		String sql = "select b.ISBN, b.title, b.category, b.NoOfBooks , a.authorname , a.mailID from book b ,author a where b.ISBN = a.ISBN and b.title LIKE ? ";
		Book b = null;
		List<Book> list = new ArrayList<Book>();

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+title+"%");

			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next())
			{
				Author a = new Author(rs.getString(5), rs.getString(6));
				b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), a);
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Book> getCategory(String category) 
	{
		String sql = "select b.ISBN, b.title, b.category, b.NoOfBooks, a.authorname , a.mailID from book b ,author a where b.ISBN = a.ISBN and b.category LIKE ? ";
		Book b = null;
		List<Book> list = new ArrayList<Book>();

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+category +"%");

			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next())
			{
				Author a = new Author(rs.getString(5), rs.getString(6));
				b = new Book( rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), a);
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Book> getAuthorname(String authorname ) 
	{
		String sql = "select b.ISBN, b.title, b.category, b.NoOfBooks, a.authorname , a.mailID  from book b ,author a where b.ISBN = a.ISBN and a.authorname LIKE ? ";
		Book b = null;
		List<Book> list = new ArrayList<Book>();

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+authorname+"%");

			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next())
			{
				Author a = new Author(rs.getString(5), rs.getString(6));
				b = new Book( rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), a);
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean update(Book b)
	{
		String sql = "update book set ISBN=? where title=? ";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getISBN());
			ps.setString(2, b.getTitle());
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows > 0;
	}

	public boolean delete(String ISBN)
	{
	//	String sql = "delete from author where ISBN=?";
		String sql = "delete from book b, author a  where b.ISBN=a.ISBN and a.ISBN=?";
		
		int rows = 0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ISBN);

			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows > 0;
	}
	
	public boolean deleteBook(String ISBN)
	{
		String sql = "delete from book where ISBN=?";
		
		int rows = 0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ISBN);

			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows > 0;
	}
	public boolean create(Book b) 
	{
		String sql1 = "insert into book(ISBN, title, category,NoOfBooks) values (?,?,?,?)";
		String sql2 = "insert into author(authorname,mailID,ISBN) values (?,?,?)";

		int row1 =0,row2=0 ;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, b.getISBN());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getCategory());
			ps.setInt(4, b.getNoOfBooks());

			row1 = ps.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, b.getAuthor().getAuthorname());
			ps2.setString(2, b.getAuthor().getMailId());
			ps2.setString(3, b.getISBN());

			row2 = ps2.executeUpdate();

		} catch (SQLException e) {
			if(e.getMessage().contains("Duplicate"))
			{                          //primary key violation
				throw new BMSException("Book Id already exists");
			}
			else
			{                          //general msg
				throw new BMSException("DB Error during create,contact admin");
			}
		}
		return (row1 > 0 && row2 > 0 );
	}


}
