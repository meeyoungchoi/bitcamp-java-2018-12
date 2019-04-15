package com.eomcs.lms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@Component
public class PhotoBoardController   {
  
  @Autowired PhotoBoardService photoBoardService;
  @Autowired LessonService lessonService;
  private String uploadDir;
  
  @RequestMapping("/photoboard/add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    String uploadDir = request.getServletContext().getContextPath();
    
    List<Lesson> lessons = lessonService.list();
    request.setAttribute("lessons", lessons);
    // 뷰 컴포넌트의 URL을 ServletRequest 보관소에 저장한다.
    request.setAttribute("viewUrl", "/photoboard/form.jsp");
  
    PhotoBoard board = new PhotoBoard();
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

    ArrayList<PhotoFile> files = new ArrayList<>();
    Collection<Part> photos = request.getParts();
    
    for (Part photo : photos) {
      if (photo.getSize() == 0 || !photo.getName().equals("photo")) 
        continue;
      
      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);
      
      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      files.add(file);
    }
    board.setFiles(files);

    if (board.getLessonNo() == 0) {
      throw new Exception("사진 또는 파일을 등록할 수업을 선택하세요.");
      
    } else if (files.size() == 0) {
      throw new Exception("최소 한 개의 사진 파일을 등록해야 합니다.");

    } else if (board.getTitle().length() == 0) {
      throw new Exception("사진 게시물 제목을 입력하세요.");

    } else {
      photoBoardService.add(board);
    
      return "redirect:list";
    }
  }
  
  @RequestMapping("/photoboard/delete")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {


    int no = Integer.parseInt(request.getParameter("no"));
    if (photoBoardService.delete(no) > 0) 

      throw new Exception("해당 번호의 회원이 없습니다.");


    return "redirect:list";


  }
  
  @RequestMapping("/photoboard/list")
  public String list(
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception {
    
    List<PhotoBoard> boards = photoBoardService.list(0, null);

    request.setAttribute("list", boards);
    
    return "/photoboard/list.jsp";
  }
  
  @RequestMapping("/photoboard/search")
  public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {

    
    int lessonNo = 0;
    try {
      lessonNo = Integer.parseInt(request.getParameter("lessonNo"));
    } catch (Exception e) { // 수업 번호를 입력하지 않거나 정상 입력이 아닌 경우는 무시한다.
    }

    String searchWord = null;
    try {
      String keyword = request.getParameter("keyword");
      if (keyword.length() > 0)
        searchWord = keyword;
    } catch (Exception e) { // 사용자가 검색어를 입력하지 않았으면 무시한다.
    }

    List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord);
    request.setAttribute("list", boards);
    
    
    return "/photoboard/search.jsp";
  }
  
  @RequestMapping("/photoboard/update")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {


    
    this.uploadDir = request.getServletContext().getRealPath("/upload/photoboard");
    
    PhotoBoard board = new PhotoBoard();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

    ArrayList<PhotoFile> files = new ArrayList<>();
    Collection<Part> photos = request.getParts();

    for (Part photo : photos) {
      if (photo.getSize() == 0 || !photo.getName().equals("photo"))
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
      throw new Exception("해당 번호의 수업이 없습니다.");

      return "redirect:list";

    
  }

}