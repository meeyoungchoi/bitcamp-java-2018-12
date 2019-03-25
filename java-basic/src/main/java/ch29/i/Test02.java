// @Component - <context:component-scan>사용법1 - 특정 클래스나 패키지 제외하기
package ch29.i;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/h/application-context-02.xml");
    
    //@Component 애노테이션이 붙은 클래스의 인스턴스를 자도응로 생성한다.
    //=>org.springframework.context.annotation.internalCommonAnnotationProcessor ==> org.springframework.context.annotation.CommonAnnotationBeanPostProcessor애가 추가된다.
    System.out.println("---------------------------------------");


    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c2"));
    System.out.println(iocContainer.getBean("c3"));
    System.out.println(iocContainer.getBean("c4"));
 
   
 
  }
}
