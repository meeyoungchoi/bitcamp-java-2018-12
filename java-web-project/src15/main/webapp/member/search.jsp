<%@page import="com.eomcs.lms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 trimDirectiveWhitespaces="true"%>
<%
  List<Member> list = (List<Member>) request.getAttribute("keyword");
%>
<!DOCTYPE html>


<html>
<head>
<title>회원 목록</title>
</head>
<body>
 <jsp:include page="/header.jsp" />
 <h1>회원 목록(JSP)</h1>
 <table border='1'>
  <tr>
   <th>번호</th>
   <th>이름</th>
   <th>이메일</th>
   <th>전화번호</th>
   <th>가입일</th>
  </tr>

  <%for (Member member : list) { %>
  <tr>
   <td><%=member.getNo()%></td>
   <td><a href='detail?no=<%=member.getNo()%>'><%=member.getName()%></a></td>
   <td><%=member.getEmail()%></td>
   <td><%=member.getTel()%></td>
   <td><%=member.getRegisteredDate()%></td>
  </tr>
  <%} %>
 </table>
 <p>
  <a href='list'>목록</a>
</body>
</html>
