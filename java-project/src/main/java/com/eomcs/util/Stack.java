package com.eomcs.util;

public class Stack {
	public static final int DEFAULT_SIZE = 5;
	
	Object[] list;
	int size;
	
	public Stack() {
		list = new Object[DEFAULT_SIZE];
	}
	
	public void push(Object value) {
		//맨 마지막에 추가한다.
		//배열의 크기가 작다면 확장해야 한다.
		if (size == list.length) {
			Object[] arr = new Object[list.length + (list.length >> 1)];
		for (int i = 0; i < this.size; i++) {
			arr[i] = list[i];
			}
		list = arr;
		}
	list[size++] = value;
}
	
	public Object pop(Object value) {
		//맨 마지막 값을 꺼내 리턴한다.
		//배열의 크기가 작다면 확장해야 한다.
		if (size == 0)
			return null;

		return list[--size];
	}
	

	public boolean empty() {
		return false;
	}
	
	public int size() {
		return this.size;
	}
}
