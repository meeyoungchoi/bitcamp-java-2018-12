package com.eomcs.lms.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Controller
@RequestMapping("/lesson")
public class LessonController {
  
  @Autowired LessonService lessonService;

  @RequestMapping("form")
  public void form() throws Exception {    
  }
  
  @RequestMapping("add")
  public String add(Lesson lesson) throws Exception {
    lessonService.add(lesson);
    return "redirect:list";
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {

    if (lessonService.delete(no) == 0) 
      throw new Exception("해당 번호의 수업이 없습니다.");
      
    return "redirect:list";
  }
  
  @RequestMapping("detail")
  public void detail(int no, Model model) throws Exception {
    Lesson lesson = lessonService.get(no);
    model.addAttribute("lesson", lesson);
    
  }

  @RequestMapping("list")
  public void list(Model model) throws Exception {
    List<Lesson> lessons = lessonService.list();
    model.addAttribute("list", lessons);
  }
  
  @RequestMapping("update")
  public String update(Lesson lesson) throws Exception {
    if (lessonService.update(lesson) == 0)
      throw new Exception("해당 번호의 수업이 없습니다.");
    return "redirect:list";
  }
}
