<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규수업(jsp)</title>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <h1>신규 수업(JSP)</h1>
  <form action='add' method='post'>
    <table border='1'>
      <tr>
        <th>제목</th>
        <td><input type='text' name='title'></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name='contents' rows='5' cols='50'></textarea></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td><input type='date' name='startDate'></td>
      </tr>
      <tr>
        <th>종료일</th>
        <td><input type='date' name='endDate'></td>
      </tr>
      <tr>
        <th>총 수업시간</th>
        <td><input type='number' name='totalHours'></td>
      </tr>
      <tr>
        <th>일 수업시간</th>
        <td><input type='number' name='dayHours'></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
      <a href='list'>목록</a>
    </p>
  </form>
</body>
</html>