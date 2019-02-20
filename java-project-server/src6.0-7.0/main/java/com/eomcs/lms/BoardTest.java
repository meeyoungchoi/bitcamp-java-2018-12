//7단계 - 서버 실행 테스트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.eomcs.lms.domain.Board;

public class BoardTest {

	ObjectOutputStream out;
	ObjectInputStream in;

	public BoardTest(ObjectOutputStream out, ObjectInputStream in) {
		this.out = out;
		this.in = in;
	}
	
	public void test(BoardTest obj) throws Exception {
		add(new Board(1, "내용"));
		add(new Board(2, "내용x"));

		detail(1);

		update(new Board(1, "내용222"));

		detail(1);

		delete(2);

		list();
	}
	private static void delete(int i) {
		// TODO Auto-generated method stub

	}

	private static void update(Board board) {
		// TODO Auto-generated method stub

	}

	private static void detail(int i) {
		// TODO Auto-generated method stub

	}

	private void add(Board board) throws Exception {
		out.writeUTF("/board/add");
		out.writeObject(board);
		out.flush();

		if (in.readUTF().equals("ok"))
			return;
		
		System.out.println(in.readUTF());

		String status = in.readUTF();

		if (status.equals("OK"))
			System.out.println("데이터 추가 성공!");
		else
			System.out.println("데이터 추가 실패!");
	}

	private void list() throws Exception {
		out.writeUTF("/board/list");
		out.flush();

		
		if (in.readUTF().equals("ok"))
			return;
		String status = in.readUTF();

		if (!status.equals("ok")) {
			System.out.println("데이터 목록 가져오기 실패!");
			return;
		}
		@SuppressWarnings("unchecked")
		//서버에 저장된 객체 목록을 받아서 출력
		List<Board> boards  = (List<Board>) in.readObject();//얘가 리턴한다 리스트를
		for (Board b : boards) {
			System.out.println(b);
		}
	}

	private void quit() throws Exception {
		out.writeUTF("종료함");
		out.flush();
		System.out.println(in.readUTF());
	}
}

