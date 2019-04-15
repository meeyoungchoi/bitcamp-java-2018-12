//reflaction api - 배열 항목의 타입 알아내기
package ch27.b;

import java.sql.Date;

public class Test10 {

  public static void main(String[] args) throws Exception {

    int[] arr1 = {};

    Class<?> clazz = arr1.getClass();

   /* System.out.println(new byte[]{}.getClass().getName());
    System.out.println(new short[]{}.getClass().getName());
    System.out.println(new int[]{}.getClass().getName());
    System.out.println(new long[]{}.getClass().getName());
    System.out.println(new float[]{}.getClass().getName());
    System.out.println(new double[]{}.getClass().getName());
    System.out.println(new boolean[]{}.getClass().getName());
    System.out.println(new char[]{}.getClass().getName());
    System.out.println(new String[]{}.getClass().getName());
    System.out.println(new Date[]{}.getClass().getName());*/
    
    //배열 타입이 아닌 경우 항목이 없기 때문에 getComponentType()의 리턴 값은 null이다.
    System.out.println(byte.class.getComponentType());
    
    System.out.println(byte.class.getName());//byte
    System.out.println(new byte[]{}.getClass().getName());//byte배열
    System.out.println(new byte[]{}.getClass().getComponentType().getName());//byte배열의 항목 타입
    
    
    System.out.println(new short[]{}.getClass().getName());
    System.out.println(new short[] {}.getClass().getComponentType().getName());
    
    System.out.println(int.class.getName());//int의 타입의 이름
    System.out.println(new int[]{}.getClass().getName());
    
    System.out.println(long.class.getName());
    System.out.println(new long[]{}.getClass().getName());
    
    System.out.println(float.class.getName());
    System.out.println(new float[]{}.getClass().getName());
    
    System.out.println(double.class.getName());
    System.out.println(new double[]{}.getClass().getName());
    
    System.out.println(boolean.class.getName());
    System.out.println(new boolean[]{}.getClass().getName());
    System.out.println(new char[]{}.getClass().getName());
    System.out.println(new String[]{}.getClass().getName());
    System.out.println(new Date[]{}.getClass().getName());
  }

}


