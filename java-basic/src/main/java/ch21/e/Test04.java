//사용자 정의 예외 정보 출력하기 3.
package ch21.e;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test04 {
	
	
	public static void main(String[] args) throws Exception{
		Scanner keyboard = null;
		
		try {
			keyboard = new Scanner(System.in);
			System.out.print("값1?");
			int a = Integer.parseInt(keyboard.nextLine());
			
			int result = sum(a);
			System.out.println(result);
		} catch (Exception e) {
			
			StringWriter out = new StringWriter();//출력된 값을 문자열로 보관한다.
			PrintWriter out2 = new PrintWriter(out);
			
			//상세 오류 정보를 String으로 받기
			e.printStackTrace(out2);
			
			out2.close();
			out.close();
			
			//StringWriter 객체에 저장된 문자열 꺼내기
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
