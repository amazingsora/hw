<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/plugin/jquery-3.5.1.min.js"/>"></script>
<meta charset="UTF-8">
<title>登入頁面</title>
</head>
<body>
<h2>登入</h2>
<span style="color:red;">${err}</span> <br>
<form METHOD="post"  ACTION="login" id="form">
	帳號:<input type="text" name="account" id="account"><br>
	密碼:<input type="text" name="password" id="password">
</form>

	<button id="send">送出</button>
	
<script>
$("#send").on("click", function() {
	$("#form").submit();
});
</script>
</body>
</html>