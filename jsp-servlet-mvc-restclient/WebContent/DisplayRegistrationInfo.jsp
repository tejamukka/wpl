<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message Posting Center</title>
</head>
<body>
	<h1>Message Posting Center</h1>
	<h2>Messages:</h2>
	<ul>
	  <li>By: <%= request.getAttribute("fname") %></li>
	  <li>Member Since: <%= request.getAttribute("lname") %></li>
	  <li>Member Since: <%= request.getAttribute("email") %></li>
	  <li>Member Since: <%= request.getAttribute("password1") %></li>
	  <li>Member Since: <%= request.getAttribute("password2") %></li>
	</ul>
</body>
</html>