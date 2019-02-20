package design_pattern.proxy.before2.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//클라이언트 쪽 대행
//클라이언트 요청을 실제 일을 하는 객체에게 전달하고,
//객체가 작업한 결과를 클라이언트에게 보내주는 일을 한다.
//즉 중개인 역할을 수행한다.
//이렇게 원격에서 객체를 사용할수 있도록 중계인의 역할을 수행하는 객체를 
//=> "Object Request Broker(ORB)"라 부른다.
// 서버측 ORB(객체가 있는 서버 측에서 요청과 응답을 대행하는 orb를 스캘레톤(skeleton)이라 부른다.)
//객첼를 사용하는 클라이언트 측에서 요청과 응답을 대행하는 orb를 스텁(stub)이라 부른다.
//
public class CalculatorServer {//실제 일을 하는 것을 중간에서 대행해준다.
	//서버 쪽에서 대행하므로 스캘레톤 orb이다.
	//결과를 받아서 클라이언트에게 돌려주는 역할을 한다.
	//클라이언트 요청을 받아서 cal.plus()에게 일을 시키고 그 결과를 받아서 클라이언트에게 던져준다.
	//단, 통신은 하지않는다.

	public static void main(String[] args) {

		//실제 계산작업 수행
		Calculator calc = new Calculator();


		try (ServerSocket ss = new ServerSocket(8888)) {
			System.out.println("서버 실행중");

			while (true) {
				try (Socket s = ss.accept();
						//순서 중요
						DataInputStream in = new DataInputStream(s.getInputStream());
						DataOutputStream out = new DataOutputStream(s.getOutputStream())) {

					int a = in.readInt();
					int b = in.readInt();
					String op = in.readUTF();

					switch (op) {
					case "+":
						//클라이언트 요청을 처리하기 위해 실제 작업을 수행하는 객체를 사용한다.
						out.writeUTF("OK");
						out.writeInt(calc.plus(a, b));//결과를 받아서 클라이언트에게 던져준다.
						break;
					case "-":
						out.writeUTF("OK");
						out.writeInt(calc.minus(a, b));
						break;
					default:
						out.writeUTF("FAIL");
						out.writeUTF("해당 연산자를 지원하지 않습니다.");

					}
					out.flush();

				} catch (Exception e) {
					System.out.println("클라이언트 요청 처리 중 오류 발생");
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
