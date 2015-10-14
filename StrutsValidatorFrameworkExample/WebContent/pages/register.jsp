<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<html:errors />
	
	<form action="dog.do" method="POST">
	
		Username: <input type="text" name="username" /> <br>
		Password: <input type="password" name="password" /><br>
		Age: <input type="text" name="age"/><br>
		Email: <input type="text" name="email"/><br>
		<input type="submit" value="Click here to register"/>
	
	</form>

</body>
</html>