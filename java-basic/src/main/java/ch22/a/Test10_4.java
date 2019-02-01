//java.io.file 클래스: 필터 사용하기2
package ch22.a;

import java.io.File;
import java.io.FilenameFilter;

public class Test10_4 {
	
	public static void main(String[] args) throws Exception {
			
		File file = new File(".");
		
		//anonymous class 익명클래스
		//메서드가 한 개짜리인 경우 lambda 표현식을 사용할 수 있다.
		//문법:
		//   (파라미터, 파라미터,...) -> 문장 한개
		//	(파라미터,파라미터,...) -> {문장1, 문장2, 문장3}
		// () -> 문장 한개
		// () -> {문장1; 문장2; 문장3;}
		String[] names = file.list((File dir, String name) -> { 
				if (name.endsWith(".txt"))
					return true;
				else 
					return false;
		});
		for (String name : names) {
			System.out.println(name);
		}
	}
}