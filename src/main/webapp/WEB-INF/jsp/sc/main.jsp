<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<span>現在SESSION==><c:out value="${sessionId}"/></span><br/>
	<span>現在color==><c:out value="${color}"/></span><br/>
		<span>現在t==><c:out value="${t}"/></span>
	
	<form action="setSession" method="post">
		<span>設定SESSION <input type="text" name="id" /><input
			type="submit" /></span>



	</form>
	<form action="setColor" method="post">
		<input type="hidden" name="color" value="blue" /> 
		<input type="submit" value="藍色" />



	</form>
	<form action="setColor" method="post">
		<input type="hidden" name="color" value="red" /> 
		<input type="submit" value="紅色" />



	</form>
	<form action="setColor" method="post">
		<input type="hidden" name="color" value="green" /> 
		<input type="submit" value="綠色" />



	</form>
</body>
</html>