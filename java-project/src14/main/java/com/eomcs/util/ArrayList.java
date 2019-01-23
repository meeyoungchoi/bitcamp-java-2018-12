//모든 제품명에 다룰수 있으므로
package com.eomcs.util;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class ArrayList<E> {//ArrayList를 다루는 타입이 E이다.
  //ArrayList에 멤버 리스트 보드 배열이 다 들어가있다.
  static final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;

  public ArrayList() {
    list  = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    if (a.length < size) {
      return (E[]) Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
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

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    
      return (E) list[index];
  }

  public int size() {
    //add할때마다 증가된 size호출
   return this.size;
  }
  
  @SuppressWarnings({"unchecked", "unused"})
  public E remove(int index) {
    if (index < 0 || index >= size)
    return null;
    

    E obj = (E) list[index];
    
    for (int i = index; i < size - 1; i++ ) {
      list[i] = list[i + 1];//앞방->현재방
      size--;
      
      return obj;
    }
    return obj;
 }

 

  public E set(int index, E value) {
 
    if (index < 0 || index >= size) 
      return null;
      
      @SuppressWarnings("unchecked")
      E obj = (E)list[index];
      list[index] = value;
      return obj;
    
  }
  
    
  }

