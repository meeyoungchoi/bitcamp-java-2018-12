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

  public void insert(Member member) {//add
	  try (PreparedStatement stmt = con.prepareStatement("insert into lms_member(name, email, pwd, cdt, tel, photo) "
				+ "values(?, ?, ?, ?, ?, ?)")) {


			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getPassword());
			stmt.setDate(4, member.getRegisteredDate());
			stmt.setString(5, member.getTel());
			stmt.setString(6, member.getPhoto());

			stmt.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
  }

  public Member findByNo(int no) {
	  try (PreparedStatement stmt = con.prepareStatement("select member_id, name, email, pwd, cdt, tel, photo from lms_member where member_id = ?")) {

			stmt.setInt(1, no);//detail

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					Member member = new Member();
					member.setNo(rs.getInt("member_id"));
					member.setName(rs.getString("name"));
					member.setEmail(rs.getString("email"));
					member.setPassword(rs.getString("pwd"));
					member.setRegisteredDate(rs.getDate("edt"));
					member.setTel(rs.getString("tel"));
					member.setPhoto(rs.getString("photo"));

					return member;
					/* System.out.printf("제목: %s\n", rs.getString("title"));
		            System.out.printf("내용: %s\n", rs.getString("contents"));
		            System.out.printf("등록일: %s\n", rs.getString("created_date"));
		            System.out.printf("조회수: %d\n", rs.getInt("view_count"));*/
				} else {
					return null;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
  }

  public int update(Member member) {
		//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
		//=>java.sql.statement 구현체
		try (PreparedStatement stmt = con.prepareStatement("update lms_member set name = ?, email = ?, pwd =?, tel = ?, photo = ? where lesson_id = ?")) {

			stmt.setString(1,member.getName());//첫번쨰 물음표에 이름을 넣을거다.
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getTel());
			stmt.setString(5,	member.getPhoto());
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
  }

  public int delete(int no) {
	//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
			//=>java.sql.statement 구현체
			try (PreparedStatement stmt = con.prepareStatement(
					"delete from lms_member where member_id = ?")) {

				stmt.setInt(1, no);//1: 물음표가 첫번쨰에 있는거여서 1번이다. 첫번쨰 물음표에 no의 값을 넣고 그 no의 값을 지운다

				return stmt.executeUpdate();
			}	catch (Exception e) {
				throw new RuntimeException(e);
			}
  }
}









