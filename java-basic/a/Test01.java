// aop 사용 전
package ch30.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch30/a/application-context-01.xml");
    
   
    System.out.println("---------------------------------------");

    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
    	System.out.printf("%s ==> %s\n",
    			name, iocContainer.getBean(name).getClass().getName());
    }
    
   System.out.println("---------------------------------------------------");
   
   
   System.out.println(iocContainer.getBean("caller"));
  }
}
