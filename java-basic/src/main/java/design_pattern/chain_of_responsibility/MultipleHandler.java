package design_pattern.chain_of_responsibility;

public  class MultipleHandler extends AbstractHandler{

  @Override
  public void handle(int a, int b, String op) {
    if (op.equals("*")) {
      System.out.printf("%d * %d = %d\n",a , b, (a * b));
      return;
    } 
    next.handle(a, b, op);//이거를 안적으면 다음 핸들러로 넘어가지 않는다.
  }
}
