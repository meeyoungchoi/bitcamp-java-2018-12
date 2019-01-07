//산술 연산자
package ch04;

public class Test02 {

  public static void main(String[] args) {
    
  //데이터 타입에 따라 제공되는 연산자가 다르다.
    System.out.println(5.75 % 0.24); //ok
    //System.out.println(true % false); //boolean 타입에 대해서는 산술 연산자를 사용할 수 없다. 컴파일 오류
    //System.out.println(true + true);//컴파일 오류

    System.out.println("Hello" + "world"); //+ 연산자는 문자열 연결 용도로 사용된다.
    //System.out.println("Hello" - "o"); //컴파일 오류

    //System.out.println("hello," *5);// 컴파일 오류
    
    System.out.println(true && true);
    //System.out.println(10 && 10); //컴파일 오류
    //대입연산자는 데이터 타입에 따라서 사용여부가 결정된다.
  }

}


