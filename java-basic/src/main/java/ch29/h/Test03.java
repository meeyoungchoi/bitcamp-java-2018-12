// BeanPostProcessor - 스프링에서 제공하는 @Autowired 애노테이션을 처리할 BeanPostProcessor 등록하기
package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
public static void main(String[] args) {
	ApplicationContext iocContainer = 
	        new ClassPathXmlApplicationContext("ch29/h/application-context-03.xml");
    //car라는 생성자가 먼저 호출되고 인스턴스가 만들어진다.
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c2"));
    System.out.println(iocContainer.getBean("c3"));
    System.out.println(iocContainer.getBean("c4"));
    
 
  }
}
