//StateLess 통신방식 
package ch23.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * Stateless
 * 서버에 연결한 후 한번 요청하고 응답 받은 후 연결을 끊는다. 
 * 단점: 서버에 요청할 때마다 연결해야 한다.
 * 지속적으로 서버에 연결하는데 실행시간이 소요된다.
 * 장점: 서버에 계속 연결된 상태가 아니기 때문에 서버쪽에서 메모리를 많이 사용하지 않는다.
 * stateful보다 더 많은 클라이언트 요청을 처리할 수 있다.
 * 예
 *http프로토콜, 메신저 등
 * */

public class CalculatorClient3 {
	public static void main(String[] args) throws Exception {

		Scanner keyboard = new Scanner(System.in);

		while (true)/*왜 와일문으로 감싸는가?*/ {
			System.out.print(">");
			String input = keyboard.nextLine();//keyboard.nextLine():문자열을 받을때? 식이 문자열로 저장이 되는것인가? 한개의 문장(식)을 읽어들인다.
			if (input.equalsIgnoreCase("quit"))//만약에 종료한다면 =>input에 만약에 quit이 입력된다면
				break;

			//서버에 요청할 때 연결을 하고
			//서버로 부터 응답을 받으면 연결을 끊는다.=>stateless : 요청할때마다 연결해야하므로 연결하는데 시간이 걸린다.(단점)
			//매번 요청할 때마다 서버와 연결해야 하기 때문에 연결하는데 실행 시간 중에 연결에 소요되는 시간이 일정하게 걸린다.
			//대신 서버로 부터 응답을 받은 후에 즉시 연결을 끊기 때문에 
			//서버쪽에는 메모리가 낭비되지 않는다.
			try (Socket socket = new Socket("localhost",8888);//IP주소,포트번호
					PrintStream out = new PrintStream(socket.getOutputStream());
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


				System.out.println("서버와 연결된 서버에게 계산 작업을 요청함");
				out.println(input);
				out.flush();
				
				String response = in.readLine();//result를 client에서 받는 변수가 response?맞다.
				System.out.println(response);//result값이 들어온다? 맞다.

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("서버와 연결 끊음");
		} //while

		keyboard.close();
	}
}



