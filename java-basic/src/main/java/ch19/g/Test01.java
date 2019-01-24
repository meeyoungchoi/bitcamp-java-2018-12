//패키지 멤버 클래스가 불편한 경우 - 익명 클래스를 사용하기 전(파일 필터 적용전)
package ch19.g;

import java.io.File;

public class Test01 {

	public static void main(String[] args) {
		//File 클래스: 파일이나 디렉토리 정보를 다루는 도구
		File dir = new File("./");//이클립스에서 실행하면 ./는 프로젝트 디렉토리를 가리킨다.
		
		//프로젝트 디렉토리에 있는 모든 파일이나 디렉토리를 검색하여 이름을 출력한다.
		String[] names = dir.list();

		for (String name : names) {
			System.out.println(name);
		}
	}

}
