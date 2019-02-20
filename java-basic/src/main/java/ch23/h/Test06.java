//url connection 사용

package ch23.h;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test06 {
	public static void main(String[] args) throws Exception {
		
		//1.
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//2. 
		HttpGet get = new HttpGet("https://www.naver.com");
		
		//3.
		//
		CloseableHttpResponse response = httpClient.execute(get);
		
		//4.응답도구를 
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
		//5.HttpEntity 객체에 들어있는 값을 문자열로 변환하여 출력한다.
		System.out.printf("응답 데이터 크기 => %d\n",entity.getContentLength());
		//System.out.printf("응답 데이터의 인코딩 타입: %s\n",entity.getContentEncoding());
		System.out.printf("응답 데이터의 타입 => %s\n",entity.getContentType());
		System.out.println("---------------------------------------------------");
		//HttpEntity에 들어있는 서버 응답 데이터를 꺼내려면 getContent()를 사용해야 한다.
		//getContent()의 리턴 값은 inputStream 객체이다.
		//inputStream을 가지고 데이터를 읽으려면 입출력 코딩을 작성해야 한다.
		//이 부분을 대신해주는 도우미 클래스가 있다.
		//InputStream in = entity.getContent();
		
		String content = EntityUtils.toString(entity);
		System.out.println(content);
		
		}
		
	}
}
