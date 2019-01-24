//배열 복제를 도와주는 클래스
package ch19.e;

public class Array {
	LinkedList list;
	
	public Array(LinkedList list) {//Array?
		this.list = list;//this?
	}
	
	//입력된 순서대로 배열을 만든다.
/*	public Object[] copy() {
		Object[] arr = new Object[list.size()];//list의 사이즈 만큼 빈 배열 준비
		for (int i = 0; i < list.size(); i++ ) {
			arr[i] = list.get(i);
		}
		
		return arr;
	}
*/
	
	//입력된 순서대로 배열 만들기
	public Object[] copy() {
		Object[] arr = new Object[list.size()];//list의 사이즈 만큼 빈 배열을 준비한다.
		for (int i = 0; i < list.size(); i++) {//?
			arr[i] = list.get(i);//?
		}
		return arr;
	}
	
	
	
	
	
	
	
	//입력된 순서의 역순으로 배열을 만든다.
	/*public Object[] reverseCopy() {
		Object[] arr = new Object[list.size()];
		//값을 뒤집겠다.
		for (int i = list.size(), j = 0;  i >= 0; i--, j++) {
			arr[j] = list.get(i);
		}
		return arr;
	}*/
	
	//입력된 역순으로 배열을 만든다.
	public Object[] reverseCopy() {
		Object[] arr = new Object[list.size()]; //list의 사이즈 만큼 빈 배열을 준비한다.
		for (int i = list.size(), j = 0; i >= 0; i--, j++) {
			arr[j] = list.get(i);
		}
		return arr;
	}
}
