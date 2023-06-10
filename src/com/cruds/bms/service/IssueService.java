package com.cruds.bms.service;

import java.util.Date;
import java.util.List;

import com.cruds.bms.db.IssueDAO;
import com.cruds.bms.entity.Issue;
import com.cruds.bms.entity.Student;

public class IssueService {
	
	public static List<Issue> listBooks(String usn){
		IssueDAO dao = new IssueDAO();
		return dao.listBooks(usn);
	}
	
	public static List<Issue> getIssuedBooks(){
		IssueDAO dao = new IssueDAO();
		return dao.getIssuedBooks();
	}
	
	public static List<Issue> returnBooks(){
		IssueDAO dao = new IssueDAO();
		return dao.returnBooks();
	}
	
	public static boolean issueBook(Student student,Date issueDate,String ISBN )
	{
		IssueDAO dao = new IssueDAO();
		return dao.issueBook(student, issueDate, ISBN);
	}

}
