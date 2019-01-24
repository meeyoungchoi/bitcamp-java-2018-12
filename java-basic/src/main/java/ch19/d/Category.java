//static nested class 문법을 응용
package ch19.d;


//상수를 관리하는 용도로만 사용될 클래스라면 서브 클래스를 만들지 못하도록 막야야한다.
//final modifier 제한자를 사용하라
//final modifer:상수를 관리하는 용도로만 사용된 클래스에서는 서브 클래스를 만들지 못하도록 막기 위해 final modifer를 사용한다.
public  final class Category {
	
	//static nested class 문법이 필요한 이유?
	//  작은 클래스를 패키지 멤버 클래스로 만들면 소스 파일이 너무 많이 생기기 떄문에 관리하기가 번거롭다
	//예
	//computer.java mouse.java appliance.java book.java=>어느 한 클래스안에 static 중첩 클래스로 작성하면 소스 파일을 관리하기 쉽다.
	//
	//이렇게 작은 크기에 클래스가 많은 경우 
	//어느 한 클래스 안에   static 중첩 클래스로 작성하는 것이 
	// 소스 파일을 관리하기 쉽게 도와준다.
	//
	//분류의 각 계층을 static 중첩 클래스로 선언하여 관리한다.
	//
	//
	public final static class computer {
		
		public final static class mouse {
			public static final int bluetooth = 111;
			public static final int gaming = 112;
			public static final int wired = 113;
			public static final int trackball = 114;
		}
		

	public static final int keyboard = 102;
	public static final int monitor = 103;
	public static final int cpu = 104;
	public static final int ram = 105;
	public static final int vga = 106;
	}
	
	public final static class appliance {
	public static final int tv = 201;
	public static final int audio = 202;
	public static final int dvd = 203;
	public static final int vacuum = 204;
	}
	
	public final static class book {
	public static final int poet = 301;
	public static final int nover = 302;
	public static final int essay = 303;
	public static final int it = 304;
	public static final int lang = 305;
	}
}
