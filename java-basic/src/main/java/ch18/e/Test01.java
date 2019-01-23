//Canvas와 Pen을 활용하는 예:
package ch18.e;

public class Test01 {

  public static void main(String[] args) {
    
   BallPen153 t1 = new BallPen153();
   MultiPen t2 = new MultiPen();
    
    //
   Canvas c1 = new Canvas(t1);
    
    //캔버스를 실행한다.
    //캔버스는 생성자에서 주입 받은 팬을 사용하여 텍스트를 그릴것이다.
    //쓰기 전에 먼저 볼펜을 사용할 수 있게 볼심을 밖으로 내민다.
   t1.press(true);
   c1.render("오호라...모나미 펜으로 그린 것");
    
    //볼펜을 교첸
   c1.setPen(t2);
    
    //멀티펜을 사용할 수 있게 한다.
   t2.rotate(Zebra.ON);

    //
   c1.render("오호라...모나미 펜으로 그린 것");
   
  }
}
