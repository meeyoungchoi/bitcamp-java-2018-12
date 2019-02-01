//java.io.file 클래스: 람다표현식 연습
package ch22.a;

import java.io.File;
import java.io.FileFilter;

public class Test11_4 {
	//
	static class TextFileFilter implements FileFilter {

		@Override
		public boolean accept(File pathname) {
			if (pathname.isFile() && pathname.getName().endsWith(".txt"))
				return true;
			else 
				return false;
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		
		//파일은 디렉토리와 파일을 통칭하는 용어이다.
		File file = new File(".");
		
		//
		File[] files = file.listFiles((File pathname) -> {
			if (pathname.isFile() && pathname.getName().endsWith(".txt"))
				return true;
			else 
				return false;
			
		});
		for (File f : files) {
			System.out.printf("%s %12d %s\n",f.isDirectory() ? "d" : "-"
				,f.length(),
				f.getName());
		}
	}
}
