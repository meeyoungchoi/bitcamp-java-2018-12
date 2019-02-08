//정리

package ch22.c;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test05 {
	public static void main(String[] args) {
		//IO Stream 클래스의 역할에 따른 분류
		//1)data sink stream class
		// 파일이나 메모리에서 직접 데이터를 읽고 쓰는 클래스
		//파일: FileInputStream/FileOutputStream, FileReader/FileWriter
		// 메모리:
		//ByteArrayInputStream / ByteArrayOutputStream
		//CharArrayReader/CharARrayWriter
		//StringReader/StringWriter
		//프로세스: 다른 프로그램과 연결되어 데이터를 읽고 쓴다.
		//PipedInputStream/PipedOutputStream
		//pipedReader/PipedWriter
		//
		//
		//2) data processing stream class
		// 데이터를 
		//데코레이터 역할을 수행한다.
		//java.io.filterinputstream/filteroutputstream의 서브 클래스이다.
		//filterreader/filterwirter의 서브 클래스이다.
		//data sink stream class 제외한 모든 클래스
		//예;
		//BufferedInputStream, BufferedOutputStream
		//BufferedR BufferedW
		//Datais dos
		//objis, objos
		//
		//바이너리 스트림과 문자 스트림 클래스
		//1.binary stream class
		//바이트 단위로 데이터를 다루는 클래스
		//inputstream/outputstream의 서브 클래스이다.
		//보통 클래스 이름이  inputstream outputstream로 끝난다.
		//2. character string class
		//문자 단위로 데이터를 다루는 클래스이다.
		//데이터를 입출혁 할 때 utf-16을 다른 문자표의 코드 값으로 자동 변환해 준다.
		//reader/writer의 서브 클래스이다.
		//보통 클래스 이름이 reader writer로 끝난다.
		//
		
	}
}
