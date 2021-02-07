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

	帳號:<input type="text" name="account" id="account"  ><br>
	名稱:<input type="text" name="username" id ="username">
	<button id="send">查詢</button>
	
</div>

<form METHOD="post"  ACTION=userAction id="updateform">
	<input type="hidden" name="account" id="updateaccount"  >
	<input type="hidden" name="action" value="update"  >

</form>
<div id="grid">

</div>
	<button id="add" onclick="location.href='<c:url value="/userAction?action=add"/>'">新增</button>

<script>
$( document ).ready(function() {
	$("#send").on("click", function() {
		$.ajax({
			url:"<c:url value="/userQuery"/>",
			type:"POST",
			data: {
				username : $("#username").val(),
				account: $("#account").val()
			},
			success:function(data){
				console.log(data);
				$("#grid").html(data);
			}
		});
				
	});
				
});
function del(userid){
	$.ajax({
		url:"<c:url value="/update?action=del"/>",
		type:"POST",
		data: {
			username : $("#username").val(),
			account: userid
		},
		success:function(data){
			console.log(data);
			$("#grid").html(data);
		}
	});
}

function update(userid){
	$("#updateaccount").val(userid);
	$("#updateform").submit();
}

function Add(){
	
}
</script>
</body>
</html>