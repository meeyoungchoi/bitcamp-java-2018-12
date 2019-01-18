//object 클래스 - getClass(): 해당 클래스의 저보를 리턴한다.
package ch15;

import java.util.HashMap;

class My11 {

}



  
public class Test12{
 public static void main(String[] args) {
   
  My11 obj1 = new My11();
  
  Class classInfo = obj1.getClass();
   
  //
  System.out.println(classInfo.getName());
  System.out.println(classInfo.getSimpleName());
  
   }
}
