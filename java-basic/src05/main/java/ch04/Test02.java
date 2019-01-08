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
    //&&: 이 연산자는 왼쪽과 오른쪽 두개가 모두 참일때 참이 나오고
    //둘중 하나라도 거짓이면 거짓이 나온다.
    // &&이 연산자 사이에는 true냐 false냐를 판달할수 있는 식이 오거나 boolean값 즉, true 또는 false 의 불린값도 들어갈수 있다.
    //System.out.println(10 && 10); //컴파일 오류
    //대입연산자는 데이터 타입에 따라서 사용여부가 결정된다.
  }

}


