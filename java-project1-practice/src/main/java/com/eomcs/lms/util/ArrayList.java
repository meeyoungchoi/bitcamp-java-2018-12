//18과제 : 제넥릭 적용
package com.eomcs.lms.util;

import java.util.Arrays;

public class ArrayList<T> {
  static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size = 0;

  public ArrayList() {
    elementData  = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      elementData = new Object[initialCapacity];
    else
      elementData = new Object[DEFAULT_CAPACITY];
  }

  public T[] toArray(T[] a) {
    if (a.length < size) {
      return (T[]) Arrays.copyOf(elementData, size, a.getClass());
    }
    System.arraycopy(elementData, 0, a, 0, size);
    if (a.length > size) 
      a[size] = null;
    return a;
  }

  public void add(Object obj) {
    if (size >= elementData.length) {
      int oldCapacity = elementData.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      elementData = Arrays.copyOf(elementData, newCapacity);
    }

    elementData[size++] = obj;
  }
}
