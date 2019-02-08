//String 읽기 -BufferedReader 붙이기
package ch22.d;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.CharBuffer;

public class Test03_2 {
	public static void main(String[] args) {
		
		//filewriter
		//문자 단위로 데이터를 읽는 일을 한다.
		//
		try (FileReader in = new FileReader("data.txt");
				//데코레이터를 붙인다.
				//버퍼 기능 + 한줄 읽기 기능
				BufferedReader in2 = new BufferedReader(in)) {
		
			System.out.println(in2.readLine());
			//CharBuffer cbuf = CharBuffer.allocate(1024);
			//int len = in.read(cbuf);
		
			//System.out.println(len);
			
			//System.out.println(cbuf.get(0));
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("일기완료");
	}

}
