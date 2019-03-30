
package bitcamp.lms;



public class App2 {
    

    public static void main(String[] args) {
      
      java.util.Scanner keyboard=new java.util.Scanner(System.in);
      java.util.Date today = new java.util.Date();
      
      int i=0;
      
      int[] number=new int[10];
      String[] name=new String[10];
      String[] email=new String[10];
      int[] secret=new int[10];
      String[] photo=new String[10];
      String[] tel=new String[10];

      
    
      
      while(i < 10) {
     //번호? 1
      System.out.printf("번호?");
      number[i] = Integer.parseInt(keyboard.nextLine());
 
      
      //이름? 홍길동
      System.out.printf("이름?");
      name[i]=keyboard.nextLine();
      
    //이메일? hong@test.com
      System.out.printf("이메일?");
      email[i]=keyboard.nextLine();

      //암호? 1111
      System.out.printf("암호?");
      secret[i]=Integer.parseInt(keyboard.nextLine());
  
      
      //사진? hong.png
      System.out.printf("사진?");
      photo[i]=keyboard.nextLine();
      //
      //전화? 1111-2222
      System.out.printf("전화?");
      tel[i]=keyboard.nextLine();
      

      
      
      i++;

      System.out.printf("\n계속입력하시겠습니까?(y/n)");
      String input=keyboard.nextLine();
      System.out.println();
      if (!input.equalsIgnoreCase("y") && !input.equals(" ")) {
        break;
        
        }//if문 종료     
      }//while문 종료
      
        int j = 0;
        while(j < i) {
          
          System.out.printf("%d, ",number[j]);
          System.out.printf("%s, ", name[j]);
          System.out.printf("%s, ", email[j]);
          System.out.printf("%s,", tel[j]);
          System.out.printf("%1$tY-%1$tm-%1$td\n", today);
          
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