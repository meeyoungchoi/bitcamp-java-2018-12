<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="java.util.List"%>
<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  PhotoBoard board = (PhotoBoard) request.getAttribute("board");
  List<Lesson> list = (List<Lesson>) request.getAttribute("lesson");
%>
<!DOCTYPE html>


<html>
<head>
<title>사진 조회</title>
</head>
<body>
 <jsp:include page="/header.jsp" />
 <h1>사진 조회(JSP)</h1>
 <form action='update' method='post' enctype='multipart/form-data'>
  <table border='1'>
   <tr>
    <th>번호</th>
    <td><input name='no' value='<%=board.getNo()%>' readonly></td>
   </tr>
   <tr>
    <th>제목</th>
    <td><input name='title' value='<%=board.getTitle()%>'></td>
   </tr>
   <tr>
    <th>등록일</th>
    <td><%=board.getCreatedDate()%></td>
   </tr>
   <tr>
    <th>조회수</th>
    <td><%=board.getViewCount()%></td>
   </tr>
   <tr>
    <th>수업</th>
    <td><select name='lessonNo'>
      <option value='0'>수업을 선택하세요</option>
       <%
         for (Lesson lesson : list) {
       %>
      
      <option value='<%=lesson.getNo()%>'>
       <%=board.getLessonNo() == lesson.getNo() ? "selected" : ""%> <%=lesson.getTitle()%> (
       <%=lesson.getStartDate()%> ~
       <%=lesson.getEndDate()%>
       </option>
       <%
         }
       %>
      
    </select></td>
   </tr>
   <input type='hidden' name='lessonNo' value='110'>
   </tr>
   <tr>
    <td colspan='2'>최소 한 개의 사진 파일을 등록해야 합니다.</td>
   </tr>
   <tr>
    <th>사진1</th>
    <td><input type='file' name='photo'></td>
   </tr>
   <tr>
    <th>사진2</th>
    <td><input type='file' name='photo'></td>
   </tr>
   <tr>
    <th>사진3</th>
    <td><input type='file' name='photo'></td>
   </tr>
   <tr>
    <th>사진4</th>
    <td><input type='file' name='photo'></td>
   </tr>
   <tr>
    <th>사진5</th>
    <td><input type='file' name='photo'></td>
   </tr>
   <tr>
    <th>사진</th>
    <td><img src='../upload/photoboard/0db7d456-f861-4a51-8c15-461be42f8bcf'
     style='height: 80px'></td>
   </tr>
  </table>
  <p>
   <a href='list'>목록</a> <a href='delete?no=<%=board.getNo()%>'>삭제</a>
   <button type='submit'>변경</button>
  <p>
 </form>
</body>
</html>

