<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>로그인</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<jsp:include page="../header.jsp"/>

<div class="container">
<h1>로그인(JSP)</h1>
<form action='login' method='post'>
<table border='1'>
<tr>
 
 
</p>
</form>
 <div class="form-group">
    <label for="email">이메일</label>
    <input type="email" 
    class="form-control" id="email" name="email"
    value='{cooke.email.value}'
     aria-describedby="emailHelp" placeholder="Password">
    <small id="emailHelp" class="form-text text-muted">당신의 이메일을 다른 사이트와 결코 공유하지 않습니다.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="암호를 입력하세요">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="saveEmail"
    name="saveEmail"> <!-- name은 서버에 데이터를 보낼때 사용한다. -->
    <label class="form-check-label" for="saveEmail">이메일 저장</label>
  </div>
  <button class="btn btn-primary">로그인</button> 
</div><!-- .container -->

<jsp:include page="../javascript.jsp"/>
</body>
</html>
