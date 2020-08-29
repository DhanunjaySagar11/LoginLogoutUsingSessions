<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String un=null,sessionid=null;
if(request.getSession().getAttribute("SessionName")==null)
{
	response.sendRedirect("Login.jsp");
}
else
{
	un=request.getSession().getAttribute("SessionName").toString();
	sessionid=request.getSession().getId();
}
%>

Welcome<br/>
UserName:<%=un %><br/>
Session Id:<%=sessionid %>


<form action = "<%=request.getContextPath()%>/MemberAreaController" method = "get">
<input type ="hidden" name="action" value="destroy">
<input type="submit" value = "Logout">



</form>


</body>
</html>