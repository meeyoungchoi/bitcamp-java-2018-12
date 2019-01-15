//생성자 - 기본 생성자(default constructor) 2.
package ch10;

class Monitor8 {
  int bright;//밝기0 ~ 100
  int contrast = 50;//명암(0 ~ 100)
  int widthRes;//해상도 너비
  int heightRes = 1080;//해상도 높이

 //만약 생성자가 한 개라도 있으면 컴파일러는 기본 생성자를 추가하지 않는다.
  //
  //파라미터로 부터 받은 값을 인스턴스에 저장
  //파라미터가 있는 생성자를 만들면 기본생성자가 없으므로 만들어 지지 않는다.
  Monitor8(int bright, int contrast)  {
    this.bright = bright;
    this.contrast = contrast;
  }
  

 

  public void on() {
    
    System.out.println("화면을 출력한다.");
  }
}


public class Test10 {
  
  public static void main(String[] args) {
   //인스턴스 생서
    
    //기본 생성자가 없는 경우 다음과 같이 기본 생성자를 지정할 수 없다.
   // new Monitor8(); //기본생성자가 없다는 오류
    
    
    //존재하는 생성자를 지정해야 하고, 그 생성자의 파라미터에 맞춰 값을 넘겨야 한다.
    //=>모니터8 설계도에 따라 인스턴스를 생성한 후, int값 두개를 받는 생성자를 호출하라는 의미이다.
    new Monitor8(50, 50); //ok

    
  
    
   }
}




/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
