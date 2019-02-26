package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.agent.BoardAgent;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {
	Scanner keyboard;
	BoardAgent agent;


	public BoardAddCommand(Scanner keyboard, BoardAgent boardAgent) {
		this.keyboard = keyboard;
		this. boardAgent = boardAgent;
		//agent = new BoardAgent("localhost",8888,"/board");
	}

	@Override
	public void execute(ObjectInputStream in, ObjectOutputStream out) {
		Board board = new Board();

		System.out.print("번호? ");
		board.setNo(Integer.parseInt(keyboard.nextLine()));

		System.out.print("내용? ");
		board.setContents(keyboard.nextLine());

		board.setCreatedDate(new Date(System.currentTimeMillis())); 

		board.setViewCount(0);

		try {
			Agent.add(board);
			System.out.println("저장하였습니다.");

		} catch (Exception e) {
			System.out.printf("실행 오류! : %s\n", e.getMessage());
		}
	}
}
