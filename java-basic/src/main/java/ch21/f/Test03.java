//try - with  resources 문법 사용전
package ch21.f;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
	
	static class MyResource1 {
		public void close() {
			System.out.println("MyResource1.close()");
		}
	}
	
	static class MyResource2 implements AutoCloseable {
		@Override
		public void close() {
			System.out.println();
		}

		public char[] divide(int i, int j) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		try (
				//java.l
				//MyResource1 r1 = new MyResource1();
				MyResource2 r2 = new MyResource2();
				) {
			System.out.println(r2.divide(10,2));
			System.out.println(r2.divide(10,0));
			
			//
			
			
			} catch (Exception e) {
				System.out.println("예외발생!");
			}
		}
	
	
}
