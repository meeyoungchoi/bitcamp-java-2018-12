
package bitcamp.lms;
import java.util.Scanner;
import java.sql.Date;
public class App2 {
    

    public static void main(String[] args) {
      
      Scanner keyboard=new Scanner(System.in);
      
      //Member변수 50개를 만드는 배열 선언
      //member:배열의 주소를 저장하는 레퍼런스
      //new Member[50]: Member 레퍼런스 50개를 생성한다.
      Member[] member=new Member[50] //1. 배열 변수를 만들어야 한다.
          
          //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.;
      int i=0;
      

      while(i < 50) { //1. 배열 변수를 만들어야 한다.
        
        //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.
        
        //member1 인스턴스에 필드 값을 설정한다.
        //즉, member1이 가리키는 인스턴스의 각 필드값을 설정한다.
        //member1: 객체의 주소를 담고있는 레퍼런스
      Member member1=new Member();

      System.out.printf("번호?"); //1. 배열 변수를 만들어야 한다.
      
      //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.
      member1.number = Integer.parseInt(keyboard.nextLine());
 
      

      System.out.printf("이름?");
      member1.name=keyboard.nextLine();
      
 
      System.out.printf("이메일?");
      member1.email=keyboard.nextLine();
      java.util.Date today = new java.util.Date();

 
      System.out.printf("전화?");
      member1.tel=keyboard.nextLine();
      
      
      member1.date = new Date(System.currentTimeMillis());

      //member1이 가리키던 인스턴스를 member[i]에 넣어준다.
      member[i]=member1;
      
      i++;

      System.out.printf("\n명령을 입력하시겠습니까?");
      String input=keyboard.nextLine();
      System.out.println();
      
      if (!input.equalsIgnoreCase("lesson add") && !input.equals(" ")) {
          break;
        
        }//if문 종료     
      }//while문 종료
      
        int j = 0;
        while(j < i) {
          
          System.out.printf("%d, ",member[j].number);
          System.out.printf("%s, ", member[j].name);
          System.out.printf("%s, ", member[j].email);
          System.out.printf("%s,", member[j].tel);
          System.out.printf("%s\n", member[j].date);
          
          j++;
           }
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