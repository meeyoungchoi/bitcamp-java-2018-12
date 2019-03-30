package design_pattern.chain_of_responsibility;

//인터페이스를 구현할 핸들러 클래스에게 기능을 공통으로 물려주기위해서 정의했다.
public abstract class AbstractHandler implements Handler{

  Handler next;
  
  public AbstractHandler() {
    
  }
  
  public AbstractHandler(Handler next) {
    this.next = next;
  }

  public Handler getNext() {
    return next;
  }

  public void setNext(Handler next) {
    this.next = next;
  }
  
  
}
