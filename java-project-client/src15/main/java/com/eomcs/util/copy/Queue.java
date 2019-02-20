//제네릭 적용 + Cloneable
package com.eomcs.util.copy;

//Queue가 보관하는 데이터 타입을 E라고 가정하자.
//E라고 가정한 상태에서 코드를 작성한다.
//
public class Queue<E> extends LinkedList<E> implements Cloneable{

	
	public void offer(E value) {
		//상속 받은 메서드를 사용하여 값을 추가하라 
		this.add(value);
				
	}
	
	public E poll() {
		//상속 받은 메서드를 사용하여 값을 꺼내라
		return this.remove(0);
		
	}
	
	public boolean empty() {
		//상속 받은 필드나 메서드를 사용하여 값을 리턴하라
		return this.size == 0;
	}

	//복제기능 추가
	//그냥 object에서 상속 받은 clone 메서드를 오버라이딩 하면된다.
	//public 으로 공개 한다.
	//=>리턴 타입을 클래스 타입으로 변경한다.
	//클래스에 대해 복제를 허락하도록 java.lang.cloneable 인터페이스를 구현한다.
	@SuppressWarnings("unchecked")
	@Override
	public Queue<E> clone() throws CloneNotSupportedException {
		//return (Queue) super.clone();
		Queue<E> temp = new Queue<>();
		for (int i = 0; i < this.size; i++) {
			temp.add(this.get(i));
		}
		return temp;
	}
}
