import java.util.Arrays;

import com.eomcs.lms.domain.Board;

public class BoardList {
	 static final int DEFAULT_CAPACITY = 10;
	 Board[] boards;
	 int size = 0;
	 
	public BoardList() {
		boards = new Board[DEFAULT_CAPACITY];
	 }
	 
	 public BoardList(int initialCapacity) {
		if (initialCapacity >DEFAULT_CAPACITY) 
			boards = new Board[initialCapacity];
		else 
			boards = new Board[DEFAULT_CAPACITY];
	}
 
	 public Board[] toArray() {
		//return Arrays.copyOf(boards,size);
		 
		 Board[] list = new Board[size];
		 
		 for (int i = 0; i < size; i++) {
			list[i] = boards[i];
		 }
		 return list;
	}
	 
	 public void add(Board board) {
		 if (size >= boards.length) {//20 >= 5
			 int oldCapacity = boards.length;
			 int newCapacity = oldCapacity + (oldCapacity >> 1);
			 boards = Arrays.copyOf(boards, newCapacity);//boards배열로 newCapacity만큼 복사해라
		 }
		 
		 boards[size++] = board;
			 
	 }
}
