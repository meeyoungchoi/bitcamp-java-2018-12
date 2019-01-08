//부동소수점 리터럴의 메모리크기

//부동소수점을 메모리에 저장하는 방법
package ch02;

public class Test05{

    public static void main(String[] args){

        //9876.54345678
      System.out.println(9876.54345678);//
      
      //9876.54345678f
      //4바이트에 담으려고 줄어든다.
      //유효자릿수 7자리까지 유효하다.
      System.out.println(9876.54345678f); //=>9876.543
  
    }
}