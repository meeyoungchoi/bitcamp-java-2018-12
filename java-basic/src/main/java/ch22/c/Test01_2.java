//버퍼 사용 - 사용후
package ch22.c;

import java.io.FileInputStream;


public class Test01_2 {
	public static void main(String[] args) {
		//배열 값 출력
		try {
			//1.데이터 출력을 담당할 객체를 생성한다.
			FileInputStream in = new FileInputStream("jls11.pdf");
			
			System.out.println("데이터 읽는중");
			
			long start = System.currentTimeMillis();
			
			byte[] buf = new byte[1000];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				//if (++count % 1000  == 0)
					//System.out.print(".");
				//if (count % 20000 == 0)
					//System.out.println();
			}
			
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력완료");
		
	}
}
