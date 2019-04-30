<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test3x</title>
</head>
<body>
<h1>test3x.jsp실행</h1>
<% request.setCharacterEncoding("UTF-8"); %>
name: ${param.name}<br>
age: ${param.age}<br>
</body>
</html>
<%
response.setHeader("Access-Control-Allow-Origin","*");

//일부러 응답을 지연시킨다.
Thread.currentThread().sleep(10000);
%>