
package bitcamp.lms;




public class App5 {
    

    public static void main(String[] args) {
      
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    java.util.Date today=new java.util.Date();
    
    //배열변수 만들기
      int i=0;
    
     
      int[] number=new int[10];
      String[] name=new String[10];
      String[] email=new String[10];
      int[] secret=new int[10];
      String[] photo=new String[10];
      String[] tel=new String[10];

      while(i < 10) { 
      System.out.printf("번호?");
      number[i] = Integer.parseInt(keyboard.nextLine());
      
 
      System.out.printf("이름?");
      name[i] = keyboard.nextLine();
     
      System.out.printf("이메일?");
      email[i] = keyboard.nextLine();

      //System.out.printf("암호?");
      //secret[i] =Integer.parseInt(keyboard.nextLine());
  
      System.out.printf("사진?");
      photo[i] = keyboard.nextLine();
    
      System.out.printf("전화?");
      tel[i] = keyboard.nextLine();
      
      i++;
      System.out.println();
      System.out.printf("계속 진행하겠습니까:(y/n)");
      String input=keyboard.nextLine();
      
      if ((!input.equalsIgnoreCase("y") && (!input.equalsIgnoreCase("")))) {
          break;
        
      }//if문 종료

   }//while 종료
      int j=0;
      
      while(j < i) {
        System.out.printf("%d, ", number[j]);
        System.out.printf("%s, ", name[j]);
        System.out.printf("%s, ", email[j]);
        System.out.printf("%s, ", tel[j]);
        System.out.printf("%tY-%tm-%td\n",today,today,today);
        
        
        j++;
                    }//두번째 while문 종료
            }//main 종료     
     }//class 종료
      
        
    

     
      
     
     

     
            
    
    
      
      
      
   



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