package ch29.h;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car7 {
  private String maker;
  private String model;
  private int cc;
  private int valve;
  private boolean auto;
  private Date createdDate;
  private BlackBox blackBox;
  
  //@Autowired를 필드에 붙여도 된다.
  //=>이런 경우 세터/게터를 제거해도 동작한다.
  //=>required를 false로 설정하면 해당 객체가 없더라도 오류가 발생하지 않느다.
  //@Autowired(required=false)  
  //@Qualifier("bb2")//같은 타입의 객체가 여러 개 있을 경우 어떤 객체를 주입해야 하는지 이름을 지정하라
  //@Resource(name="bb2") //@Resource는 JRE라이브러리에 포함되어있지 않다.  별도로 라이브러리를 추가해야 한다.

  
  //생성자의 의존 객체를 파라미터로 선언하면
  //스프링 ioc컨테이너가 생성자를 ㅗ출할 떄
  //자동으로 해당 객체를 찾아 주입해 준다.
  //BlackBox 객체가 없으면 car7 객체가 생성되지 않는다.
  public Car7(BlackBox blackBox) {
    System.out.println("Car7(BlackBox)");
    this.blackBox = blackBox;
  }
  
  @Override
  public String toString() {
    return "Car7 [maker=" + maker + ", model=" + model + ", cc=" + cc + ", valve=" + valve
        + ", auto=" + auto + ", createdDate=" + createdDate + ", blackBox=" + blackBox + "]";
  }

  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    this.valve = valve;
  }
  public boolean isAuto() {
    return auto;
  }
  public void setAuto(boolean auto) {
    this.auto = auto;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

}
