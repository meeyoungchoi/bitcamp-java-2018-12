<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

  <jsp:include page="../header.jsp" />

  <div class="container">
    <h1>회원 목록</h1>
    <p>
      <a href='form' class="btn btn-primary btn-sm">새 회원</a>
    </p>

    <div class="bit-list">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">이름</th>
            <th scope="col">이메일</th>
            <th scope="col">전화</th>
             <th scope="col">가입일</th>
            </tr>
              </thead>
              </body>
           <c:forEach items="${list}" var="member">
                <tr>
                  <th scope="row">${member.no}</th>
                  <td><a href='${member.no}'>${member.name}</a></td>
                  <td>${member.email}</td>
                  <td>${member.tel}</td>
                  <td>${member.registeredDate}</td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div><!-- .bit-list -->

  <nav aria-label="목록 페이지 이동">
  <ul class="pagination justify-content-center">
    <li class="page-item ${pageNo <= 1 ? 'disabled' : ''}">
      <a class="page-link" 
        href="?pageNo=${pageNo - 1}&pageSize=${pageSize}">이전</a></li>
    <li class="page-item active"><span class="page-link">${pageNo}</span></li>
    <li class="page-item ${pageNo >= totalPage ? 'disabled' : ''}">
      <a class="page-link" 
         href="?pageNo=${pageNo + 1}&pageSize=${pageSize}">다음</a></li>
  </ul>
</nav>


</div><!-- .container -->
  
 <jsp:include page="../javascript.jsp"/> 
</body>
</html>





