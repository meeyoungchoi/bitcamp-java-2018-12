package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
 

  static final int DEFAULT_CAPACITY = 10;

  Lesson[] list;
  int size = 0; //lessonIdx

  public LessonList() {
    list = new Lesson[DEFAULT_CAPACITY];
  }
  
  public LessonList(int initialCapacity) {//추가 하려는 데이터
    if (initialCapacity > DEFAULT_CAPACITY) {
      list = new Lesson[initialCapacity];
    } else {
      list = new Lesson[DEFAULT_CAPACITY];
          }
    }
  
  public Lesson[] toArray() {
    return Arrays.copyOf(list, size); //original, new Length
    
    /*
    Lesson[] list = new Lesson[size];
    for (int i = 0; i < size; i++) {
        list[i] = lessons[i];
    }
    return list;
  }
  */
  }
  
  //새로운 데이터를 추가 할때
  public void add(Lesson lesson) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
    }
  }
}

    

