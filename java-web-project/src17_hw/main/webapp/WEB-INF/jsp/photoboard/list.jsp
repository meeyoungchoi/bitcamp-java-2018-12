<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>사진 목록</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

  <jsp:include page="../header.jsp" />
  
  <h1>사진 목록</h1>
  <p>
    <a href='form'>새 사진</a>
  </p>
  
    <div class="bit-list">
      <table class="table table-hover">
        <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">등록일</th>
      <th scope="col">조회수</th>
      <th scope="col">수업</th>
    </tr>
  <c:forEach items="${list}" var="board">
    <tr>
      <td>${board.no}</td>
      <td><a href='${board.no}'>${board.title}</a></td>
      <td>${board.createdDate}</td>
      <td>${board.viewCount}</td>
      <td>${board.lessonNo}</td>
    </tr>
  </c:forEach>
  </table>

  <form action='search'>
    수업번호: <input type='text' name='lessonNo'> 검색어: 
    <input type='text' name='keyword'>
    <button type='submit'>검색</button>
  </form>

</body>
</html>








