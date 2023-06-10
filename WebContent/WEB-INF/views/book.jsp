<%@page import="com.cruds.bms.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<title>Book Page</title>

<script type="text/javascript">

	var selISBN;
	//var selTitle;

	function setData(iSBN,booktitle)
	{
		//alert(ISBN);
		//alert(ISBN+title)
		selISBN = iSBN;
		//selTitle = booktitle;
	}
	
	function dodelete() 
	{
		document.bookform.ACTION.value = "DELETE";
		document.bookform.delISBN.value = selISBN;
		document.bookform.submit();
	}
	function dodeleteBook() 
	{
		document.bookform.ACTION.value = "DELETEBOOK";
		document.bookform.delISBN.value = selISBN;
		document.bookform.submit();
	}

/* 	function populateform()
	{
		document.bookform.ACTION.value = "UPDATE";
		document.bookform.ISBN.value = selISBN;
		document.bookform.ISBN.readOnly = true;
		document.bookform.btnSubmit.value = "Update";
		document.bookform.title.value = selTitle;
	}
 */
</script>


</head>
<body>

	<br>
	<a href="home.jsp"><button>Home</button></a><br><br>

	<%
	String msg = (String)session.getAttribute("MESSAGE");
	List<Book> listbook = (List<Book>) request.getAttribute("BOOKLIST");
	%>

	<h1>Book</h1>

	<form action="BookAuthorServlet" method="post">
		<label>Author Name:</label> 
		<input type="text" name="authorname" /><br />
		<label>E-mailId:</label> 
		<input type="text" name="mailId" /> <br />
		<label>ISBN:</label> 
		<input type="text" name="ISBN" /> <br /> 
		<label>Title:</label>
		<input type="text" name="title" /> <br /> 
		<label>Category:</label> 
		<input type="text" name="category" /> <br /> 
		<label>NoOfBooks:</label> 
		<input type="text" name="NoOfBooks" /> <br /> 
		
		<input type="submit" value="Create" name="btnSubmit"/>
		<input type="hidden" name="ACTION" value="CREATE" />
 	    <input type="hidden" name="delISBN"/>
	</form>
<br><br>

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
				<td> <input type="checkbox" onclick="setData(<%= b.getISBN() %>,'<%= b.getTitle() %>')"/></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	
<!-- 	<input type="button" onclick="dodelete()" value="Delete"/>
	<input type="button" onclick="dodeleteBook()" value="Delete"/>
 -->	<!-- <input type="button" onclick="populateform()" value="Edit"/>
 -->
</body>
</html>