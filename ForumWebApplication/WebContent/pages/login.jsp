<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body align="center">

	<html:errors  />

	<form action="cat.do" method="post">
	
		<input type="hidden" name="forumSet" />
		<h1>Username: <input type="text" name="username" /> <br></h1>
		
		<h1>Password: <input type="password" name="password" /> <br></h1>
		
		<h1><input type="submit" value="Click here to login" /></h1>
		<h1><p><a href="register.jsp"/>Click here to register </p></h1>
		
	</form>
	
</body>
</html>