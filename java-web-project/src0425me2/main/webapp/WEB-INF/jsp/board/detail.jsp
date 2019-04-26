<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시물 조회</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

<jsp:include page="../header.jsp"/>

<div class="container">
  <h1>게시물 조회</h1>
<c:choose>
<c:when test="${empty board}">
  <p>해당 게시물이 없습니다</p>
</c:when>
<c:otherwise>
  <form action='update' method='post'>
   <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">번호</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="no" name="no" value='${board.no}' readonly>
    </div>
    
       <div class="form-group row">
    <label for="contents" class="col-sm-2 col-form-label">내용</label>
    <div class="col-sm-10">
      <textarea class="form-control" id="contents" name="contents" value='${board.contents}' readonly>
    </div>
    
    <div class="form-group row">
    <label for="createdDate" class="col-sm-2 col-form-label">작성일</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="createdDate" value="${board.createdDate}">
    </div>
    
       <div class="form-group row">
    <label for="viewCount" class="col-sm-2 col-form-label">조회수</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="viewCount" value="${board.viewCount}">
    </div>

      <div class="form-group row">
    <label for="viewCount" class="col-sm-2 col-form-label">조회수</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="viewCount" value="${board.viewCount}">
    </div>
  
    
    </table>
    <p>
      <a href='.'>목록</a> <a href='delete/${board.no}'>삭제</a>
      <button type='submit'>변경</button>
    <p>
  </form>
</c:otherwise>
</c:choose>

</div><!-- .container -->

<jsp:include page="../javascript.jsp"/>
</body>
</html>






