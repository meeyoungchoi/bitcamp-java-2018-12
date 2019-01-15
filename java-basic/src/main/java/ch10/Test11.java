//생성자 - 기본 생성자(default constructor) 2.
//인스턴스에 있는 메서드를 정상적으로 사용할수 있도록 인스턴스 메서드가 필요로 하는 값들을 유효한 값으로 초기화 시키자
package ch10;

class Monitor9 {
  int bright;//밝기0 ~ 100
  int contrast = 50;//명암(0 ~ 100)
  int widthRes;//해상도 너비
  int heightRes = 1080;//해상도 높이

  //여러 개의 생성자를 정의 할 수 있다. 
  Monitor9()  {//메소드가 사용하는 값
    this.bright = 50;
    this.contrast = 70;
    this.widthRes = 2560;
    this.heightRes = 1200;
    System.out.println("monitor9()");
  }
  Monitor9(int bright, int contrast)  {
    this.bright = bright;
    this.contrast = contrast;
    System.out.println("monitor9(int, int)");
  }
  
  Monitor9(int bright, int contrast, int widthRes, int heightRes) {
    this.bright = bright;
    this.contrast = contrast;
    this.widthRes = widthRes;
    this.heightRes = heightRes;
    System.out.println("monitor9(int, int, int, int)");
    
  }
  

 

  public void on() {
    
    System.out.println("화면을 출력한다.");
  }
}


public class Test11 {
  
  public static void main(String[] args) {
   //인스턴스 생성
    
    //생성자를 지정할 때 파라미터의 값에 따라 결정된다.
    new Monitor9(); //기본 생성자를 지정한다.
    new Monitor9(50, 50); //Monitor9(int, int) 생성자를 지정한다.
    new Monitor9(50, 50, 1920, 1080); //Monitor9(int, int , int, int)  
    
    //파라미터 타입이나 개수가 일치하지 않는 생성자는 호출할 수 없다.
    //new Monitor9(50);//컴파일 오류

    
  
    
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
