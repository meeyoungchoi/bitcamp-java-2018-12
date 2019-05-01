<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 검색</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>
  <jsp:include page="../header.jsp" />

<div class="container">
  <h1>회원 검색</h1>
  <c:choose>
  <c:when test="${empty member}">
  <p>해당하는 회원이 없습니다.</p>
</c:when>
<c:otherwise>
   <form action='search' method='post' enctype='multipart/form-data'>
    <div class="form-group row">
      <label for="no" class="col-sm-2 col-form-label">번호</label>
      <div class="col-sm-10">
      <input type="text" class="form-control-plaintext" id="no" 
             name='no' value='${member.no}' >
                <label for="name" class="col-sm-2 col-form-label">이름</label>
      <div class="col-sm-10">
      <input type="text" class="form-control-plaintext" id="name" 
             name='name' value='${member.name}' >
    </div>
  </div>
<c:forEach items="${list}" var="member">
    <tr>
      <td>${member.no}</td>
      <td><a href='detail?no=${member.no}'>${member.name}</a></td>
      <td>${member.email}</td>
      <td>${member.tel}</td>
      <td>${member.registeredDate}</td>
    </tr>
</c:forEach>
  </table>
  <p>
    <a href='.'>목록</a>
  </p>
</body>
</html>
