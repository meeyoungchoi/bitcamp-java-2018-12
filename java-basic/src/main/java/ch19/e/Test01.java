//패키지 멤버 클래스가 불편한 경우를 살펴보자
package ch19.e;

public class Test01 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		
		LinkedList list2 = new LinkedList();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		list2.add(40);
		list2.add(50);
		list2.add(60);
		
		//list에 들어있는 값을 배열로 꺼내보자
		Object[] arr = list.toArray(LinkedList.FORWARD);//list에게 너가 갖고있는 값을 배열로 리턴해줄래?
		//1.LinkedList에게 배열을 달라고 요청한다.
		//LinkedList는 Array에게 자신의 주소를 알려주면서
		//자신이 갖고있는 값을 꺼내 배열을 만들어 달라고 요청한다.
		//Array는 LinkedList 객체의 주소를 참고하여 해당 값을 통해 배열을 만들어 리턴한다.
		// LinkedLIst는 
		//
		for (Object obj : arr) {
			System.out.print(obj + ",");
		}
		System.out.println();
		
		Object[] arr2 = list.toArray(LinkedList.REVERSE);
		for (Object obj : arr2) {
			System.out.print(obj + ",");
		}
		System.out.println();

		}
	//?
	Object[] arr3 = list2.toArray(LinkedList.REVERSE);
	for (Object obj : arr3) {
		System.out.print(obj + ",");
	}
	System.out.println();

	}
}
	
	

