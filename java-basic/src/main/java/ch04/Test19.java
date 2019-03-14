// 비트연산자 응용
// 
package ch04;

public class Test19 {
	public static void main(String[] args) {
		//한 개의 정수 값에 여러 개의 정보를 저장하기
		//비트에 1 또는 0을 이용하여 정보를 표현할 수 있다.
		//예: 개발자가 프로그래밍 가능한 언어를 int 값으로 표현해 보자
		//java : 0000 0000 0000 0001 = 0x01
		//c: 0000 0000 0000 0010 = 0x02
		//c++: 0000 0000 0000 0100 = 0x04
		//python: 0000 0000 0000 1000 = 0x08
		//php: 0000 0000 0001 0000 = 0x10
		//kotlin: 0000 0000 0010 0000 = 0x20
		//groovy 0000 0000 0100 0000 = 0x40
		//java script 0000 0000 1000 0000 = 0x80
		// TypeScript   : 0000 0001 0000 0000 = 0x0100
		//go 0000 0010 0000 0000 = 0x02
		//sql 0000 0100 0000 0000  = 0x04
		//r 0000 1000 0000 0000 = 0x08


		//java와 c, c++ java script를 할 줄 아는 개발자의 정보를 설정하라
		int d1 = 0x01 | 0x02 | 0x04 | 0x80; //0x01 | 0x02 | 0x04 | 0x80를 or 연산해서 나온 결과다. 0000 0000 1000 0111
		int d2 = 0x0087;//1000 0111를 16진수 한것이다.

		System.out.println(d1);
		System.out.println(d2);

		//정수 값에서 특정 비트의 값만 검사하는 방법
		//0000 0000 0001 0111 (여러 프로그래밍 언어에 대해 설정된 값)
		//여기서 타입 스크립트 언어를 할줄 아는지 검사하기
		//  0000 0000 0001 0111
		// & 0000 0001 0000 0000(typescript 값을 조사하려는 값과 &(AND) 한다.)
		//-----------------------------------------------(조사 하려는 값에 0비트를 and 하면 무조건 0으로 만든다. )
		// 0000 0000 0000 0000 (조사하려는 값에 1을 and 하면 원래 값 그대로 리턴한다.)
		//and 결과 값을 검사 값과 같은지 비교하면 된다.
		// 0000 0000 0000 0000(:결과값)
		//0000 0001 0000 0000(:타입스크립트 여부를 조사하는 값)
		//즉 결과 값과 조사한 값이 같지 않으면 해당 비트가 0이라는 의미다.
		//즉 검사값과 결과값이 다르면 false가 된다.

		//d2중 자바를 할수 있냐?
		System.out.printf("java: %b\n", (d2 & 0x0001) == 0x0001 );
		System.out.printf("c: %b\n", (d2 & 0x0002) == 0x0002 );
		System.out.printf("c++: %b\n", (d2 & 0x0004) == 0x0004 );
		System.out.printf("python: %b\n", (d2 & 0x0008) == 0x0008 );
		System.out.printf("php: %b\n", (d2 & 0x0010) == 0x0010 );
		System.out.printf("kotlin: %b\n", (d2 & 0x0020) == 0x0020 );
		System.out.printf("groovy: %b\n", (d2 & 0x0040) == 0x0040 );
		System.out.printf("javascript: %b\n", (d2 & 0x0080) == 0x0080 );
		System.out.printf("typescript: %b\n", (d2 & 0x0100) == 0x0100 );
		System.out.printf("go: %b\n", (d2 & 0x0200) == 0x0200 );
		System.out.printf("sql: %b\n", (d2 & 0x0400) == 0x0400 );
		System.out.printf("r: %b\n", (d2 & 0x0800) == 0x0800 );
		
		System.out.println("------------------------------------------------------------");
		//값이 같지 않으면 어차피 결과는 0이다.
		//그래서 다음과 같이 검사해둬 된다.
		System.out.printf("java: %b\n", (d2 & 0x0001) != 0 );
		System.out.printf("c: %b\n", (d2 & 0x0002) != 0 );
		System.out.printf("c++: %b\n", (d2 & 0x0004) != 0);
		System.out.printf("python: %b\n", (d2 & 0x0008) != 0);
		System.out.printf("php: %b\n", (d2 & 0x0010) != 0);
		System.out.printf("kotlin: %b\n", (d2 & 0x0020) != 0);
		System.out.printf("groovy: %b\n", (d2 & 0x0040) != 0);
		System.out.printf("javascript: %b\n", (d2 & 0x0080) != 0);
		System.out.printf("typescript: %b\n", (d2 & 0x0100) != 0);
		System.out.printf("go: %b\n", (d2 & 0x0200) != 0);
		System.out.printf("sql: %b\n", (d2 & 0x0400) != 0);
		System.out.printf("r: %b\n", (d2 & 0x0800) != 0);
	}
}

















