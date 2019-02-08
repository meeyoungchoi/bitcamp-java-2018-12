//문자 데이터 출력하기
package ch22.d;

import java.io.FileWriter;

public class Test01_1 {
	public static void main(String[] args) {
		
		//filewriter
		//
		//
		try (FileWriter out = new FileWriter("data.txt")) {
			
			out.write('A'); //=>0X41 1바이트 출력
			out.write('B'); //=>0X42 1바이트 출력
			out.write('C'); //0X43 1바이트 출력
			out.write('가');//0XEAB080 3바이트 출력
			out.write('각');//0XEAB081 3바이트 출력
			out.write('간');//0XEAB084 3바이트 출력
			
			//character stream 클래스 filewriter는 
			//문자 데이터를 출력할 떄 자바 내부에서 문자열을 다룰 때 사용하는 utf-16코드를
			//os의 기본 character set 코드로 값을 변환하여 출력한다.
			//
			//linux. macos의 기본 character set => utf-8
			//windows의 기본 characer set ms949
			//
			//따라서 같은 프로그램을 어느 os에서 실행하느냐에 따라
			//출력되는 코드 값이 달라진다.
			//
			//os에 상관없이 동일한 characterset으로 출력하고 싶다면
			//jvm을 실행할 때 file.encoding 프로퍼티에 character set 이름을 지정하라
			//예 java-Dfile.encoding-utf-8 클래스명
			//단, character set을 지정할 때는 해당 os에서 사용가능한 문자표여야 한다.
			//ms windows에서는 ms949 문자표를 사용할 수 있지만
			//리눅스나 macos에서는 ms949 문자표를 사용할 수 없다.
			//왜? 국제 표준이 아니기 때문이다.
			//결론
			//무슨 os를 사요하든지 출력할 때는 가능한 국제 표준인 utf-8을 사용하라
			//
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력완료");
	}

}
