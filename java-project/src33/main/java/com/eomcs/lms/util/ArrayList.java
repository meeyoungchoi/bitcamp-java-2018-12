package com.eomcs.lms.util;

import java.util.Arrays;

import com.eomcs.lms.domain.Board;

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
	public E[] toArray(E[] a) {//?
		if (a.length < size) {//왜 length에만 a. 이 붙는가?
		return (E[]) Arrays.copyOf(list, size, a.getClass());//a.getClass()?
		}
		System.arraycopy(list, 0, a, 0, size);//?
		if (a.length > size)
			a[size] = null;//?
		return a;
	}
	
	public void add(E obj) {
		if (size >= list.length) {
			int oldCapacity = list.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			list = Arrays.copyOf(list, newCapacity);
	}
	list[size++] = obj;
	}
}
