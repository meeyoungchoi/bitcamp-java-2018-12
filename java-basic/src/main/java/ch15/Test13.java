// Object 클래스 - getClass() 와 배열
package ch15;

public class Test13 {
  public static void main(String[] args) {
	  String obj1 = new String();
   
    // 레퍼런스를 통해서 인스턴스의 클래스 정보를 알아낼 수 있다.
    Class classInfo = obj1.getClass();
    System.out.println(classInfo.getName());
    
    String[] obj2 = new String[10];
    classInfo = obj1.getClass();
    System.out.println(classInfo.getName());//ljava.lang.string
    
    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName());//[I :int 배열을 의미
    
    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName());//[F
    
    boolean[] obj5 = new boolean[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName());//[Z
  }
}







