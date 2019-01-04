// 키보드로 입력한 값을 받기-int와 문자열ㅇ르 섞어읽기
package ch03;

public class Test09 {

  public static void main(String[] args) {
    
    //1.키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다,
    //system.in:키보드
 
    
   
    java.util.Scanner keyboard=new java.util.Scanner(System.in);
  

   System.out.printf("나이?");
    int age;
    age=keyboard.nextInt(); 
    //nextInt(): 한 개의 토큰을 읽은 후에 줄 바꿈 코드는 그냥 읽기 전 상태로 내비둔다.
    //따라서 다음에 nextLine()을 호출하면 의도치 않게 빈 문자열을 가진 한 줄을 읽는 상황이 된다.
    //nextInt() 다음에 nextLine()을 호출할 때 이런 상황이 발생한다.
    //해결방법?
    //nextInt()를 호출한 후 남아있는 엔터 코드를 읽어서 제거하라.
    keyboard.nextLine();// 남아있는 빈 문자열의 한 줄(lf 코드)를 읽어서 버린다.
   
    
    
    System.out.printf("이름?");
    String name=keyboard.nextLine();//입력이 완료될때까지 다음라인을 실행하지 않는다(blocking)
    //enter를 처야 변수에 값이 들어간다.
    //키보드로부터 입력된 값이 콘솔창에 보여지고 그 값이 nextLine()으로 보내진다.
    
  
   System.out.printf("%d(%s)\n",age,name);
    
  
   
   
    
  }

}









