// 키보드로 입력한 값을 받기
package ch03;

public class Test06 {

  public static void main(String[] args) {
    
    //1.키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다,
    java.io.InputStream in=System.in;
    
    //2.inputStream은 바이트 단위로 읽는 기능이 있다.
    //바이트 단위로 읽어서 int나 문자열로 바꾸려면 또 코딩해야 하는 불편함이 있다.
    //이런 불편함을 줄이기 이해 자바에서는 바이트를 적절한 개발자가 원하는 값으로 
    //바꿔주는 기능을 제공한다.
    //그런 기능이 들어있는 도구가 java.util.scanner이다.
    java.util.Scanner keyboard=new java.util.Scanner(in);
  
   //System.out.println(데이터를종류별로쉽게읽을수있는기능을갖춘도구.nextLine());//한줄 읽어라
   
   //사용자에게 입력하라고 간단히 출력하자
   System.out.println("이름을 입력하세요:");
    
   //3. scanner에 들어있는 nextLIne()은 사용자가 한 줄을 입력할 때까지 기다리다가
   //사용자가 한 줄을 입력하면 그 값을 문자열로 만들어 리턴한다.
   //한줄을 읽으면 str메모리에 저장한다.
   //한죽 읽어들이고 싶을때 생각하지말고 그냥 써라
    java.lang.String str=keyboard.nextLine();
    
    //사용자가 입력한 문자열을 출력한다.
    //%s에 str에 저장된 문자열을 넣고 한줄 출력한다.
   System.out.printf("당신의 이름은 %s 입니다.\n", str);
    
  
   
   
    
  }

}









