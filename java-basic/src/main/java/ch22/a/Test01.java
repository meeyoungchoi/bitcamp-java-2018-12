//java.io.file 클래스: 폴더 다루기
package ch22.a;

import java.io.File;

public class Test01 {
	public static void main(String[] args) throws Exception {
		//file 클래스
		//디렉토리나 파일을 다룰 때 사용하는 클래스
		//디렉토리나 파일을 생성, 삭제, 변경 할 수 있다.
		
		//현재 디렉토리를 조회
		//이클립스: '.'으로 펴현한다. 프로젝트 디렉토리를 가리킨다.
		//콘솔: 현재 명령어를 실행하는 위치를 가리킨다.
		//
		File dir = new File("../../teacher/java-basic");
		System.out.println(dir.getName());//폴더명
		System.out.println(dir.getPath());//경로
		System.out.println(dir.getAbsolutePath());//절대경로
		System.out.println(dir.getCanonicalPath());//계산된 경로(../..)을 계산해서 표현
		
		//디렉토리가 존재하지 않는 경우 크기는 0이 나온다.
		System.out.println(dir.getTotalSpace());//HDD 전체 용량?
		System.out.println(dir.getFreeSpace());//그 중에서 빈용량
		System.out.println(dir.getUsableSpace());//빈용량 중에서 사용할 수 있는 용량
		
		//디렉토리가 존재하지 않는 경우 리턴값은 false이다.
		System.out.println(dir.isDirectory());//디렉토리 여부 확인
		System.out.println(dir.isFile());
		System.out.println(dir.isHidden());
		System.out.println(dir.exists());
		System.out.println(dir.canExecute());//그 안으로 들어갈수 있다? 실행할수 있는지
		
		System.out.println("-----------------------------------------");
		
		dir = new File(".");
		System.out.println(dir.getName());//폴더명
		System.out.println(dir.getPath());//경로
		System.out.println(dir.getAbsolutePath());//절대경로
		System.out.println(dir.getCanonicalPath());//계산된 경로(../..)을 계산해서 표현
		
		//디렉토리가 존재하지 않는 경우 크기는 0이 나온다.
		System.out.println(dir.getTotalSpace());//HDD 전체 용량
		System.out.println(dir.getFreeSpace());//그 중에서 빈용량
		System.out.println(dir.getUsableSpace());//빈용량 중에서 사용할 수 있는 용량
		
		//디렉토리가 존재하지 않는 경우 리턴값은 false이다.
		System.out.println(dir.isDirectory());//디렉토리 여부 확인
		System.out.println(dir.isFile());
		System.out.println(dir.isHidden());
		System.out.println(dir.exists());
		System.out.println(dir.canExecute());//그 안으로 들어갈수 있다
	
		
		
	}
}
