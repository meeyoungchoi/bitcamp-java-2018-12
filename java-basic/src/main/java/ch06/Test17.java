//jvm 아규먼트 응용
package ch06;

public class Test17 {
  public static void main(String[] args) {
    //학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
    //$ java -cp ./bin/main -Dname=홍길동 -Dkor=100 -Deng=100 -Dmath=90 ch06.Test17
   //jvm 아규먼트의 값 꺼내기
    


  
    
    double average;
    String name = System.getProperty("name");
    int kor=Integer.parseInt(System.getProperty("kor"));
    int Eng=Integer.parseInt(System.getProperty("eng"));
    int Math=Integer.parseInt(System.getProperty("math"));
    int sum = kor + Eng + Math;
    average=sum/3;
    
   System.out.printf("이름:%s, ",name);
   System.out.printf("총점:%d,  ",sum);
   System.out.printf("평균:%s, ",sum/3);
   System.out.printf("평균:%s, ",average);
  
    
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
