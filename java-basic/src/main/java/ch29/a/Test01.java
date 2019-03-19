//스프링 IoC 컨테이너 사용
//컨테이너의 종류
package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		//IoC 컨테이너
		//=>bean Contatiner 라고도 부른다.
		//=>인스턴스의 생성과 관리를 담당한다,
		//=>각 객체가 의존하는 객체(dependency)를 주입한다.
		// 의존 객체 주입(depedency injection; di)이라 부른다.
		//그래서 di 컨테이너  라고도 부른다.
		//
		//ApplicationContect 인터페이스
		//=>스프링 IoC 컨테이너의 사용 규칙을 정의한 인터페이스이다.
		//=>모든 스프링 IoC 컨테이너는 이 규칙에 따라 IoC 컨테이너가 정의되어 있다.
		//
		//ApplicationContext 구현체(impelments, 인터페이스를 구현한 클래스 또는 그 클래스의 인스턴스)의 종류
		//=> xml 파일에서  설정 정보를 읽어들이는 IoC 컨테이너
		//  -classPathXmlApplicationCOlntext : 설정 파일을 자바 classpath 경로에서 찾는다.
		//   -FileSystemXmlApplicationContext: 설정 파일을 os 경로에서 찾는다.
		//=> 자바 클래스 파일의 애노테이션 설정 정보를 읽어들이는 IoC 컨테이너
		// -AnnotationCOnfigApplicationContext : 설정 정보를 자바 클래스에서 찾는다.
		
		//1) 자바 classpath 에서 설정 파일을 찾는 ioc컨테이너
		//=>classPath?
		// /Users.ecom
		//즉 jvm을 실행했을 때 jvm 이 자바 클래스 파일(.class)을 로딩하ㅣㄱ 위해 찾는 경로이다.
		//보통 jvm을 실행할 때 -classPath 옵션이나 -cp 옵렷능로 경로를 지정한다.
		//물론 jvm이 클래스 파일을 찾을 jvm의 기본 경로($JAVA_HOME/lib)를 가장 먼저 뒤진다.
		//=>설정 파일 경로를 지정할 때 자바 패키지 경로를 짖어ㅏ낟,
		//파일 경로이기 때문에 패키지와 패키지 사이에는 . 대신에 /를 사용해야 한다.
		ApplicationContext iocContainer1 = 
				new ClassPathXmlApplicationContext("ch29/a/application-context.xml");
		
		//2) 운영체제의 파일 시스템에서 설정 파일을 찾는 IoC 컨테이너
		//=>설정 파일 경ㅇ로를 지정할 때 
		//주의!
		//설정 파일 경로를 지정할 때 url 형식으로 지정해야 한다.
		//url 형식에서는 파일 시스템을 가리킬 때 다음의 접두어를 붙인다,
		// file://
		ApplicationContext iocContainer2 = 
				new FileSystemXmlApplicationContext(
						"file:///home/meeyoungchoi/git/bitcamp-java-2018-12/java-basic/bin/main/ch29/a/application-context.xml");
		
		
		//3) 자바 클래스 파일의 애노테이션으로 부터 설정 정보를 추출한다,
		//=>생성
		ApplicationContext iocContainer3 = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("실행완료");
		
		
	}

}
