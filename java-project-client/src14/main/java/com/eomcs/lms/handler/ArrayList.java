package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList<E> {

  static final int DEFAULT_CAPACITY = 10;


  Object[] list;
  int size = 0;

  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
    /*
    E[] arr = Arrays.copyOf(sampleArr, size);
    for (int i = 0; i < size; i++) {
      arr[i] = (E) list[i];
    }
    return arr;
    */
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
  
    // index : 값을 꺼낼 배열의 항목 위치
    // 그러면 Lesson배열의 요소번호가 index이다.
    //그러면 E 타입의  ArrayLIst에서 Lesson배열의 인덱스를 가져온다.
    //그러면 그 가져온 Lesson배열의 인덱스를 넣어줄 배열이 필요하다.
    //Lesson배열의 인덱스에서 가져온 값을 넣어줄 배열명은 list[size]이다.
    //그러면 만약에 Lesson배열에 들어있값이 없으면 리턴을 해주면 안된다.
    //배열의 index에 아무것도 없으면 안되고 size 크기 만큼의 배열은 있어야 한다.
    //그래야 값을 가져올수 있다.
    if (index  < 0 || index > size  ) {//retun 되는게 없어야된다.
      return null;
    } else {//index요소 번호가 0보다 크거나 index요소가 size보다 작으면 배열의 요소 값을 가져온다.
        //그러면 E 타입의  ArrayLIst에서 Lesson배열의 인덱스를 가져온다.
      //Lesson배열의 인덱스에서 가져온 값을 넣어줄 배열명은 list[size]이다.
      return (E) list[size];
      //(E) 얘를 왜 붙이는 걸까?
      
    }
    //하지만 Lesson배열에 값이 들어있으면 그배열의 값을 list[size]에 넘겨줘야 한다.
    

    
  }
  // index : 값을 변경할 배열의 항목 위치 //value : 해당 위치에 있는 값을 대체할 값  // 리턴 값 : 대체되기 전의 기존 값
  //Lesson에서 가져와서 list[size]로 옮겨진 배열중 특정 항목을 변경한다.
  public E set(int index, E value) {
   
    //그러면 list[size]에서 특정 항목을 뽑아내야한다.
    //(E) list[size]에 들어있는 항목중 어떤 특정한 값을 뽑아내야한다
    //String tmp = list[index].get(index);
    
    
    
    
    
    
    //그리고 그 뽑아낸 항목의 내용을 바꿔줘야한다.
    
    
    return null;
  }
  
  public E remove(int index) {
    // index : 삭제할 배열의 항목 위치
    // 리턴값: 삭제된 이전 값
    // 힌트: System.arraycopy() 참고! 
    return null;

  }
}
