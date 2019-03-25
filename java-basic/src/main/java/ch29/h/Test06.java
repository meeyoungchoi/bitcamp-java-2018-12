// BeanPostProcessor - @Autowired 사용법 : 필수/선택 의존 객체 지정
package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {
public static void main(String[] args) {
	ApplicationContext iocContainer = 
	        new ClassPathXmlApplicationContext("ch29/h/application-context-06.xml");
    //car라는 생성자가 먼저 호출되고 인스턴스가 만들어진다.
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));

   
   
 
  }
}
