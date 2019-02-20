package ch24.d;

public class Account {
	String name;
	double balance;//잔액
	
	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	synchronized public double withdraw(double money) {//크리티컬 섹션
		//이 메서드 처럼 여러 스레드가 같은 메모리(balance 필드)의 값을 동시에 변경할 때
		//문제가 발생하는 코드를 "critical section, critical region"이라 부른다.
		//임계영역
		//크리티컬 섹션에 동시에 접근하지 못하게 하는 기법을
		//mutex 또는 세마포제로라 부른다.
		//자바에서 뮤텍스를 구현하는 방법
		//크리티컬 섹션에 해당하는 메서드나 코드 블록에 싱크로나이즈드 키워드를 붙여  한번에 한 스레드만 집입할 수 있도록 lock을 건다.메서드나 코드 블록을 지정하라
		double temp = this.balance;//
		
		if (temp - money < 0)
			return 0;//중간에 이 작업 하다가 cpu를 다른 스레드에게 뺏겨라
		
		temp = temp - money;
		
		this.balance = temp;//여기까지는 다른 스레드가 여기에 들어오지 못하게 해야 한다.
		//여러 스레드가 동시에 값을 덮어쓰게 되면 의도하지 않은대로 돌아가게 된다.
		
		return money;
	}
	
}
