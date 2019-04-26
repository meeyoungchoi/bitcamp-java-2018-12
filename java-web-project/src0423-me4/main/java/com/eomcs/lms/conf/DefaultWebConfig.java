package com.eomcs.lms.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;

//app-servlet.xml의 설정을 이 클래스로 대신한다.
//
@ComponentScan("com.eomcs.lms.web")
@EnableWebMvc//프론트 컨트롤러가 웹 앰비스 컨피규어로 구현한 메서드를 전부 찾는다. 
public class DefaultWebConfig implements WebMvcConfigurer {
  
  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    // 매트릭스 변수 등을 사용할수 있도록 기능을 활성화 시키려면
    //이 메서드를 오버라이딩하여 파라미터로 넘겨받은 객체를 통해
    //설정해 줘야 한다.
    
    //url에서 매트릭스 변수를 추출해주는 도우미 객체를 준비한다.
    //클라이언트가 보낸 url을 처리하는 도우미 객체를 준비한다.
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    
    //url 경로에서 세미콜론(;)있는 값을 제거하지 않도록 설정한다.
    //다음의 예와 같이 url 경로에서 세미콜론(;)dlTsms rkqtdmf wpwrjgkwl dksgehfhr tjfwjdgksek.
    //http://loc
    //그래야 페이지 컨트롤러의 request handler에서 해당 매트릭스 값을 추출할 수 있다.
    urlPathHelper.setRemoveSemicolonContent(false);
    
    //위에서 준비한 도우미 객체를 설정기에 등록한다.
    //이것은 xml에서 다음과 같이 설정한 것과 같다.
    //=><mvc:annotation-driven enable-matrix-variables="true"/>
   configurer.setUrlPathHelper(urlPathHelper);
  }
  
  /*
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    // 프론트 컨트롤러가 사용하는 기본view Resolver를 대체하고 싶다면
    //이 메서드를 오버라이딩 한다.
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/jsp", "jsp");
    viewResolver.setViewClass(JstlView.class);
    registry.viewResolver(viewResolver);
  }*/
  
  @Bean
  public ViewResolver viewResolver() {
    //이 메서드는 xml설정에서 다음 xml 설정과 같다.
    /**/
    InternalResourceViewResolver vr = new InternalResourceViewResolver("/WEB-INF/jsp", "jsp");
    vr.setViewClass(JstlView.class);
    return vr;
  }

}
