package bitcamp.p02;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter01 implements Filter{

 @Override
public void init(FilterConfig filterConfig) throws ServletException {
  
  System.out.println("Filter01.init()");
}
 
 @Override
  public void destroy() {
    System.out.println("Filter01.destroy()");
    
  }
 
 @Override
  public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain)
      throws IOException, ServletException {
   
    System.out.println("Filter01.doFilter() : 시작");

    //다음 필터를 실행하거나 요청한 서블릿을 실행하면 다음 코드를 실행할 수 있게 해준다.
    chain.doFilter(request, response);
    
    System.out.println("Filter01.doFilter() : 종료");
  }
}
