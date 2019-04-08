<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%
  Lesson lesson = (Lesson) request.getAttribute("lesson");
%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 조회</title>
</head>
<body>

  <jsp:include page="/header.jsp" />

  <h1>게시물 조회(JSP2)</h1>

  <%
    if (lesson == null) {
  %>
  <p>해당 게시물이 없습니다</p>
  <%
    } else {
  %>
  <form action='update' method='post'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input type='text' name='no' value='<%=lesson.getNo()%>' readonly></td>
      </tr>
      <tr>
        <th>수업</th>
        <td><textarea name='title' rows='3' cols='50'><%=lesson.getTitle()%></textarea></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name='contents' rows='3' cols='50'><%=lesson.getContents()%></textarea></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td><textarea name='date' rows='3' cols='50'><%=lesson.getStartDate()%></textarea></td>
      </tr>
      <tr>
        <th>종료일</th>
        <td><textarea name='date' rows='3' cols='50'><%=lesson.getEndDate()%></textarea></td>
      </tr>
      <tr>
        <th>일 수업시간</th>
        <td><textarea name='number' rows='3' cols='50'><%=lesson.getDayHours()%></textarea></td>
      </tr>
      <tr>
        <th>총 교육시간</th>
        <td><textarea name='number' rows='3' cols='50'><%=lesson.getTotalHours()%></textarea></td>
      </tr>
    </table>
    <p>
      <a href='list'>목록</a> <a href='delete?no=<%=lesson.getNo()%>'>삭제</a>
      <button type='submit'>변경</button>
    <p>
  </form>
  <%
    }
  %>
</body>
</html>
