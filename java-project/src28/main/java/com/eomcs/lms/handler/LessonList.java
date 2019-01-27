package com.eomcs.lms.handler;

import java.util.Arrays;
import java.util.Scanner;

import com.eomcs.lms.domain.Lesson;

public class LessonList {

	 static final int DEFAULT_CAPACITY = 10;//int LENGTH를 int DEFAULT_CAPACITY로 바꾼다.
	 Lesson[] list;//새롬운 변화된 크기를 담을 새로운 배열
	 int size = 0;//i번째 배열의 정보
	 
	 //수업데이터 배열을 리턴하는 toArray()메서드를 정의한다.
	 public Lesson[] toArray() {
		 //만약 배열의 크기가 늘어났다면 그 늘어난 크기만큼 lessons[]에 들어가는 값(기존에 있던 값 포함)을 list[]로 옮겨줘야한다.
		 Lesson[] lessons = new Lesson[size];
		 for (int i = 0; i < size; i++) {
			list[i] = lessons[i];
		 }
		return list;//수업데이터 배열인 list를 리턴한다?
	}
	 
	 //수업 데이터를 저장한다.
	 public void add(Lesson lesson) {
		 //만약 가변길이(size)가 원래크기(length)보다 크다면
		 //기의 크기를 저장할 변수인 oldCapacity에는 length(즉, 기존 배열의 크기가 들어간다.)
		 //그리고 기존 배열의, 크기가 들어가고 새로운 배열의 크기를 저장하기 위해 자리를 마련하는 과정을 newCapactity 변수에 저장한다.
		 //즉, newCapacity를 복사해서 list에 넣어준다.
		 if (size >= list.length) {//근데 왜 default_capacity변수가 들어가면 안되나?
			int oldCapacity = list.length;
			@SuppressWarnings("unused")
			int newCapacity	=	oldCapacity + (oldCapacity >> 1);
			Arrays.copyOf(list, newCapacity);//기존, 새론운크기
			 
		 }
		list[size++] = lesson;
		
	 }
	 
	 //기본 생성자? 와 배열의 초기 크기를 설정하는 생성자를 정의한다.
	 //LessonList()의 파라미터 값으로 DEFAULT_CAPACITY(배열의 초기 크기)를 넣어준다. 
	 public LessonList() {
		 list = new  Lesson[DEFAULT_CAPACITY];
	 }
	 
	 //기본생성자에 파라미터 값으로 배열의 크기를 넣어준다.
	 public LessonList(int initialCapacity) {
		 //만약 만들려는 배열의 크기가 배열의 초기 크기 보다 크다면
		 if (initialCapacity > DEFAULT_CAPACITY)
			 //Lesson인스턴스에 initialCapacity 값을 넣어준다.
			 list = new Lesson[initialCapacity];
		 else 
			 list = new Lesson[DEFAULT_CAPACITY];
	 }
}
