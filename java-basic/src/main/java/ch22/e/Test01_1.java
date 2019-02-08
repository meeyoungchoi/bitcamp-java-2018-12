//인스턴스 출력하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test01_1 {
	public static void main(String[] args) {
		
		//다음 세 학생의 성적 정보를 score.data 파일에 바이너리 형식으로 저장하라
	    // => java.io.BufferedOutputStream 클래스를 사용하라.
	    // => java.io.DataOutputStream 클래스를 사용하라.
	    //
		Score s1 = new Score("홍길동", 100, 100, 100);
		Score s2 = new Score("임꺽정", 90, 90, 100);
		Score s3 = new Score("유관순", 80, 80, 80);
		
		try (																//버퍼가 꽉차면 파일 아웃풋 스트림을 통해서 최종ㅈㄱ으로 출ㄹ겨한다.
				DataOutputStream out = new DataOutputStream//decorator
				(new BufferedOutputStream(//decorator
				new FileOutputStream("score.data")))) {//원래 객체
			
			//기존의 값을 가지고 계산하는 경우 계산된 값은 저장하지 않는다.
			out.writeUTF(s1.getName());
			out.writeInt(s1.getKor());
			out.writeInt(s1.getEng());
			out.writeInt(s1.getMath());
			
			out.writeUTF(s2.getName());
			out.writeInt(s2.getKor());
			out.writeInt(s2.getMath());
			out.writeInt(s2.getEng());
			
			out.writeUTF(s3.getName());
			out.writeInt(s3.getKor());
			out.writeInt(s3.getMath());
			out.writeInt(s3.getEng());
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
