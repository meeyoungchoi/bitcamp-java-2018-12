// Object 클래스 - clone() 1.(사용법).
package ch15;

//clone(): 인스턴스를 복제할 때 호출하는 메서드이다.
public class Test16 {
	
	//인스턴스 복제 기능을 활성화 하려면 Clonable 인터페이스를 구현해야 한다.
	//이 인터페이스에는 메서드가 선언되어 있지 않다.
	//따라서 클래스는 따로 메서드를 구현할 필요가 없다.
	//=>Cloneable을 구현하는 이유는 jvm에게 이 클래스의 인스턴스를 복제할 수 있음을 표시하기 위함이다.
	//
	//인스턴스를 복제할 때는 
	//Object에서 상속 받은 clone()을 호출해야 한다.
	//그런데 clone()의 접근 제어가 protected 이라서
	//같은 패키지의 멤버이거나 서브 클래스 만이 호출할 수 있다.
	//다른 패키지의 멤버가 호출하려면 public으로 접근제어의 범위를 넓혀야 한다.
	//어떻게? 오버라이딩 하라
	static class Score implements Cloneable {
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
		
		//자바에서 제공하는 인스턴스 복제 기능을 사용하려면
		//java.lang.Cloneable 인터페이스 규칙을 따라야 한다.
		//Object에서 상속 받은 clone()을 오버라이딩 하여 다른 패키지의 멤버도 사용할 수 있게
		//public으로 접근 범위를 넓혀라
		//오버라이딩은 접근 범위를 좁힐수는 업
		//오버라이딩 할때 리턴 타입을 클래스 타입으로 변경해도 된다.
		@Override
		public Score clone() throws CloneNotSupportedException {
			// 복제를 위한 코드를 작성할 필요가 없다.JVM이 알아서 해준다.
			//그냥 상속 받은 메서드를 호출하라
			return (Score) super.clone();
		}
	}
  public static void main(String[] args) throws Exception{
	  Score s1 = new Score("홍길동",100, 100, 100);
	  //System.out.println(s1);
	  
	  //인스턴스 복제
	  //Object에서 상속받은 clone()은 protected 접근 제한이 있다.
	  
	  //해결책
	  //직접 복제하라
	  //Score s2 = new Score(s1.name, s1.kor, s1.eng, s1.math);
	 // s2.name = "홍길동";
	  Score s2 = s1.clone();//java.lang.CloneNotSupportedException:오류
	  //즉 Score 클래스는 개발자가 복제를 허락하지 않았다는 뜻이다.
	  // implements Cloneable예를 해줘야 한다.
	  s2.name = "임꺽정";
	  System.out.println(s1);
	  System.out.println(s2);
	  
	  
  }
}







