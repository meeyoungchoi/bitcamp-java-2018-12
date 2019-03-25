// 프로퍼티 값 변환기 - 개발자가 직접 문장령르 프로퍼티 타입으로 변환하여 넣기
package ch29.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
 
	  public static void main(String[] args) {
		   ApplicationContext iocContainer = 
			        new ClassPathXmlApplicationContext("ch29/g/application-context-02.xml");
	    //car라는 생성자가 먼저 호출되고 인스턴스가 만들어진다.
	    System.out.println("---------------------------------------");
	    
	    System.out.println(iocContainer.getBean("c1"));
	    
	 
	  }
	


}
