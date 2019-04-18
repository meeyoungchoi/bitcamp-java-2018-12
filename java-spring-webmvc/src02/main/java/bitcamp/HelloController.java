package bitcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
  
  @RequestMapping("/hello")
  @ResponseBody
  public String hello() throws Exception {
    //response.setContentType("text/html;charset=UTF-8");
    //PrintWriter out = response.getWriter();
    //out.println("<html><body><h1>Helloo!</h1></body></html>");
    return "<html><body><h1>Helloo!</h1></body></html>";
  }
}
