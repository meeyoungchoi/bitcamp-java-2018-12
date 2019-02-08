//인스턴스 출력하기 - ObjectOutputStream 데코레이터 사용하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test04_1 {
	public static void main(String[] args) {
		

		ArrayList<Score> students = new ArrayList<>();
		students.add(new Score("홍길동", 100, 100, 100));
		students.add(new Score("임꺽정", 90, 90, 90));
		students.add(new Score("유관순", 80, 80, 80));

		//ObjectOutputStream
		//
		//인스턴스를 바이트 배열로 만들어 출력하는 기능이 있다.
		//단 java.io.Serizable~~~
		
		
		try (	ObjectOutputStream out = new ObjectOutputStream//decorator
				(new BufferedOutputStream(//decorator
				new FileOutputStream("score.data")))) {//원래 객체
			
			out.writeInt(students.size());//students배열이 몇번 저장되었는지를 보여준다.?
			
			
			for (/*int i = 0; i < students.length; i++*/ Score s : students) {//배열 전체를 반복할때
				out.writeObject(s);
			//out.writeUTF(s.getName());
			//out.writeInt(s.getKor());
			//out.writeInt(s.getEng());
			//out.writeInt(s.getMath());
			}
			/*out.writeUTF(s2.getName());
			out.writeInt(s2.getKor());
			out.writeInt(s2.getMath());
			out.writeInt(s2.getEng());
			
			out.writeUTF(s3.getName());
			out.writeInt(s3.getKor());
			out.writeInt(s3.getMath());
			out.writeInt(s3.getEng());*/
			out.flush();
			
//			System.out.printf("%s,%d,%d,%d\n",s1.getName(), s1.getMath(), s1.getMath(), s1.getKor());
//			System.out.printf("%s,%d,%d,%d\n", s2.getName(),s2.getKor(), s2.getMath(), s2.getEng());
//			System.out.printf("%s,%d,%d,%d\n", s3.getName(), s3.getKor(), s3.getMath(), s3.getEng());
			//int score = out2.writeInt();
			//String name = in2.readUTF();
			
			
			
			
		//out.close();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력완료");
	}
}
