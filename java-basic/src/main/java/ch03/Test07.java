// 키보드로 입력한 값을 받기-한줄의 문자열 읽기
package ch03;

public class Test07 {

  public static void main(String[] args) {
    
    //1.키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다,
    //system.in:키보드
 
    
   
    java.util.Scanner keyboard=new java.util.Scanner(System.in);
  

   System.out.println("이름을 입력하세요:");
    java.lang.String name=keyboard.nextLine(); //enter칠때까지 리턴하지 않는다
    //엔터를 치면 키보드에서 0a값이 들어오면 문자열을 리턴한다.
    
    
    System.out.println("나이를 입력하세요:");
    String age=keyboard.nextLine();//입력이 완료될때까지 다음라인을 실행하지 않는다(blocking)
    //java.lang 패키지의 멤버를 사용할 때는 
    //패키지 이름을 적지 않아도 된다.
    //enter를 처야 변수에 값이 들어간다.
    //키보드로부터 입력된 값이 콘솔창에 보여지고 그 값이 nextLine()으로 보내진다.
    
  
   System.out.printf("당신의 이름은 %s 입니다.\n", name);
   System.out.printf("%s(%s)\n",name, age);
    
  
   
   
    
  }

}









