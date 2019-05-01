package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonService {
  List<Lesson> list(int pageNo, int pageSize);
  int add(Lesson lesson);
  Lesson get(int no);
  int update(Lesson lesson);
  int delete(int no);
}
