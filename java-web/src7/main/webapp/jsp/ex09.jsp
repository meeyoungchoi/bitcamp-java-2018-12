<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex09</title>
</head>
<body>
<h1>지시문(directive element) - taglib</h1>
<c:forEach items="홍길동,임꺼정,유관순,안중근,윤봉길,김구,김원봉" var="n">
<!-- 값 한개를 꺼낸서 n이라는 이름으로 젖아하고 반복하라 -->
이름=<%=pageContext.getAttribute("n")%><br>
</c:forEach> 
</body>
</html>
<%--
taglib 지시문
=>외부에 따로 정의된 jsp 확장 태그를 가져올 떄 사용한다.
=>jsp 확장 태그 
1) jstl(jsp standart tag library)
  -jsp 명세에 추가로 정의된 태그이다.
  Servlet/jsp api에서는 jstl구현체를 제공하지 않는다.
  -따로 구현된 라이브러리를 다운로드 받아야 한다.
  -보통 apache.org 사이트에서 구현한 것을 사용한다.
2) 갭라자가 정의한 태그
  -개발자가 따로 태그를 정의할 수 있다.
  -그러나 실무에서는 유지보수의 일관성을 위해 jstl과 같은 표준 api를 사용한다.
  -즉 개발자가 자신의 회사에서만 사용할 태그를 따로 정의하지 않는다.

=>사용법
 <% taglib uri="확장 태그를 정의할 때 부여한 확장 태그 uri" prefix="확장태그를 사아ㅛㅇ할 떄 븉이는 버두사" %>
 jsp 페이지에서 사용하기
 <확장_태그_ 접두사:사용자태그명 속성명="값" .../>
--%>








