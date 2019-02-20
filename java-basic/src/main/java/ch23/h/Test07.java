//test01 복습
package ch23.h;

import java.net.URL;

public class Test07 {
	public static void main(String[] args) throws Exception {
		/*
		 * 웹에서 자원의 위치를 표현하는 방법
		 * [프로토콜]: //서버주소: 포트번호/자원의경로
		 * 프로토콜:http, https
		 * 서버 주소: IP주소, 서버도메인주소
		 * 포트번호:
		 * 자원의 경로: /index.html, board/list.do
		 * 
		 * 
		 * */
		
		//자바에서 url 저장하기
		URL url = new URL("http://www.bitcamp.co.kr:80/index.php?main_page=home&articleId=100");
		//?뒤가 쿼리스트림이다.
		//url에게 던져주는 값
		
		System.out.printf("프로토콜: %s\n",url.getProtocol());
		System.out.printf("서버주소: %s\n",url.getHost());
		System.out.printf("포트번호: %s\n",url.getPort());
		System.out.printf("자원경로: %s\n",url.getPath());
		
		//queryString
		//자원경로(path) 다음에 오는 파라미터
		//형식: 파라미터명=파라미터값&파라미터명=파라미터값&파라미터명=파라미터값&파라미터명=파라미터값
		System.out.printf("QueryString: %s\n",url.getQuery());
	}
}
