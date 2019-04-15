<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:out</h1>
<%-- 
- 출력문을 만드는 태그이다.
  &lt;c:out value="출력될 값" default="기본 값"/>
  &lt;c:out value="출력될 값>기본값<c:out>
--%>

<c:out value="임꺽정"/><br>
<%--객체를 지정할 때는 el을 넣으면 객체의 주소가 넣인다. --%>
<c:out value="${null}" default="홍길동"/><br>
<c:out value="${null}">홍길동</c:out><br>
<c:out value="${'임꺽정'}" default="홍길동"/><br>
</body>
</html>












