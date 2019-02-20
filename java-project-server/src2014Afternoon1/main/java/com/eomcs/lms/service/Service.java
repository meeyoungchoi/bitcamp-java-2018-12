// 추상 클래스를 인터페이스로 전환한다.
//앱서버가 서비스를 호출하는 규칙
package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Service {//파일명과 인터페이스명이 일치해야 한다.
  void execute(
		  String request, ObjectInputStream in, ObjectOutputStream out) throws Exception;

}







