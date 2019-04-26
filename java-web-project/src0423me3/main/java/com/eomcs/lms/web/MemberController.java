package com.eomcs.lms.web;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
  
  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("form")
  public void form() throws Exception {  
  }
  
  @RequestMapping("add")
  public String add(Member member,
       Part photoFile) throws Exception {
    
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath(
          "/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    memberService.add(member);
    
    return "redirect:list";
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {

    if (memberService.delete(no) == 0) 
      throw new Exception("해당 번호의 회원이 없습니다.");
    
    return "redirect:list";
  }
  
  @RequestMapping("detail")
  public void detail(int no, 
      Model model) throws Exception {

    Member member = memberService.get(no);
    model.addAttribute("member", member);
  }
  
  
  @RequestMapping("list")
  public void list(Model model) throws Exception {

    List<Member> members = memberService.list(null);
    model.addAttribute("list", members);
    
   }
  
  @RequestMapping("search")
  public String search(
      @RequestParam("keyword") String keyword,
      Map<String,Object> map) throws Exception {
   
    List<Member> members = memberService.list(keyword);
    map.put("list", members);
    
    return "/member/search.jsp";
  }

  @RequestMapping("update")
  public String update(
      Member member,
      @RequestParam("photoFile") Part photoFile) throws Exception {

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    if (memberService.update(member) == 0)
      throw new Exception("해당 번호의 회원이 없습니다.");
      
    return "redirect:list";
  }
}
