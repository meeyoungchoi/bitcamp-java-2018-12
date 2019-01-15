//생성자 - 생성자와this

package ch10;

class Monitor10 {
  int bright;//밝기0 ~ 100
  int contrast = 50;//명암(0 ~ 100)
  int widthRes;//해상도 너비
  int heightRes = 1080;//해상도 높이

  //여러 개의 생성자를 정의 할 수 있다. 
  Monitor10()  {
    //다른 생성자를 호출할 수 있다.
    //=>단 반드시 첫 번쨰 문장으로 작성해야 한다.
    this(50, 50, 2560, 1200);

    //다른 생성자를 호출한다.
    //this(50, 50, 2560, 1200);//Constructor call must be the first statement in a constructor
    System.out.println("monitor10()");
  }
  Monitor10(int bright, int contrast)  {
    this(bright, contrast, 0, 0);
    System.out.println("monitor10(int, int)");
  }
  
  Monitor10(int bright, int contrast, int widthRes, int heightRes) {
    this.bright = bright;
    this.contrast = contrast;
    this.widthRes = widthRes;
    this.heightRes = heightRes;
    System.out.println("monitor10(int, int, int, int)");
    
  }
  

 

  public void on() {
    //주의!
    //일반 메서드는 생성자를 호출할 수 없다.
   // this();//Constructor call must be the first statement in a constructor
    
    System.out.println("화면을 출력한다.");
  }
}


public class Test12 {
  
  public static void main(String[] args) {
   //인스턴스 생성
    
  
    new Monitor10(); 
    System.out.println("======================================");
    
    new Monitor10(50, 50); 
    System.out.println("======================================");
    
    new Monitor10(50, 50, 1920, 1080); 
 
    
    //주의!
    //일반 메서드처럼 임의로 생성자를 호출할 수는 없다.
    Monitor10 obj1 = new Monitor10();
    //obj1.Monitor10();//컴파아리 오류

    
  
    
   }
}




