package ch29.j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


//@Configuration : 스르핑 IoC 컨테이너에게 이 클래스를 직접 알려주기 때문에 이 애노테이션은 필요없다.
@ComponentScan(basePackages="ch29.j2")
public class AppConfig4 {
	//애노테이션을 사용할 수 없는 경우 다음과 같이 수도응로 객체를 생성할 수 있다.
	//이때 @Bean 애노테이션을 붙여 이 메서다ㅡ를 호출하라고 스프링 IoC 컨테이너에게 알려줘야 한다.
	//스프링 IoC 컨테이너는 이 메소드를 호출한 후 그 리턴 값을 메서드 이름으로 저장한다,
	@Bean
	public BlackBox blackBox() {
		//이 메서드의 이름이 리턴 값을 젖아하는 이름으로 사용되기 때문에
		//메서드의 이름을 명사 형태로 짓느느다.
		BlackBox obj = new BlackBox();
		obj.setMaker("비트박스");
		obj.setModel("비트비트");
		
		return obj;
	}
	
	//스프링 IoC 컨테이너로 부터 객체를 주입받고 싶다면 파라미터에 선언하라
	@Bean//메서드의 리턴값을 보관하라
	public Car car2(ApplicationContext iocContainer) {
		BlackBox bb = (BlackBox)iocContainer.getBean("blackBox");
		Car obj = new Car();
		obj.setMaker("비트자동차");
		obj.setModel("모델1");
		obj.setAuto(true);
		obj.setBlackBox(bb);
		
		return obj;
	
	} 
}
