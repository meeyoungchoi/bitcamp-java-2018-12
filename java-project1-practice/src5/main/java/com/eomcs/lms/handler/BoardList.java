//16과제
package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {

  static final int DEFAULT_CAPACITY = 10;

  Board[] list;
  int size = 0;

  public BoardList() {
    list = new Board[DEFAULT_CAPACITY];
  }
  
  public BoardList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY) {
      list = new Board[initialCapacity];
    } else {
      list = new Board[DEFAULT_CAPACITY];
          }
  }
  
  public Board[] toArray() {
    return Arrays.copyOf(list, size);
  }
  
  //새로운 데이터를 추가 할때
  public void add(Board board) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
    }
  }

}
