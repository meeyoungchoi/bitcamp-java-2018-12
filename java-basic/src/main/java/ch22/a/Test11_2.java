//java.io.file 클래스: file 필터 사용하기
package ch22.a;

import java.io.File;
import java.io.FileFilter;

public class Test11_2 {
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
		
		//하위 파일이나 디렉토리의 상세 정보 알아내기
		File[] files = file.listFiles(new TextFileFilter());//디렉토리안에 있는 파일 목록을 리턴한다.
		for (File f : files) {
			System.out.printf("%s %12d %s\n",f.isDirectory() ? "d" : "-"
				,f.length(),
				f.getName());
		}
		
	}
}
