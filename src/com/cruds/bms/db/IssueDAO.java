package com.cruds.bms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cruds.bms.entity.Issue;
import com.cruds.bms.entity.Student;
import com.cruds.bms.util.DateUtil;

public class IssueDAO {
	
	public List<Issue> listBooks(String usn)
	{
		String sql ="select s.name,b.title,i.returnDate,i.issueID from student s, book b, bookissue i where i.ISBN = b.ISBN and i.usn = s.usn and s.usn = ? ";
		List<Issue> list1 = new ArrayList<Issue>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usn);
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Issue i = new Issue(rs.getInt(4), rs.getString(3), rs.getString(2), rs.getString(1));
				list1.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;
	}
	
	public List<Issue> getIssuedBooks()
	{
		String sql =" select usn,issueDate,ISBN,returnDate from bookissue";
		List<Issue> list = new ArrayList<Issue>();
		Issue i = null;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs != null && rs.next())
			{
				i = new Issue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<Issue> returnBooks()
	{
		String sql = "select s.name,b.title,b.ISBN,i.issueID from student s, book b,bookissue i where i.ISBN = b.ISBN and i.usn = s.usn  and i.returnDate = ?";
		List<Issue> list2  = new ArrayList<Issue>();

			
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1 , DateUtil.getCurrDateAsSQLDate());
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Issue i = new Issue(rs.getInt(4), rs.getString(3), rs.getString(2), rs.getString(1));
				list2.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list2 ;
	}
	
	public boolean issueBook(Student student,Date issueDate,String ISBN )
	{
		String sql1 = "select usn from Student where usn = ?";
		String sql2 = "insert into bookissue(usn,issueDate,returnDate,ISBN) values (?,?,?,?) ";
		String sql3 = "update book set NoOfBooks = NoOfBooks-?  where ISBN = ? ";
		
	    int  row2 = 0 ,row3 = 0;
	    int Book1 = 1;
	    String USN = null;
	    
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(issueDate);
	    cal.add(Calendar.DATE, 7);
	    Date returnDate = cal.getTime();
	    
	    java.sql.Date rDate = new java.sql.Date(returnDate.getTime());
	    java.sql.Date iDate = new java.sql.Date(issueDate.getTime());
	    
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, student.getUsn());
			ResultSet rs = ps1.executeQuery();
			if(rs != null && rs.next())
			{
				USN = rs.getString(1);
			}
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1,student.getUsn());
			ps2.setDate(2, iDate);
			ps2.setDate(3, rDate);
			ps2.setString(4, ISBN);
			row2 = ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Book1);
			ps3.setString(2, ISBN);
	
			row3 = ps3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row2 > 0 && row3 > 0 );
	}


}
