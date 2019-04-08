<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구동 원리</title>
</head>
<body>

<h1>jsp 구동 원리</h1>
<pre>
1) 웹브라우저 ==> 서블릿 컨테이너
  -jsp 실행 요청
  예) http://localhost:8080/java-web/jsp/ex01.jsp
2) 서블릿 컨테이너가 실행
  2.1 JSP의 서블릿 객체를 찾는다.
  2.2 있으면,
    2.2.1 그 서블릿 객체를 호출한다.
  2.3 없으면,
  2.3.1jsp 엔진을 이용하여 jsp 파일을 가지고 서블릿 자바 소스 파일을 생성한다.
  2.3.2자바 컴파일ㅇ러를 이용하여 소스 파일을 컴파일 한다.
  2.3.3서블릿 객체를 생성한다.
  2.3.4그 서블릿 객체를 호출한다.
  2.4jsp 파일이 변경된 상태 라면,
   2.4.1다시 "2.3"을 반복한다.
 3) 서블릿 컨테이너 ==> 웹 브라우저
  -서블릿 실행 결과를 응답
jsp 파일을 가지고 생성한 서블릿 소스와 클래스 파일(.class)의 위치
-org.eclipse.wst.server.cor/tmpx/work/...

정리
-jsp 파일은 python이나 php 처럼 직접 그 스크립트가 인터프리팅 되는 것이 아니다.
-jsp 엔진의 역할을 jsp 파일을 분서하여 섭르릿 클래스를 생성하는 것이다. (init() 호출)
-즉 jsp 파일이 직접 실행되지 않는다.

jsp
-자바 서블릿 클래스를 만드는 재료로 사용된다.
-그래서 서블릿 클래스를 만드는 틀 이라 해서 템플릿 이라 부른다.
-jsp를 템플릿 기술이라 부르기도 한다.

jsp 공부법
-jsp를 작성할 때 사용하는 트겆ㅇ 태그들이 어떤 자바 코드를 생성하는지 이해하는 것이 중요하다.

jsp 실행을 요청하기
-jsp 팡리이 있는 위치를 지정한다.
예)http://localhost:8080/java-web/jsp/ex01.jsp

jsp를 변경한 후 실행을 요청하기
-그냥 jsp 파일이 있는 위치를 지정하면 된다.
-위에서 설명한대로 jsp 구동 원리에 따라 동작된다.


</pre>
</body>
</html>