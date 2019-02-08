package ch22.c;

import java.io.IOException;
import java.io.InputStream;

//InputStream에 기능을 덧붙이는 플러그인 역할을 수행하는 클래스이다.
//=> 이런 클래스를 데코레이터(decorator)라 한다.
//=> 데코레이터는 기능을 덧붙이는 대상 클래스와 같은 조상을 가져야 한다.
// 그리고 생성자에게 대상 객체 주소를 받아야 한다.
// 작업을 수행할 때 대상 객체를 사용한다.
// 그리고 자신만의 기능을 덧붙인다.
public class BufferedInputStream extends InputStream{//캡슐화(encapsulation)
	
	InputStream in;
	byte[] buf = new byte[1024];
	int size = 0;
	int cursor = 0;//버퍼를 가리킨다.
	
	public BufferedInputStream(InputStream in) {
		this.in = in;
	}
	
	public int read() throws IOException {
		//
		if (cursor >= size ) {//buf에 있는 데이터를 다 읽은 후 cursor가 각 방에 접근해서 리턴해준다.
			size = in.read(buf);//읽은 개수를 리턴한다.read()메서드를 통태서 buf를 읽은 개수를 size에 저장한다.
			if (size == -1)//cursor와 size가 같을때 더 이상 읽을게 없다는 의미이다. 
				return -1;
			cursor = 0; //읽을게 남아있다면
		}
		
		
		//바이트의 값을 온전히 4바이트 int값으로 변환하기 위해
		//0x00000ff 값을 & 비트연산 한다.
		//참고 0xff 상수 값은 0x00000ff를 의미한다.
		return buf[cursor++] & 0xff;//비트연산자
	}

	
}
