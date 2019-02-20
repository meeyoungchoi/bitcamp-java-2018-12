package ch24.d;

public class ATM extends Thread {
	
	String title;
	Account account;
	
	public ATM(String name, Account account) {
		//this.title = title;
		super(name);
		this.account = account;
	}
	
	@Override
	public void run() {
		double sum = 0;
		while (true) {
			double money = account.withdraw(100);
			
			if (money == 0)
				break;
			
			sum += money;
		}
		System.out.printf("%s 에서 찾은 금액 합계:%.2f\n", this.getName(), sum); //this.getName(): 스레드 이름을 가져와서 출력
	}
}
