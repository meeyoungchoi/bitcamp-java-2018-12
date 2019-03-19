//패키지를 탐색하여 빈을 자동 생성하기
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03_j {
	public static void main(String[] args) {
		ApplicationContext iocContainer = 
				 new AnnotationConfigApplicationContext(AppConfig03.class);
		
	//스프링 IoC 컨테이너가 생성한 객체 꺼내기
		Student2 obj1 = (Student2) iocContainer.getBean("student2");
		System.out.println(obj1);
		
		  // @Component가 붙지 않은 클래스는 자동으로 객체를 생성하지 않는다.
	   // Student obj2 = (Student) iocContainer.getBean("student");
	   // System.out.println(obj2);
		
		System.out.println("실행완료");
		
	}

}
