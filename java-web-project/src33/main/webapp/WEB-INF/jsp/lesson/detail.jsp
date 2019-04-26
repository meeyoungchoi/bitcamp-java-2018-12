<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>수업 조회</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

  <jsp:include page="../header.jsp" />

  <div class="container">
    <h1>수업 조회</h1>
    <c:choose>
      <c:when test="${empty lesson}">
        <p>해당 수업이 없습니다</p>
      </c:when>
      <c:otherwise>
        <form action='update' method='post'>

          <div class="form-group row">
            <label for="no" class="col-sm-2 col-form-label">번호</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="no" name='no'
                value='${lesson.no}' readonly>
            </div>
          </div>

          <div class="form-group row">
            <label for="title" class="col-sm-2 col-form-label">수업</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="title" name='title'
                value='${lesson.title}' readonly>
            </div>
          </div>

          <div class="form-group row">
            <label for="contents" class="col-sm-2 col-form-label">내용</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="contents" name='contents'
                value='${lesson.contents}' readonly>
            </div>
          </div>

          <div class="form-group row">
            <label for="startDate" class="col-sm-2 col-form-label">시작일</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="startDate" name='startDate'
                value='${lesson.startDate}' readonly>
            </div>
          </div>

          <div class="form-group row">
            <label for="finishDate" class="col-sm-2 col-form-label">종료일</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="finishDate" name='finishDate'
                value='${lesson.finishDate}' readonly>
            </div>
          </div>

          <div class="form-group row">
            <label for="totalHours" class="col-sm-2 col-form-label">총 교육시간</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="totalHours" name='totalHours'
                value='${lesson.totalHours}' readonly>
            </div>
          </div>


          <div class="form-group row">
            <label for="dayHours" class="col-sm-2 col-form-label">일 교육시간</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="dayHours" name='dayHours'
                value='${lesson.dayHours}' readonly>
            </div>
          </div>

          <div class="form-group row">
            <div class="col-sm-10">
              <a class="btn btn-primary" href='.'>목록</a> 
              <a class="btn btn-primary" href='.'>삭제</a>
              <a class="btn btn-primary" href='.'>변경</a>
            </div>
          </div>
        </form>
      </c:otherwise>
    </c:choose>

  </div>
  <!-- .container -->


  <jsp:include page="../javascript.jsp" />
</body>
</html>
