//jvm 아규먼트 응용2
package ch06;

public class Test18 {
  public static void main(String[] args) {
      //jvm에 기본으로 설정되어 있는 프로퍼티을 모두 출력하라
       // jvm의 기본정보를 출력할수 있다.
    
    //jvm의 전체 프로퍼티 목록 가져오기
    //java.util패키지에서 Properties형태의 props변수를 가져와서 예를 System.getProperties()에 담는다.
    java.util.Properties props = System.getProperties(); //getProperties()는 String을 요구한다.
    
    java.util.Set keyset=props.keySet();//keyset이 리턴하는 것은 키가 들어있는 목록이다.=>키값 리턴?
    
    for (Object key : keyset) {// keyset이라는 배열의 key라는 요소를 전부 출력
      String value = System.getProperty((String) key);
      System.out.printf("%s = %s\n",key,value);
    }
    
   
   
    
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
