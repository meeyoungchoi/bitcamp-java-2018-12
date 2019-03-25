package ch29.j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


//@Configuration : 스르핑 IoC 컨테이너에게 이 클래스를 직접 알려주기 때문에 이 애노테이션은 필요없다.
@PropertySource({"classpath:ch29/j/jdbc.properties",
	"classpath:ch29/j/jdbc2.properties"})
public class AppConfig5 {
	//@PropertySorce를 통해 로딩된 프로퍼티 값을 사용하고 싶다면
	//
	@Autowired
	Environment env;
	
	//@PropertySource를 통해 로딩된 프로퍼티 값 중에서 특정 값만 필드로 주입 받을 수 있다.
	//=>필드에 @value 
	@Value("${jdbc.url}")
	String jdbcUrl;

	
	
	@Value("${jbcd2.url}")
	String jdbc2Url;
	
	@Bean
	public Car car1() {
		System.out.println("car() 호출 : ");
		System.out.println(" "  + env.getProperty("jdbc.url"));
		System.out.println(" " + env.getProperty("jdbc2.url"));
		return new Car();
	}
	
	@Bean
	public Car car2() {
		System.out.println("car() 호출 : ");
		System.out.println(" " + this.jdbcUrl);
		System.out.println(" " + this.jdbc2Url);
		return new Car();
	}
	
	@Bean
	public Car car3(@Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password) {
		
		System.out.println("car() 호출 : ");
		System.out.println(" " + username);
		System.out.println(" " + password);
		return new Car();
	}
}
