//레퍼런스와 인스턴스의 관계
package ch07;

public class Test05 {
 
  static class Score {
    String name; 
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  public static void main(String[] args) {
    
    Score s1 = new Score();
    //s1에 저장된 주소로 찾아거서 그 메모리의 각 항목 값을 설정한다.
    //=>s1에 저장된 주소로 찾아가서 그 인스턴스의 각 변수에 값을 설정한다.
    //=>s1이 가리키는 인스턴스의 각변수에 갑을 설정한다.
    //=>s1이 가리키는 인스턴스의 각 필드값을 설정한다.
    //=>s1 인스턴스에 필드 값을 설정한다.
    //=>s1객체의 필드 값을 설정한다.
    //s1:객체의 주소를 담고있는 레퍼런스
    s1.name="홍길동";//표현:s1객체의 name에 홍길동을 저장한다.
    s1.kor=100;
    s1.eng=100;
    s1.math=100;
    

    Score s2=s1; //s1에 저장된 인스턴스 주소를 s2에 복사한다.
    System.out.println(s2.name);
    s1.name="임꺽정";
    System.out.println(s2.name);
    
    //메서드가 생성한 인스턴스의 주소를 받을 수 있다.
    Score s3 = createScore("유관순", 90, 90, 90);//
    System.out.println(s3.name);
    System.out.println(s3.kor);
   
  

    }
   //createScore() 성적 데이터를 가지고  score 객체를 생성하여 리턴한다.
  //score인스턴스를 생성하여 리턴한다
  //score 인스턴스를 생성한후 그 주소를 리턴한다.
  static Score createScore(String name, int kor, int eng, int math) {
    Score s=new Score();//인스턴스는 살아지지 않는다.
    s.name=name;
    s.kor=kor;
    s.eng=eng;
    s.math=math;
    s.sum=kor + eng + math;
    s.aver=s.sum / 3f;
    
    return s;
    //s에 저장된 인스턴스의 주소를 리턴한다.
    //강사님 로컬 변수는 메서드 호출이 끝난 다음에 삭제된다고 했는데
    //위에서 생성한 s변수도 삭제되고, name , kor, eng, mathe도 삭제되는게 아닌가요?
    //예 삭제됩니다.
    // Score 인스턴스도 삭제되는게 아닌가요?
    //삭제되지 않습니다. 인스턴스는 힙 메모리에 생성된다.
    //어떤 메서드에서 인스턴스를 생성하든지 간에 힙에 생성된 것은 메서드 호출이 끝나더라고 
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
