<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	.partOfLayout{
		width: 100%;
		height = 100px;
	}
	
	#myHeader{
		background-color: blue;
	
	}
	#myMenu{
		background-color: green;
	
	}
	#myBody{
		background-color: red;
	
	}
	#myFooter{
		background-color: orange;
	
	}

</style>

</head>
<body>



	<div id="myHeader" class="partOfLayout">	
		<tiles:insert attribute="header"/>
	</div>
	<div id="myMenu" class="partOfLayout">
		<tiles:insert attribute="menu"/>
	</div>
	<div id="myBody" class="partOfLayout">
		<tiles:insert attribute="body"/>
	</div>
	<div id="myFooter" class="partOfLayout">
		<tiles:insert attribute="footer"/>
	</div>

</body>
</html>