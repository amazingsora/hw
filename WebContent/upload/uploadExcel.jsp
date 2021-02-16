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
	<form action="uploadFile" enctype ="multipart/form-data"  method="post">
		<input type="file" name="file" multiple="multiple"/>
		<input type="submit" value="提交" />
	</form>
	<div id="grid">
		<table  border="1px" >
			<c:forEach items="${excelList}" var="item">
	   		<tr>
				<td>${item.currency}</td>
				<td>${item.buyRate}</td>
				<td>${item.buyCash}</td>
				<td>${item.buyInTime}</td>
				<td>${item.buyDay10}</td>
				<td>${item.buyDay30}</td>
				<td>${item.buyDay60}</td>
				<td>${item.buyDay90}</td>
				<td>${item.buyDay120}</td>
				<td>${item.buyDay150}</td>
				<td>${item.buyDay180}</td>
				
				<td>${item.sellRate}</td>
				<td>${item.sellCash}</td>
				<td>${item.sellInTime}</td>
				<td>${item.sellDay10}</td>
				<td>${item.sellDay30}</td>
				<td>${item.sellDay60}</td>
				<td>${item.sellDay90}</td>
				<td>${item.sellDay120}</td>
				<td>${item.sellDay150}</td>
				<td>${item.sellDay180}</td>
			</tr>
		</c:forEach>
		
			
		</table>
		
	</div>
</body>
</html>