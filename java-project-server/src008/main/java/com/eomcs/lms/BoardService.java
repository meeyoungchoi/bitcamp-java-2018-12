//8단계 - 클라이언트 요청을 처리하는 클래스에 대해 리팩토링 수행
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.eomcs.lms.domain.Board;

//클라이언트의 요청을 처리하는 클래스라는 의미로
//클래스명을 *service로 변경한다.
public class BoardService {

	  ArrayList<Board> boardss = new ArrayList<>();

	  ObjectInputStream in;
	  ObjectOutputStream out;

	  public BoardService(ObjectInputStream in, ObjectOutputStream out) {
		  this.in = in;
		  this.out = out;
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
	    boardss.add((Board)in.readObject());
	    out.writeUTF("OK");
	  }

	  private void list() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    out.writeUTF("OK");
	    out.writeObject(boardss);
	  }

	  private void detail() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    int no = in.readInt();

	    for (Board m : boardss) {
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
	    for (Board m : boardss) {
	      if (m.getNo() == boards.getNo()) {
	        boardss.set(index, boards);
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
	    for (Board m : boardss) {
	      if (m.getNo() == no) {
	        boardss.remove(index);
	        out.writeUTF("OK");
	        return;
	      }
	      index++;
	    }

	    out.writeUTF("FAIL");    
	  }

	}


