//java.io.file 클래스: 폴더 생성 후 파일 생성
package ch22.a;

import java.io.File;

public class Test07 {
	public static void main(String[] args) throws Exception {
		//폴더와 파일을 한 번에 생성하는 방법
		File file = new File("temp2/a/b/c/test.txt");
		
		//File dir = new File(file.getParent());//파일의 디렉토리 경로를 가지고 파일 객체 생성 
		System.out.println(file.getParent());//파일의 디렉토리 정보를 출력 이거가지고 디렉토리 생성한후 그다믕에 파일을 생성하면된다.
		File dir = file.getParentFile();//현재 파일의 디렉토리 정보를 가지고 파일을 만든다.
		
		//먼저 디렉토리를 생성한다.
		if (dir.mkdirs()) {
			System.out.println("디렉토리를 생성하였음");
		} else {
			System.out.println("디렉토리를 생성하지 못함");
		}
		
		
		if (file.createNewFile()) {
			System.out.println("파일이 생성됨");
		} else {
			System.out.println("파일을 생성하지 못함");
		}
//예외하고는 상관이 없다.
		
	}
}
