// 리프래시 또는 리다이렉트 최종 요청 페이지 - 클라이언트에게 다른 url을 요청하라나는
package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/s100")
@SuppressWarnings("serial")
public class Servlet100 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    //이 서블릿은 직접 실행할 용도로 만든 것이 아니다.
    //리프래시와 리다이렉트를 연습할 용도로 만들었다.
    //
    //예) 로그인 후 메인페이지로 자동 이동
    //예) 메일을 전송한 후 메일 목록 페이지로 자동 이동
    //예) 게시글 등록한 후 게시글 목록으로 자동이동
    //예) 결제 완료 후 결제 상태 페이지로 자동 이동
    //
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("반가워요! -/ex08/s100");
    
    //다음은 일부러 버퍼를 채우는 코드이다.
    //버퍼가 꽉 차면 자동으로 출력하는 것을 학인해보자!
    for (int i = 0; i < 150; i++) {
      //약 50 바이트씩 100번 출력한다.
      //아직 버퍼에 차지 않았기 때문에 클라이언트로 출력되지 않는다.
      //따라서 반복문 아래에 있는 응답 헤더 설정이 유효하다.
      //그러나 200번 출력하면 8kb 버퍼가 꽉 차기 때문에
      //반복문 다음에 헤더를 설정하기 전에 이미 버퍼 내용이 출력된다.
      //즉 응답이 완료된다.
      //응답을 완료한 다음에 응답 헤더의 값을 변경하거나 추가해봐야 소용없다.
      out.println(i + "   ====> 1234567890123456789012345678901234567890");
    }
    
    response.setHeader("Refresh", "3;url=s100");
  
  }
}

