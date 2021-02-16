<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
        
        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadPic" enctype ="multipart/form-data"  method="post">
		<input name="file" type="file" accept="image/gif, image/jpeg, image/png">
		<input type="submit" value="提交" />
	</form>
	<div id="grid">
		<img alt="" src="data:image/png;base64,${Pic}">
	</div>
</body>
</html>