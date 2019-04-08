
<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%
  List<Lesson> list = (List<Lesson>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 목록</title>
</head>
<body>

  <jsp:include page="/header.jsp" />

  <h1>수업 목록(JSP4)</h1>
  <p>
    <a href='add'>새 수업</a>
  </p>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>내용</th>
      <th>등록일</th>
      <th>종료일</th>
      <th>종수업시간</th>
      <th>일수업시간</th>
    </tr>
    <%
      for (Lesson lesson : list) {%>
    <tr>
      <td><%=lesson.getNo()%></td>
      <td><a href='detail?no=<%=lesson.getNo()%>'><%=lesson.getContents()%></a></td>
      <td><%=lesson.getTitle()%></td>
      <td><%=lesson.getContents()%></td>
      <td><%=lesson.getStartDate()%></td>
      <td><%=lesson.getEndDate()%></td>
      <td><%=lesson.getDayHours()%></td>
      <td><%=lesson.getTotalHours()%></td>
    </tr>
    <%}%>
  </table>
</body>
</html>







