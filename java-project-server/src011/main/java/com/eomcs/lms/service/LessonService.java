//11
package com.eomcs.lms.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class LessonService extends AbstractService<Lesson>  {
	
	
	  
	  public void execute(String request) throws Exception {

	    switch (request) {
	      case "/lesson/add":
	        add();
	        break;
	      case "/lesson/list":
	        list();
	        break;
	      case "/lesson/detail":
	        detail();
	        break;
	      case "/lesson/update":
	        update();
	        break;
	      case "/lesson/delete":
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
	    list.add((Lesson)in.readObject());
	    out.writeUTF("OK");
	  }

	  private void list() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    out.writeUTF("OK");
	    out.writeObject(list);
	  }

	  private void detail() throws Exception {
	    out.writeUTF("OK");
	    out.flush();
	    int no = in.readInt();

	    for (Lesson m : list) {
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
	    Lesson lesson = (Lesson) in.readObject();

	    int index = 0;
	    for (Lesson m : list) {
	      if (m.getNo() == lesson.getNo()) {
	        list.set(index, lesson);
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
	    for (Lesson m : list) {
	      if (m.getNo() == no) {
	        list.remove(index);
	        out.writeUTF("OK");
	        return;
	      }
	      index++;
	    }

	    out.writeUTF("FAIL");    
	  }

	}



