//4단계 - 서버 실행 테스트
package practice1_4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.eomcs.lms.domain.Member;

public class ServerTest2 {
	public static void main(String[] args) {

	try (Socket socket = new Socket("localhost",8888);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
				
		System.out.println("서버와 연결되었음");
		
		Member member = new Member();
		member.setNo(1);
		member.setName("홍길동");
		member.setEmail("hong@test.com");
		member.setPassword("1111");
		member.setPhoto("hong.gif");
		member.setTel("1111-1111");
		
		out.writeObject(member);
		out.flush();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
	System.out.println("클라이언트와의 연결을 끊음");
	}
}

