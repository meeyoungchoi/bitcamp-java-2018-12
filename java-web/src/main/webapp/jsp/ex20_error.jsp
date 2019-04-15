<%@page import="java.util.ArrayList"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="ex20_error.jsp"
    %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex20</title>
</head>
<body>
<h1>오류 발생</h1>
<%=exception.getMessage() %>
<jsp:include page="ex19_header.jsp"/>

</body>
</html>
<%--pageError
=>jsp를 실행하는 중에 오류가 발생했을 때 실행할 jsp를 지정할 수 있다.
=>어떻게?
  <%@ page errorPage="URL"%>
  =>이 속성에 url을 지정하지 않으면 오류가 발생했ㅇ르 때
  서블릿 컨테이너의 기본 
  
  isErrorPage
  =>오류가 발생했을 때 실행되는 jsp쪽에서
  그 오류 내용을 받을 때 사용한다.
   --%>





