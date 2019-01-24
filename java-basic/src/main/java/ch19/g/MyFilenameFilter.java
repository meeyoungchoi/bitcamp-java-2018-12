package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

//File (클래스의 인스턴스 메서드인 list())  .list() 메서드에서 사용할 FilenameFileter 를 만든다.
//file.list(): 클래스의 인스턴스 메서드인 list() 메서드에서 사용할 filenamefilter를 만든다.
public class MyFilenameFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		if (name.endsWith(".txt"))
			return true;
		else
			return false;
	}

}
