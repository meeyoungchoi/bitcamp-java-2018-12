//else if
package ch05;

public class Test03 {

  public static void main(String[] args) {
   int age=78;
    
   if (age < 8)
      System.out.println("유아입니다.");
   
   else if (age >= 8 && age < 14)
     System.out.println("어린이입니다.");
  
   else if(age >= 14 && age < 65)
     System.out.println("성년입니다.");
     else
       System.out.println("노인입니다.");
   
   //오직 if ~ else 문법만 있을 뿐이다.
   
   
   if (age > 19) {
     if(age >= 65)
   
     System.out.println("노인입니다.");
    
   } else 
     System.out.println("미성년입니다.");
   
   //들여쓰기에 속지 마라
   //else는 가장 가까운 if에 종속된다.
   //따라서 위의 else 는 바로 위의 if에 종속된다.
     
   }
   
  }
   
    




/**
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
 * 
 * */
