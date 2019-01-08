// 키보드로 입력한 값을 받기-토큰 단위로 문자열 읽기
package ch03;

public class Test15 {

  public static void main(String[] args) {
  
    //이거는 dog이라는 변수를 가지는 int타입의 배열 10개를 선언했다.
    int[] dog=new int[10];
    //여기서 dog는 레퍼런스 변수이고
    //int[10]이 부분 때문에 10개의 배열의 방이 만들어진다.
    
    //dog이라는 변수의 0번지에 10이라는 값을 저장한 것이다.
    //dog은 레퍼런스 변수이고 [0]는 0번지 인덱스 이다.
    //10은 값이다.
    //dog[0]을 합쳐서 변수로 보면된다.
    //dog[0]을 왜 레퍼런스변수로 보냐면
    //dog[0]=10 일때 
    //[0]번지에 10이라는 변수가 저장이 될때 주소값으로 변환되어서 저장이 되기 때문에 
    //그 dog[0] 이 자체를 레퍼런스 변수라고 부를수 있는 것이다.
    dog[0]=10;
    dog[1]=20;
    dog[2]=30;
    dog[3]=40;
    dog[4]=50;
    dog[5]=60;
    dog[6]=70;
    dog[7]=80;
    dog[8]=90;
    dog[9]=100;
    
    int sum1=0;
    //배열의 값을 다 더한다.
    for(int name : dog) {
      sum1=sum1+name;
    }
    System.out.println(sum1);
    
    
    
   
    
  }

}


/**
 *  배열
 *  -같은 종류의 메모리를 여러 개 만드는 문법
 *  
 *  배열 선언
 *  메모리종류[] 레퍼런스변수명;
 *  레퍼런스변수명=new 메모리종류[개수];
 *  
 *  메모리종류를 데이터타입이라 부른다.
 *  데이터타입[] 레퍼런스;
 *  레퍼런스=new 데이터타입[개수];
 * 
 * 예 int 메모리를 5개 선언하라
 * int[] values;
 * values=new int[5];
 * 
 * 
 * 배열 사용
 * 배열 레퍼런스[인덱스]=값;
 * 인덱스는 0부터 시작하여 배열개수 보다 한개 작은 값을 가진다.
 * 즉, int[] arr=new int[10];
 * 인덱스:0~9까지 부여된다.
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
 */








