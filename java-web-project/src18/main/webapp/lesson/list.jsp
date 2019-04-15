<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
  <title>수업 목록</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h1>수업 목록(JSP2)</h1>
<p><a href='add'>새 수업</a></p>

<table border='1'>
  <tr><th>번호</th><th>수업</th><th>기간</th><th>총교육시간</th></tr>
  <jsp:useBean scope="request" id="list" type="List<Lesson>"></jsp:useBean>
<%for (Lesson lesson : list) {%>
  <tr>
    <td>${lesson.No()}></td>
    <td><a href='detail?no=${lesson.No()}'>${lesson.Title()}'</a></td>
    <td>${lesson.StartDate()} ~ ${lesson.EndDate()}</td>
    <td>${lesson.TotalHours()}</td>
  </tr>
<%}%>
</table>
</body>
</html>







