<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>새 글</title>
</head>
<body>

<jsp:include page="/header.jsp"/>

  <h1>새 글(JSP)</h1>
  <form action='add' method='post'>
    <table border='1'>
      <tr>
        <th>수업</th>
        <td><textarea name='title' rows='5' cols='50'></textarea></td>
      </tr>
         <tr>
        <th>내용</th>
        <td><textarea name='contents' rows='5' cols='50'></textarea></td>
      </tr>
            <tr>
        <th>시작일</th>
        <td><textarea name='startDate' rows='5' cols='50'></textarea></td>
      </tr>
            <tr>
        <th>종료일</th>
        <td><textarea name='endDate' rows='5' cols='50'></textarea></td>
      </tr>
           <tr>
        <th>일 수업시간</th>
        <td><textarea name='dayHours' rows='5' cols='50'></textarea></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
      <a href='list'>목록</a>
    </p>
  </form>
</body>
</html>
