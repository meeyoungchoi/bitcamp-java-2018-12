package com.eomcs.lms.dao.mariadb;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

//서버쪽에 있는 MemberDaoImpl 객체를 대행할 클라이언트측 대행자 클래스 정의 
//
public class MemberDaoImpl implements MemberDao {

 Connection con;
 
 public MemberDaoImpl(Connection con) {
	 this.con = con;
 }

  @SuppressWarnings("unchecked")
  public List<Member> findAll() {
	  
		      
		      try (PreparedStatement stmt = con.prepareStatement("select member_id, name, email, pwd, cdt, tel, photo  from lms_lesson" 
		    		  + " order by member_id desc")) {
		        
		        try (ResultSet rs = stmt.executeQuery()) {
		        	
		        	ArrayList<Member> list = new ArrayList<>();
		          while (rs.next()) {
		        	  Member member = new Member();
		        	  member.setNo(rs.getInt("member_id"));
		        	  member.setName(rs.getString("name"));
		        	  member.setPassword(rs.getString("pwd"));
		        	  member.setPhoto(rs.getString("photo"));
		        	  member.setRegisteredDate(rs.getDate("cdt"));
		        	  member.setTel(rs.getString("tel"));
		        	  member.setPhoto(rs.getString("photo"));
		        	  
		        	  list.add(member);
		        	  
		          } return list;
		          
		        }
		      } catch (Exception e) {
		  throw new RuntimeException(e);
		  
	  }  
  }

  public void insert(Member member) {
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/member/add"); 
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(member);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버의 데이터 저장 실패!");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Member findByNo(int no) {
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/member/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버의 데이터 가져오기 실패!");

      return (Member) in.readObject();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Member member) {
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/member/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(member);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) 
        throw new Exception("서버의 데이터 데이터 변경 실패!");
      
      return 1;
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/member/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버의 데이터 삭제 실패!");
      
      return 1;
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}









