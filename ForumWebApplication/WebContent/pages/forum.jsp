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
<title>Forum</title>
</head>
<body align="center">
	<jsp:useBean id="forum" class="net.mv.domain.Forum" scope="session"></jsp:useBean>
	<jsp:useBean id="reply" class="net.mv.domain.Reply" scope="session"></jsp:useBean>
	<jsp:useBean id="user" class="net.mv.domain.User" scope="session"></jsp:useBean>
	<h1>Title: <jsp:getProperty property="title" name="forum"/><br></h1>
	<h1>Description: <jsp:getProperty property="f_desc" name="forum"/><br></h1>
	<h1>Created By: <jsp:getProperty property="username" name="user"/><br></h1>
		
<%-- 	<h1>Title: ${ forum.title }</h1> --%>
<%-- 	<h1>Description: ${ forum.f_desc }</h1> --%>
<%-- 	<h1>Created By: ${ forum.user.username }</h1><br> --%>
	
	<form action="forum.do" method="post">
		<c:forEach items="${ replySet }" var="reply">
			<table align="center">
				<tr>
					<td><h3>${ reply.r_desc } </h3></td>
					<td><h3> | Posted by: ${ reply.user.username }</h3></td>
				</tr>
			</table>
		</c:forEach>
	</form>
	
	<form action="forum.do" method="post">	
		<h3>Create a reply: </h3>
		<h3><textarea rows="4" cols="50" name="createReply" ></textarea></h3><br>
		<h3><input type="submit" name="addReply" value="Add Reply" /></h3>
		<h1><p><a href="home.jsp"/>Back to Home </p></h1>
	</form>
	
</body>
</html>