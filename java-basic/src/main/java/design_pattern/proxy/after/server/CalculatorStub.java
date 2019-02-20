package design_pattern.proxy.after.server;

//stub: 클라이언트 대행
//클라이언트 요청을 서버에게 전달하고 
//서버가 작업한 결과를 클라이언트에게 보내주는 일을 한다.
//즉 중개인 역할을 수행한다.
//이렇게 원격에서 객체를 사용할수 있도록 중계인의 역할을 수행하는 객체를 
//=> "Object Request Broker(ORB)"라 부른다.
//서버측 ORB(객체가 있는 서버 측에서 요청과 응답을 대행하는 orb를 스캘레톤(skeleton)이라 부른다.)
//객첼를 사용하는 클라이언트 측에서 요청과 응답을 대행하는 orb를 스텁(stub)이라 부른다.
//
//stub은 실제 일을 하는 객체를 대행하기 때문에 같은 규칙에 따라 구현되어야 한다. 
//클라이언트는 이 스텁 클래스르 ㄹ사용하여 작업을 수행한다.
//클라이언트는 이 스텁 클래스가 실제 일을 하는 객체 인양 그대로 사용한다.
//메서드를 호출할 때 자신이 직접 일을 하지 않고, 실제 일을 하는 객체이게 위임한다.
//이런식으로 설계하는 것을  프록시(대행자) 디자인 패턴 이라 한다.
//
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
//calculator 규칙을 따른다.
public class CalculatorStub implements Calculator {
	
	//int자리에 9가 들어간다.
	public  int compute(int a, int b, String op) throws Exception {//서버에 연결해서 서버의 규칙에 따라 데이터를 주고받는다.
		try (Socket s = new Socket("localhost",8888);
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				DataInputStream in = new DataInputStream(s.getInputStream())) {

			out.writeInt(a);
			out.writeInt(b);
			out.writeUTF(op);

			if (in.readUTF().equalsIgnoreCase("ok")) {
				return in.readInt();//다시 int를 읽어와라

			} else {
				throw new RuntimeException(in.readUTF());
			}

		} 

	}

	@Override
	public int plus(int a, int b) {
		try {
			return compute(a, b, "+");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int minus(int a, int b) {
		try {
			return compute(a, b, "-");
		} catch (Exception e) {
			throw new RuntimeException(e);//굳이 선언하지 않아도 호출자에게 예외를 던질수 있다.
		}
		
	}
}

