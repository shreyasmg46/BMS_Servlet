<%@page import="com.cruds.bms.entity.Issue"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Return Books</title>
</head>
<body>
	<br>
	<a href="home.jsp"><button>Home</button></a><br><br>	
		
	<%
		List<Issue> list = (List<Issue>) request.getAttribute("RETURNBOOKS");
	%>
	
	<%
		if(list != null){
	%>

	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>Title</td>
				<td>ISBN</td>
				<td>Issue ID</td>
			</tr>
		</thead>
		<tbody>
			<%
			for(Issue i : list){
		%>
			<tr>
				<td><%=i.getName() %></td>
				<td><%=i.getTitle() %></td>
				<td><%=i.getISBN() %></td>
				<td><%=i.getIssueID() %></td>
			</tr>
			<%
			}
		%>

		</tbody>
	</table>
	
	<%
		}
		else if(list.isEmpty()){
	%>
	<h2>Zero Books to be returned for Current Date</h2>
	
	<%
		}
	%>

</body>
</html>