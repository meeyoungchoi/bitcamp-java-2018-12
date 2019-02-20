package com.eomcs.lms.handler;

import java.util.Arrays;

import com.eomcs.lms.domain.Member;

public class MemberList {
	 static final int DEFAULT_CAPACITY = 10;
	 
	 Member[] list;
	 int size = 0;//배열 요소의 개수
	  
public MemberList() {
	list = new Member[DEFAULT_CAPACITY];
	
}

public MemberList(int initCapacity) {
	if (initCapacity >DEFAULT_CAPACITY)
		list = new Member[initCapacity];
	else 
		list = new Member[DEFAULT_CAPACITY];
	}


public Member[] toArray() {
	
	return Arrays.copyOf(list, size);//list:원본배열 size:새로운 배열로 복사할 요소의 개수
	//list 배열과 같은 타입의 복사된 새로운 배열에 size 만큼의 새로운 배열을 복사하여 반환한다.

}

public void add(Member member) {
	if (size >= list.length);{//새로운 배열로 복사할 요소의 개수가 원본 배열보다 크거나 같다면
		//size: 새로운 배열로 복사할 요소의 개수 list.length: 원본 배열의 크기
		int oldCapacity = list.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		list = Arrays.copyOf(list, newCapacity);//list:원본배열, newCapacity:새로운 배열로 복사할 배열 요소의 개수
	}
	list[size++] = member;
}

}