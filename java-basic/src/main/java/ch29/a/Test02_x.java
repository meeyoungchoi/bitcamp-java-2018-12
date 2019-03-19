//패키지를 탐색하여 빈을 자동 생성하기
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test02_x {
	public static void main(String[] args) {
		//빈을 자도으로 생성하고 싶은 클래스에
		//@Component 등의 애노테이션을 붙인다.
		ApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("ch29/a/application-context-02.xml");
		
	//스프링 IoC 컨테이너가 생성한 객체 꺼내기
		Student b1 = (Student) iocContainer.getBean("b1");
		System.out.println(b1);
		
		//=> No bean named 'b2' available
		Student b2 = (Student) iocContainer.getBean("b2");
		System.out.println(b2);
		
		System.out.println("실행완료");
		
		
	}

}
