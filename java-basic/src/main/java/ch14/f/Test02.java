//다형적 변수의 규칙 - 2- 형변환
package ch14.f;

public class Test02 {

  public static void main(String[] args) {
    
    A obj = new B();//ok
    obj.m1();//=>B.m1()
    //obj.m2();//오류
    
    //실제 obj에 B인스턴스의 주소가 들어 있다 할지라도
    //직접 B 레퍼런스(obj2)에 저장할 수 없다.
   // B obj2 = obj;//=>오류
    
    
    
    //레퍼런스가 가리키는 실제 타입을 그대로 사용하고 싶다면,
    //(obj에 저장된 B클래스를 그대로 사용하고 싶다면)
    //형변환하여 사용하라
    B obj2 =(B) obj; //컴ㅍ아일러야 obj에 들어있는 주소가 원래 B의 인스턴스이다.
                     //그러니 obj2에 저장해주렴
    
    obj2.m2();
   
   if (obj == obj2) {
     System.out.println("obj == obj2");
   }
   
   //컴파일러는 속일지라도 jvm은 속일 수 없다.
   A obj3 = new A();
   
   //A 타입의 인스턴스를 B 타입의 인스턴스라고 주장하면, 컴파일러는 통과시킨다.
   //그러나 JVM은 오류를 발생히킨다.
   B obj4 = (B) obj3;//Runtime 예외 발생: class ch14.f.A cannot be cast to class ch14.f.B 
   
   
   obj3.m1();
   obj4.m2();
    
  
  }

}
