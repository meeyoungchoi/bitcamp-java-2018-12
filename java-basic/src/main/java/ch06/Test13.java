//main() 메서드의 파라미터
package ch06;

public class Test13 {
  public static void main(String[] args) {//String[] args 배열에서
    System.out.println("=======================");
   // String s1 = args[0];//args라는 이름의 배열의  0번쨰 인덱스 값이 s1이 저장이된다.
    
    for (String arg : args)//arg에 배열의 주소가 저장된다.
  
      System.out.println(arg);//arg로 배열의 주소가 복사된다.
    //근데 args라는 배열의 이름으로 배열의 요소를 선언하지 않았기 때문에 배열의 요소가 텅빈값이 나온다.
    System.out.println("=======================");

    
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
