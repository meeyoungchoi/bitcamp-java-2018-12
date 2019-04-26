<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

  <jsp:include page="../header.jsp" />

<div class="container">
  <h1>새 회원</h1>
  <form action='add' method='post'>
  <div class="form-group row">
    <lable for="title" class="col-sm-2 col-form-label">회원</lable>
     <div class="col-sm-8">
      <textarea class="form-control" id="name" 
                name='tname' rows='5'>${member.name}</textarea>
    </div>
  </div>
  
  
    <div class="form-group row">
    <lable for="contents" class="col-sm-2 col-form-label">수업</lable>
     <div class="col-sm-8">
      <textarea class="form-control" id="contents" 
                name='contents' rows='5'>${member.contents}</textarea>
    </div>
  </div>


<div class="form-group row">
    <lable for="email" class="col-sm-2 col-form-label">이메일</lable>
     <div class="col-sm-8">
      <textarea class="form-control" id="email" 
                name='email' rows='5'>${member.email}</textarea>
    </div>
  </div>
  
  
<div class="form-group row">
    <lable for="password" class="col-sm-2 col-form-label">암호</lable>
     <div class="col-sm-8">
      <textarea class="form-control" id="password" 
                name='password' rows='5'>${member.password}</textarea>
    </div>
  </div>
    
    
      
<div class="form-group row">
    <lable for="photo" class="col-sm-2 col-form-label">사진</lable>
     <div class="col-sm-8">
      <textarea class="form-control" id="photo" 
                name='photo' rows='5'>${member.photo}</textarea>
    </div>
  </div>
  
  
  <div class="form-group row">
    <lable for="tel" class="col-sm-2 col-form-label">전화</lable>
     <div class="col-sm-8">
      <textarea class="form-control" id="tel" 
                name='tel' rows='5'>${member.tel}</textarea>
    </div>
  </div>
   
   <div class="form-group row">
    <div class="col-sm-10">
      <button class="btn btn-primary">등록</button>
      <a class="btn btn-primary" href='.'>목록</a> 
    </div>
  </div>
  </form>
</div><!-- .container -->
 
 <jsp:include page="../javascript.jsp"/>
</body>
</html>





