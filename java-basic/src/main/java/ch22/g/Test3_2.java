//Serialize - private 인스턴스 필드의 값을  읽어서 채우기 :getter/setter
package ch22.g;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test3_2 {
	
	public static void main(String[] args) {
	
		
		try (ObjectInputStream in= new ObjectInputStream(
				new FileInputStream("score3.data"))) {
			
		
			Score3 score = (Score3) in.readObject();
			System.out.println(score);
			
			//transient 필드느 ㄴ보안상 serialize되지 않았기 때문에
			//deserialize 한 후 계산을 다시 해야 한다.
			//파일ㅇ르 조작해서 합계와 평균을 왜곡하는 상황을 막을 수 있다.
			score.compute();
			System.out.println(score);
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
