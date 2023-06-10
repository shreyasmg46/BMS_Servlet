<%@page import="com.cruds.bms.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
</head>
<body>

	<%
	List<Book> listbook = (List<Book>) request.getAttribute("BOOKLIST");
	%>


<h1>Book List</h1>

	<table> <!-- class="table table-dark table-hover" -->
		<thead> <!-- class="table-dark" --> 
			<tr>
				<td><strong>Author Name</strong></td>
				<td><strong>E-mailId</strong></td>
				<td><strong>ISBN</strong></td>
				<td><strong>Title</strong></td>
				<td><strong>Category</strong></td>
				<td><strong>NoOfBooks</strong></td>
			</tr>
		</thead>
		<tbody>
			<%
				for (Book b : listbook) {
			%>
			<tr>
				<td><%=b.getAuthor().getAuthorname()%></td>
				<td><%=b.getAuthor().getMailId()%></td>
				<td><%=b.getISBN()%></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getCategory()%></td>
				<td><%=b.getNoOfBooks()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>