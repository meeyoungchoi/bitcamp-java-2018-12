<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>새 글</title>
</head>
<body>

  <jsp:include page="/header.jsp" />

  <h1>새 글(JSP)</h1>
  <form action='add' method='post'>
    <table border='1'>
      <tr>
        <th>이름</th>
        <td><textarea name='name' rows='5' cols='50'></textarea></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><textarea name='name' rows='5' cols='50'></textarea></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><textarea name='password' rows='5' cols='50'></textarea></td>
      </tr>
      <tr>
        <th>사진</th>
        <td><textarea name='photo' rows='5' cols='50'></textarea></td>
      </tr>
      <tr>
        <th>전화</th>
        <td><textarea name='tel' rows='5' cols='50'></textarea></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
      <a href='list'>목록</a>
    </p>
  </form>
</body>
</html>
