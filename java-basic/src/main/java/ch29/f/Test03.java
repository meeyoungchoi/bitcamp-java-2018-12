// 팩토리 클래스를 통해 객체 생성하기 -3 스프링 아이오시 컨테이너의 factorybean 규칙에 따라 공장 클래스 만들기 
package ch29.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
	   ApplicationContext iocContainer = 
		        new ClassPathXmlApplicationContext("ch29/f/application-context-03.xml");
    //car라는 생성자가 먼저 호출되고 인스턴스가 만들어진다.
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("blackBox"));//BlackBOx 객체 리턴
    System.out.println(iocContainer.getBean("carFactory"));//카팩토리2 객체 리넡
    System.out.println(iocContainer.getBean("c1"));//카 객체 리턴
    System.out.println(iocContainer.getBean("c1"));//기존에 생성된 카 객체 리턴
 

  }
}
