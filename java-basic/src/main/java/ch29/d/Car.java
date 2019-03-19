package ch29.d;

import java.util.Date;

public class Car {
  private String maker;
  private String model;
  private int cc;
  private int valve;
  private boolean auto;
  private Date createdDate;
  private BlackBox blackBox;
  

  
  public Car() {
	  System.out.println("Car()");
  }

  @Override
public String toString() {
	return "Car [maker=" + maker + ", model=" + model + ", cc=" + cc + ", valve=" + valve + ", auto=" + auto
			+ ", createdDate=" + createdDate + ", blackBox=" + blackBox + "]";
}
public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
	   System.out.println("Car.setMaker()");
    this.maker = maker;
 
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
    System.out.println("Car.setModel()");
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
    System.out.println("Car.setCc()");
  }
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    this.valve = valve;
    System.out.println("Car.setValve()");
  }
  public boolean isAuto() {
    return auto;
  }
  public void setAuto(boolean auto) {
	  System.out.println("Car.setAuto()");
    this.auto = auto;
   
  }

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	 System.out.println("Car.setCreatedDate()");
	this.createdDate = createdDate;

}

public BlackBox getBlackBox() {
	return blackBox;
}

public void setBlackBox(BlackBox blackBox) {
	 System.out.println("Car.blackBox()");
	this.blackBox = blackBox;
	
}
  
  
}

