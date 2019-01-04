// 키보드로 입력한 값을 받기-int 값 읽기
package ch03;

public class Test08 {

  public static void main(String[] args) {
    
    //1.키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다,
    //system.in:키보드
 
    
   
    java.util.Scanner keyboard=new java.util.Scanner(System.in);
  

   System.out.printf("a? ");
    int a;
    a=keyboard.nextInt(); //하나의 숫자를 입력받는 명령어
    //하나의 정수값을 읽을때 사용
    //nextInt()는 한개의 토큰(token)을 읽을 때까지 기다린다.
    //한 개의 token을 읽으면 4바이트 정수 값으로 바꾼 다음에 리턴한다.
    //토큰(token)
    //토큰이란 공백으로 구분되는 단어를 뜻한다.
    //공백(whiltespace,스페이스 누룰때)
    //=>스페이스, 탭 , 줄바꿈 코드를 말한다.
    //예) aaa bbb cc=>aaa, bbb,cc
    //중간에 여러 개의 공백이 들어가더라도 한 개의 공백으로 간주한다.
    //단어와 단어사이에 공백이 있으면 자른다.
    //토큰이 되는 조건은 양쪽에 공백이 있어야 한다.
    
    
    System.out.printf("b?");
    int b=keyboard.nextInt();//입력이 완료될때까지 다음라인을 실행하지 않는다(blocking)
    //enter를 처야 변수에 값이 들어간다.
    //키보드로부터 입력된 값이 콘솔창에 보여지고 그 값이 nextLine()으로 보내진다.
    
  
   System.out.printf("%d * %d=%d\n",a,b,a*b);
    
  
   
   
    
  }

}









