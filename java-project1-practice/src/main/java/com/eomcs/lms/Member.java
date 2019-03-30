//06까지
package com.eomcs.lms;

import java.util.Scanner;

public class Member {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    int[] number = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    int[] password = new int[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    String[] login = new String[LENGTH];

    int i = 0;

    while (i < LENGTH) {
      System.out.print("번호: \n");
      number[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("이름: \n");
      name[i] = keyboard.nextLine();

      System.out.printf("이메일: \n");
      email[i] = keyboard.nextLine();

      System.out.print("암호: \n");
      password[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("사진: \n");
      photo[i] = keyboard.nextLine();

      System.out.print("전화: \n");
      tel[i] = keyboard.nextLine();

      System.out.print("가입일: \n");
      login[i] = keyboard.nextLine();
      
      i++;
      
      System.out.println("계속 입력하시겠습니까?");
      String answer = keyboard.nextLine().toLowerCase();
      
      if (!answer.equals("y") && answer.length() > 0 ) {
        break;
      }
      
      System.out.println("");
      
    }
    
    keyboard.close();
    
    for (int j = 0; j < i; j++) {
      System.out.printf("%d, %s, %s, %d, %s, %s\n",
          number[j], name[j], email[j], password[j], photo[j],
          tel[j], login[j]);
    }
  }

}
