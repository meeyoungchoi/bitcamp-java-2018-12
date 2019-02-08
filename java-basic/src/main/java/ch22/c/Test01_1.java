//버퍼 사용 - 사용전
//
package ch22.c;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01_1 {
	public static void main(String[] args) {
		//System.out.println(0xff);
		//배열 값 출력
		
		try {
			//1.데이터 출력을 담당할 객체를 생성한다.
			FileInputStream  in = new FileInputStream("jls11.pdf");
		
			System.out.println("데이터 읽는 중...");
			
			long start = System.currentTimeMillis();
			
			int b;
			
			while ((b = in.read()) != -1) {
				//b를 더이상 읽어들일수 없다면?
				//-1이 되면 더이상 읽어들일게 없으므로 while문을 끝낸다.
			}
			
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
		
		System.out.println("출력완료");
		
	}
}
