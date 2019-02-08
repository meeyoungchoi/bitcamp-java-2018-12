//인스턴스 읽기 - 배열 활용
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test02_2 {
	public static void main(String[] args) {
		
		//Score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라
		 // => java.io.BufferedInputStream 클래스를 사용하라.
	    // => java.io.DataInputStream 클래스를 사용하라.
	    //
		Score[] students = null;
		/*Score s1 = null;
		Score s2 = null;
		Score s3 = null;*/
				
		try (//FileInputStream in = new FileInputStream("score.data");
			//	BufferedInputStream in1 = new BufferedInputStream(in);
				DataInputStream in = new DataInputStream(
						new BufferedInputStream(
						new FileInputStream("score.data")))) {
			int len = in.readInt();
			students = new Score[len];//배열을 딱 그 개수만큼 만들려구
			
			for (int i = 0; i < students.length; i++) {
				Score s = new Score();
			//s = new Score();
			s.setName(in.readUTF());
			s.setKor(in.readInt());
			s.setEng(in.readInt());
			s.setMath(in.readInt());
			students[i] = s;//레퍼런스 주소를 배열의 방에 저장한다.
			}
			
			
			/*s2 = new Score();
			s2.setName(in.readUTF());
			s2.setKor(in.readInt());
			s2.setEng(in.readInt());
			s2.setMath(in.readInt());
		
			
			s3 = new Score();
			s3.setName(in.readUTF());
			s3.setKor(in.readInt());
			s3.setEng(in.readInt());
			s3.setMath(in.readInt());*/
			//Score s2 = new Score(in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
		//	Score s3 = new Score(in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
			  
			for (Score s : students) {
			System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
					s.getName(),s.getKor(),s.getEng(),s.getMath(),s.getSum(),s.getAver());
			
			}
		/*System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
					s2.getName(), s2.getKor(), s2.getEng(), s2.getMath(), s2.getSum(), s2.getAver());

				
			System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
			s3.getName(), s3.getKor(), s3.getEng(), s3.getMath(), s3.getSum(), s3.getAver());
				*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("저장완료");
		
		
		
		//그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라
		//=>홍길동, 100, 100, 100, 300, 100
		//
	}
}
