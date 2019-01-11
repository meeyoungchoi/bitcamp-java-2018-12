//클래스, 레퍼런스, 인스턴스
package ch07;

public class Test04 {
  //클래스
  //사용자 정의 뎅터 타입
  //개발자가 애플리케이션에서 특정 정보를 저장할 목적으로 정의한 메모리 설계도
  static class Score {
    String name; 
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  public static void main(String[] args) {
    //레퍼런스: 클래스 설계도에 따라 생성한 변수를 가리키는 준비된 "메모리의 주소를 담는 변수"
    Score s1; //=> Score: 주머니 s1:레퍼런스
    //인스턴스: 클래스 설계도에 따라 준비된 메모리(변수들)
    s1=new Score(); //=>s1 레퍼런스에 인스턴스값을 집어 넣는다.
    

    Score s2=new Score();
    
    Score s3=new Score();
    
     //인스턴스 필드(인스턴스의 각 항목):클래스 설계도에 따라 준비된 메모리의 각 항목
    s1.name="홍길동";
    s1.kor=100;
    s1.eng=100;
    s1.math=100;
   
    s2.name="임꺽정";
    s2.kor=90;
    s2.eng=90;
    s2.math=90;
    
    s3.name="유관순";
    s3.kor=70;
    //2에 저장되었던 주소는 s1에 저장된 주소로 변경된다.
    //s2가 가리키던 원래의 인스턴스는 주
    s3.kor=80;
    s3.eng=100;
    
    printScore(s1);
 
    printScore(s2);
    
    printScore(s3); 
 
    }
  
  
  
  static void printScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    System.out.printf("%s, %d, %d, %d, %d, %f\n",s.name, s.kor, s.eng,s.math, s.sum, s.aver );
    
    
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
 * 자바 기본 데이터 타입의 변수 선언 vs 클래스의 변수 선언
 * 자바 기본 데이터 타입은 변수르르 선언하는 순간 메모리에 생성된다.
 * int a; //바로 int 값을 저장할 메모리가 준비된다.
 * 클래스의  변수선언은 주소를 담는 레퍼런스이다. 
 * 따라서 주소를 담는 메모리만 준비된다.
 * Score s; //아직  Score 설계도에 따라 변수들이 준비된 상태가 아니다.
 * 클래스의 설계도에 따라 메모리를 준비하려면 따로 NEW 명령을 사용해야 한다.
 * new Score();
 * 생성된 메모리를 사용하려면 주소를 잘 보관해 두어야 ㅎ나다.
 * s=new Score(); 
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
