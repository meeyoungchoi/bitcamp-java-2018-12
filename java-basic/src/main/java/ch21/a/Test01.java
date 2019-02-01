//예외처리 - 예외의 종류
package ch21.a;

public class Test01 {
	public static void main(String[] args) {
		
		// 1. 시스템 예외
		//=>jvm이 발생시키는 예외
		//애플리케이션에서 처리할수 없다.
		//애플리케이션의 현재 작업 결과를 적절히 저장한 후 즉시 종료해야 한다.
		//=>Error계열의 예외
		//예) java.lang.Object
		//	ㄴ java.lang.Trowable
		//   ㄴ java.lang.Error=>exception ==>java.lang.exception
		//    예)stack overflowerror, outofmemoryerror, ioerror, threaddeath=>시스템애러
		
		//애플리케이션 애러
		// ArrayIndexOutOfBoundsException,ClassNotFoundException,ClassCastException	
		//NullPointerException ioexcepion sqlexception filenotfoundexception socketexception
		//malformedurlexception runtimeexcepion ArithmeticException
		
		//애플리케이션 예외 발생시키기
		//예외를 처리하지 않으면 jvm에게 전달되고, jvm은 즉시 멈춘다.
		//
		int result = 100 / 0;
		//Exception in thread "main" java.lang.ArithmeticException: / by zero
		//at ch21.a.Test01.main(Test01.java:23)
		
		//위의 코드에서 예외가 발생하면 다음 코드를 실행할 수 없다.
		//왜? 즉시 jvm에게 예외 내용이 보고되고 
		//
		System.out.println("실행완료!");

		
		//stackOverFLowerror 발생시키기
		//=>예외를 처리하지 않으면 jvm에게 예외가 전달되고 jvm은 즉시 멈춘다.
		//jvm이 멈추기 전에 현재까지 작업한 것을 저장하고 싶다면, 예외처리 코드를 추가해야 한다.
		//System.out.println(sum(100000));//StackOverFLow발생 jvm애러
		
		//2.애플리케이션 예외
		//애플리케이션에서 발생시키는 예외이다.
		//예외처리라 함은 이 애플리케이션 예외를 다루는 것을 말한다. 
		//애플리케이션에서 예외를 처리하지 않으면 jvm은 실행을 멈춘다.
		//실행을 멈추지 않게 하려면 애플리케이션 예외가 발생했을 때 적절히 조치를 취해야 한다.
		//exception 계열의 예외이다.
	}
	
	static long sum(long value) {
		if (value == 0)
			return 0;
		
		
		return value + sum(value - 1);
	}
}




//예외클래스 계층도
