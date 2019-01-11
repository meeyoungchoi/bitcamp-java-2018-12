//main() 메서드의 파라미터 응용2
package ch06;

public class Test15 {
  public static void main(String[] args) {
    //학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
    //$ java -cp .bin/main ch06.Test14 홍길동 100 100 90
    //총점: 290
    //평균: 96.9

    int sum=0;
   
    if (args.length < 4) {
      System.out.println("실행형식: java -cp ./bin/main ch-6.Test15 이름 국어 영수 수학 총점 평균");
    }
    for(int i=1; i < args.length; i++) {
    sum+=Integer.parseInt(args[i]);
      System.out.printf("이름: %s", args[0]);
      System.out.printf("총점: %d", sum);
      System.out.printf("평균: %1.f", sum/3);
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
