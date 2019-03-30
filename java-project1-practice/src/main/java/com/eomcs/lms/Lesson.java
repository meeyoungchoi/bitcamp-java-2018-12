//06까지
package com.eomcs.lms;

import java.util.Scanner;

public class Lesson {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    final int LENGTH = 10;
 

    int[] num = new int[LENGTH];
    String[] lesson = new String[LENGTH];
    String[] startDate = new String[LENGTH];
    String[] finishDate = new String[LENGTH];
    int[] totalHour = new int[LENGTH];
    int[] dayHour = new int[LENGTH];
    
    
    int i = 0;
    
    while (i < LENGTH) {
      
      System.out.print("번호:\n");
      num[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("수업명: \n");
      lesson[i] = keyboard.nextLine();

      System.out.print("시작일: \n");
      startDate[i] = keyboard.nextLine();

      System.out.print("종료일: \n");
      finishDate[i] = keyboard.nextLine();

      System.out.print("총 수업시간: \n");
      totalHour[i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("일수업시간: \n");
      dayHour[i] = Integer.parseInt(keyboard.nextLine());

      i++;
      
      System.out.println("계속 입력하시겠습니까?");
      String answer = keyboard.nextLine().toLowerCase();

      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }
      
      System.out.println("");
      
    }
    
    keyboard.close();

    for (int j = 0; j < i; j++ ) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          num[j],lesson[j],startDate[j],finishDate[j],
          dayHour[j]);
    }
  }
}
