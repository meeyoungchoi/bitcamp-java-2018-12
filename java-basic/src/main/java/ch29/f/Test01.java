// 팩토리 클래스를 통해
package ch29.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
	   ApplicationContext iocContainer = 
		        new ClassPathXmlApplicationContext("ch29/f/application-context-01.xml");
    //car라는 생성자가 먼저 호출되고 인스턴스가 만들어진다.
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
    
    java.sql.Date obj = (java.sql.Date) iocContainer.getBean("d1");
    System.out.println(obj);

  }
}
