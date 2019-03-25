package ch30.e;

import org.springframework.stereotype.Component;

@Component //일반 적인 객체는 컴퓨넌트
public class X {
	
	public String hello1(String name) {
		System.out.println("X.hello()");
		return name + "님 반갑습니다.";
	}

	public int calculate(int i, int j, String op) {
		System.out.println("X.calculate()");
		switch (op) {
		case "+": return i + j;
		case "-": return i - j;
		case "*": return i * j;
		case "/": return i / j;
		default:
			throw new RuntimeException("지원하지 않는 연산자 입니다.");
		}
	}
}
