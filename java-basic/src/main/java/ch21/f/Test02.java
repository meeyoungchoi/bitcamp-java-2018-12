//try - with  resources 문법 사용전
package ch21.f;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
	
	
	public static void main(String[] args) throws Exception{
		//자바에서 제공하는 자원들 중에서는 쓰고 난 다음에 해제시켜야 하는 자원이 있다.
		//
		//한정된 자원인 경우 특히 다른 프로그램이 사용할수 있도록 해제시킨다.
		//Scanner 객체나 FileWriter, pritWriter 객체가 이에 해당한다.
		//
		//한정된 자원을 사요하는 경우
		//그래서 자원을 해제시킬 떄 주로 try ~ catch ~ finally에서 처리한다.
		Scanner keyboard = null;
		
		try {
			keyboard = new Scanner(System.in);
			System.out.print("값1?");
			int a = Integer.parseInt(keyboard.nextLine());
			
			int result = sum(a);
			System.out.println(result);
		} catch (Exception e) {
			
		 StringWriter out = new StringWriter();//출력된 값을 문자열로 보관한다.
		 PrintWriter	out2 = new PrintWriter(out);
			
			//상세 오류 정보를 String으로 받기
			e.printStackTrace(out2);
			
			out2.close();
			try {
				out.close();
			} catch (Exception e2) {
				//
				//예외를 받기만 하고 특
			}
			out.close();
			
			//
			String str = out.toString();
			System.out.println(str);
			
		} finally {
		keyboard.close();
		
		}
	}
	
	static int sum(int value) {//f(x) = n + f(n -1)
		if (value == 1)
			return 1;
		return value + sum(value - 1);
	}
	
	
}
