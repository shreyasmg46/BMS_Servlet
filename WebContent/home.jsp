<%@page import="com.cruds.bms.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<h1>Home</h1>
	
	<%
		User user = (User) session.getAttribute("USER");
	%>
	
	<%
		if(user.getRole().equals("A"))
		{
	%>

	<a href="BookAuthorServlet">Create Book</a><br><br>
	
	<a href="StudentServlet">Create Student</a><br><br>
	
	<a href="IssueBookServlet">Issue Book</a><br><br>
	
	<a href="SearchByISBN">Search Book By ISBN</a><br><br>
	
	<a href="ReturnBooksForCurrentDate">List Books Which are to be returned for Current Date</a><br><br>
	
	<a href="ListStudentBooks">List Books issued to Students Based on USN</a><br><br>
	
	<% 
		}
	%>
	
<!-- 	<a href="\bms\WebContent\WEB-INF\views\booklist.jsp">List Books</a><br><br>
 -->	
	<a href="SearchByTitleServlet">Search Book By Title</a><br><br>
	
	<a href="SearchByCategory">Search Book By Category</a><br><br>
	
	<a href="SearchByAuthor">Search Book By Author</a><br><br>
	
	<a href="SearchByStudent">Search Student By USN</a><br><br>
	
	
	<a href="UserLoginServlet"><button>Login Page</button></a>
	
	
	
	
	
	

	
</body>
</html>