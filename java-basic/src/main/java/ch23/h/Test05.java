//url connection 사용

//Apache HttpComponent 사용 - httpGet 클래스
package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.methods.HttpGet;

public class Test05 {
	public static void main(String[] args) throws Exception {
		//HttpGet클래스
		//wwww.apache.org 사이트에서 제공하는 HttpComponent 라이브러리에 들어있는 클래스이다.
		//사용하려면 먼저 외부 라이브러리를 프로젝트로 가져와야 한다.
		//mvnrepository.com
		//최신 라이브러리 정보를 buid.gradle의 dependencies {} 블록에 추가한다.
		//콘솔에서 "gradle eclipse"를 실행하여 .classpath 파일을 갱신한다.
		//이때 이부 라이브러리를 자동으로 다운로드 받을 것이다.
		//라이브러리에서 확인한다.
		HttpGet get = new HttpGet("http://sk.co.kr");
		URL url = new URL("https://www.naver.com");
		
		//url 정보를 가지고 http 요청을 수행할 객체를 얻는다.
		URLConnection con = url.openConnection();
		
		//웹서버와 연결한후 http를 요청한다.
		con.connect();
		
		
		//웹서버의 응답 데이터를 읽어들일 도구를 리턴한다.
		InputStream in = con.getInputStream();
		
		//서버가 보낸 데이터를 한 줄씩 읽기 위해 데코레이터를 붙인다.
		//inputstream이랑 bufferedreader를 붙여주기 위해 inputstreamreader를 사용
		//inputstream의 읽어들이는 속도를 높이기 위해서 bufferedreader를 사용했다.
		BufferedReader in2 = new BufferedReader(new InputStreamReader(in));
		
		while (true) {
			String str = in2.readLine();
			if (str == null)
				break;
			System.out.println(str);
			
			
		}
		
		in2.close();
		in.close();
	}
}
