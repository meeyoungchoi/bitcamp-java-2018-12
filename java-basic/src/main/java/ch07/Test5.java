
package ch07;

public class Test5 {

  //5. 성적데이터를 저장할 변수를 main에서 빼내서 score라는 클래스를 만들고 이 클래스 속에 변수를 집어넣었다.
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
  }
  //16.위의 클래스 선언한거에서 static을 없애면 
 

 
  public static void main(String[] args) {
   
    //1. 성적 데이터를 저장할 변수 선언
   /* String name = "강강강";
    int kor = 100;//main에 만들어진 로컬변수는 자도응로 초기화 되지 않는다.
    int eng = 90;
    int math = 70;
    int sum = kor + eng + math;
    float aver = sum / 3;
    */
    //12. int 배열선언
    int[] values = new int[3];
    //values:레퍼런스:배열의 주소를 담는 변수
    
    //13. 레퍼런스 선언
   // Score s1, s2, s3;
    //14.score변수3개를 만드는 배열
    Score[] scores = new Score[3];
    //scores(레퍼런스): 배열의 주소 저장
    //new Score[3]: Score 레퍼런스 3개를 생성한다.
    
    //15.scores라는 배열레퍼런스에 인스턴스 주소를 넣어준다.그러러면 new를 사용해야한다.
    scores[0] = new Score();//new를 사용해서 레퍼런스에 인스턴스 주소를 넣어준다.
    scores[1] = new Score();
    scores[2] = new Score();
    //그러면 이제 레퍼런스가 유효한 인스턴스 주소를 갖게 된다.
    
    System.out.println(scores[0].kor);
    //2. 성적 데이터 변수 출력
    //System.out.printf("%s, %d, %d, %d",name, kor, eng, math, sum, aver);
    
    //6. 클래스의 인스턴스 주소를 저장하는 인스턴스와 클래스의 메모리 주소를 저장하는 레퍼런스를 만들었다.
    //7. 인스턴스에 값 넣기(레퍼런스.변수명=값)
    Score s1 = new Score();
    s1.name = "강강강";
    s1.kor = 100;
    s1.eng = 70;
    s1.math = 80;

    //10. s1에 저장된 인스턴스 주소를 s2에 복사한다.
    Score s2 = s1;
    System.out.println(s2.name);
    System.out.println(s2.kor);
    System.out.println(s2.math);
    System.out.println(s2.eng);
    
    //11. 생성한 인스턴스의 주소를 메서드가 받을수 있다.
    Score s3 = createScore("냥냥냥", 90, 80, 70);
    System.out.println(s3.name);
    System.out.println(s3.kor);
    System.out.println(s3.math);
    System.out.println(s3.eng);
    //s3:인스턴스 필드(생성되는 즉시 0으로 초기화 된다.)
    
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
    
      
     //12. createScore() 성적 데이터를 가지고 score객체를 생성하여 리턴한다.
      //리턴값을 가진다.
      static Score createScore(String name, int kor, int eng, int math)  {
        Score s = new Score();
        s.name = name;
        s.kor = kor;
        s.eng = eng;
        s.math = math;
        s.sum = kor + eng + math;
        s.aver = s.sum / 3f;
        
        return s;
      }
      
      static void m1() {
        
        
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
