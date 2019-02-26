//src34
package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {

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
	
	public Object[] toArray() {
		return Arrays.copyOf(list, size);
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
