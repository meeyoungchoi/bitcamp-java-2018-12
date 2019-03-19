//빈 생성과 꺼내기
//xml로 빈 설정하기
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test03_x {
	public static void main(String[] args) {
		//객체 생성
		//<bean id ="빈의 이름" class="패키지명을 포함한 클래스명"/>
		ApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("ch29/a/application-context-03.xml");
		
	//스프링 IoC 컨테이너가 생성한 객체 꺼내기
		Student2 obj1 = (Student2) iocContainer.getBean("student2");
		System.out.println(obj1);
		
		 // @Component가 붙지 않은 클래스는 자동으로 객체를 생성하지 않는다.
	    Student obj2 = (Student) iocContainer.getBean("student");
	    System.out.println(obj2);
	    
		
		System.out.println("실행완료");
		
		
	}

}
