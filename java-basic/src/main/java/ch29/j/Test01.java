// java config - 자바 클래스로 스프링 IoC zjsxpdlsj tjfwjdgkrl
package ch29.j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
  public static void main(String[] args) {
	  
	  //java-config를 다룰때는 AnnotationConfigApplicationCOntext 클래스를 사용한다.
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig1.class);
    
    //@Component 애노테이션이 붙은 클래스의 인스턴스를 자동으로 생성한다.
    //=>org.springframework.context.annotation.internalCommonAnnotationProcessor ==> org.springframework.context.annotation.CommonAnnotationBeanPostProcessor애가 추가된다.
    System.out.println("---------------------------------------");

    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
    	System.out.printf("%s ==> %s\n",
    			name, iocContainer.getBean(name).getClass().getName());
    }
  }
}
