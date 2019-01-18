//해시코드 응용 3 - key로 String 사용하기
package ch15;

import java.util.HashMap;

public class Test09{
 public static void main(String[] args) {
   
   HashMap map = new HashMap();
   
   String k1 = new String("ok");
   String k2 = new String("no");
   String k3 = new String("haha");
   String k4 = new String("ohora");
   String k5 = new String("hul");
   String k6 = new String("haha");
 
   System.out.println(k3 == k6);
   System.out.println(k3.hashCode());
   System.out.println(k6.hashCode());
   System.out.println(k3.equals(k6));
   
   //비록 k3와 k6는 서로 다른 인스턴스이지만,
   //hashCode()의 리턴 값이 같고, equals()의 리턴값이 true이기 때문에
   //두 객체는 같은 key로 간주한다.
   
   System.out.println(map.get(k6));
   
   String k7 = new String("haha");
   System.out.println(map.get(k7));
 
   
  
   
  
   }
}
