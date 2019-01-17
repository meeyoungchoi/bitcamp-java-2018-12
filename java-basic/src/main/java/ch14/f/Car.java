package ch14.f;

public abstract class Car {
  String model;
  int cc;
  
  public void run() {
    System.out.println("달린다.");
  }
  
  public void stop() {
    System.out.println("멈춘다.");
  }

}
