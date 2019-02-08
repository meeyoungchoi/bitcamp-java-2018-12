//Serialize - Serializable 구현체의 인스턴스를 읽기
package ch22.f;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test2_2 {
	
	public static void main(String[] args) {
	
		//drserialize
		//=>저장할 떄 사용한 클래스를 가지고 인스턴스를 만든 후에 바이트 배열을 읽어 인스턴스 필드에 그대로 저장한다.
		//생성자를 호출하지 않는다.
		//저장할 때 사용한 클래스가 변경된 경우에는
		//deserialize 할 때 예외가 발생한다.
		//예) Score2 인스턴스를 저장한 후,
		//Score2 클래스를 변경하라.
		//인스턴스 필드를 추가해보라
		//그런후에 다시 읽기를 시도해보라
		//
		try (ObjectInputStream in= new ObjectInputStream(
				new FileInputStream("score2.data"))) {
			
			Score2  score = (Score2) in.readObject();
			//score.compute();
			System.out.println(score);
			
			//Score2 클래스를 번경한 후 이 클래스를 이용하여
			//serialize 된 데이터를 읽어 들이면 예외가 발생하낟.
			//예외 분석
			//java.io.serializable 구현체는 내부적으로 
			//serialVersionUID라는 스태틱 변수가 자동으로 생긴다.
			//serialize되는 데이터의 파일 버전 역할을 한다.
			//serialVersionUID 값을 개발자가 지정하지 않으면
			//컴파일할 때 자동으로 부여된다.
			//Score2 클래스 또한 이 변수가 존재하고
			//score2.data 파일로 인스턴스를 출력할 때
			//이 변수의 값이 함께 저장된다.
			//Score2 클래스를 변경하게 되면 이 변수의 값이 자동으로 새로 부여된다.
			//ObjectInputSTream.readObject()는 scor2.data 파일ㅇ르 읽을 때 함께 저장된 serailBersionUID 값과
			//deserialize 할 때 사용할 Scor2 클래스의 serialVersionUID 값을 비교하여 같다면 파일의 데이터를 읽어 인스턴스를 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
