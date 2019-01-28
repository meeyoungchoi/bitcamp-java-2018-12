//Stack 클래스 사용법 - peek()
package ch20.b;

import java.util.Stack;

public class Test03 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		//push()
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		
		//peek()
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
	}
}
