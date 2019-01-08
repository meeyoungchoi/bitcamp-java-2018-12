//switch와 enum
//switch 조건으로 4바이트 정수값만 된다.
package ch05;

public class Test06 {
  
  //상수를 정의하는 문법
  static enum UserType {
    MANAGER, MEMBER, GUEST
  };
  
  public static void main(String[] args) {
    UserType type=UserType.MANAGER;
    
      //switch의 조건으로 상수를 의미하는 enum값이 올수 있다.
     switch (type) {
       case MEMBER:
          System.out.println("일반회원입니다.");
          break;
       case MANAGER:
         System.out.println("메니저입니다.");
         break;
       case GUEST:
         System.out.println("게스트입니다");
        break;
        default:
          System.out.println("유효하지않은사용자입니다.");
       
       
       
       
       
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
