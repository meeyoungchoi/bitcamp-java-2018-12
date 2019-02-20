package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.eomcs.lms.domain.Board;

public class BoardCommand {

	  static ArrayList<Board> boards = new ArrayList<>();

	  static ObjectInputStream in;
	  static ObjectOutputStream out;

	  public static void service(String request) throws Exception {

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

	  static void add() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    boards.add((Board)in.readObject());
	    out.writeUTF("OK");
	  }

	  static void list() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    out.writeUTF("OK");
	    out.writeObject(boards);
	  }

	  static void detail() throws Exception {
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

	  static void update() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    Board board = (Board) in.readObject();

	    int index = 0;
	    for (Board b: boards) {
	      if (b.getNo() == board.getNo()) {
	        boards.set(index, board);
	        out.writeUTF("OK");
	        return;
	      }
	      index++;
	    }

	    out.writeUTF("FAIL");
	  }

	  static void delete() throws Exception {
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

	}


