// aop 사용 - java config로 aop 생성하기
package ch30.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
  public static void main(String[] args) {
	   //Aop애노테이션을 사용하려면,
	  //aop 애노테이션을 처리할 클래스를 등록해야 한다.
	  //=><>
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig.class);
    
   
    System.out.println("---------------------------------------");

    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
    	System.out.printf("%s ==> %s\n",
    			name, iocContainer.getBean(name).getClass().getName());
    }
    
   System.out.println("---------------------------------------------------");
   
   
   X x = (X) iocContainer.getBean("x");
   System.out.println(x.calculate(10, 20, "+"));
   
   try {
   System.out.println(x.calculate(10, 20, "%"));
   } catch (Exception e) {
	   System.out.println("예외 발생!");
   }
  }
}

