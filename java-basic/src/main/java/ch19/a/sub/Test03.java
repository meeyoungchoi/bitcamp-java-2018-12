//중첩 클래스와 접근제어
package ch19.a.sub;

public class Test03 {
	//중첩 클래스도 멤버이기 때문에 필드나 메서드처럼 접근 제한자를 붙일수 있다.
	public static class A1 {}
	static class B {}
	protected static class A3 {}
	public static class A4 {}
	
	private class B1 {}
	class B2 {}
	protected class B3{}
	public class B4{}
	
	public static void main(String[] args) {
		//로컬 클래스는 로컬 변수와 같은 조건을 갖는다.
		class c1 {}
		//private class C2{} //오류! 로컬 변수에 접근 제한자를 붙일 수 없듯이 로컬 클래스도 불가능하다.

	}
	
}



	



