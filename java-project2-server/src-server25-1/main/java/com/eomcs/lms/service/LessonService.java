package com.eomcs.lms.service;

import java.util.List;

import com.eomcs.lms.domain.Lesson;

public interface LessonService {
	List<Lesson> list();
	int add(Lesson lesson);
	Lesson detail(int no);
	Lesson get(int no);
	int update(Lesson lesson);
	int delete(int no);
}
