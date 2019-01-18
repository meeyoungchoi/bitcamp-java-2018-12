//해시코드 응용 4 - 사용자가 만든 클래스를 key로 사용하기
package ch15;

import java.util.HashMap;

class Key {
  String contents;
  
  public Key(String contents) {
    this.contents = contents;
  }

  @Override
  public String toString() {
    return "Key [contents=" + contents + "]";
  }
}

public class Test10{
 private static Key k6;

public static void main(String[] args) {
   
   HashMap map = new HashMap();
   
   Key k1 = new Key("ok");
   Key k2 = new Key("no");
   Key k3 = new Key("haha");
   Key k4 = new Key("ohora");
   Key k5 = new Key("hul");
   
// String을 key로 사용해보자! 
   map.put(k1, new Student("홍길동", 20, false));
   map.put(k2, new Student("임꺽정", 30, true));
   map.put(k3, new Student("유관순", 17, true));
   map.put(k4, new Student("안중근", 24, true));
   map.put(k5, new Student("윤봉길", 22, false));
 
   System.out.println(map.get(k3));
   
   // key를 사용하여 값을 꺼내보자.
   Key k6 = new Key("haha");

  System.out.println(k3 == k6);
   System.out.println(k3.hashCode());
   System.out.println(k6.hashCode());
   System.out.println(k3.equals(k6));
   
   //비록 k3와 k6는 서로 다른 인스턴스이지만,
   //hashCode()의 리턴 값이 같고, equals()의 리턴값이 true이기 때문에
   //두 객체는 같은 key로 간주한다.

   
   
   
   System.out.println(map.get(k6));
   
   Key k7 = new Key("haha");
   System.out.println(map.get(k7));
 
   
  
   
  
   }
}
