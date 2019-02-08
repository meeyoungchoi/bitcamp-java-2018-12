//인스턴스 읽기 ObjectInputs
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test04_2 {
	public static void main(String[] args) {
		
		//Score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라
		 // => java.io.BufferedInputStream 클래스를 사용하라.
	    // => java.io.DataInputStream 클래스를 사용하라.
	    //
		//Score[] students = null;
		/*Score s1 = null;
		Score s2 = null;
		Score s3 = null;*/
		
		ArrayList<Score> students = new ArrayList<>();
		
		//
		//
		//ObjectOutputStream.writeOBJECT()로 출ㄹ겨한 바이트 배열을 읽어
		//인스턴스를 생성하는 기능이 있다.
		//JAVA.IO.SERILIZABLE 인터페이스를 구혀한 클래스여야 한다.
		//출력할 떄 버전과 읽을 때 클래스의 버전이 같아야 한다.
		//인스턴스
		//
		//따라서 
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
				new FileInputStream("score.data")))) {
			int len = in.readInt();
			//students = new Score[len];//배열을 딱 그 개수만큼 만들려구
			
			for (int i = 0; i < len; i++) {
			
			Score score = (Score) in.readObject();//레퍼런스 주소를 배열의 방에 저장한다.
			//저장한 인스턴스 필드 값을 그대로 읽을 것이기 때문에
			//sum과 aver필드의 값도 그대로 읽을 것이다.
			//따라서 compute()는 따로 
			//score.compute();
			students.add(score);
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
