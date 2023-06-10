<%@page import="com.cruds.bms.entity.Issue"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Books Page</title>
</head>
<body>
	<br>
	<a href="home.jsp"><button>Home</button></a><br><br>

	<%
		List<Issue> list = (List<Issue>) request.getAttribute("ISSUEBOOKS");
		String msg = (String) request.getAttribute("MESSAGE");
	%>
	
	<%
    	if(msg != null){
    %>
		<p> <%=msg %></p>
	<% 
    	}
    %>

	<form action="" method="post">
		<label>USN :</label> 
		<input type="text" name="usn" /><br/>
		<label>ISBN:</label> 
		<input type="text" name="ISBN" /> <br/> 
		<input type="submit" value="Issue" name="btnSubmit"/>
		<input type="hidden" name="ACTION" value="CREATEISSUE" />
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<td>USN </td>
				<td>Return Date</td>
				<td>Issue Date</td>
				<td>ISBN</td>
			</tr>
		</thead>
	<tbody>
		<%
			for(Issue i : list){
		%>
			<tr>
				<td> <%=i.getUsn() %> </td>  
				<td> <%=i.getISBN() %> </td>  
				<td> <%=i.getIssueddate() %> </td>  
				<td> <%=i.getReturndate() %> </td>                                
			</tr>
		<%
			}
		%>		
	
	</tbody>				
	</table>

</body>
</html>