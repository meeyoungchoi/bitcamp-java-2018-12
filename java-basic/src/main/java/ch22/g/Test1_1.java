//Serialize - 인스턴스 필드의 값 출력: getter/setter없는 경우
package ch22.g;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {
	
	public static void main(String[] args) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("score1.data"))) {
			
			Score1 score = new Score1();
			score.name = "홍길동";
			score.kor= 100;
			score.eng= 100;
			score.math= 100;
			score.sum= score.kor + score.eng + score.math;
			score.aver = score.sum / 3f;
			
			//인스턴스 출력하기
			out.writeObject(score);
			
			System.out.println("출력완료");
			
			//getter/setter 없어도 필드 값을 읽는데 문제 없다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
