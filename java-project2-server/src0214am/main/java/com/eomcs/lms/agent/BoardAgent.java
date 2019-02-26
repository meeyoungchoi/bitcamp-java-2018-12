package com.eomcs.lms.agent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.eomcs.lms.domain.Board;

public class BoardAgent {

	@SuppressWarnings("unchecked")
	public static List<Board> list(ObjectInputStream in, ObjectOutputStream out) throws Exception {
		out.writeUTF("/board/list"); 
		out.flush();

		if (!in.readUTF().equals("OK"))
			//return;
			throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

		String status = in.readUTF();

		if (!status.equals("OK")) {
			throw new Exception("서버에서 게시글 목록 가져오기 실패!");
			//System.out.println("데이터 목록 가져오기 실패!");
			//return;
			
		
	
		
		}
		
		
	}
	public static List<Board> list(ObjectInputStream in, ObjectOutputStream out) {
		out.writeUTF("/board/list"); 
		out.flush();

		if (!in.readUTF().equals("OK"))
			//return;
			throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

		String status = in.readUTF();

		if (!status.equals("OK")) {
			throw new Exception("서버에서 게시글 목록 가져오기 실패!");
			//System.out.println("데이터 목록 가져오기 실패!");
			//return;
			
			
	
		
		}
		
		
	}
	public static void add(Board board,ObjectInputStream in, ObjectOutputStream out) throws Exception{
		out.writeUTF("/board/add"); 
		out.flush();

		if (!in.readUTF().equals("OK"))
			//return;
			throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

		out.writeObject(board);
		out.flush();
		
		String status = in.readUTF();

		if (!status.equals("OK")) {
			return 1;
			else 
				return 0;
	
	
	
	}
		
		public static void get(int no, ObjectInputStream in, ObjectOutputStream out) throws Exception {
			 try {
			    	out.writeUTF("/board/detail");
				    out.flush();
				    if (!in.readUTF().equals("OK"))
				      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
				    
				    out.writeInt(no);
				    out.flush();
				    
				    String status = in.readUTF();
				    
				    if (!status.equals("OK")) 
				    	throw new Exception ("서버에 데이터 저장 실패");
				    
				    
				    Board board = (Board) in.readObject();
				    System.out.println(board);
				    
				    System.out.printf("내용: %s\n", board.getContents());
				    System.out.printf("작성일: %s\n", board.getCreatedDate());
			    } catch (Exception e) {
			    	System.out.printf("게시글 상세정보 출력오류 : %s\n",e.getMessage());
			    }
			
		}
		}
	public static void update(Board board, ObjectInputStream in, ObjectOutputStream out) {
		out.writeUTF("/board/detail");
		out.flush();
		if (!in.readUTF().equals("OK"))
			throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

		out.writeInt(no);
		out.flush();

		String status = in.readUTF();
		if (!status.equals("ok"))
			throw 
	}
	
	public static void delete(int no, ObjectInputStream in, ObjectOutputStream out) throws Exception {
		 try {
		        out.writeUTF("/board/delete");
		        out.flush();
		        if (!in.readUTF().equals("OK"))
		          throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
		        
		        out.writeInt(no);
		        out.flush();
		        
		        String status = in.readUTF();
		        
		        if (!status.equals("OK")) 
		          throw new Exception("서버에서 게시글을 삭제하는데 실패!");
		        
		        System.out.println("게시글을 삭제했습니다.");
		        
		      } catch(Exception e) {
		    	System.out.printf("게시글 삭제 오류!:%s\n",e.getMessage());
	} 
	}
	

