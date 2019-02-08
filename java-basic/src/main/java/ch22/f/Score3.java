package ch22.f;

import java.io.Serializable;

//java.io.Serializable
//개발자가 serialVersionUID의 값을 직접 설정할 수 있다.
public class Score3 implements Serializable{
	
	//개발자가 다음과 같이 serialVersionUID 변수 값을 지정하면
	//컴팡릴러의 경고가 뜨지 않는다.
	//Test3j_1을 실행하여 score3.data파일에 인스턴스를 출력한 후
	//이 크래스에 tel 필드와 setter/getter를 추가한다.
	//또한 toString()을 다시 생성한다.
	//이렇게 Score3 클래스를 바꾸더라도 serialVersionUID는 이전과  같은 값을 갖게 한다.
	//왜?
	//바뀐 클래스로 기존의 serialize한 인스턴스 값을 읽어 들이기 위함이다.
	//단 기존의 값을 읽어 들일 수 있는 상황이어야 한다.
	//tel 필드는 추가되었다 하더라도 기존의 성적 데이터에 영향을 끼치지 않기 때문에
	//이전 버전의 값을 그대로 읽어도 된다.
	//이런 경우에 serialVersionUID의 값을 그대로 두는 것이다.
	private static final long serialVersionUID = 100L;
	
	private String name;
	private String tel;//Test3_1을 실행한 후에 이 필드를 추가한다.
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private float aver;
	
	
	//test3_1을 실행하여 score3.data 파일에 인스턴스를 출ㄹ겨한 후
	//tel 필드를 추가하고
	//toSTring()메서드를 재생성하낟.
	
	@Override
	public String toString() {
		return "Score3 [name=" + name + ", tel=" + tel + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", aver=" + aver + "]";
	}

	public Score3() {
		System.out.println("Score2()");
	}
	

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//test3_1을 실행하여 score3.data 파일에 인스턴스를 출ㄹ겨한 후
	//tel필드를 추가하고
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		this.compute();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		this.compute();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		this.compute();
	}

	public int getSum() {
		return sum;
	}

	public float getAver() {
		return aver;
	}

	public Score3(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		compute();
	}
	
	public void compute() {
		this.sum = this.kor + this.eng + this.math;
		this.aver = this.sum / 3f;
	}
}
