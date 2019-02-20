package com.eomcs.lms.util;

import java.util.Arrays;

public class ArrayList<E> {

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
	public E[] toArray(E[] a) {//a의 의미?
		if (a.length < size) {//a.length의 의미?
			return (E[]) Arrays.copyOf(list, size, a.getClass());//list배열로 size만큼 배열요소의 개수를 복사한다. / a.getClass()란?
		}
		System.arraycopy(list, 0, a, 0, size);//a라는 배열의 0 번지 부터 size개수 만큼 복사하여
														//list배열의 0번지부터 저장한다.
			if (a.length > size)//?
				a[size] = null;
			return a;
		}
	
	public void add(Object obj) {
		if (size >= list.length) {
			int oldCapacity = list.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			list = Arrays.copyOf(list, newCapacity);
	}
	list[size++] = obj;
	}
}
