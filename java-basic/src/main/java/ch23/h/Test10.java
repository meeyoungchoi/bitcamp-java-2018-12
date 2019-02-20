//url connection 사용

//Apache HttpComponent 사용 - httpGet 클래스
package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.methods.HttpGet;

public class Test10 {
	public static void main(String[] args) throws Exception {
	
		HttpGet get = new HttpGet("http://sk.co.kr");
		URL url = new URL("https://www.naver.com");
		
		//url 정보를 가지고 http 요청을 수행할 객체를 얻는다.
		URLConnection con = url.openConnection();
		
		//웹서버와 연결한후 http를 요청한다.
				con.connect();
	}
}
