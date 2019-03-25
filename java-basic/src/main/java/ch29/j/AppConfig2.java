package ch29.j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@Configuration 
//=>AnnotationApplicationContext 컨테이너에 클래스를 직접 지정할 경우에는
//굳이 @Configuration 애노테이션을 붙일 필요가 없다.
//예) ApplicationContext iocContaioner =
 //  new Annocati
//
//=>그런데 다음과 같이 컨테이너에 java config 클래스를 직접 알려주지 않을 경우에는,
//예), ApplicationContext iocContainer = 
//new AnnotationConfigApplicationContext("ch29.j");
//이 클래스가 java config 클래스임을 표시할 때 붙이는 애노테이션이 @Configuration이다.
//이 클래스를 컨테이너에게 간접적으로 알려주고 싶을 때 
//그러니까 객체 생성해서 처리해아
/**@Configuration를 붙였을때 출력되는 결과
 * appConfig2 ==> ch29.j.AppConfig2$$EnhancerBySpringCGLIB$$1df5599a
blackBox ==> ch29.j.BlackBox
car ==> ch29.j.Car
 * 
 * 
 * */
@Configuration
@ComponentScan("ch29.j2")
public class AppConfig2 {

}
