<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body align="center">
	<script src="validate.js"></script>
	<jsp:useBean id="user" class="net.mv.domain.User" scope="session"></jsp:useBean>
	<h1>Hello <jsp:getProperty property="username" name="user"/>, Here are all forums:<br></h1>
	
	<form action="home.do" method="post">
		<input type="hidden" name="replySet" />
		<c:forEach items="${ forumSet }" var="forum">
			<table>
				<tr>
					<td>
						<h3><input type="submit" name="title" value="${ forum.title }"/></h3>
					</td>
					<td>
						<h3> | ${ forum.f_desc }</h3>
					</td>
				</tr>
			</table>
		</c:forEach>
	</form>
	
	<form action="home.do" method="post">	
		<h3>Title: <input type="text" name="title" /></h3> 
		<h3>Description: <input type="text" name="description" /></h3> <br>
		<h3><input type="submit" name="addForum" value="Add Forum" /></h3>
		<h1><p><a href="login.jsp"/>Logout </p></h1>
	
	</form>
</body>
</html>