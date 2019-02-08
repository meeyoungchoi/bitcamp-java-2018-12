package ch22.g;

import java.io.Serializable;

//sum과 aver 필드는 getter 메서드만 둔다.
//setter를 제거한다.
public class Score3 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	//serialize 대상에서 제외할 필드는 transizent로 선언한다.
	transient private int sum;
	transient private float aver;
	
	
	public Score3() {
		
		System.out.println("Score3()");
	}


	@Override
	public String toString() {
		return "Score3 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", aver="
				+ aver + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
		compute();
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
		compute();
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		System.out.println("setMath()");
		this.math = math;
		compute();
	}

	//sum과 aver 필드처럼 내부 필드 값을 가지고 계산할 결과를 
	//저장하는 경우 외부에서 직접 필드의 값을 성정하지 못하게 해야 한다.
	//setter를 만들지 마라
	public int getSum() {
		return sum;
	}

	public float getAver() {
		return aver;
	}

	public void compute() {
		this.sum = this.kor + this.eng + this.math;
		this.aver = this.sum / 3f;
	}


}
