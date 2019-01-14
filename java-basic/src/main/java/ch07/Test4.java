
package ch07;

public class Test4 {

  //5. 성적데이터를 저장할 변수를 main에서 빼내서 score라는 클래스를 만들고 이 클래스 속에 변수를 집어넣었다.
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
  }
 

 
  public static void main(String[] args) {
   
    //1. 성적 데이터를 저장할 변수 선언
   /* String name = "강강강";
    int kor = 100;
    int eng = 90;
    int math = 70;
    int sum = kor + eng + math;
    float aver = sum / 3;
    */
    
    //2. 성적 데이터 변수 출력
    //System.out.printf("%s, %d, %d, %d",name, kor, eng, math, sum, aver);
    
    //6. 클래스의 인스턴스 주소를 저장하는 인스턴스와 클래스의 메모리 주소를 저장하는 레퍼런스를 만들었다.
    //7. 인스턴스에 값 넣기(레퍼런스.변수명=값)
    Score s1 = new Score();
    s1.name = "강강강";
    s1.kor = 100;
    s1.eng = 70;
    s1.math = 80;

    //8. 메서드를 통해서 메모리 주소 전달
    printScore(s1);



  } 
  
  //3. 별도로 뺀 블록(이름, 국어, 영어, 수학의 값을 받아오기 위해서 별도의 블록으로 분리했다.)
  //4. 3번의 블록을 별도의 블록으로 뺀다(main바깥으로 뺏다. 그리고 합계와 평균을 구하는 식을 이 블록에 넣었다.).
    /*static void printScore(String name, int kor, int eng, int math) {
      int sum = kor + eng + math; 
      float aver = sum /3f;
      System.out.printf("%s, %d, %d, %d",name, kor, eng, math);
      */
  
      //9. 그 메모리 주소를 받을 변수를 파라미터로 선언
      static void printScore(Score s) {
        s.sum = s.kor + s.eng + s.math;
        s.aver = s.sum / 3f;
        System.out.printf("%s, %d, %d, %d, %d, %f", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
      }
    


}







/**
 * 
 * 클래스 문법의 활용
 * 1. 사용자 정의 데이터 타입과 그 타입의 값을 다루는 연산자를 정의할 때 사용한다.(새로운 데이터타입)
 * 2. 서로 관련된 일을 하는 메서드를 분류하여 묶는 용도로 사용한다.
 * 클래스:메소드를 분류해서 관련있는 기능별로 묶어놓는다.
 * class Calculator에서 Calculator가 클래스의 분류명이다.
 * 객체지향:소스코드를 좀더 조직적으로 관리하자
 * 리펙토링:클래스를 다시 재구성한다.(클래스를 다시 재분류해야할때)
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
