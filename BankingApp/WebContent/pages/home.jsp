<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script src="validate.js"></script>
	<jsp:useBean id="customer" class="net.mv.domain.Customer" scope="session"></jsp:useBean>
	Hello <jsp:getProperty property="custName" name="customer"/><br>
	Your balance: <jsp:getProperty property="custBalance" name="customer"/>
	
	<form action="home.do" method="post">
		<input type="hidden" id="balance" value="<jsp:getProperty property="custBalance" name="customer"/>"/>
		Amount: <input type="text" name="amount" id="amount" onkeypress="checkValidate()" onkeyup="checkValidate()"/> <br>
		<input type="submit" name="transaction" value="Deposit" />
		<input type="submit" name="transaction" value="Withdrawn" id="withdrawn" /> <br><br>
		<p><a href="login.jsp"/>Logout </p>
	
	</form>
</body>
</html>