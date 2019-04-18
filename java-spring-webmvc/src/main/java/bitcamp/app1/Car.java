package bitcamp.app1;

import java.util.Date;

public class Car {
 protected String model;
 protected String maker;
 protected boolean auto;
 protected int cc;
 protected Date createdDate;
 protected Engine engine;
  
  
  
  public Engine getEngine() {
  return engine;
}
public void setEngine(Engine engine) {
  this.engine = engine;
}
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public boolean isAuto() {
    return auto;
  }
  public void setAuto(boolean auto) {
    this.auto = auto;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  
}
