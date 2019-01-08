// 조건연산자=>피연산자가 3개이다
//조건 ? 표현식1 : 표현식2
//condition ? expression: expression
//   (con)           (expr)
//문장
//세미콜론으로 끝나는 여러개의 연산자나 표현식으로 이루어진 한 명령
//표현식
//문장 중에서 리턴값이 있는 문장
//조건이 참이면 표현식 1의 리턴값이 놓이고, 거짓이면 표현식2의 리턴값이 놓인다.


package ch04;

public class Test17 {

  public static void main(String[] args) {

    int age=20;

    String result = (age >= 19) ? "성인" : "미성년";
    System.out.println(result);
    System.out.println((age >= 19) ? "성인" : "미성년");
    System.out.println((age >= 65) ? "성인" : "false");
  }

}


/***

 *
 * 
 * 
 * *
 */



