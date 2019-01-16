//캡슐화 적용 예 2
//캡슐화: 외부에서 함부로 못만지게 한다.
package ch12.c;

public class Test01 {

  public static void main(String[] args) {
    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;
    s1.compute();
    
    //private으로 보호되고있는 값을 꺼내고 싶다면
    //
    System.out.printf("총점=%d, 평균=%.1f\n", s1.getSum(), s1.getAver());
    
  
    Score s2 = new Score();
    s2.name = "홍길동";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 80;
    s2.compute();
    
    //private으로 보호되고 있는 메서드는 값을 임으로 왜곡할 수 없다.(캡슐화를 쓰는 이유)
    //s2.aver = 95.5f; 컴파일 오류
    
    System.out.printf("총점=%d, 평균=%.1f\n", s2.getSum(), s2.getAver());

  }

}


/**
 * 객체지향 프로그래밍(Object-orientd programmin; oop)의 특징
 * 1. 추상화(abstraction)
 * -프로그램에서 다루는 데이터나 코드를 클래스로 정의하는 행위
 * -클래스 멤버(스태틱 멤버): 스태틱 필드, 스태틱 블록, 스태틱 메서드
 * -인스턴스 멤버: 인스턴스 필드, 인스턴스 블록, 인스턴스 메서드, 생성자
 * 
 * 2. 상속(inheritance)
 * -기능 확장을 위한 문법
 * 
 * 3. 캡슐화(encapsulation)
 * -외부의 접근을 제어하는 문법
 * 
 * 
 * 4. 다형성(polymorphism)
 * -하나의 코드가 여러 용도로 쓰이게 하는 것
 * -오버로딩(overloading):메서드 시그너처가 다르더라도 같은 기능을 하는 메서드에 대해 같은 이름을 갖게하여 일관성 있는 프로그래밍을 하게 도와주는 문법.
 * -오버라이딩(overriding): 상속 받은 메서드를 자신의 역할에 맞게 재정의 하는 것
 * 다형적 변수(polymophic variable) :하난의 변수가 여러 타입을 가리킬 수 있고, 다양한 타입으로 다뤄질 수 있게 도와주는 문법
 * 
 * 캡슐화
 * -클래스 멤버나 인슽턴스 멤버의 접근을 제한 하는 문법이다.
 * -이유? 잘못된 사용으로 결과가 왜곡되는 것을 막기 위함이다.
 * -정의된 대로 역할을 수행하게 도와준다.
 * -문법: 클래스 멤버나 인스턴스 멤버 선언할 때 접근 제한자를 붙인다.
 * -접근 제한다
 * -private:클래스에 소속된 같은 멤버만 접근 간으
 * -defalut: 같은 패키지에 소속된 멤버만 접근 간으
 * -protected: 같은 패키지에 소속되거나 자식 클래스의 멤버만 접근 간ㅇ
 * -public: 모두 접근 가능
 * 
 * 
 * getter/setter
 * -캡슐화와 더불어 사용되는 기술이다.
 * -필드에 대해 외부의 직접적인 접근을 막는대신 메서드를 통해 값을 변경, 조회 하도록 유도한다.
 * -메서드에서 값의 유효 범위를 검사하여 변겨을 허락할수 있다.
 * -getter/setter를 다른 말로 "property"라 부른다.
 * -getter만 있는 경우:read only 프로퍼티(읽기만 가능)
 * -setter만 있는 경우:write only 프로퍼티
 * -gettter/setter 모두 있는 경우:read/write 프로퍼티
 * 
 * 
 * 
 * 
 * 
 * */
