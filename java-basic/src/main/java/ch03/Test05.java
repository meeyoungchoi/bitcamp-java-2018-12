//레퍼런스 변수
package ch03;

public class Test05 {

  public static void main(String[] args) {
    
    //java.util=>패키지
    //패키지에서 Date 데이터타입을 가지고온다.
    //Date에서 선언된 레퍼런스변수인 d1,d2에 저장이된다.
    //java.util.Date여기에 d1의 값이 저장된다.
    //d1에 java.util.Date값이 저장이된다.
    //java.util스.Date=>레퍼런
    //java.util.Date =>이 패키지에서 d1이라는 변수를 생성한것이다.  
    //java.util.Date에 d1,d2의 값이 저장이된다.
    java.util.Date d1=new java.util.Date();
    java.util.Date d2=d1; //주소를 복사한다는 의미이다.
    //따라서 서로 같은 값을 가진다.
    //d2라는 변수를 생성하고 d
    
    System.out.printf("%d, %d\n",d1.getDate(),d2.getDate() );
    //디프리케이티드 메소드:앞으로 사라질 메소드
    
    //System.out.println(d2.getDate());
    
    d1.setDate(22);//d1=22
    
    System.out.printf("%d, %d\n",d1.getDate(),d2.getDate());
    //System.out.println(d2.getDate());

    //d1에 저장된 일자 값을 변강한 후 
    //d2에 저장된 일자 값을 출력해 보면 d1과 똑같이 변경되어 있다.
    //이유
    //d1과 d2에 저장되는 것은 값이 아닌 날짜 정보가 저장되어 있는 메모리의 주소이다.
    //이렇게 값을 저장하지 않고 값이 저장된 위치(주소)를 저장하는 변수를
    //레퍼런스(변수) 라고 부른다.
    //자바 기본 데이터타입(byte, short, int, long, float, double, boolean, char)을 제외한 모든 변수가 레퍼런스이다.
    //클래스에서 더 자세히 다룬다
    //주소를 저장하는 변수를 레퍼런스라고 부른다.
    
  }

}

/**
 * 
 *
 * 
 * 
 * 
 * */








