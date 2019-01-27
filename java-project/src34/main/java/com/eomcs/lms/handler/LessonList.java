package com.eomcs.lms.handler;

import java.util.Arrays;
import java.util.Scanner;

import com.eomcs.lms.domain.Lesson;

public class LessonList {
	 static final int DEFAULT_CAPACITY = 10;
	  
	  Scanner keyboard;
	  Lesson[] list ;
	  int size = 0;
	
	public LessonList() {
		list = new Lesson[size];
	}
	  
	public LessonList(int initCapacity) {
		if (initCapacity > DEFAULT_CAPACITY)
			list = new Lesson[initCapacity];
		else 
			list = new Lesson[DEFAULT_CAPACITY];
	}
	
	public Lesson[] toArray() {
		return list = Arrays.copyOf(list, size);
		/**
		 * Lesson[] list = new Lesson[size];
		 * for (int i = 0; i < size; i++) {
		 * 		list[i] = lessons[i];
		 * 	}
		 * return list;
		 * 
		 * 
		 * 
		 * 
		 * */
	}
	
	public void add(Lesson lesson) {
		if (size >= list.length) {
			int oldCapacity = list.length;
			int newCapactiy = list.length + (list.length << 1);
			list = Arrays.copyOf(list, newCapactiy);
		}
		list[size++] = lesson;
	}
}
