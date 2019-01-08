//switch과 문자열
//switch 조건으로 4바이트 정수값만 된다.
package ch05;

public class Test05 {

  public static void main(String[] args) {

      String str="ok";
      
     switch (str) {
       case "ok":
         System.out.println("okokok");
      
         break;
       case "no":
         System.out.println("nononono");
        break;
        default:
          System.out.println("????????");
       
       
       
       
       
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
