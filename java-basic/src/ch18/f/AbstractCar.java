package ch18.f;

public abstract class AbstractCar {
  String model;
  int cc;
  
  
  public void on() {
    System.out.println("켠다");
  }
  
  public void off() {
    System.out.println("끈다");
  }
  
  //그 중 상속해주는 메서드 중에서 일부는 서브 클래스가 구현하도록 강제할 수 있다.
  //이럴 때 사용하는 문법이 추상클래스
  public abstract void run(); 
}
