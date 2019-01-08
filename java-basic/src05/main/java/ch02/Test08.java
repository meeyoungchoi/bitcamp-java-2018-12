//논리 리터럴
package ch02;

public class Test08{


    public static void main(String[] args){
      
    System.out.println(true);
    System.out.println(false);
    
    //System.out.println((boolean)1);=>안된다.
    //자바는 정수 값을 true/false로 형변환할수 없다.
    
    //작은 따옴표(single quote)의 리턴값은 2바이트 정수 값이다.(utf-16)코드이다.
    //'가'의 리턴값은 숫자이다.
    if('가'==0xac00) {
      System.out.println("맞다");
    }else {
      System.out.println("아니다.");
    
    
              }
    
    //if(10 - 10)가 c에서는 오류가 안난다.
    //if(10 -10) {//자바는 오류난다.
     // System.out.println("참");
    //}
    
    
    
    
        }
    }
