package com.eomcs.lms.dao;

import java.util.List;

import com.eomcs.lms.domain.Lesson;

public class LessonDao extends AbstractDao<Lesson>{
	public LessonDao(String filepath) {
		this.filepath = filepath;
		this.loadData();
	}
	


  public void insert(Lesson lesson) {
      list.add((lesson));
  }

  public List<Lesson> findAll() {
	  return list;
  }

  public Lesson findByNo(int no) {
    for (Lesson l : list) {
      if (l.getNo() == no) {
    	  return l;
      }
    }
    return null;
  }

  public int update(Lesson lesson) {
    int index = 0;
    for (Lesson l : list) {
      if (l.getNo() == lesson.getNo()) {
        list.set(index, lesson);
        return 1;
      }
      index++;
    }
    return 0;
  }

  public int delete(int no) {
    int index = 0;
    for (Lesson b : list) {
      if (b.getNo() == no) {
        list.remove(index);
       
        return 1;
        
      }
      index++;
    }
    return 0;
    
  }
}
