//클래스 로딩과 클래스 필드의 생성,method area의 관계
package ch08;

class My2 {

  //클래스 필드
  static String manager = "관리자";
  static String member = "회원";
  static String guest = "손님";
  
  //인스턴스 필드
  String name;
  int age;
  String userType;
  
}

public class Test02 {
  public static void main(String[] args) {
   //클래스 로딩 과정
    // 1.  $ java ch08.Test02를 실행한다면
    //1) Test02.class를 메서드 에리어 영역에 로딩한다.println
    //2) Test02의 메인 메서드를 호출한다.
    //3) 메인 메서드에 선언된 로컬 변수 args를 jvm 스택 영역(메모리영역)에 생성한다.
    // -args를 스택영역에 생성
    //4) 메인 메서드(main())의 코드를 실행한다.
    // -My2.class 를 메서드 에리어에 로딩한다.
    // -My2의 클래스 필드를 메서드 에리어에 생성한다.
    // -System.out.println(My2.magager);를 실행한다.
    //    -MY2 클래스가 이미 로딩되었기 때문에 다시 로딩하지 않는다.
    //      -System.out.println(My2.member)를 실행한다.
    //5) new 명령에 따라 힙 영역에 인스턴스 필드를 생성한다.
    
    System.out.println(My2.manager);
    System.out.println(My2.member);
    

  
   }
}




/**
 * 클래스 로딩
 * 외부 저장장치(hdd,usb 메모리, dvd-rom 등)에 있는 .class 팡리을 jvm이 관리하는 메모리로 로딩하는 것
 * 
 *1. jvm이 관리하는 메모리 영역
 * heap:new 명령으로 생성한 인스턴스가 놓인다.
 * 즉 인스턴스 필드가 이 영역에 생성된다.
 * 가비지 컬렉터는 이 메모리의 가비지들을 관리한다.
 *2. jvm stack
 *  각 스레드가 개인적으로 관리하는 메모리 영역
 *  스레드에서 메서드를 호출할때 메서드의 로컬변수를 이영역에 만든다.
 *  메서드가 호출될 때 그 메서드가 사용하는 로컬 변수를 프레임에 담아 만든다.
 *  메서드 호출이 끝나면 그 메서드가 소유한 프레임이 삭제된다.
 *3. method area
 *  jvm이 실행하는 바이트코드(.class 파일)를 두는 메모리 영역이다.
 *  jvm은 코드를 실행할 때 이 영역에 놓은 명령어를 실행하는 것이다.
 *  주의! 힙에는 개발자가 작성한 명령어가 없다.
 *  개발자가 작성한 클래스, 메서드 등 이런 코드들이 이 영역에 놓이는 것이다.
 *  힙에는 인스턴스 필드가 놓인다.
 *  힙에는 new Scanner 했을때 scanner가 사용할 메모리 필드가 올라온다.
 *   스태틱 필드를 이 영역에 생성한다.
 *   
 * 클래스 로딩
 * -클래스의 코드를 사용하는 시점에 메모리(Method Area)에 로딩된다.
 * -한번 로딩되면 jvm을 종료할 때메인 메서드(main())의 코드를 실행한다까지 유지한다.
 * -물론 강제로 unloading 할수 있다. 그리고 다시 로딩할 수 있다.
 * 
 * 클래스의 코드를 사용하는 시점?
 * -스태틱 멤버(필드와 메서드)를 사용할 때
 *        My2.member=200;
 *        system.out.println(my2.member);
 *         
 * -new 명령을 사용하여 인스턴스를 생성할 때
 *          new My2();
 *          주의!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
 *          
 * My2 obj;
 *  =>레퍼런스 변수를 선언할 때는 클래스를 로딩하지 않는다!!!!!!!!!!!!!!!!!!!!!!!!!
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
