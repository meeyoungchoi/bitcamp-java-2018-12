//singleton
package Design_pattern.singleton;
//인스턴스를 딱 한개만 생성하여 공유하고 싶다면
//싱글톤 설계 방식으로 클래스를 정의하라.
class Car2 {
  String model;
  int cc;
  
  //인스턴스 주소를 받을 클래스 필드를 선언한다.
  private static Car2 instance ;
  
  //1) 생성자를 정의하고 private으로 선언하여 비공개로 만들어라
  //
  //
  private Car2() {}
  
  //클래스 이름으로 호출하는 클래스 메서드
  //2) 인스턴스를 생성해주는 메서드를 정의한다.
  public static Car2 getInstance() {
    if (Car2.instance == null) {
      //아직 인스턴스를 생성한 적이 없다면 즉시 인스턴스를 생헝한다.
      Car2.instance = new Car2();//null일때 인스턴스를 만든다.
    } 
    //다음번에 또 호출하면 기존에 변수에 저장된 인스턴스 주소를 리턴한다.
    return Car2.instance;//따라서 car2의 인스턴스는 하나 빡에 없다.
  } 
}
public class Test02 {
  public static void main(String[] args) {
   
    //생성자가 존재 하지만 private으로 비공개 되어 있기 때문에 직접 호출할 수 없다.
    //생성자를 호출할 수 없으면 인스턴스를 생성할 수 없다.
    //new 명령으로 인스턴스를 만들면 안된다.
    //=>다른 메서드를 호출하여 인스턴스를 생성하라는 의미다.
    //Car2 c1 = new Car2();//컴파일 오류
    
    //인스턴스를 생성해주는 메서드를 통해 인스턴스를 얻는다.
    Car2 c2 = Car2.getInstance();
    Car2 c3 = Car2.getInstance();
    
    if (c2 != c3)
      System.out.println("다르다");
    else 
      System.out.println("같다");

  }
}
