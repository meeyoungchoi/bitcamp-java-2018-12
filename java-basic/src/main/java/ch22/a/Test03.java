//java.io.file 클래스: 디렉토리 생성
package ch22.a;

import java.io.File;

public class Test03 {
	public static void main(String[] args) throws Exception {

	//생성할 디렉토리 정보를 준비한다.
		File dir = new File("temp");//그 경로에 디렉토리가 생성된다.
		dir.mkdir();//리턴값: t,f
		if (dir.mkdir()) {
			System.out.println("디렉토리 생성됨");
		} else {
			System.out.println("디렉토리 생성못함");
		}
		
		//존재하지 않는 폴더 아래에 새 폴더를 만들 때
		//존재하지 않는 폴더가 자동 생서오디지 않느다.
		//다라서 그 하위 폴더를 생성할 수 없다.
		//
		dir = new File("temp2/ok");//그 경로에 디렉토리가 생성된다.
		dir.mkdir();//리턴값: t,f
		if (dir.mkdir()) {
			System.out.println("디렉토리 생성됨");
		} else {
			System.out.println("디렉토리 생성못함");
		}
		
		// 존재하지 않는 상위 폴더를 자동으로 생성하는 방법
		//mkdirs()
		dir = new File("temp3/ok");//그 경로에 디렉토리가 생성된다.
		if (dir.mkdirs()) {
			System.out.println("디렉토리 생성됨");
		} else {
			System.out.println("디렉토리 생성못함");
		}
		
	}
}
