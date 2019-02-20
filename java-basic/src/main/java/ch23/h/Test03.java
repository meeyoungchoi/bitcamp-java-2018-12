//url다루기 - os의 파일시스템 가리키기
package ch23.h;

import java.net.URL;

public class Test03 {
	public static void main(String[] args) throws Exception {
		//파일 시스템
		//[프로토콜]://서버주소:포트번호/자원의경로
		//예 file:///c:/Users/bitcamp/a.html
	
		//URL 형식으로 파일시스템의 자원을 가리키기(for Windows)
		URL url = new URL("file:///c:/Users/bitcamp/a.html");//?쿼리스트림: url에게 던져주는 값
		
		System.out.printf("프로토콜: %s\n",url.getProtocol());
		System.out.printf("서버주소: %s\n",url.getHost());
		System.out.printf("포트번호: %d\n",url.getPort());//포트번호를 생략하면 -1을 리턴한다.
		System.out.printf("자원경로: %s\n",url.getPath());//
		//System.out.printf("내부위치: %s\n",url.getRef());//=>side : html안에서 특정 위치를 가리킬때 사용
		
		System.out.println("==========================================================");
		//URL 형식으로 파일시스템의 자원을 가리키기(for Unix) 드라이브 지정하지 않는다.
		url = new URL("file:///home/bitcamp/a.html");//?쿼리스트림: url에게 던져주는 값
		
		System.out.printf("프로토콜: %s\n",url.getProtocol());
		System.out.printf("서버주소: %s\n",url.getHost());
		System.out.printf("포트번호: %d\n",url.getPort());//포트번호를 생략하면 -1을 리턴한다.
		System.out.printf("자원경로: %s\n",url.getPath());//
		//System.out.printf("내부위치: %s\n",url.getRef());//=>side : html안에서 특정 위치를 가리킬때 사용
	}
}
