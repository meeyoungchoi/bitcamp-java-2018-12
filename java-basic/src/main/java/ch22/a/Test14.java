//java.io.file 클래스: 연습과제 - bin/main 폴더를 뒤져서 모든 클래스 파일의 이름을 출력하라
//클래스 이름을 출력할 때 패키지 이름을 포함해야 한다.
		//ch01.Testt01
		//ch22.a.Test14
		//재귀호출
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test14 {

	public static void main(String[] args) throws Exception {
		
		File file = new File("bin");
		findClass(file,"");
		System.out.println("파일찾기 완료");
	}
	
	static void findClass(File dir, String packageName) {

		File[] files = dir.listFiles(pathname ->
		pathname.isDirectory() || (pathname.isFile() && pathname.getName().endsWith(".class"))
				? true : false);
		
		for (File file : files ) {
			if (file.isFile()) {
				System.out.printf("%s%s\n", packageName,
						file.getName().replace(".class",""));
				file.delete();
			} else {
				findClass(file,packageName + file.getName() + ".");
				//delete(file);
				}
			}
		}
	}
