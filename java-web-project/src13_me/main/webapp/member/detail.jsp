<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%
  Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 조회</title>
</head>
<body>

  <jsp:include page="/header.jsp" />

  <h1>게시물 조회(JSP)</h1>

  <%
    if (member == null) {
  %>
  <p>해당 게시물이 없습니다</p>
  <%
    } else {
  %>
  <form action='update' method='post'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input type='text' name='no' value='<%=member.getNo()%>' readonly></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><textarea name='name' rows='3' cols='50'><%=member.getName()%></textarea></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><textarea name='email' rows="" cols="50"><%=member.getEmail()%></textarea></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><textarea name='password' rows="" cols="50"><%=member.getPassword()%></textarea></td>
      </tr>
      <tr>
        <th>사진</th>
        <td><textarea name='photo' rows="" cols="50"><%=member.getPhoto()%></textarea></td>
      </tr>
      <tr>
        <th>전화</th>
        <td><textarea name='tel' rows="" cols="50"><%=member.getTel()%></textarea></td>
      </tr>
    </table>
    <p>
      <a href='list'>목록</a> <a href='delete?no=<%=member.getNo()%>'>삭제</a>
      <button type='submit'>변경</button>
    <p>
  </form>
  <%
    }
  %>
</body>
</html>
