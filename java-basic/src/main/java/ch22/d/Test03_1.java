//String 출력하기
package ch22.d;

import java.io.FileWriter;

public class Test03_1 {
	public static void main(String[] args) {
		
		//filewriter
		//
		//
		try (FileWriter out = new FileWriter("data.txt")) {
			
			char[] chars = {'A', 'B', 'C', '홍','길','동', '0', '1', '2'};
			out.write("ABC가각간012#!?");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력 완료");
	}

}
