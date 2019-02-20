package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
        Lesson lesson = LessonAgent.get(no, in, out);
      
        // 기존 값 복제
        Lesson temp = lesson.clone();
        
        System.out.printf("내용? ");
        String input = keyboard.nextLine();
        if (input.length() > 0) 
          temp.setContents(input);
        
        LessonAgent.update(temp, in, out);
        
        System.out.println("변경했습니다.");
        
      } catch (Exception e) {
        System.out.printf("실행 오류! : %s\n", e.getMessage());
      }
  }
}
