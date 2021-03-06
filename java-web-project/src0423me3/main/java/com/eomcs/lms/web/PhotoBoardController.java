package com.eomcs.lms.web;

import java.util.ArrayList;
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
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {

  @Autowired LessonService lessonService;
  @Autowired PhotoBoardService photoBoardService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("form")
  public void form(Map<String,Object> map) {
    List<Lesson> lessons = lessonService.list();
    map.put("lessons", lessons);
  }
  
  
  @RequestMapping("add")
  public String add(PhotoBoard board,
      Part[] photos) throws Exception {

    ArrayList<PhotoFile> files = new ArrayList<>();
    
    String uploadDir = servletContext.getRealPath(
        "/upload/photoboard");

    for (Part photo : photos) {
      if (photo.getSize() == 0) 
        continue;
      
      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);
      
      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      files.add(file);
    }
    board.setFiles(files);

    if (board.getLessonNo() == 0) {
      throw new RuntimeException("사진 또는 파일을 등록할 수업을 선택하세요.");
      
    } else if (files.size() == 0) {
      throw new Exception("최소 한 개의 사진 파일을 등록해야 합니다.");

    } else if (board.getTitle().length() == 0) {
      throw new Exception("사진 게시물 제목을 입력하세요.");

    } else {
      photoBoardService.add(board);
      return "redirect:list";
    }
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {

    if (photoBoardService.delete(no) == 0)
      throw new Exception("해당 번호의 사진이 없습니다.");
      
    return "redirect:list";
  }
  
  @RequestMapping("detail")
  public void detail(int no,
      Model model) throws Exception {
    
    PhotoBoard board = photoBoardService.get(no);
    List<Lesson> lessons = lessonService.list();
    model.addAttribute("board", board);
    model.addAttribute("lessons", lessons);
    
  }
  
  @RequestMapping("list")
  public void list(Model model) throws Exception {

    List<PhotoBoard> boards = photoBoardService.list(0, null);
    model.addAttribute("list", boards);
    
  }
  
  @RequestMapping("search")
  public String search(
      @RequestParam("lessonNo") int lessonNo,
      @RequestParam("keyword") String keyword,
      Map<String,Object> map) throws Exception {

    String searchWord = null;
    if (keyword.length() > 0)
      searchWord = keyword;

    List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord);
    map.put("list", boards);
    
    return "/photoboard/search.jsp";
  }
  
  @RequestMapping("update")
  public String update(PhotoBoard board,
      @RequestParam("photo") Part[] photos) throws Exception {

    ArrayList<PhotoFile> files = new ArrayList<>();
    String uploadDir = servletContext.getRealPath("/upload/photoboard");
    
    for (Part photo : photos) {
      if (photo.getSize() == 0)
        continue;

      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);

      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      file.setPhotoBoardNo(board.getNo());
      files.add(file);
    }
    board.setFiles(files);

    if (files.size() == 0) 
      throw new Exception("최소 한 개의 사진 파일을 등록해야 합니다.");
    
    photoBoardService.update(board);
    return "redirect:list";
  }
}