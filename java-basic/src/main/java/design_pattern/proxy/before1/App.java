/*
 * #1단계 - 데스크톱용 계산기 애플리케이션 만들기
개발자는 Calculator 클래스를 직접 호출하여 사용한다.
이때는 app이 calculator를 직접 제어한다.
 * */
package design_pattern.proxy.before1;

public class App {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		System.out.println(calc.plus(100, 200));
		System.out.println(calc.minus(100, 200));
	}

}
