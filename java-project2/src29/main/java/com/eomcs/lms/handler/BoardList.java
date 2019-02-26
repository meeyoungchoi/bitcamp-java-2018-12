package com.eomcs.lms.handler;

import java.util.Arrays;

import com.eomcs.lms.domain.Board;

public class BoardList {
	static final int DEFAULT_CAPACITY = 10;
	Board[] list;
	int size = 0;//?
	  
	public BoardList() {
		  list = new Board[DEFAULT_CAPACITY];
	  }

	public BoardList(int initCapacity) {//initCapacity = 20
		if (initCapacity > DEFAULT_CAPACITY)
			list = new Board[initCapacity];//Board[20]
		else
			list = new Board[DEFAULT_CAPACITY];
		}



	public Board[] toArray() {
		
		return Arrays.copyOf(list, size);//?
	}



	public void add(Board board) {
		
		if (size >= list.length) {//size?
			int oldCapacity = list.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			
		}
		list[size++] = board;
	}
}
