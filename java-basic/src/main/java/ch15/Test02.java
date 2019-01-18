//Object 클래스 - toString을 오버라이딩 할때
package ch15;

class My3 {
  String name;
  int age;
  
  //개발을 하다 보면 인스턴스의 현재 값을 간단히 확인하고 싶을 경우가 있다.
  //그런 경우 toString()을 오버라이딩 하라
  //오버랑이딩(알트/)을 하지않으면 무조건 클래스명과 식별자가 나온다.
  
  @Override
  public String toString() {
    return "My3 [name=" + name + ", age=" + age + "]";
  }
  


}

public class Test02 {
  public static void main(String[] args) {
    My3 obj1 = new My3();
    obj1.name = "홍길동";
    obj1.age = 20;
    System.out.println(obj1.toString());
    
    //println()의 파라미터 값으로 문자열을 넘겨주지 않으면 
    //println() 내부에서 파라미터로 넘어온 객체에 대해 toString() 호출한 후
    //그 리턴 값을 출력한다.
    //따라서 그냉 객체(주소)를 넘겨줘도 된다.
    System.out.println(obj1);//println()메서드안에서 toString을 호출한후 그 리턴 값을 출력한다.

    
    
  }

}
