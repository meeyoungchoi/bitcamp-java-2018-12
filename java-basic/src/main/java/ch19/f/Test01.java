//non-static 메서드가 활용되는 경우
package ch19.f;

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
		//
		//
		//Array는 LinkedList 객체의 주소를 참고하여 해당 값을 통해 배열을 만들어 리턴한다.
		// LinkedLIst는 
		//
		for (Object obj : arr) {
			System.out.print(obj + ",");
		}
		System.out.println();
		
		Object[] arr2 = list.toArray(LinkedList.REVERSE);
		for (Object obj2 : arr2) {
			System.out.print(obj2 + ",");
		}
		System.out.println();

		}
	
	Object[] arr3 = list2.toArray(LinkedList.REVERSE);
	for (Object obj2 : arr3) {
		System.out.print(obj2 + ",");
	}
	System.out.println();

	}
}
/*
 * 중첩 클래스
 * 어떤 클래스에 식구(멤버)로 만드는 문법이다.
 * 같은 식구가 되면 그 클래스의 모든 멤버를 자기 것처럼 사용할 수 있다.
 * 즉 접근이 쉬워 코딩하기 편하다.
 * 유지보수도 편하다.
 * 식구의 종류에는 크게 두가지가 있는데 
 * 1.static
 * =>그 집안(바깥 클래스)의 static 멤버만 사용할 수 있다.
 * 2.non static (nested class)
 * =>그 집안(바깥 클래스의 )static 멤버 뿐만 아니라 non -static 멤버도 사용할 수 있다.
 * 
 * 
 * non-static:
 * 인스턴스 필드, 인스턴스 메서드, 생성자, 인스턴스 블록
 * 인스턴스 주소가 있어야만 사용할 수 있는 멤버
 * 3.  
 * 
 * */

	
	

