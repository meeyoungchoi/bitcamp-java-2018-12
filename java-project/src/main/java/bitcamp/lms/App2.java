
package bitcamp.lms;

import java.util.Date;

public class App2 {
    

    public static void main(String[] args) {
     
      java.util.Scanner keyboard=new java.util.Scanner(System.in);
      
     //번호? 1
      System.out.printf("번호?");
      int number=keyboard.nextInt();
      keyboard.nextLine();
      
      //이름? 홍길동
      System.out.printf("이름?");
      String name=keyboard.nextLine();
      
    //이메일? hong@test.com
      System.out.printf("이메일?");
      String email=keyboard.nextLine();
      
      //암호? 1111
      System.out.printf("암호?");
      int secret=keyboard.nextInt();
      keyboard.nextLine();
      
      //사진? hong.png
      System.out.printf("사진?");
      String photo=keyboard.nextLine();
      //
      //전화? 1111-2222
      System.out.printf("전화?");
      String tel=keyboard.nextLine();
      
      Date registeredDate=new Date(System.currentTimeMillis());
      //현재 시점까지 지나온 년 월 일 시 분초를 리턴한다.
      
      System.out.printf("가입일?");
      String come=keyboard.nextLine();
      
      
      
      System.out.println();
     
      //번호: 1
       
      System.out.printf("번호? %d\n",number);
      
      //int num=keyboard.nextInt();
      //keyboard.nextLine();
      
      //이름: 홍길동
      System.out.printf("이름? %s\n",name);
     // String name1=keyboard.nextLine();
      
      //이메일: hong@test.com
      System.out.printf("이메일:%s\n",email);
      //String email1=keyboard.nextLine();
      
      //암호: 1111
      System.out.printf("암호:%d\n",secret);
      //int secret1=keyboard.nextInt();
     // keyboard.nextLine();
      
      //사진: hong.png
      System.out.printf("사진: %s\n",photo);
     // String photo=keyboard.nextLine();
      
      //전화: 1111-2222
      System.out.printf("전화:%s\n",tel);
      //String tel=keyboard.nextLine();
      
      //가입일: 2019-01-01
      System.out.printf("가입일:%s",come);
     // String come=keyboard.nextLine();
     
      
    }
}


/**
 * 
 * ### 작업2) 한 명의 회원 정보를 입력 받아 출력하라.

App2.java 실행 결과

```
번호? 1
이름? 홍길동
이메일? hong@test.com
암호? 1111
사진? hong.png
전화? 1111-2222

번호: 1
이름: 홍길동
이메일: hong@test.com
암호: 1111
사진: hong.png
전화: 1111-2222
가입일: 2019-01-01
```
 * 
 * 
 * 
 * 
 * 
 */