<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head><title>로그인</title></head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>

<jsp:include page="../header.jsp"/>

<div>
<h1>로그인(JSP)</h1>
<form action='login' method='post'>
<table border='1'>
<tr>
  <th>이메일</th>
  <td><input type='email' name='email' value='${cookie.email.value}'></td>
</tr>
<tr>
  <th>암호</th>
  <td><input type='password' name='password'></td>
</tr>
</table>
<input type='checkbox' name='saveEmail'> 이메일 저장
<p>
  <button>로그인</button>
</p>
</form>
</div><!-- .container그룹에 소속되어있는 div -->

<jsp:include page="../javascript.jsp"/>
</body>
</html>
