package com.eomcs.lms.domain;

import java.util.Arrays;

public class ArrayList {
	
	static final int DEFAULT_CAPACITY = 10;

	Object[] elementData;//BoardHandler, LessonHandler. MemberHandler클래스를 다뤄야 하므로
	//이들을 모두 담을수 있는 최상위 클래스인 Object타입의 elementData배열을 만들었다.
	int size = 0;
	
	public ArrayList() {
		this.elementData = new Object[size]; 
	}
	
	public ArrayList(int initialCapacity) {
		if (initialCapacity > DEFAULT_CAPACITY)
			elementData = new Object[DEFAULT_CAPACITY];
		else 
			elementData = new Object[initialCapacity];
	}
	
	public Object[] toArray() {
		//return Arrays.copyOf(elementData, size);
		Object[] list = new Object[size];
		
		for (int i = 0; i < size; i++) {
			list[i] =  elementData[i];
		}
		return list;
	
	}
	
	public void add(Object obj) {
		if (size >= elementData.length) {
			int oldCapacity = elementData.length;
			int newCapacity = oldCapacity + (oldCapacity << 1);
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
		elementData[size++] = obj;
	}
}
