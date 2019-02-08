//Serialize - 
package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test2_1 {
	
	public static void main(String[] args) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("score2.data"))) {
			
			//
			
			//Score2 클래스는 java.io.Serializable을 구현하였다.
			//즉 serialize가 허락
			//이제 writeObject()를 사용하여 객체를 serialize 할수 있다.
			//Score2 클래스에 tel필드와 getter/setter 가없는 상태에서 
			//이 클래스를 실행하라
			//
			out.writeObject(new Score2("홍길동", 100, 100, 100));
			
			System.out.println("출력완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
