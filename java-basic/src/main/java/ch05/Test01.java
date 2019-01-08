//변수 선언과 메모리 크기
package ch05;

public class Test01 {

  public static void main(String[] args) {
    int age=19;
    
   if (age >= 20)
     System.out.println("성인입니다.");
   
   //보통 조건 다음에 오는 문장은 다음 줄에 놓는다.
   if (age >= 20)
     System.out.println("성인입니다.");
   
   //실행할 문장이 여러 개이면 중괄호로 묶어야 한다.
   //if문과 ()붙이지 않는다.
   if (age >= 20) {
     System.out.println("성인");
     System.out.println("입니다.");
   }
   
     System.out.println("=========================================");
   
   //주의
   //중괄호로 묶지 않았을 때 문제점
   if(age >= 20)
     System.out.print("성인");
     System.out.println("입니다."); //이 문장은 if 문에 종속되지 않는다.
     

    

  }

}


/**
 * if 조건문
 * 문법1:
 *  if(조건) 문장1;
 *  =>조건이 참일때 문장1 수행
 *  
 *  
 *  문법2
 *  if(조건) 문장1; else 문장2
 *  whrjsdl
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
