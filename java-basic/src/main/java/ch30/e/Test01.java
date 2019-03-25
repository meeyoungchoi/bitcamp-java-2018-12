// aop 사용 후 - 기능 추가 위치
package ch30.e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
	  //Aop 사용
	  //1) 프로젝트에 의존 라이브러리를 추가한다.
	  //-mvnrepository.com에서 aspectjweaver 라이브러리 검색
	  //-build,gradle 추가
	  //-$ gradle eclipse 실행
	  //- 이클립스 프로젝트 갱신
	  //
	  //2) Advice 생성
	  //-메서드를 호출할 때 호출 전/후에 삽입될 기능을 가리킨다.
	  //-예)MyAdvice
	  //3)join point
	  //-Advice가 삽입될 메서드를 가리킨다.
	  //-예)X.m1() 메서드
	  //4) PointCut
	  //-join point를 가리키킄 패턴 정보
	  //-얘) execute(* ch30.c.x.m1(..))
	  //5) Target Objecg
	  //-advice를 삽입할 대상 객체
	  //-예) x 클래스
	  //6) Aspect
	  //-어떤 pointcut에 어떤 Advice를 삽입할 것인지를 알려주는 설정 정보이다.
	  //
	  //AOP 사요잉점
	  //=>AOP는 기존 코드를 손대지 않고 기능을 삽입하는 기술이다.
	  //
	  //
	  //AOP 구동 원리
	  //=>AOP는 proxy 디자인 패턴 을 사용한다.
	  //=>AOP를 설정하면, 
	  //SpringIoC 컨테이너를 point-cut에 지정된 클래스에 대해 
	  //proxy 클래스를 생성한다.
	  //그리고 그 Proxy 객체를 IoC zjsxpdlsjdp wjwdkegksek.
	  //=>IoC 컨테이너에서 point-cut에 지정한 객체를 꺼내면 
	  //원래의 객체 대신 프록시 객체가 리턴되나.
	  //=> 프로기 객체에 대해 메서드를 호출하면,
	  //AOP에 설정한 대로 Advice 메서드를 호출 한 후 원래의 메서드를 호출 한다.
	  //
	  //
	  
	  
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch30/e/application-context-01.xml");
    
   
    System.out.println("---------------------------------------");

    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
    	System.out.printf("%s ==> %s\n",
    			name, iocContainer.getBean(name).getClass().getName());
    }
    
   System.out.println("---------------------------------------------------");
   
   
   X x = (X) iocContainer.getBean("x");
   System.out.println(x.calculate(10, 20, "+"));
   
   try {
   System.out.println(x.calculate(10, 20, "%"));
   } catch (Exception e) {
	   System.out.println("예외 발생!");
   }
  }
}

