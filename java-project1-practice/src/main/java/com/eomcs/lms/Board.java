//06까지
package com.eomcs.lms;

import java.util.Scanner;

public class Board {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    int[] number = new int[LENGTH];
    String[] content = new String[LENGTH];

    int i = 0;

    while (i < LENGTH) {
      System.out.print("번호: \n");
      number[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("내용: \n");
      content[i] = keyboard.nextLine();

      System.out.printf("조회수: %d\n",0);

      i++;

      System.out.println("계속 입력하시겠습니까?");
      String answer = keyboard.nextLine().toLowerCase();

      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }
      
      System.out.println("");
    }
    
    keyboard.close();
    
    for (int j = 0; j < i; j++) {
      System.out.printf("%d, %s\n",
          number[j], content[j]);
    }
    


  }

}
