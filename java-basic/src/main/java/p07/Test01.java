package p07;

public class Test01 {
	//학생의 성적 데이터를 담을 새로운 구조의 메모리 정의
	//class 새데이터타입이름
	//변수선언
	static class Score {
		//변수선언(설계 도며이기 때문에 변수가 존재하는 상태가 아니다.)
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float aver;
	}

	public static void main(String[] args) {
		
		//클래스에 정의된 대로 인스턴스를 생성한다.
		//new 클래스명();
		//클래스 설계도에 따라 변수를 사용하려며 메모리의 주소가 있어야 한다.
		//즉, 클래스의 인스턴스 주소를 저장할 변수를 생성해야 한다.
		//클래스명 변수명;
		Score s1;//s1: Score 인스턴스 주소를 저장할 변수
		s1 = new Score();//Score 설계도에 따라 메모리(변수)를 준비시킨다.
		                     //그리고 메모리의 주소를 레퍼런스에 저장한다.
		//s1에 자장된 주소로 찾아가서 그 인스턴스의 각 변수에 값을 설정한다.
		/*Score s2 = new Score(); //s1 인스턴스의 필드 값을 설정한다.
		s2.name = "냥냥";
		s2.kor = 70;
		s2.math = 80;
		s2.eng = 100;
		*/
		//Score 클래스의 인스턴스에 값을 넣는다.
		//문법: 레퍼런스.변수명 = 값
		s1.name ="강강강";
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 90;
		
		Score s3 = new Score();
		s3.name = "남남";
		s3.kor = 80;
		s3.eng= 75;
		s3.math = 60;
		
		printScore(s3);//printScore() 메서드에 새 데이터 타입으로 만든 메모리 주소 즉 s3을전달한다.
		//그러면 printScore()메서드에 s3 주소가 전달되고   PrintScore() 메서드에서  Score 클래스의 
		//메모리주소(인스턴스 주소)를 받을 변수를 s라고 선언했다.
		//그래서 printScore()메서드의 파라미터에 s3 주소가 전송되고 
		
		Score s2 = s1; //s1에 저장된 인스턴스 주소를 s2에 복사한다.
		//메서드에 새 데이터 타입으로 만든 메모리의 주소를 전달한다.(즉, 인스턴스의 주소를 전달한다.)
		printScore(s1);
		System.out.println(s1.name);
		System.out.println(s1.aver);
		//메서드가 생성한 인스턴스의 주소를 받을 수도 있다.?
		Score s3 = createScore("유관순", 90, 90, 90);
		System.out.println(s3.name);
		
	}

	static Score createScore(String name, int kor, int math, int eng) {
		Score s = new Score();
		s.name = name;
		return s;
	}
	// 새 데이터 타입(클래스)의 메모리 주소(인스턴스 주소)를 받을 변수를 파라미터로 선언한다.
	//printScore 인스턴스를 생성한후 그 주소를 리턴한다.
	static void printScore(Score s) {
		s.sum = s.kor + s.eng + s.math;
		s.aver = s.sum /3f;
		System.out.println(s.aver);
		System.out.println(s.name);
		
	}
}
