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
<h1>jsp 액션 태그 - jsp:useBean (계속)</h1>
<%--보관소에 저장된 객체 꺼내기 --%>
<%
application.setAttribute("s1", "홍길동");
session.setAttribute("s2","안중근");
pageContext.setAttribute("s4", "윤봉길");
%>

<jsp:useBean id="s1" type="java.lang.String" scope="application"></jsp:useBean>
<%--자바코드로 표현해보면,
java.lang.String s1 = (String)application.getAttribute("s1");
 --%>
<jsp:useBean id="s2" type="java.lang.String" scope="session"></jsp:useBean>
<jsp:useBean id="s3" type="java.lang.String" scope="reqeust"></jsp:useBean>
<jsp:useBean id="s4" type="java.lang.String" scope="page"></jsp:useBean>
<%--보관소에 없는 객체를 꺼내려 하면 예외 발생! --%>
<jsp:useBean id="s5" type="java.lang.String" scope="page"></jsp:useBean>

<%=s1 %><br>
<%=s2 %><br>
<%=s3 %><br>
<%=s4 %><br>

</body>
</html>
<%--
jsp:useBean (계속)

1)type 속성
-보관소에서 꺼낸 객체의 타입을 지정할 때 사용하낟..

 --%>






