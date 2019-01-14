//클래스 필드
package ch08;

class My1 {
  //My1 인스턴스(데이터 타입의 값)을 다룰 때 사용할 값이라면 따로 떼어 놓지 말고
  //My1 클래스에 선언하는 것이 사용할 때 편하다.
  //값을 직접 입력하게되면 오타가 발생할수 있다.
  //이 변수는 userType에서 사용된다.
  //변수의 값을 여러 인스턴스에서 공유하게 되면 인스턴스를 만들 때마다 해당 변수를 만들게 되어 메모리를 낭비하게 된다.
  //그래서 클래스 필드가 등장하게 된다.
  //클래스 필드는 인스턴스를 생성할 떄 만드는 변수가 아니라 클래스를 로딩할 때 생성되는 변수이다.
  //클래스는 jvm마다 딱 한 번만 로딩되기 때문에 클래스 필드도 딱 한 번만 생성되므로 메모리를 절약할 수 있다.
  //클래스 멤버 선언: static 데이터타입 변수명;
  //클래스 필드 사용하려면 클래스명.필드명=값;
  //인스턴스 필드를 사용할때는 레퍼런스(인스턴스주소).필드명=값;
  
  
  static String manager = "관리자"; //클래스 멤버 선언 static 데이터타입 변수명
  static String member = "회원"; //클래스 멤버 선언
  static String guest = "손님"; //클래스 멤버 선언
  
  //new 명령을 실행할 대 힙 메모리에 생성되는 변수이다.
  //이런 변수를 "인스턴스 필드" 라고 부른다.
  String name; //인스턴스 팔드
  int age;    //인스턴스 팔드
  String userType;
  
}

public class Test01 {
  public static void main(String[] args) {
   
    
    My1 obj1 = new My1();//obj1: 레퍼런스
    obj1.name = "홍길동";//인스턴스 필드 사용 => 레퍼런스.필드명 = 값
    obj1.age = 20;
    obj1.userType = My1.guest;
    
    My1  obj2 = new My1();
    obj2.name = "임꺽정";
    obj2.age = 20;
    obj2.userType = My1.manager;

    My1  obj3 = new My1();
    obj3.name = "유관순";
    obj3.age = 17;
    obj3.userType = My1.guest; //변수에 값을 미리 지정해놓으면 사용하기 편하다
   
    
    My1  obj4 = new My1();
    obj4.name = "윤봉길";
    obj3.age = 22;
    obj3.userType = My1.member;
  
   }
}




/**
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
