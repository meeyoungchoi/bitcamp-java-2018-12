// 데이터 처리 관련 코드를 별도의 클래스로 분리
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl extends AbstractDao<Board> implements BoardDao{

	public BoardDaoImpl(String filepath) {
		this.filepath = filepath;
	}

	public void insert(Board board)  {
		try {
			list.add(board);
			this.saveData();
		} catch (Exception e) {//파일에 저장하다가 오류가 떳을때 그 예외를 호출하는 쪽에 알려줘야 한다,
			//호출하는 쪽에 계속 가야하는지 말아야하는지를 알려줘야 한다.
			//그러므로 여기에 대충 메세지를 적으면 안된다.
			//호출자에게 왜 에러가 떳는지를 알려줘야 한다.
			//runtimeexception
			throw new RuntimeException(e);//숨겨짐 모드로 던지기 때문에 인터페이스 예외를 선언하지 않아도 된다.
			//런타임익셉션 계열의 예외를 던질때는 메서드에 예외를 던진다고 선언할 필요가 없다.
		}
	}

	public List<Board> findAll() {
		return list;
	}

	public Board findByNo(int no) {
		for (Board obj : list) {
			if (obj.getNo() == no) {
				return obj;
			}
		}
		return null;
	}

	public int update(Board board) {
		try {
			int index = 0;
			for (Board obj : list) {
				if (obj.getNo() == board.getNo()) {
					list.set(index, board);
					this.saveData();
					return 1;
				}
				index++;
			}
			return 0;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int delete(int no)  {
		try {
			int index = 0;
			for (Board obj : list) {
				if (obj.getNo() == no) {
					list.remove(index);
					this.saveData();
					return 1;
				}
				index++;
			}
			return 0;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}







