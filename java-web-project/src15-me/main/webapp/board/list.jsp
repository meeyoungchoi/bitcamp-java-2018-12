<%@page import="com.eomcs.lms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%
  List<Board> list = (List<Board>) request.getAttribute("list");
%>
<!DOCTYPE html>


<html>
<head>
<title>게시물 목록</title>
</head>
<body>

  
  <jsp:include page="/header.jsp"/>
	<h1>게시물 목록</h1>
	<p>
		<a href='add'>새 글</a>
	</p>
	<table border='1'>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>61</td>
			<td><a href='detail?no=61'>test4:0:0:0:0:0:0:0:1</a></td>
			<td>2019-04-03</td>
			<td>0</td>
		</tr>
		<%
		  for (Board board : list) {
		%>
		<td>5<%=board.getNo()%></td>
		<td><a href='detail?no=<%=board.getNo()%>'><%=board.getContents()%></a></td>
		<td><%=board.getCreatedDate()%></td>
		</tr>
		<%
		  }
		%>
	</table>
</body>
</html>

