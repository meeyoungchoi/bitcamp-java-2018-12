package com.eomcs.lms.util;

import java.util.Arrays;

public class ArrayList<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private Object[] elementData;/*elementData*/;//BoardHandler, LessonHandler. MemberHandler클래스를 다뤄야 하므로
	//이들을 모두 담을수 있는 최상위 클래스인 Object타입의 elementData배열을 만들었다.
	private int size = 0;

	public ArrayList() {
		elementData = new Object[DEFAULT_CAPACITY]; 
	}

	public ArrayList(int initialCapacity) {
		if (initialCapacity > DEFAULT_CAPACITY)
			elementData = new Object[DEFAULT_CAPACITY];
		else 
			elementData = new Object[initialCapacity];
	}

	public T[] toArray(T[] a) {//a: 배열의 타입정보(Lesson[] lesson, Board[] board, Member[] member)
		if (a.length < size) {
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());//원래 배열과 같은 타입의 배열을 배열크기(new length)에 맞춰 새로 생성한다.??
		}
		System.arraycopy(elementData, 0,a,0,size);//a의 0번쨰 부터 size까지를 elementData의 0번째 부터 넣어라
		if (a.length > size)//length: 몇번 입력했는가 size: 배열의 크기
			a[size] = null;//배열의 크기가 입력한 횟수보다 작으면 size의 남는 배열에는 null값이 들어간다.
		return a;
	}
	//T[] list = new T[size];

	//for (int i = 0; i < size; i++) {
	//list[i] =  elementData[i];
	//}
	//return list;

	public void add(T obj) {//Lesson 타입의 lesson?
		if (size >= elementData.length) {
			int oldCapacity = elementData.length;
			int newCapacity = oldCapacity + (oldCapacity << 1);
			elementData = Arrays.copyOf(elementData, newCapacity);//원래 배열과 같은 타입의 배열을 배열크기에 맞춰 새로 생성한다.
		} else
		elementData[size++] = obj;
	}

	public T get(int index) {
		if (index <0 || index >= size) {
			return null;
		} 
		return (T) elementData[index];
	}

	public T set (int index, T obj) {
	   if (index < 0 || index >= size) 
		   return null;
	   
	    T old = (T)elementData[index];
	    elementData[index] = obj;
	    return old;
	  }

	public T remove (int index) {//T: Lesson,Board,Member
		if (index < 0 || index > size)//
			return null;

	T old	= (T) elementData[index];
	int newSize = size -1;//3
	System.arraycopy(elementData, index, elementData, index, newSize - index);//
	//elementData의 index부터 제거하려는 index를 제외한 배열의 크기를 새로운 elementData의 index에 복사해라?
	elementData[size = newSize] = null;//?
	return old;
	
	}
}
