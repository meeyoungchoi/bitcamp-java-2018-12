package p10;
class Monitor10 {
	int bright;
	int contrast = 50;
	int widthRes;
	int heightRes = 1080;
	
	Monitor10() {
		//다른 생성자를 호출할 수 있다.
		//반드시 첫번째 문자응로 작성해야 한다.
		this(50, 50, 2560, 1200);
		System.out.println("Monitor10()");
	}
	
	Monitor10(int bright, int contrast, int widthRes, int heightRes) {
		this.bright = bright;
		this.contrast = contrast;
		this.widthRes = widthRes;
		this.heightRes = heightRes;
		System.out.println("Monitor10(int, int, int ,int)");
	}
	
	Monitor10(int bright, int contrast) {
		this(bright, contrast, 0, 0);
		System.out.println("Monitor10(int, int)");
	}
}
class Monitor9 {
	int bright;
	int contrast = 50;
	int widthRes;
	int heightRes = 1080;
	
	Monitor9() {
		this.bright = 50;
		this.contrast = 50;
		this.widthRes = 2560;
		this.heightRes = 1200;
		System.out.println("Monitor9()");
	}
	
	Monitor9(int bright, int contrast) {
		this.bright = bright;
		this.contrast = contrast;
		System.out.println("Monitor9(int, int)");
	}
	
	Monitor9(int bright, int contrast, int widthRes, int heightRes) {
		this.bright = bright;
		this.contrast = contrast;
		this.widthRes = widthRes;
		this.heightRes = heightRes;
		System.out.println("Monitor9(int, int, int, int)");
	}
	
	public void on() {
		System.out.println("화면을 출력한다.");
	}
}
class Monitor8 {
	int bright;
	int contrast = 50;
	int widthRes;
	int heightRes = 1080;
	//만약 생성자가 한 개라도 있으면 컴파일러는 기본 생성자를 추가하지 않는다.
	Monitor8(int bright, int contrast) {
		this.bright = bright;
		this.contrast = contrast;
	}
	
	public void on() {
		System.out.println("화면을 출력한다.");
	}
}
class Monitor7 {
	int bright;
	int contrast = 50;
	int widthRes;
	int heightRes = 1080;
	
}
class Monitor6 {
	int bright;
	int contrast;
	int widthRes;
	int heightRes = 1080;
	
	//기본생성자
	//파라미터가 없는 생성자
	Monitor6() {
		this.bright = 50;
		this.contrast = 50;
		this.widthRes = 250;
		this.heightRes = 1200;
	}
	
	public void on() {
		System.out.println("화면을 출력한다.");
	}
	
}
public class Test08 {
	public static void main(String[] args) {
		//파라미터가 없는 생성자를 호출할 경우 괄호를 표시한다.
		new Monitor6();
		new Monitor7();
		//존재하는 생성자를 지정해야 하고, 그 생성자의 파라미터에 맞춰 값을 넘겨야 한다.
		new Monitor8(50, 50);
		new Monitor9(50, 50, 1920, 1080);
		
		//인스턴스 생성
		new Monitor10();
		System.out.println("-------------------------------");
		
		new Monitor10(50, 50);
		System.out.println("----------------------------------");
		
		new Monitor10(50, 50, 1920, 1080);
		
		//생성자를 일반 메서드처럼 임으로 호출할 수는 없다.
	}
}
