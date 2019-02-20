// 프록시 패턴 적용 -BoardDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardDao {
//runtimeException은 인터페이스에 선언하든 안하든 의미가 없다.

  void insert(Board board); //예외를 던진다고 안되있다.
  //인터페이스에서는 예외를 던질수 없다.

  List<Board> findAll(); 

  Board findByNo(int no);

  int update(Board board); 

  int delete(int no);

}







