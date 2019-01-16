// wrapper 클래스 생성자에 대한 고찰
package ch11;

import java.util.Date;

public class Test11 {
  public static void main(String[] args) {
  //왜 레퍼클래스에 생성자를 쓰지 못하는가
    Integer obj1 = new Integer(100);//new로 만들면 힙에 만들어 지므로 주소가 다르다.
    Integer obj2 = new Integer(100);
    
    if (obj1 ==  obj2) {
      System.out.println("obj1 == obj2");
    } else {
      System.out.println("obj1 != obj2");
    }
    
    if(obj1.equals(obj2)) 
      System.out.println("obj1.equals(obj2)");
    else 
      System.out.println("!obj1equals(obj2)");
    
    //new를 사용하여 객체를 만들면 인스턴스 주소가 다르므로 equals를 사용해야 한다.
    //같은 값을 갖은 인스턴스인 경우 중복 생성하지 않고 한 개만 생성하면 번거로움을 피할수 있다.
    //그래서 생성자를 사용하여 integer 객체를 만들지 만고 
    //valueOF는 값이 같으면 같다고 나온다.
    
    Integer obj3 = Integer.valueOf(100);
    Integer obj4 = Integer.valueOf(100);
    
    //두 객체의 값을 비교할떄 equals를 사용하지 말고 그냥 주소를 비교해도 된다.
    //주소가 같다는 것은 같은 인스턴스라는 의미이다.(결국 값이 같다는 것이다.)
    if (obj3 ==  obj4) {
      System.out.println("obj3 == obj4");
    } else {
      System.out.println("obj3 != obj4");
    }
  }
}





