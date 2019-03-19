//빈 생성과 꺼내기
//xml로 빈 설정하기
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test02_j {
	public static void main(String[] args) {
		//객체 생성
		//@Bean public Student b1() {return new Student(); }
		//
		ApplicationContext iocContainer = 
				new AnnotationConfigApplicationContext(AppConfig02.class);
		
	//스프링 IoC 컨테이너가 생성한 객체 꺼내기
		Student b1 = (Student) iocContainer.getBean("b1");
		System.out.println(b1);
		
		//=> No bean named 'b2' available
		//Student b2 = (Student) iocContainer.getBean("b2");
		//System.out.println(b2);
		
		System.out.println("실행완료");
		
		
	}

}
