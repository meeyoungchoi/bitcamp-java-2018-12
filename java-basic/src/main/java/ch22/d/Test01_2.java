//문자 데이터 읽기
package ch22.d;

import java.io.FileReader;
import java.io.FileWriter;

public class Test01_2 {
	public static void main(String[] args) {
		
		//filewriter
		//문자 단위로 데이터를 읽는 일을 한다.
		//
		try (FileReader in = new FileReader("data.txt")) {
			//utf-8 코드 값을 읽어서 utf-16 코드 값으로 
			//0x41 ==> 0x0041(utf-16)
			System.out.println(Integer.toHexString(in.read()));//16진수출력 utf-16으로 바꾼 문자 코드값을 리턴한다.
			
			//0x42 ==>0x00422(utf-16)
			System.out.println(Integer.toHexString(in.read()));//16진수 출력
			
			//0x43 ==> 0x0043(utf-16)
			System.out.println(Integer.toHexString(in.read()));//16진수 출력
			
			//0xeab080 ==> 0xac00(utf-16)
			System.out.println(Integer.toHexString(in.read()));//16진수 출력
			
			//0xeab081 ==> 0xac01(utf-16)
			System.out.println(Integer.toHexString(in.read()));//16진수 출력
			
			//0xeab084 ==> 0xac04(utf-16)
			System.out.println(Integer.toHexString(in.read()));//16진수 출력
            //	
			//-Dfile.encoding=문자표
			//
			//
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력완료");
	}

}
