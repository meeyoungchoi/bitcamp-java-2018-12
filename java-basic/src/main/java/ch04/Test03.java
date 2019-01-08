//산술 연산자
package ch04;

public class Test03 {

  public static void main(String[] args) {
    
    float r=5 / 2;
    System.out.println(r); //결과가 2.0이 나온다.
    //int 와 int의 연산 결과는 int 이다.
    //r변수에 값을 저장하기 전에 이미 결과는 2이다.
    
    //System.out.pri
    //해결책
    //두 개의 정수 값을 제대로 float으로 계산하고 싶다면 형변환 하라
    //형변환?
    //다른 타입의 메모리를 임시로 만들어 값을 넣는 방법이다.
    //주의
    //형변환 이라고 해서 원래 변수나 값의 타입을 다른 타입으로 변경하는 것이 아니다.
    //그래서 형변환을 타입 캐스팅 이라고도 부른다.
    //자바에서 타입은 한번 결정되면 바뀌지 않는다.
    //문법
    //(새로 만들 메모리의 타입) 값
    //다음과 같이 개발자가 형변환을 명시하는 경우,
    //명시적 형변환 이라 부른다.
    
    //임시 메모리 float
    float r2=(float)5/(float)2;
    //float 타입의 임시 메모리가 생성된후 정수 5가 저장된다.
    //float 타입의 임시 메모리가 생성된 후 정수 2가 저장된다.
    //임시 생성된 두 개의 float 메모리 값을 계산한다.
    //당연히 그 결과는 float 타입이다.
    System.out.println(r2);
    
    //타입이 다른 경우 연산을 수행할 수 없다. && true);
    //System.out.pri
    //반드시 계산을 수행하는 피연산자의 타입이 같아야 한다.
    //다르다면 내부적으로 두 피연산자의 값을 같은 타입으로 만든 후에 계산을 수행한다.
    //즉 개발자가 지시하지 않아도 내부적으로 같은 타입으로 만드는 것을
    //암시적 형변환이라고 한다.
    System.out.println("=====================================");
    float r3=5/(float)2;
    System.out.println(r3);
    
    
    byte b1=20;
    byte b2=30;
    byte b3=(byte)(b1+b2);
    //byte b3=b1+b2; //암시적 형변환에 의해 b1 b2의 값은 int 타입의 임시 메모리에 저장
    //그런후 계산된다. int 와 int의 계산 결과는 당연히 int이다.
    //그래서 컴파일 오류인 것이다.
    
    int x1=b1+b2; //ok
    
    short s1=20;
    short s2=30;
    //short s3=s1+s2;//위와같다. 계산하기 전에 int임시메모리에 값이 저장된다. 컴파일 오류
    int x2=s1+s2;
    System.out.println("=================");
    System.out.println(x2);
    
    char c1=20;
    char c2=30;
   // char c3=c1+c2; //컴파일 오류
    int x3=c1+c2;
    System.out.println("=================");
    System.out.println(x3);
    
    //char, short byte는 무조건 int로 형변환한 다음에 계산해야 한다.
    int i1=100;
    float f1=200.5f;
    //int i2=i1+f1;//컴파일 오류
    float f2=i1+f1;
    System.out.println("========");
    System.out.println(f2);
    
    //주의
    //
    float f3=9876.543f;
    float f4=12.34567f; 
   double d1=f3 +f4;//float과 float의 계산 결과는 float이다.
   //d1에 저장되기 전에 자릿수(7자리)를 초과한 값은 오차값으로 저장된다.
   //그래서 d1을 출력하면 오차가 있는 값이 출력되는 것이다.
   //계산결과를 합쳐야 할때는 무조건 double을 사용한다.
   //c:운영체제가 몇비트 냐에 따라 int의 바이트가 달라진다.
   //자바는 운영체제에 상관없다.
   System.out.println("==========================");
   System.out.println(d1);
     //해결책
   //계산하기 전에 더 큰 타입으로 형변환 해라
   double d2=(double)f3 +(double)f4;
   //그런데 출력 결과를 보면 예상 결과와 다르게 나온다.
   //float을 double로 형변환 할때 오차가 이미 생긴다.
   //부동소수점을 다룰 때 생기는 오차이다. 개발자가 제어할 수 없다.
   System.out.println("=====================");
   System.out.println(d2);
    
  
   //해결책
   //부동소수점의 경우 계산 결과가 float의 자릿수를 넘어갈 거 같으면
   //아얘 처음부터 double에 저장해 놓고 계산하라
   double d7=9876.543;
   double d8=12.34567;
   double d9=d7+ d8;//에 수행한다.
  // *자바의 최소 연산 단위는 int이다.
   System.out.println("====================");
   System.out.println(d9);
  }

}


/***
 * 암시적 형변환의 규칙
 * 서로 다른 타입과 연산을 수행한다면 다음 규칙에 따라 오른쪽 에 수행한다.
 *자바의 최소 연산 단위는 int이다.타입으로 자동 현변환을 수행한다.
 * byte(음수가 있는 2바이트), short(음수가 없는 2바이트)=>int=>long=>float=>double
 * long이 float으로 바뀔때 위험하다.에 수행한다.
 *자바의 최소 연산 단위는 int이다.
 * 
 * byte + short + char - float + long + int + double
 *(int) + (int): int 임시메모리가 생성되고 byte 값이 저장된다.
 *byte shor char를 연산할 때는 무조건 int로 형변환 한 다음에 수행한다.
 *자바의 최소 연산 단위는 int이다.
 * int + char =>char가 int로 바뀐다.
 * int + int 
 * int - float => float -float=float
 * float + long=>float +float=float
 * float + int =>float + float=float
 * float + double=>double +double=double
 * 
 * 
 * byte short char는 연산하기 전에 인트로 바뀐다.
 * float을 다룰때는 double을 다루는게 편하다.(부동소수점의 오차때문에)
 * 
 * 
 * *
 */



