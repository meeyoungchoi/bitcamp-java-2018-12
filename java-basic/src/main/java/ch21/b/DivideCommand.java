package ch21.b;

import java.util.Scanner;

public class DivideCommand implements Command{

	Scanner keyboard;
	
	public DivideCommand(Scanner keyboard) {
		this.keyboard = keyboard;
	}
	
	public DivideCommand() {
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("값1:");
		int a = Integer.parseInt(keyboard.nextLine());
		
		System.out.println("값1:");
		int b = Integer.parseInt(keyboard.nextLine());
		
		System.out.printf("%d / %d = %d\n", a, b, (a / b));
		
	}

}
