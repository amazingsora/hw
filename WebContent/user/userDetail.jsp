<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>

<html>
<head>
<script src="<c:url value="/plugin/jquery-3.5.1.min.js"/>"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
${action}
<form METHOD="post"  ACTION="update" id="form">
	帳號:<input type="text" name="account" id="account"  value="${updateVO.account}"><br>
	名稱:<input type="text" name="username" id ="username"  value="${updateVO.username}"><br>
	<div id="passwordDiv">
		密碼:<input type="text" name="password" id="password"  value="${updateVO.password}"><br>
	</div>
	<span style="color:red;">${err}</span> <br>
	
	<input type="hidden" name="action" id="action"><br>
	
</form>


	<button id = "actionButton" ></button>

</div>
<div id="grid">

</div>
<script>
var action = '${action}';
$(document).ready(function() {
	if('${action}' == "update"){
		$("#actionButton").text("更新");
		$("#account").attr("readonly","readonly");
		$("#passwordDiv").hide();

		$("#action").val('${action}');
	}
	else{
		$("#actionButton").text("新增");
		$("#action").val("add");
	}
	
	$('#actionButton').on("click", function() {
		$("#form").submit();
	
	});
	
	
});

</script>
</body>
</html>