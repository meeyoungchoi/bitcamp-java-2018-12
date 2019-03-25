// java config - 자바 클래스로 스프링 IoC zjsxpdlsj tjfwjdgkrl
package ch29.j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test02 {
  public static void main(String[] args) {
	  
	  //AnnotationConfigApplicationContext 컨테이너에 패키지명을 알려주면
	  //그 패키지에 있는 @Componenct, @Service, @Repositor, @Controller 객체를 생성한다.
	  //만약 클래스들 중에서 @Confiiguration 애노테이션이 붙은 클래스가 있다면
	  ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext("ch29.j"); //j패키지에서 @Component가 붙은 생성자만 생성한다.
    
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
