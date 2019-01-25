package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.List;

public class BoardHandler {
  //보드핸들러 입장에서는 
  Scanner keyboard;
  List<Board> list;
  
  public BoardHandler(Scanner keyboard, List<Board> list) {
	  
    this.keyboard = keyboard;
    this.list = list;
    //this.list = new LinkedList<>();
    
    //다음과 같이 이 클래스가 사용할 리스트 객체를 LinekdList로 결정해버리면 
    //list 사용 규칙을 따르는 다른 객체로 쉽게 변경할 수 없다.
    //다른  list 객체로 변경하려면 이 클래스의 생성자 코드를
    //어떤 기능을 변경할 때마다 소스 코드를 변경하는 방식은 유지보수에 좋지 않다.
    //해결책
    //이 클래스으ㅔ서 어떤 list객체를 사용할 것인지 결정하지 말고
    //이 클래스를 사요하는 쪽에서 결정하도록 유도하라
    //즉 생성자에서 list객체를 준비하지 말고 파라미터로 주입 받아라
    //이렇게 자기가 작업하는데 필요한 사용하는 도구를 의존객체(dependency)라 부른다.
    //그리고 의존 객체를 자기가 생성하지 않고 외부로부터 주입받는 것을 
    //의존 객체 주입(dependenct injection)이라고 부른다.
    //
    //이 클래스에서 의존 객체를 결정하지 말자
   // this.list = new LinkedList<>();
    //
    
  }
  
  public void listBoard() {
	Board[] boards = new Board[list.size()];
	 list.toArray(boards);
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    list.add(board);
    
    System.out.println("저장하였습니다.");
  }

  public void detailBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }

    Board board = (Board) list.get(index);

    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
  }
  
  public void updateBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    Board board = list.get(index);
    
    try {
      // 기존 값 복제
      Board temp = board.clone();
      
      System.out.printf("내용? ");
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setContents(input);
      
      list.set(index, temp);
      
      System.out.println("게시글을 변경했습니다.");
      
    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
  
  public void deleteBoard() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
  
  private int indexOfBoard(int no) {
    for (int i = 0; i < list.size(); i++) {
      Board b = (Board) list.get(i);
      if (b.getNo() == no)
        return i;
    }
    return -1;
  }
}
