<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java"
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"
          trimDirectiveWhitespaces="true"%>
<%
  Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<title>회원 조회(JSP)</title>
</head>
<body>
  <h1>회원 조회(JSP)</h1>
  <form action='update' method='post' enctype='multipart/form-data'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input type='text' name='no' value='<%=member.getNo() %>' readonly></td>
      </tr>

      <tr>
        <th>이름</th>
        <td><input type='text' name='name' value='<%=member.getName()%>'></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type='email' name='email' value='<%=member.getEmail()%>'></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><input type='password' name='password' value='<%=member.getPassword()%>'></td>
      </tr>
      <tr>
        <th>사진</th>
        <td><%if (member.getPhoto() == null) { %>
          <img src='/images/default.jpeg' style='height:80px'>
         <%} else {%>
          <img src='/upload/member/<%=member.getPhoto()%>' style='height:80px'>
         <%} %>
        <input type='file' name='photo'>
        </td>
      <tr>
        <th>전화번호</th>
        <td><input type='text' name='tel' value='<%=member.getTel()%>'></td>
      </tr>
      <tr>
        <th>가입일</th>
        <td><%=member.getRegisteredDate()%></td>
      </tr>
    </table>
    <p>
      <a href='list'>목록</a> <a href='delete?no=<%=member.getNo()%>'>삭제</a>
      <button type='submit'>변경</button>
    </p>
  </form>
</body>
</html>

