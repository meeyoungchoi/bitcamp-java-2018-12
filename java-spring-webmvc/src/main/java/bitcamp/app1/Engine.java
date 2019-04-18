package bitcamp.app1;

public class Engine {
  protected String model;
  protected String maker;
  protected boolean auto;
  protected int capacity;
  protected int valve;
  
  @Override
  public String toString() {
    return "Engine [model=" + model + ", maker=" + maker + ", auto=" + auto + ", capacity="
        + capacity + ", valve=" + valve + "]";
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

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getValve() {
    return valve;
  }

  public void setValve(int valve) {
    this.valve = valve;
  }

  
  

}
