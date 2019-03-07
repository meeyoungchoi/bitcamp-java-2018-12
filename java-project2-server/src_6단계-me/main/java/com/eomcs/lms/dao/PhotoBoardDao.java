package com.eomcs.lms.dao;

//사진 게시판 데이터를 다룰 메서드의 규칙을 정의해놓고
	//마리아디비, 오라클에서 jdbc에서 프고르래밍하는 방법이 다르므로
	//나중에 mysql에서 오라클로 바꾸게 되면 
	//기존에 짯던 프로그램을 오라클에 맞춰서 변경해야한다.
	//그래서 규칙은 통일하데 구현체는 상황에 따라서 관리하기 위해서 인터페이스와 구현을 분리시켜야 한다.
	//mysql의 insert문과 오라클의 인서트문이 다르다. 그러므로 규칙을 정의해놓고 메서드 호출하는 부분은 분류한다.
import java.util.List;

import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {
	  //void insert(PhotoBoard photoBoard);
	  List<PhotoBoard> findAll();
	 // PhotoBoard findByNo(int no);
	 // int update(PhotoBoard photoBoard);
	  //int delete(int no);
}
