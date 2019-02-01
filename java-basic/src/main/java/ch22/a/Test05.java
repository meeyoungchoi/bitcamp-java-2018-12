//java.io.file 클래스: 파일 생성
package ch22.a;

import java.io.File;

public class Test05 {
	public static void main(String[] args) throws Exception {
		//파일의 크기가 0인 빈파일을 만든다.
		//존재하지 않는 파일을 생성함
		//이미 파일이 존재한다면 생성 못함.
		File file = new File("temp2/test.txt");
		if (file.createNewFile()) {
			System.out.println("파일이 생성됨");
		} else {
			System.out.println("파일을 생성하지 못함");
		}

		//디렉토리가 존재하지 않아도 파일을 생성하지 못함
		//예외발생=> java.io.IOException
		//즉 디렉토리가 자동으로 생성되지 않는다.
		file = new File("temp3/test.txt");
		if (file.createNewFile()) {
			System.out.println("파일이 생성됨");
		} else {
			System.out.println("파일을 생성하지 못함");
		}
	
		
	}
}
