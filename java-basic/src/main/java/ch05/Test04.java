//switch
//switch 조건으로 4바이트 정수값만 된다.
package ch05;

public class Test04 {

  public static void main(String[] args) {
      byte b=1; 
      short s=1;
      char c= 1;
      int i=1;
      long l=1; //switch조건 에러
      float f=1.0f;
      double d=1.0;
      String str="Hello";
      
     switch (b) {
       case 1:
         System.out.println("11");
         System.out.println("1111");
         break;
       case 2:
         System.out.println("22");
         System.out.println("2222");
         break;
       case 'A': //'A'의 리턴 값은 2바이트 정수값이다. //그래서 CHAR도 되는것이다.
         System.out.println("AAAA");
        default:
          System.out.println("111111111111");
       
       
       
       
       
     }
   }
   
  }
   
    




/**
 * 
 * 
 * switch 문법
 * switch (4바이트정수 값, 문자열) {
 * case 4바이트정수값 또는 문자열;
 *  문장1;
 *  문장2;
 *  break;
 *  
 * case xxxxxxx:
 *  문장1;
 *  ....
 *  break;
 * default:
 *  위의 조건에 해당하는 것이 없으면 이 문장을 실행한다.
 * 
 * 
 * }
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
