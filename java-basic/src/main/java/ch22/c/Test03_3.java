//

package ch22.c;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Test03_3 {
	public static void main(String[] args) {
		
		//데코레이터 디자인 패턴의 장점은
		//기능을 선택적으로 붙이고 떼기가 쉽다.
		//
		try (FileOutputStream out = new FileOutputStream("data.bin");
				//버퍼 데코레이터를 붙인다. => 출력 속도가 빨라지낟.
				BufferedOutputStream out1 = new BufferedOutputStream(out);//데코레이터
				//primitive type  변환 데코레이터를 붙인다 => 특정 타입의 값을 출력하기 편하다.
				DataOutputStream out2 = new DataOutputStream(out))/*데코레이터*/ {
	
			int no = 200;
			String name = "ABC가각간갇갈";
			int age = 30;
			
			out2.writeInt(no);
			out2.writeUTF(name);
			out2.writeInt(age);
			
			out2.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력완료");
		
	}
}
