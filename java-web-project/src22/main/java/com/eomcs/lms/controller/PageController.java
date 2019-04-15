package com.eomcs.lms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//페이지 컨트롤러의 사용 규칮 정의
//누가 페이지 컨트롤러를 사용하느느가?
//=>프론트 컨트롤러
public interface PageController {
  String execute(
      HttpServletRequest request,
      HttpServletResponse response)throws Exception ;

}
