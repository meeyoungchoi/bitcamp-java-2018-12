package com.eomcs.lms.util;

import java.util.Arrays;

public class ArrayList<E> {//ArrayList를 E 타입으로 다루겠다.

	static final int DEFAULT_CAPACITY = 10;
	Object[] list;//Object: 모든 자바 클래스들은 Object 클래스로부터 상속 받으므로
	                //Object 클래스의 모든 메서드와 변수는 다른 모든 클래스에서 사용가능하다.
	int size = 0;
	
	public ArrayList() {
		list = new Object[DEFAULT_CAPACITY];
	}
	
	public ArrayList(int initCapacity) {
		if (initCapacity > DEFAULT_CAPACITY)
			list = new Object[initCapacity];
		else 
			list = new Object[DEFAULT_CAPACITY];
		}
	
	@SuppressWarnings("unchecked")
	public E[] toArray(E[] a) {//a의 의미? 파라미터
		if (a.length < size) {//a.length의 의미? a변수의 length
			return (E[]) Arrays.copyOf(list, size, a.getClass());//list배열로 size만큼 배열요소의 개수를 복사한다. / a.getClass()란? 객체가 속한 클래스의 정보를 담는 메서드
				//E타입의 list배열로 size만큼의 배열요소의 개수를 복사해서 list배열이 속한 클래스로 리턴해라(즉, ArrayList클래스로 리턴해라)
		}
		System.arraycopy(list, 0, a, 0, size);//a라는 배열의 0 번지 부터 size개수 만큼 복사하여
														//list배열의 0번지부터 저장한다.
			if (a.length > size)//?a변수의 length가 size보다 크면
				a[size] = null;//a변수의 배열요소값에 null을 저장한다.
			return a;
		}
	
	public void add(Object obj) {//add메서드를 호출해라
		//Object 타입이므로 BoardList, LessonList, MemberList에 있는 add메서드를 호출한다.
		if (size >= list.length) {//size:배열의 요소의 개수가 list배열의 길이보다 크거나 같다면
			int oldCapacity = list.length;//oldCapacity에는 list의 길이를 넣는다.
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			list = Arrays.copyOf(list, newCapacity);// list배열에 newCapacity  변수를 복사해서 넣는다.
	}
	list[size++] = obj;//obj변수를  list배열의 요소 번호에 obj변수의 주소를 저장하고 배열요소의 값을 증가시킨다.
	}
}
