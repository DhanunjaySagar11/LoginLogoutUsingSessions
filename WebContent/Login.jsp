<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/SiteController" method = "post">
Name:<input type = "text" name = "name"><br/>
password:<input type="password" name= "password">
<input type="hidden" name="action" value="loginSubmit">
<input type="submit" value="submit">

</form>

</body>
</html>