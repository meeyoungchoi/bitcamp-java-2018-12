//url다루기 - 문서내부의 특정 위치를 가리키기
package ch23.h;

import java.net.URL;

public class Test08 {
	public static void main(String[] args) throws Exception {
		//웹에서 자원의 위치를 표현하는 방법
		//[프로토콜]://서버주소:포트번호/자원의경로
		//프로토콜: http, https
		//서버주소:IP주소, 서버도메인주소
		//포트번호
		//자원의 경로
		
		URL url = new URL("httl://www.bitcamp.co.kr:/80/a/b/c/index.html#side");
		
		System.out.printf("프로토콜:%s\n",url.getProtocol());
		System.out.printf("서버주소:%s\n",url.getHost());
		System.out.printf("포트번호: %d\n",url.getPort());//포트번호를 생략하면 -1을 리턴한다.
		System.out.printf("자원경로: %s\n",url.getPath());//
		System.out.printf("내부위치: %s\n",url.getRef());//=>side : html안에서 특정 위치를 가리킬때 사용
	}
}
