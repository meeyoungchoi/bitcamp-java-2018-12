package com.eomcs.lms.handler;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Component
public class PhotoBoardCommand {

  PhotoBoardService photoBoardService;

  public PhotoBoardCommand(PhotoBoardService photoBoardService) {
    this.photoBoardService = photoBoardService;
  }

  @RequestMapping("/photoboard/list")
  public void list(ServletRequest request,ServletResponse response) {
    List<PhotoBoard> boards = photoBoardService.list(0, null);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진 게시판</title></head>");
    out.println("<body><h1>사진 게시판</h1>");
    out.println("<p><a href='/photoboard/form'>새 사진파일</a></p>");
    out.println("<table border='1'>");
    out.println("<tr><th>번호</th><th>제목</th><th>작성일</th><th>조회수</th></tr>");

    for (PhotoBoard board : boards) {
      response.println(
          String.format("<tr><td>%d</td><td><a href='/photoboard/detail?no=%1$d'>%s</a></td>"
              + "<td>%s</td><td>%d</td><td>%d</td></tr>", 
              board.getNo(), 
              board.getTitle(), 
              board.getCreatedDate(), 
              board.getViewCount(),
              board.getLessonNo()));
    }
  }

  @RequestMapping("/photoboard/add")
  public void add(ServletRequest request, ServletResponse response) {
    
      PhotoBoard board = new PhotoBoard();
      board.setTitle(request.getParameter("title"));
      board.setLessonNo(Integer.parseInt(request.getParameter("lessonNO")));

      PrintWriter out = response.getWriter();
      out.println("<p>최소 한 개의 사진 파일을 등록해야 합니다.</p>");
      out.println("<p>파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.</p>");

      ArrayList<PhotoFile> files = new ArrayList<>();
      while (true) {
        String fileName = request.getParameter("photoFile");
        if (fileName.length() == 0) {
          out.println("<p>최소 한 개의 사진 파일을 등록해야 합니다.</p>");
          continue;
        }  PhotoFile file = new PhotoFile();
        file.setFilePath(fileName);
        files.add(file);
        out.println("<p>저장하였습니다.</p>");
        out.println("</body></html>");
      }


  }


@RequestMapping("/photoboard/detail")
public void detail(ServletRequest request, ServletResponse response) throws Exception {
  int no = Integer.parseInt(request.getParameter("no"));

  PhotoBoard board = photoBoardService.get(no);

  PrintWriter out = response.getWriter();
  out.println("<html><head><title>사진 조회</title></head>");
  out.println("<body><h1>사진 조회</h1>");

  if (board == null) {
    out.println("<p>해당 사진을 찾을 수 없습니다.</p>");

  } else {

    out.println("<form action='/photoboard/update'>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>번호</th>");
    out.printf("  <td><input type='text' name='no' readonly value='%d'></td>\n", no);
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>제목</th>");
    out.printf("  <td><input type='text' name='title' value='%s'></td>\n",board.getTitle());
    out.println("</tr>");
    out.println("<tr>");
    out.println("<th>조회수</th>");
    out.printf("<td><input type='text' name='createdDate' readonly value='%d'></td>\n", board.getViewCount());
    out.println("</tr>");
    response.println(String.format("수업: %s(%s ~ %s)", 
        board.getLesson().getTitle(),
        board.getLesson().getStartDate(),
        board.getLesson().getEndDate()));

    response.println("사진파일:");
    List<PhotoFile> files = board.getFiles();
    for (PhotoFile file : files) {
      response.println(String.format("> %s", file.getFilePath()));
    }
  }
}

@RequestMapping("/photoboard/update")
public void update(ServletResponse response) throws Exception {

  try {
    PhotoBoard board = new PhotoBoard();
    board.setNo(response.requestInt("번호?"));

    PhotoBoard origin = photoBoardService.get(board.getNo());
    if (origin == null) {
      response.println("해당 번호의 사진이 없습니다.");
      return;
    }

    String input = response.requestString(
        String.format("제목(%s)?", origin.getTitle()));

    if (input.length() > 0) {
      board.setTitle(input);
    }

    // 변경하려면 사진 게시물의 첨부 파일을 출력한다.
    response.println("사진 파일:");
    List<PhotoFile> files = origin.getFiles();
    for (PhotoFile file : files) {
      response.println("> " + file.getFilePath());
    }
    response.println("");

    response.println("사진은 일부만 변경할 수 없습니다.");
    response.println("전체를 새로 등록해야 합니다.");
    input = response.requestString("사진을 변경하시겠습니까?(y/N)");
    if (input.equalsIgnoreCase("y")) {
      // 그리고 새 첨부 파일을 추가한다.
      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

      ArrayList<PhotoFile> photoFiles = new ArrayList<>();
      while (true) {
        String filePath = response.requestString("사진 파일?");
        if (filePath.length() == 0) {
          if (photoFiles.size() == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
            break;
          }
        }
        PhotoFile file = new PhotoFile();
        file.setFilePath(filePath);
        file.setPhotoBoardNo(board.getNo());

        photoFiles.add(file);
      }

      board.setFiles(photoFiles);
    }

    photoBoardService.update(board);
    response.println("변경했습니다.");

  } catch (Exception e) {
    response.println("변경 중 오류 발생.");
  }
}

@RequestMapping("/photoboard/delete")
public void delete(ServletResponse response) throws Exception {
  try {
    int no = response.requestInt("번호?");
    if (photoBoardService.delete(no) == 0) {
      response.println("해당 번호의 사진이 없습니다.");
      return;
    }
    response.println("삭제했습니다.");

  } catch (Exception e) {
    response.println("삭제 중 오류 발생.");
  }
}

@RequestMapping("/photoboard/search")
public void search(ServletResponse response) {
  int lessonNo = 0;
  try {
    lessonNo = response.requestInt("수업 번호?");
  } catch (Exception e) { // 수업 번호를 입력하지 않거나 정상 입력이 아닌 경우는 무시한다.
  }

  String searchWord = null;
  try {
    String keyword = response.requestString("검색어?");
    if (keyword.length() > 0)
      searchWord = keyword;
  } catch (Exception e) { // 사용자가 검색어를 입력하지 않았으면 무시한다.
  }

  List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord);

  response.println("[검색 결과]");
  for (PhotoBoard board : boards) {
    response.println(
        String.format("%3d, %-20s, %s, %d, %d", 
            board.getNo(), 
            board.getTitle(), 
            board.getCreatedDate(), 
            board.getViewCount(),
            board.getLessonNo()));
  }
}

@RequestMapping("/photoboard/form")
public void form(ServletRequest request, ServletResponse response) throws Exception {
  PrintWriter out = response.getWriter();

  out.println("<htm>");
  out.println("<head><title>새 사진게시판</title></head>");
  out.println("<body>");
  out.println("<h1>새 사진</h1>");
  out.println("<form action='/photoboard/add'>");
  out.println("<table border='1'>");
  out.println("<tr>");
  out.println("  <th>제목</th>");
  out.println("  <td><input type='text' name='title'></td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("  <th>수업</th>");
  out.println("  <td><textarea name='text' rows='5' cols='50'></textarea></td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("  <th>한 개 이상의 사진을 등록해야 합니다.</th>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("  <th>사진1</th>");
  out.println("  <td><input name='photo0'></textarea></td>");
  out.println("</tr>");
  out.println("<tr>");
  out.println("</tr>");
  out.println("</table>");
  out.println("<p>");
  out.println("  <button type='submit'>등록</button>");
  out.println("  <a href='/photoBoard/list'>목록</a>");
  out.println("</p>");
  out.println("</form>");
  out.println("</body>");
  out.println("</html>");
}
}
