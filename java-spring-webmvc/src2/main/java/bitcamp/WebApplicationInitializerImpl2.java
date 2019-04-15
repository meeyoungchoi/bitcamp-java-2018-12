package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//webApplicationInitializer 구현체를 만드는 두 번쨰 방법
//=>인터페이슬 직접 구현하는 대신에 그 인터페이스를 ㄱ현한
//AbstartactAnnotaionConfigDispatcherServletInitailizerd
public class WebApplicationInitializerImpl2 
  extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }
  
  @Override
  protected Class<?>[] getServletConfigClasses() {
    //스프링 Web MVC 프레임워크에서 DispatcherServlet이 사용할 IoC 컨테이너를 준비할 때
    //이 메서드를 호출한다.
    //이 메서드가 리턴한 java config 클래스를 이요하여 IoC 컨테이너를 설정할 것이다.
    return new Class<?>[] {AppConfig.class};
  }
  
  @Override
  protected String[] getServletMappings() {
    // 스프링 프레임워크에서 DispatcherServlet을 등록할 때 이 메서드를 호출한다.
    //이 메섣의 리턴 값을 가지고 url 패턴으로 사용된다.
    return new String[] {"/app7/*"};
  }

  @Override
  protected String getServletName() {
    // 스프링 Web MVC 프레임워크는
    //웹 애플리케이션에 DispatcherServlet을 등록할 때 이 메서드를 호출한다.
    //이 메서드의 리턴 값이 서블릿의 이름으로 사용된다,
    //이 메서드를 오버라이딩 하지 않으면 기본 이름(dispatcher)이 사용된다.
    //=>한 개만 등록할 것이라면 오버라이딩 하지 않아도 됮만,
    //여러개의 DispatcherServlet을 등록할 것이라면 오버라이딩 하여
    //이름을 다르게 해야 한다.
    return "app7";
  }
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // 이 메서드가 호출될 때 간단한 메시지를 출력하기 위해 오버라이딩 하였다.
    //따라서 원래의 메서드를 반드시 호출해 줘야 한다.
    //호출이 되었는지 확인하기 이해 오버라이딩 했다.
    System.out.println("WebApplicationINitailizerImpl2.onStartUp()...호출됨!");
    super.onStartup(servletContext);
  }

}
