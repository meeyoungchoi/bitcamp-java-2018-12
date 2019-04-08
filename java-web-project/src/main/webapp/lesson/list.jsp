<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons");
    %>
<!DOCTYPE html>
<html>
<head>

<title>수업 목록(JSP)</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1>수업 목록(JSP)</h1>
<p><a href='add'>신규 수업</a></p>
<table border='1'>
  <tr> <th>번호</th> <th>수업 제목</th> <th>시작일 ~ 종료일</th> <th>총 시간</th> </tr>
  <%for (Lesson lesson : lessons) {%>
  <tr>
    <td><%=lesson.getNo()%></td>
    <td><a href='detail?no=<%=lesson.getNo()%>'><%=lesson.getTitle()%></a></td>
    <td><%=lesson.getStartDate()%> ~ <%=lesson.getEndDate()%></td>
    <td><%=lesson.getTotalHours()%></td>
  </tr>
  <%}%>
</table>
<a href='../index.html'>처음화면</a>

</body>
</html>