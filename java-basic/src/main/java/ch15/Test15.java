// Object 클래스 - clone() 1.(사용법).
package ch15;

//clone(): 인스턴스를 복제할 때 호출하는 메서드이다.
public class Test15 {
	
	static class Score {
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float aver;
		
		public Score() {
			
		}
		public Score(String name, int kor, int eng, int math) {
			this.name = name;
			this.eng = eng;
			this.kor = kor;
			this.math = math;
			this.sum = this.eng + this.kor + this.math;
			this.aver = this.sum / 3f;
		}

		@Override
		public String toString() {
			return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum
					+ ", aver=" + aver + "]";
		}
	}
  public static void main(String[] args) {
	  Score s1 = new Score("홍길동",100, 100, 100);
	  System.out.println(s1);
	  
	  //인스턴스 복제
	  //Object에서 상속받은 clone()은 protected 접근 제한이 있다.
	  
	  //해결책
	  //직접 복제하라
	  Score s2 = new Score(s1.name, s1.kor, s1.eng, s1.math);
	  s2.name = "홍길동";
	  
	  //
	  System.out.println(s1);
	  System.out.println(s2);
	  
	  //해결책2.
	  //object에서 상속 받은 clone()을 오버라이딩 하라!
	  //=>16.java
  }
}







