//버퍼 사용 - 사용전
//
package ch22.c;


import java.io.FileOutputStream;

//InputStream에 기능을 덧붙이는 플러그인 역할을 수행하는 클래스이다.
//이런 클래스를 데코레이터라 한다.
//데코레이터는 기능을 덧붙이는 대상 클래스와 같은 조상을 가져야 한다.
//그리고 생성자로부터 대상객체 주소를 받아야 한다.
//작업을 수행할 떄 대상 객체를 사용한다.
//그리고 자신만의 기능을 덧붙인다.
public class Test02_1 {
	public static void main(String[] args) {
			FileOutputStream out = null;
		try {
			
			out = new FileOutputStream("data.bin");
						
			System.out.println("데이터 쓰는 중...");
			
			long start = System.currentTimeMillis();
			
			for (int i = 0; i < 1000000; i++) {
				out.write(0x55);
			}
			
			long end = System.currentTimeMillis();
			System.out.println(end - start);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {out.close();} catch (Exception e) {}
		}
		
		System.out.println("출력완료");
		
	}
}
