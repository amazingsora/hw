<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>INSPINIA | Login</title>
</head>

<body>
	<form class="m-t" role="form" method="post"
		action="${pageContext.request.contextPath}/login">
		<div class="form-group">
			<input type="text" name="hwUser" class="form-control"
				placeholder="Username" required="">
		</div>
		<div class="form-group">
			<input type="password" name="hwPW" class="form-control"
				placeholder="Password" required="">
		</div>
		<button type="submit" class="btn btn-primary block full-width m-b">Login</button>

		<a href="login.html#"><small>Forgot password?</small></a>
		<p class="text-muted text-center">
			<small>Do not have an account?</small>
		</p>
		<a class="btn btn-sm btn-white btn-block" href="register.html">Create
			an account</a>
	</form>
</body>

</html>