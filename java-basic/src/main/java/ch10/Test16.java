//생성자 활용 - java.util.Calendar 클래스의 생성자


package ch10;

import java.util.Calendar;

public class Test16  {
  public static void main(String[] args) throws Exception {
    
    Calendar c1;
    //패키지가 달라도 자식클래스는 접근할수 있다.
    //생성자가 있다하더라도 접근권한이 없으면 호출할 수 없다.
    //c1 = new Calendar();//Cannot instantiate the type Calendar:캘린더 클래스에 대해서 인스턴스를 생성할수 없다.
    //캘린더에서 갖고 있는 프로텍티드 생성자는 패키지 안에서 만 사용할수 있다.
    //그래서 get인스턴스 방식으로 했는데 이거는 팩토리 메서드라는 디자인 방식을 이용해서 하는것이다.
    
    //Calendar는 인스턴스 생서응ㄹ 도와주는 별도의 클래스 메서드(스태틱 메서드)를 제공한다.
    c1 = Calendar.getInstance();//적절한 달력을 만들어준다.

    System.out.println(c1.get(Calendar.YEAR));
    
    /*
     * 팩토리 메서드(factory method)
     * Golf(gang of four)의 23가지 디자인 패턴(design pattern)중 하나이다.
     * 인스턴스를 생성해주는 메서드 이다.
     * 인스턴스 생성 과정이 복잡할 경웨 인스턴스를 생성해주는 메서드를 미리 정의해 둔다.
     * 그래서 인스턴스가 필요할 때 마다 메서드를 호출하여 인스턴스를 리턴 받는다.
     * 
     * 싱글톤(singleton pattern)
     * gof의 23 가지 디자인 패턴 중 하나
     * 인스턴스를 한 개만 생성하도록 제한 할 떄 사용
     * 생성자를 private으로 처리하여 직접 인스턴스를 생성하지 못하도록 만든다.
     * 메서드를 통해 인스턴스를 생성하도록 유도한다.
     * 캘린더는 싱글톤에 가깝다.
     * 
     * 
     * 
     * */
   }
}





