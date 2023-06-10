<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Register Page</title>
</head>
<body>

	<a href="home.jsp"><button>Home</button></a>
	<br>
	<br>

	<form action="UserRegisterServlet" method="post">
		<label>User Name:</label>
		<input type="text" name="userName"/>
		<br/>
		<label>Password:</label>
		<input type="password" name="pwd"/>
		<br/>
		<label>Phone Number:</label>
		<input type="text" name="phoneNo"/>
		<br/>
		<label>E-mail:</label>
		<input type="text" name="email"/>
		<br/>
 		<input type="submit" value="Register"/>
	</form>	      


</body>
</html>