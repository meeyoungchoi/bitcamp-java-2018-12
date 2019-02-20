package com.eomcs.lms.handler;

import java.util.Arrays;

import com.eomcs.lms.domain.Board;

public class BoardList {

	static final int DEFAULT_CAPACITY = 10;
	Board[] newboard;
	int boardNo = 0;
	
	public BoardList() {
		
	}
	
	public BoardList(int box) {
		if (box > DEFAULT_CAPACITY)
			newboard = new Board[box];
		else 
			newboard = new Board[DEFAULT_CAPACITY];
	}
	
	public Board[] toArray() {
		Board[] board = new Board[boardNo];
		for (int i = 0; i < boardNo; i++) {
			newboard[i] = board[i];
		}
		return newboard;
		//return  Arrays.copyOf(newboard, boardNo);
	}
	
	public void add(Board board) {
		if (boardNo >= newboard.length) {
			int oldCapacity = newboard.length;
			int newCapacity = oldCapacity + (oldCapacity << 1);
			
			
	}
		newboard[boardNo++] = board;
	}
}
