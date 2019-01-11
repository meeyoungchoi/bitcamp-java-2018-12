//main() 메서드의 파라미터 응용2
package ch06;

public class Test16 {
  public static void main(String[] args) {
    
    //$
   //jvm 아규먼트의 값 꺼내기
    String value1 = System.getProperty("a");
    String value2 = System.getProperty("b");
    String value3 = System.getProperty("c");
    
    //system.getProperty("이름");
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
    
      }
}
  

  

    
    
    
    
  




/**
 *프로그램 아규먼트
 *프로그램을 실행할 때 넘겨주는 값
 *어떻게 아규먼트를 넘기는가?
 *$java 클래스명 값1, 값2, 값3
 *
 *아규먼트는 공백으로 구분한다.
 *jvm은 아규먼트의 개수 만큼 문자열 배열을 만들어 저장한다.
 *아규먼트가 없으면 빈 배열을 만든다.
 *그런후 main()을 호출할 때 그 배열의 주소를 넘겨준다.
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
