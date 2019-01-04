// 키보드로 입력한 값을 받기-토큰 단위로 문자열 읽기
package ch03;

public class Test10 {

  public static void main(String[] args) {
    
    //1.키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다,
    //system.in:키보드
 
    
   
    java.util.Scanner keyboard=new java.util.Scanner(System.in);
  

   System.out.printf("나이?");
    int age;
    age=keyboard.nextInt(); 

    keyboard.nextLine();// 남아있는 빈 문자열의 한 줄(lf 코드)를 읽어서 버린다.
   
    
    
    System.out.printf("이름?");
    String name=keyboard.next();
    //next:토큰 단위로 문자열을 읽는다.
    //nextInt()을 호출한 후 엔터 코드가 남아 있다 하더라도
    //but, next()는 공백(엔터)를 버리기 때문에 영향을 받지 않는다.

    
  
   System.out.printf("%d(%s)\n",age,name);
    
  
   
   
    
  }

}









