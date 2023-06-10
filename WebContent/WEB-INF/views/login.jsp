<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>

<link rel="stylesheet" href="css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Alkatra&family=Delicious+Handrawn&family=Merriweather:ital,wght@1,300&family=Montserrat:ital,wght@1,200&family=Sacramento&display=swap" rel="stylesheet">

</head>
<body>

	<%
   		String error = (String) session.getAttribute("ERROR");
  		if(error != null )
  		 {
  	 %>
		<p><%=error %> </p>
	<%
  		 }
	%>

	<form class="form" action="UserLoginServlet" method="post">
		<label>User Name:</label>
		<input type="text" name="userName"/>
		<br><br>
		<label class="pass">Password :</label>
		<input type="password" name="pwd"/>
		<br><br>
		<input class="btn" type="submit" value="Login"/>
	</form>	   
	
	<br>
	<b><font size ="4">new user? </font></b>
	<a href="UserRegisterServlet" > <strong>register</strong></a>


</body>
</html>