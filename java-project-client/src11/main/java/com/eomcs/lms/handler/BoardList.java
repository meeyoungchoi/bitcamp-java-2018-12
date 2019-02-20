package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

public class BoardList {
  static final int LENGTH = 10;
  BoardList list = new BoardList();//처음부터 인스턴스 필드로 만드는것이 기본이다.(클래스 문버이란 메서드를 묶는것이다 라는것이 전달이 안된다.)
  static int boardIdx = 0;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
    public void listBoard() {
      
      Board[] a = new Board[size];
      for (int i =0; i < size; i++ ) {
        a[i] = this.array[i];
      }
      return null;
    }
    
    public void add(Board board) {
      if [size == arr.lengtn] {//배열의 사이즈가 꽉 찼다면
        //새 배열을 만들어라
        Board[] a = new Board[arr.length + arr.length >> 1]; 
        for( int i = 0; i < arr.length; i++) {
          a[i] = arr[i];
      }
      arr = a;
      System.out.printf("배열 증가 함: %d\n" ,);
      
    }
      arr[size++] = board;
}
