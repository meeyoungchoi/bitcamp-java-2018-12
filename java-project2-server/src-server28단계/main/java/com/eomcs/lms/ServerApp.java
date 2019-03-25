// 28단계: log4j 1.x 저굥ㅇ하기
// =>애플리케이션을 실행하는 중에 내부 상태를 확인할 목적으로 
//기록을 남기는 것을 로깅(logging)이라 한다.
//=>로깅은 애플리케이션을 실행하는 콘솔 창으로 출력할 수 도 있고,
//파일이나 네트웍으로도 출력할 수 있다.
//=>보통 실무에서는 파일로 기록을 남긴다.
//=>로깅 작업을 도와주는 대표적인 라이브러리가 log4j 이다.
//출력 레벨에 따라 로깅을 조절할 수 있어 편리하다.
// 작업
//1)log4j 1.x 라이브러리를 추가한다
//=>ㅡ
//2)log4j 설정 파일 준비한다.
//=>classpath 루트 패키지에 log4j.properties 파일을 생성한다.
//3) mybatis에서 사용할 로깅 라이브러리 지정하기
//=>sqlSessionFacotory 객체를 생성할 때 어떤 로깅 라이브러리를 사용할 지 지정한다.
//MybatisConfig,java에서 SqlSessionFactory 생성하는 메서드 안에
//logFactory.useLog4Jlogging()

//Log4j 설정법
//=>classpath 루트 패키지에 log4j.properties이름으로 설정 파일을 둔다
//1)출력 등급 설정
// log4j.rootLogger=DEBUG,...
//  -rootLogger에 설정하면 모든 클래스에 대해 적용된다.
//=> log4j.logger.com.eomcs.lms.service=error
//   -com.eomcs.lms.service 패키지에 대해서는 error 레벨ㅇ르 적용한다.
//    -즉 rootLogger에 기본 출력 등급을 설정하고,
//    특정 패키지 전체나 특정 클래스에 대해 등급을 바꿀때 사용한다.
//=> 다음과 같이 등급을 조정할 수 있다.
// rootLogger = DEBUG
// com.eomcs.lms.dat = error
//com.eomcs.lms.service=fatal
//com.eomcs.lms.handler=info
//따로 지정하지 않으면 rootLogger의 출력 등급을 적용한다.
//=>등급 
// fatal: 애플리케이션을 중지할 만큼 치명적인 오류일 경우 예) dbms 연결 안됨
// error: 계속 애플리케이션을 실행해도 되는 오류일 경우 예)날짜 형식이 잘못되어 형변환 오류가 발생
// warn: 잠재적인 위험을 안고 있는 경우 예) 서버와의 소켓 연결을 close() 하지 못했을 때.
// info: 애플리케이션의 주요 실행 정보 예)어떤 ip의 클라이언트가 접속했는지에 대한 접속 정보, 연결종료 
//	debug: 애플리케이션의 내부 실행 상태를 추적해 볼 수 있는 정보 
// 예) mybatis가 실행하는 sql, sql을 실행할 때 in-parameter에 설정되는 값.
//	trace: 디버그 보다 더 상세한 정보
//예) IoC 컨테이너가 생성한 객체 목록
//
//=>등급에 따른 출력 제어
//FATAL > ERROR > WARN > INFO >  DEBUG> TRACE
//-지정된 등급 이상의 로그는 모두 출력된다.
//-즉 INFO 등급의 로그만 출력하도록 했으면, INFO 보다 큰 레벨(warn, error, fatal)의 로그도 출력한다.
//
//2) 출력 대상 지정
//=>어디로 출ㄹ겨할 것인지 지정한다.
//=>log4j.roolLogger=출력등급, 담당자 이름
//log4j.appender.담당자이름=담당자가 출력하기 위해 사용할 도구(패키지명을 포함한 클래스명)
// 예) 
//log4j.rootLogger=DEBUG, A
//log4j.appender.A=org.apache.log4j.ConsoleAppender
//=>출력도구
//org.apache.log4j.ConsoleAppender : 콘솔 창으로 출력, 
//즉 System.out/System.err 객체를 사용하여 출력.
//org.apache.log4j.FileAppender
//-지정된 파일로 출ㄹ겨
//org.apache.log4j.net.SockerAppender
//
//3) 출력 형식 지정
//=>출력할 문자열의 형식을 지정할수 있다.
//=>log4j.appender.담당자명.layout=출력형식을 다룰 클래스
//예) log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
//=>출력 형식을 다룰 클래스
//org.apache.log4j.PatternLayout
//-단순 문자열 출력
//org.apache.log4j.HTMLLayout
//-html 태그로 출력
//org.apache.log4j.PatterLayout
//-설정 파일에 지정된 형식에 맞춰 출력
//org.apache.log4j.xml.xmllayout
//-xml태그로 출력
//
//4) 출력 형식의 패턴 설정하기
//=>PatternLayout을 사용하여 출력할 떄 설정하는 방법
//=> 문법
//%p - 출력 등급. 예) FATAL, ERROR, WARN, INFO, DEBUG, TRACE
//%자릿수p 출력문자열의 자릿수 지정
//%t 스레드 이름. 서버인 경우 동시에 여러 클라이언트가 요청을 한다.
//    따라서 클라이언트 요청을 처리하는 스레드가 다를 수 있다.
//%m  -로그메시지.
//%n -줄바꿈 명령. 
//%d{yyyy-MM-dd HH:mm:ss} -년 월 일 시간:분 초 를 출력
//%c - 클래스명 출력
//%c{개수}
//%출력개수c- 클래스명을 포함하여 패키지명 개수 지정
//%M -로그를 출력하는 메서드명 출력
//log4j를 코드에서 사용하기
//1) 특정 클래스로 로그 남기기
//Logger logger = LogManager.getLogger(클래스 타입);
//2) xmrwjd qnsfbauddmfh fhrm skarlrl
//=>여러 클래스의 로그를 하나로 묶어 표현하고 싶을 때
//Logger logger = LogManager.getLogger("분류명");
//
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.Response;

public class ServerApp {
	//보통 클래스에서 사용할 로그 출력 객체는 클래스의 스태틱 멤버로 선언한다.
	final static  Logger logger =LogManager.getLogger(ServerApp.class);

	// Command 객체와 그와 관련된 객체를 보관하고 있는 빈 컨테이너
	ApplicationContext iocContainer;

	// 클라이언트 요청을 처리할 메서드 정보가 들어 있는 객체
	RequestMappingHandlerMapping handlerMapping;

	public void service() throws Exception {

		try (ServerSocket ss = new ServerSocket(8888)) {
			logger.info("서버 실행 중...");//단순 정보

			// Spring IoC 컨테이너 준비
			iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
			printBeans();

			// 스프링 IoC 컨테이너에서 RequestMappingHandlerMapping 객체를 꺼낸다.
			// 이 객체에 클라이언트 요청을 처리할 메서드 정보가 들어 있다.
			handlerMapping = 
					(RequestMappingHandlerMapping) iocContainer.getBean(
							RequestMappingHandlerMapping.class);



			while (true) {
				new RequestHandlerThread(ss.accept()).start();
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} // try(ServerSocket)

	}

	public static void main(String[] args) throws Exception {
		ServerApp app = new ServerApp();

		// App 을 실행한다.
		app.service();
	}

	// 바깥 클래스(ServerApp)의 인스턴스 필드를 사용해야 한다면 
	// Inner 클래스(non-static nested class)로 정의하라!
	// 
	class RequestHandlerThread extends Thread {

		Socket socket;

		public RequestHandlerThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			logger.info("클라이언트 연결되었음.");
			try (Socket socket = this.socket;
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream())) {

				// 클라이언트의 요청 읽기
				String request = in.readLine();

				// 클라이언트에게 응답하기
				// => 클라이언트 요청을 처리할 메서드를 꺼낸다.
				RequestMappingHandler requestHandler = handlerMapping.get(request);

				if (requestHandler == null) {
					out.println("실행할 수 없는 명령입니다.");
					out.println("!end!");
					out.flush();
					return;
				}

				try {
					// 클라이언트 요청을 처리할 메서드를 찾았다면 호출한다.
					requestHandler.method.invoke(
							requestHandler.bean, // 메서드를 호출할 때 사용할 인스턴스 
							new Response(in, out)); // 메서드 파라미터 값

				} catch (Exception e) {
					out.printf("실행 오류! : %s\n", e.getMessage());
					e.printStackTrace();
				}

				out.println("!end!");
				out.flush();

			} catch (Exception e) {
				logger.error("명령어 실행 중 오류 발생 : " + e.toString());
				StringWriter strWriter = new StringWriter();
				PrintWriter out = new PrintWriter(strWriter);
				e.printStackTrace(out);//상세하ㅔ 출력

				logger.error(strWriter.toString());

			}logger.info("클라이언트 연결종료.");
		}
	}

	private void printBeans() {
		//개발하는 동안 참고할 로그는 보통 debug 등급으로 출력한다.
		logger.debug("============= ====================");
		String[] names = iocContainer.getBeanDefinitionNames();
		for (String name: names) {
			logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)",name,
					iocContainer.getBean(name).getClass().getName()));
		}
		logger.debug("============= ====================");
	}

}









