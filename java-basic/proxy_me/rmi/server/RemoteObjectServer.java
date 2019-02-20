//원격 객체를 서버에 등록하기 - rmi 레지스트리 서버에 등록하기
package design_pattern.proxy.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectServer {

	public static void main(String[] args) {
		//실행방법
		//=> 먼저 rmi registry 서버를 실행하라
		// >rmiregistry
		//=> 주의! rmi registry 서버가 클래스를 찾을 수 있도록  .class 파일이 있는 디렉토리에서 실행하라
		// java-basic/bin/main>rmiregistry
		//그리고 이 클래스를 실행한다.
		
		//원격 객체를 사용할 수 있도록 rmi reg
		
		//보안 관리자 등록
		//원격에서 접속할 때 사용할 수 있는 자원의 범위를 통제하는 객체
		//
	//	if (System.getSecurityManager() == null) {
	//		System.setSecurityManager(new SecurityManager());
	//	}
		
		try {
			//2원격 객체 (실제 일을 하는 객체)생성 : calObj
			Calculator calObj = new CalculatorImpl();
			
			//3. 원격 객체와 통신을 담당할 프록시(클라이언트측 ORB)를 생성한다.
			//첫 번째 파라미터는 원격 객체 : calObj
			//두 번째 파라미터 : 포트번호, 0으로 지정하면 임의의 유효한 포트번호가 지정된다. 포트번호를 신경쓸 필요없다. : 0
			//이렇게
			Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calObj, 0);
			//stub을 서버에 등록 해야 한다.
			
			//4. rmi registry 서버를 다룰 rmi registry 서버에 stub 객체를 등록해줄 도구를 준비한다.
			//LocateRegistry.getRegistry()의 값을 registry에 담는다.
			//127.0.0.1로 접속하여 찾을 수 있다.
			Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");
			
			//5. Registry 도구를 사용하여 rmi registry 서버에 stub을 등록한다.
			//
			registry.rebind("calc", stub);//stub: 클라이언트 대행//stub객체를 clac라는 이름으로 등록한다.
			
			System.out.println("Calculator 객체의 프록시(stub)가 rmi registry 서버에 등록되었다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
