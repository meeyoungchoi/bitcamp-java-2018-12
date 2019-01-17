package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

class LessonList {
  static final int LENGTH = 10;
  static Lesson[] lessons = new Lesson[LENGTH];
  int lessonIdx = 0;
  
  public Lesson[] toArray() {
    return null;
  }
  
  public void add() {//void:리턴하는 값이 없다.
    
  }
  //생성자 호출할때는 void를 안쓴다.
  LessonList() {
    
  }
}
