// &&, || vs  &, |

package ch04;

public class Test12 {

  public static void main(String[] args) {
    //괄호 연산
    int a=5;
    int r=10 / (a=2);
    System.out.printf("%d, %d\n", a, r);
   //괄호를 먼저 실행해서 a=2
    ////r=10 /(a=2)
    //r=10/(a변수에 2를 저장한다)
    //r=10/(a변수의 값을 리턴한다.)
    //r=10/2
    //r=5
    
    //&&와 &의 차이점
    //&& 피연사자가 모두 true일때만 true이다.
    //나머지는 false
    boolean b1=true;
    boolean b2=false && (b1=true); //r이 false이면 
    System.out.printf("b1=%b, b2=%b\n",b1,b2);
    // &&: l-vale의 값으로 결과를 유츄할수 있다면, r-value를 실행하지 않는다.(효율적 연산 수행)
   
    b1=true;
    b2=false & (b1=true);//&: 둘다 flase이면 false이다.
    System.out.printf("b1=%b, b2=%b\n",b1,b2);
    //false, false=>false
    //true, false=>false
    //true, true=>true
    //&: ll-vale의 값으로 결과를 유츄할수 있다해도 r-value까지 끝까지 계산해서 결과를 낸다.
    
    
    b1=true;
    b2=true || (b1=false); 
    // || 둘중에 한개라도 true이면 true이다.
    //나머지는 false
    
    System.out.printf("b1=%b, b2=%b\n",b1,b2);
    
    b1=true;
    b2=true | (b1=false); 
    //  | 둘중에 한개라도 true이면 true이다.
    System.out.printf("b1=%b, b2=%b\n",b1,b2);
  }

}


/***
 
 *
 * 
 * 
 * *
 */



