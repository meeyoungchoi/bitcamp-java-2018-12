package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[] {});
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    list.add(lesson);

    System.out.println("저장하였습니다.");
  }
  
  //addLesson에 입력된 값을 꺼내서 보여줘야 한다.
  //Lesson배열의 인덱스 값을 list[size]로 옮겼다.
  //list[index] 요소에 값이 저장되어있다.
  //index: 값을 꺼낼 배열 항목의 위치
  public void detailLesson() {
   //list[index]의 요소 중에서 특정 요소의 번호를 입력을 받아야 한다.
    System.out.print("번호?");
    //입력받은 번호를 출력해야 한다.
    int no =Integer.parseInt(keyboard.nextLine());
    //입력받은 번호가 출력되면 list배열의 입력받은 번호의 요소에 해당하는 입력되어있는 값을 보여줘야 한다.
    //이 입력받은 번호에 해당하는 입력된 내용을 보여줘야 한다.
    //입력받은 번호에 해당하는 값은 어디에서 온거지?
    //list[index]에 저장된 내용이 번호가 입력되었을때 보여져야 한다.
    //이 list[index]에 들어있는 배열은 Lesson배열이다.
    //그러면 Lesson배열에서 index를 뽑아와서 그 내용을 int no에 저장해야 한다.
    //index값은 lesson 배열에 들어있는 값중 하나이다.
    //근데 그 index값은 사용자가 입력한 번호에 해당하는 index를 뽑아오는 거다.
    //lesson배열의 요소 중에서 사용자가 입력한 번호에 해당하는 그 요소를 가져와야 한다.
    int index = indexOflesson(no);
    //lesson배열에서 사용자가 입력한 번호에 해당하는 값이 index에 저장이된것이다.
    
    //만약 Lesson의 배열 크기가 10이라고 했을때 배열의 요소값은(0~19) 그런데
    //사용자가 입력한 값이 배열 요소의 크기 값을 벗어난 값을 입력하게 되면 
    //그 입력받은 배열 방 번호가 없다라고 알려줘야 한다.
    //배열의 크기의 요소값은 몇번까지 일지는 모르지만 어쨌든 양수이다.
    //만약에 사용자가 입력한 번호가 음수가 되면 배열의 요소 번호는 음수가 없으니까 잘못된 번호라고 알려줘야한다.
    if (index == -1 ) {
      System.out.printf("입력한 번호에 해당하는 내용이 없습니다.");
      
    } else {//사용자가 입력한 번호가 배열의 요소값의 범위에 있는 번호일 경우
      //그 번호에 해당하는 index의 내용을 보여줘야 한다.
      //이 index를 가져와야 한다. 그러면 이 index 값이 get으로 보내져야한다.
      //그래서 get(int index) 메서드로 간다.
      Lesson lesson = list.get(index);
      //그러면 그 lesson에 들어있는 index에 해당하는 내용을 출력해주면 된다.
    //  System.out.printf("수업명: %s",lesson.set(index));
      
    }
    
  }
  
  

  private int indexOflesson(int no) {
    // TODO Auto-generated method stub
    return 0;
  }

  public void updateLesson() {
    
  }
  
  public void deleteLesson() {
    
    
  }
}
