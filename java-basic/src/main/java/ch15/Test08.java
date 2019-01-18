//해시코드 응용 2
package ch15;

import java.util.HashMap;

public class Test08{
 public static void main(String[] args) {
   
   HashMap map = new HashMap();
   
   Integer k1 = new Integer(101);
   Integer k2 = new Integer(102);
   Integer k3 = new Integer(103);
   Integer k4 = new Integer(104);
   Integer k5 = new Integer(105);
   
   map.put(k1, new Student("홍길동", 20, false));
   map.put(k2, new Student("임꺽정", 30, true));
   map.put(k3, new Student("유관순", 30, true));
   map.put(k4, new Student("안중근", 24, true));
   map.put(k5, new Student("윤봉길", 22, true));
   
   //key
   Integer k6 = new Integer(102);
   
   
   System.out.println(k2 == k6);//인스턴스는 다르지만, 
   System.out.println(k2.hashCode());//integer이므로 숫자를 그대로 쓴다. hashcode는 같다,
   System.out.println(k6.hashCode());//hashcode는 같다,
   System.out.println(k2.equals(k6));//equals의 비교 결과도 같다.
   //결론!
   //=>k2와 k6는 다른 객체지만, 내용물은 같다.
   
   //get(key)
   //=>key 파라미터로 받은 객체에 대해 hashCode() 호출하여 정수 값을 얻는다.
   //=>그리고 정수 값을 이용하여 값이 저장된 우치를 찾는다.
   //원래 키와 내용물이 같은지 equals()로 한 번 더 비교한다.
   //만약 같다면 같은 key로 간주하여 해당 값을 꺼내 리턴한다.
   //
   //따라서 k2로 저장한 값을 k6로 꺼낼 수 있다.
   //왜?(hashcode()의 리턴 값이 같고, equals()의 리턴 값이 true이기 때문에 같은 key로 간주한다.)
   //객체는 다르지만 내부 값이 같기 때문에 같은 key라고 간주 한다.
   System.out.println(map.get(k6));
   
   //해당 키로 저장한 값을 찾을 수 없으면 null을 리턴한다.
   Integer k7 = new Integer(200);
   System.out.println(map.get(k7));
   
   //System.out.println(map.get(102));
   }
}
