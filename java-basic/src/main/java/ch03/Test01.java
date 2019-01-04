//변수 선언과 메모리 크기
package ch03;

public class Test01 {

  public static void main(String[] args) {
    
    //1바이트 정수값을 담을 메모리 준비
    byte b1;
    byte b2;
    byte b3;
    
    b1=-128;//리터럴 값이 비록 4바이트 크기이지만 메모리에 넣을 수 있다면 허락한다.
    b2=127;//단 8바이트 값은 담을 수 있더라도 허락하지 않는다. 컴파일 오류 ( b2=127L;)
   // b2=127L;
    //b3=128;//128은 1바이트 메모리에 담을 수 없기 때문에 컴파일 오류가 발생한다.(b3=128;)
    
    //2바이트 정수 값을 담을 메모리 준비
    short s1;
    short s2;
    short s3;
    
    s1=-32768;
    s2=32767;
    //s2=300L;//컴파일 오류 8바이트 리터럴은 안된다()
    //s3=32768;//컴파일 오류
    
    //4byte 정수 값을 담을 메모리 준비
    int i1;
    int i2;
    int i3;
    
    i1=-2100000000;
    i2=2100000000;
    //i2=2100000000L;//8바이트를 4바이트 메모리에 넣을수 없다(컴파일 오류)
   //i3=2200000000;//이때 발생하는 오류는 리터럴 표현 오류이다.( i3=2200000000;)
    //4바이트를 초과하는 값을 표현했으므로 오류
    
    
    //8바이트 정수 값을 담을 메모리
    long l1;
    long l2;
    long l3;
    
    l1=9000000000000000000L;//900경/ 922경을 넘어가면 컴파일오류
   //l2=9900000000000000000L;//8바이트 리터럴 오류
    
    
   //4바이트 부동소수점을 담을 메모리 준비
    float f1;
    float f2;
    float f3;
    
    f1=98765.43f;
    f2=98765.433456789f;//유효 자릿수를 넘어 가는 경우 짤려서 저장된다.
    //정수 메모리와 달리 컴파일 오류가 발생하지 않는다.
    //그래서 더더욱 주의해서 사용해야 한다.
    
    
    
    //System.out.println(f1);
   // System.out.println(f2);
    
    f1=9876.543f;
    f2=12.34567f;
    f3=f1+f2;//9876.543+12.34567=9888.88867이 나와야 한다.
    System.out.println(f3);// 실제 출력된 값=988.889
    
    double d3;
    d3=f1+f2; //두 부동소수점의 계산 결과가 4바이트 크기를 초과해서 결과가 이상하게 나온것 같아
    //더 큰 메모리를 준비 했다.
    
    
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f3); //두개를 더하는 순간 4바이트를 넘어서는 부동소수점 값이 되면 짤릴수 있다.
    System.out.println(d3);//그래서 기대하는 갓ㅂ이 잘나올거라고 생각하지만
    //실제 출력되는 값은 9888.8886771875로 나온다.
    
    //8바이트 부동소수점을 담을 메모리 준비
    double d1;
    double d2;
    //double d3;
    
    d1=98765.43;//8바이트 부동소수점을 표현할 때는 f, F접미사를 제거하라
    d2=98765.43456789;
    
    System.out.println(d1);
    System.out.println(d2);//유효자릿수 15자리까지 대부분 짤리지 않고 들어간다.
    //부동소수점은 원래 오차가 있을수 있다.
    
    //논리값
    boolean bool1;
    boolean bool2;
    boolean bool3;
    
    bool1=true;
    bool2=false;
    //bool3=1; =>컴파일 오류(true, false 외의 다른값은 저장할수 없다.)

    //
    char c1;
    char c2;
    char c3;
    
    c1=44032;//4바이트 정수 리터럴이더라도 0~65535까지의 값이라면
    //char 메모리에 저장하는 것을 허락한다.
    
    c2=0xac00;
    c3='가';//''의 리턴 값은 2바이트 유니코드 값이다.(0~65535)까지의 유니코드 정수값.
    System.out.println(c1);//변수 자체가 char이기 때문에 char를 붙이지 않아도 된다.
    System.out.println(c2);
    System.out.println(c3);
    
    
    
    
    
    
    

  }

}


/**
 * 변수: 값을 저장하는 메모리
 * 변수선언:값을 저장하는 메모리를 준비하는 명령(값을 저장할 메모리의 위치와 크기를 결정한다
 * 그 메모리에 이름을 부여한다.)
 * 변수를 선엏나 후 바로 그 이름을 사용하여 메모리에 접근하고 값을 넣고 꺼낸다.
 * "변수를 생성한다"라고 표현
 * 
 * 
 * 문법
 * 값을 표현할 메모리의 종류 메모리 이름;
 * int                 a;
 * 
 * 메모리 종류
 * 1)자바 primative data type(자바 원시 타입, 자바 기본 데이터 타입)
 * 정수
 *  -byte:-128 ~ 127
 *  -short(2byte): -32768 ~ 32767
 *  -int(4byte): 약 -21억 ~ 21억
 *  -long(8byte) 약: -900경 ~ 900경
 * 부동소수점
 *  -float(4byte): 유효자릿수 7자리
 *  -double(8byte): 유효자릿수 15자리
 * 논리값
 *  -boolean(int 크기):4byte(jvm에서)
 * 문자
 *  -char(2byte): 0~65535. utf-16 코드 값 저장
 *  
 * 2)레퍼런스(reference):객체 데이터들의 덩어리(객체의 주소를 저장하는 변수)
 * 자바 기본타입을 제외한 나머지 모두!
 * 문자열
 * 
 * 변수의 이름
 * 보통 소문자로 시작한다.
 * 대소문자를 구분한다.
 * 여러 단어로 구성된 경우 두 번째 단어의 시작 알파벳은 대문자로 한다.
 * 예) firstName, createdDate, userId
 * 상수인 경우 보통 모두 대문자로 이름을 짓는다.(단어와 단어사이는 _를 사용한다.)
 * 예) USER_TYPE, USER_MANAGER
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
 * 
 * 
 * */