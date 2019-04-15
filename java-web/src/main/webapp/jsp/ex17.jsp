<%@page import="java.util.ArrayList"%>
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
<title>ex16</title>
</head>
<body>
<h1>jsp 액션 태그 - jsp:useBean (계속)</h1>
<%-- --%>
%>
<%--id가 가리키는 객체가 보관소에 없을 때
class 속성에 지정된 타입의 인스턴스를 생성한다.
그래서 class 속성에는 인터페이스나 추상 클래스를 지정할 수 없다.
왜? 인터페이스나 추상클래스는 인스턴스를 생성할 수 없기 때문에   --%>
<jsp:useBean id="list" type="java.util.ArrayList<String>" scope="page"></jsp:useBean>
<%--자바코드로 표현해보면,
java.util.ArrayList list = (java.util.ArrayList<String>) application.getAttribute("list");
if (list == null) {
list = new java.util.ArraayList<String>();
pageContext.setAttribute("list")
 --%>


<%
//제네릭 문법을 사용하지 못했기 때문에 list의 타입은 java.util.ArrayList이다.
//따라서 for 문에서 항목의 타입을 지정할 때 String으로 지정할 수 없다.
for (Object n : list) {
  out.println(n + "<br>");
}
%>

</body>
</html>
<%--
jsp:useBean (계속)

1)type 속성
-보관소에서 꺼낸 객체의 타입을 지정할 때 사용하낟..

 --%>





