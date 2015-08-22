<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body align="center">
	<html:errors />
	
	<form action="dog.do" method="POST">
	
		<h1>Username: <input type="text" name="username" /></h1> <br>
		<h1>Password: <input type="password" name="password" /></h1><br>
		<h1>Confirmed Password: <input type="password" name="confirmPas" /></h1><br>
		<h1>Age: <input type="text" name="age"/></h1><br>
		<h1>Email: <input type="text" name="email"/></h1><br>
		<h1><input type="submit" value="Click here to register"/></h1>
		
	</form>

</body>
</html>