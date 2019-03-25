// BeanPostProcessor - @Autowired 사용법 : 같은 타입의 객체가 여러개 있을 경우
package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {
public static void main(String[] args) {
	ApplicationContext iocContainer = 
	        new ClassPathXmlApplicationContext("ch29/h/application-context-08.xml");
    //car라는 생성자가 먼저 호출되고 인스턴스가 만들어진다.
	//@Quqlifier("객체이름")을 사용하여 여러 개의 객체 중에서 어떤 것을 주입할 지 지정한다.
    System.out.println("---------------------------------------");
    
    
    System.out.println(iocContainer.getBean("c1"));

   
   
 
  }
}
