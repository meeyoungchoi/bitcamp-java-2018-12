//Serialize - ObjectOutputSTream을 사용하여 인스턴스 필드의 값을 출ㄹ겨하기
package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {
	
	public static void main(String[] args) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("score1.data"))) {
			
			//
			
			//wirtObject(인스턴스의 주소)
			//=>모든 인스턴스 필드를  바이트 배열로 만들어 출력한다.
			// 인스턴스의 필드 값들을 바이트 배열로 만드는 것을 "직렬화(serialize=marshaling)"라 부른다.
			//반대로 바이트 배열을 가지고 인스턴스를 만드는 것을 "객체화(deserialize=unmarshaling)"라 부른다.
			//=>단 serializ를 허락한 객체에 한 해서만 작업한다.
			//java.io.serializable 인터페이스의 구현체에 대해서만 작업 가능하다,
			//만약 허락되지 않은 겍체에 대해 이 메서드를 호출하면
			//notSErailizableException 예외 발생
			out.writeObject(new Score1("홍길동", 100, 100, 100));
			
			//Score1 클래스는 java.io.serializable을 구현하지 않았기 때문에
			//writeObject()를 사용할수 없다.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
