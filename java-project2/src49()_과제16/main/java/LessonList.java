import java.util.Arrays;
import java.util.Scanner;

import com.eomcs.lms.domain.Lesson;

public class LessonList {

	static final int DEFAULT_CAPACITY = 10;
	Lesson[] lessons;
	int size = 0;//lessonIdx
	

	public  LessonList()  {
	//기본생성자
	lessons = new Lesson[DEFAULT_CAPACITY];//DEFAULT_CAPACITY:바뀐 배열의 크기
	}
	
	public LessonList(int initCapacity) {//initCapacity:20 초기 배열의 크기
		//배열의 초기크기 리턴
		if (initCapacity >DEFAULT_CAPACITY)
			lessons = new Lesson[initCapacity];
		else 
			lessons = new Lesson[DEFAULT_CAPACITY];
		
	}
	
	public Lesson[] toArray() { //수업 데이터 배열 리턴
		//return Arrays.copyOf(lessons, size);//size:newCapactiy
		
		Lesson[] list = new Lesson[size];//?list
		
		for (int i = 0; i < size; i++) {
			list[i] = lessons[i];
		}
		return list;
	}
	
	public void add(Lesson lesson) {//수업 데이터 저장
		if (size >= lessons.length) {//만약 배열의 크기가 입력받은 배열의 크기보다 크다면
			int oldCapacity = lessons.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			lessons = Arrays.copyOf(lessons, newCapacity);//lessons배열로 newCapacity만큼 복사해라
			 
		}
		lessons[size++] = lesson;
	}
}
