//예외처리 - 예외의 종류 -시스템 예외
package ch21.a;

import java.util.ArrayList;

public class Test02 {
	public static void main(String[] args) {
		ArrayList<long[]> list = new ArrayList<>();
		//예외처리
		try {
			//System.out.println(sum(100000));
			for (int i = 0; i < 1000; i++) {
				list.add(new long[1000000]); //Heap 영역에 8MB 크기의 long배열을 생성한다.
				//만약 Heap 영역의 메모리가 모두 사용된다면 
				//더이상 배열을 생성할 수 없기 때문에 시스템 예외가 발생할 거이다.
			} 
			//
		} catch (Error err) {
			//예외가 발생하면 이 블록이 실행된다.
			//
			//jvm에게 예외 상황이 보고되지 않으면 즉시 멈추지 않는다.
			//
			//시스템 예외인 경우 현재 애플리케이션 작업 결과를 저장하고 로그 파일에 예외 정보를 남긴후
			//프로그램을 종료하는 것이 좋다.
			//
			System.out.println(list.size());
			System.out.println("시스템 예외가 발생했습니다.");
		}
		
		//시스템 예외가 발생했을 때 우외 같이 적절하게 조치를 취하고 다음과 같이
		//계속 실행할 수 있지만,
		//=>가능한 예외 상황에 대해 기록을 남기고, 현재까지 작업한 내용을 보관한 후에 프로그램을 종료하라
		//시스템 예외는 애플리케이션에서 처리할 수 없다.
		//
		//위에서 Heap 메모리가 부족해서 예외가 발생했다.
		//catch 블록에서 예외를 받았다고 해서 heap의 메모리 부족 상태가 해결되는 것은 아니다.
		//메모리 부족 상태를 애플리케이션에서 처리할 수 없다.
		//이런 상황이 시스템 예외이다.
		//따라서 시스템 예외가 발생한다면, 
		//즉시 현재 애플리케이션 상태를 저장하고 애플리케이션의 작업 내용을 저장하고 
		//예외에 대한 기록을 로그 파일에 남긴 다음에 프로그램을 종료하는것이 최선의 방법이다.
		//
		list.add(new long[1000000]);//outofMemory 메모리가 부족한 상태이기 때문에 실행 오류 해결불능
		
		//System.out.println(list.size());
		System.out.println("실행완료");
		}
	
	
}
