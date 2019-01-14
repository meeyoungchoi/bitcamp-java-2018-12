//인스턴스 필드의 초기화 - 인스턴스 필드 초기화 절차
package ch10;

class Monitor5 {
  int bright;//밝기0 ~ 100
  int contrast = 50;//명암(0 ~ 100)
  int widthRes;//해상도 너비
  int heightRes = 1080;//해상도 높이
  
  {//인스턴스 블록
    this.bright = 50;
    this.contrast = 60;
    this.widthRes = 1920;
    
  }
  
  Monitor5()  {
    this.contrast = 70;
    this.widthRes = 2560;
    this.heightRes = 1200;
  }
  void display() {
    System.out.println("==================================================");
    System.out.printf("밝기(%d)\n",this.bright);
    System.out.printf("명암(%d)\n",this.contrast);
    System.out.printf("해상도(%d x %d)\n",this.widthRes,this.heightRes);
    System.out.println("=================================================");
  } 
}


public class Test07 {
  
  public static void main(String[] args) {
   
    //모니터3 인스턴스 생성
    Monitor5 m1 = new Monitor5();
    
    //인스턴스 필드 초기화 절차
      //                      bright | contrast | widthRes | heightRes |
      // 인스턴스가 생성되면 0값       0           0           0              0     | 1. =>인스턴스 필드 생성 후 기본 값으로 초기화 됨
//2.인스턴스 필드의 초기화 문장이 실행   0           50          0              1080
//3.인스턴스 블록 실행                 50          60          1920           1080
//4.생성자 실행                       50            70          2560           1200
//
    m1.display();
    

    
    
  
    
  
    
    
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
