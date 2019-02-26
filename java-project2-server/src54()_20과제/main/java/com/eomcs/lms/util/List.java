package com.eomcs.lms.util;

public interface List<E> {
	Object[] toArray();
	<T> T[] toArray(T[] a);
	void add(E obj);
	  E get(int index);
	  E set(int index, E obj);
	  E remove(int index);
	  int size();
}
