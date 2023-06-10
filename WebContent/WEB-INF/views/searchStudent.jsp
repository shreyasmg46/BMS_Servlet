<%@page import="java.util.List"%>
<%@page import="com.cruds.bms.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>

	<br>
	<a href="home.jsp"><button>Home</button></a>
	<br>
	<br>

	<%
		List<Student> list = (List<Student>) session.getAttribute("USN");
	%>

	<h1>Search</h1>

	<form action="SearchByStudent" method="post">
		<label>USN :</label> <input type="text" name="usn" /> <br />
		<input type="submit" value="Search">
	</form>


	<table class="table table-dark table-hover">
		<thead class="table-dark">
			<tr>
				<td><strong>USN</strong></td>
				<td><strong>Name</strong></td>
			</tr>
		</thead>
		<tbody>

			<%
				for (Student s : list) {
			%>
			<tr>
				<td><%=s.getUsn()%></td>
				<td><%=s.getName()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>


</body>
</html>