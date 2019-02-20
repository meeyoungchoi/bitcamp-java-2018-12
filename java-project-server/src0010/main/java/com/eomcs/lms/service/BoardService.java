//10단계 - 데이터를 파일로 관리한다.
package com.eomcs.lms.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.domain.Board;

public class BoardService {

	  List<Board> boards;

	  ObjectInputStream in;
	  ObjectOutputStream out;
	  String filepath;

	  public BoardService(
			  ObjectInputStream in, 
			  ObjectOutputStream out
			  //String filepath
			  )  {//내부적으로 초기화작업을 하다가 예외가 발생할수 있다.
		  this.in = in;
		  this.out = out;
		  //this.filepath = filepath;
		  
		  loadData();
	  }
	  
	  @SuppressWarnings("unchecked")
	public void loadData()  {
		  this.filepath = filepath;
		  
		  try (ObjectInputStream in = new ObjectInputStream(
				  new BufferedInputStream(
						  new FileInputStream(this.filepath)))) {
			  
			  boards = (List<Board>) in.readObject();
		  } catch (Exception e) {
			  boards = new ArrayList<Board>();
			  throw new RuntimeException("게시글 파일 로딩 오류" ,e);
			  //System.out.println("게시스글 데이터를 읽는 중 오류 발생"+toString());
			  //runtimeexception: 느슨하게 던지는 예외 - 처리하지 않으면 jvm에서 멈추게된다.
			  //보고는 하는데 클래스가 못쓸정도는 아닐때-runtimeexception
			  //exception: 치명적인 에러(조치를 취하지안으면 사용 불가) -강력하게 하게되면 메서드를 호출하는 쪽에서는 try-catch 또는 메서드를 호출하는 상위 개발자에서  처리해야 한다.
		  }
	  }
	  public void execute(String request) throws Exception {

	    switch (request) {
	      case "/boards/add":
	        add();
	        break;
	      case "/boards/list":
	        list();
	        break;
	      case "/boards/detail":
	        detail();
	        break;
	      case "/boards/update":
	        update();
	        break;
	      case "/boards/delete":
	        delete();
	        break;  
	      default:
	        out.writeUTF("FAIL");
	    }
	    out.flush();
	  }

	 private void add() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    boards.add((Board)in.readObject());
	    out.writeUTF("OK");
	  }

	  private void list() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    out.writeUTF("OK");
	    out.writeObject(boards);
	  }

	  private void detail() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    int no = in.readInt();

	    for (Board m : boards) {
	      if (m.getNo() == no) {
	        out.writeUTF("OK");
	        out.writeObject(m);
	        return;
	      }
	    }

	    out.writeUTF("FAIL");
	  }

	  private void update() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    Board boards = (Board) in.readObject();

	    int index = 0;
	    for (Board m : boards) {
	      if (m.getNo() == boards.getNo()) {
	        boards.set(index, boards);
	        out.writeUTF("OK");
	        return;
	      }
	      index++;
	    }

	    out.writeUTF("FAIL");
	  }

	  private void delete() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    int no = in.readInt();

	    int index = 0;
	    for (Board m : boards) {
	      if (m.getNo() == no) {
	        boards.remove(index);
	        out.writeUTF("OK");
	        return;
	      }
	      index++;
	    }

	    out.writeUTF("FAIL");    
	  }

	  public void saveData() {
		  try (ObjectInputStream in = new ObjectInputStream(
				  new BufferedInputStream(
						  new FileInputStream(this.filepath)))) {
			  
			  out.writeObject(boards);
			  
		  } catch (Exception e) {
			 
			  throw new RuntimeException("게시글 파일 저장 오류" ,e);
			 
		  }
	  }
	  
	 public void execute(String request) throws Exception {
		 
		 switch (request) {
		 case "board/add":
			 add();
			 break;
		 case "
		 }
		 
	 }
	}



