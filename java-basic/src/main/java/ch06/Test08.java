//메서드 -가변 파라미터의 단점
package ch06;

public class Test08 {

  public static void main(String[] args) {
    compute("홍길동", 100, 100, 90);
    compute("임꺽정");
    compute("유관순");
    
    compute3(new int[] {100, 100, 90}, "홍길동");
    compute3(new int[] {}, "임꺽정");
    compute3(new int[] {100, 100, 100, 100}, "유관순");
    
    compute4(new int[] {100, 90, 80}, new String[] {"홍길동", "임꺽정","유관순"});
  }
  
  //가변 파라미터는 무조건 마지막 순서에 와야 한다.
    //static int plus1(int...value, String name) {//컴파일 오류variable argument:변할수 있는      int.. value:가변파라미터
    static void compute(String name, int... value ) {
      int sum=0;
      for(int i=0; i<value.length; i++) {
        sum += value[i];
      }
      System.out.printf("%s님의 총점은 %d입니다.\n", name, sum); //홍길동님의 총점은 290입니다. 임꺽정 유관순
    }
    
    
    //가변 파라미터는 1개만 가능하다.
    /*static int compute2(int...value1, String...name) {//가변파라미터는 항상 마지막에 와야 하기때문에 두개가 올수 없다(컴파일요류)
      int sum=0;
      for(int i=0; i<value1.length; i++) {
        sum += value1[i];
      }
      return sum;
    }*/
    
    //배열은 순서에 상관없다. 어느 순서에도 올 수 있다.
    static void compute3(int[] value, String name ) {
      int sum=0;
      for(int i=0; i<value.length; i++) {
        sum += value[i];
      }
      System.out.printf("%s님의 총점은 %d입니다.\n", name, sum);//홍길동님의 총점은 290입니다.  임꺽정님의 총점은 0입니다. 유관순님의 총점은 400입니다.
    }
    
    
  //여러개의 배열을 파라미터의 값으로 넘길 수 있다.
    static void compute4(int[] value, String[] name ) {
     //홍길동님의 총점은 100점입니다. 임꺽정님의 총점은 90입니다. 유관순님의 총점은 80입니다.
      for(int i=0; i<value.length; i++) {
        
      }

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
 * 
 * */
