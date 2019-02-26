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

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

//서버쪽에 있는 LessonDaoImpl 객체를 대행할 클라이언트측 대행자 클래스 정의 
//
public class LessonDaoImpl implements LessonDao {



	Connection con;
	
	 public LessonDaoImpl(Connection con) {
		 this.con = con;
	 }

	@SuppressWarnings("unchecked")
	public List<Lesson> findAll() {


		try (PreparedStatement stmt = con.prepareStatement("select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts  from lms_lesson" 
				+ " order by lesson_id desc")) {

			try (ResultSet rs = stmt.executeQuery()) {

				ArrayList<Lesson> list = new ArrayList<>();
				while (rs.next()) {
					Lesson lesson = new Lesson();
					lesson.setNo(rs.getInt("lesson_id"));
					lesson.setStartDate(rs.getDate("sdt"));
					lesson.setEndDate(rs.getDate("edt"));
					lesson.setTotalHours(rs.getInt("tot_hr"));
					lesson.setDayHours(rs.getInt("day_hr"));
					lesson.setTitle(rs.getString("titl"));
					lesson.setContents(rs.getString("conts"));

					list.add(lesson);

				} return list;

			}
		}catch (Exception e) {
			throw new RuntimeException(e);

		}

	}

	public void insert(Lesson lesson) {


		try (PreparedStatement stmt = con.prepareStatement("insert into lms_lesson(titl, conts, sdt, edt, tot_hr, day_hr) "
				+ "values(?, ?, ?, ?, ?, ?)")) {


			stmt.setString(1, lesson.getTitle());
			stmt.setString(2, lesson.getContents());
			stmt.setDate(3, lesson.getStartDate());
			stmt.setDate(4, lesson.getEndDate());
			stmt.setInt(5, lesson.getTotalHours());
			stmt.setInt(6, lesson.getDayHours());

			stmt.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Lesson findByNo(int no) {

		try (PreparedStatement stmt = con.prepareStatement("select lesson_id, titl, conts, sdt ,edt, tot_hr, day_hr from lms_lesson where lesson_id = ?")) {

			stmt.setInt(1, no);//detail

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					Lesson lesson = new Lesson();
					lesson.setNo(rs.getInt("lesson_id"));
					lesson.setTitle(rs.getString("titl"));
					lesson.setContents(rs.getString("conts"));
					lesson.setStartDate(rs.getDate("sdt"));
					lesson.setEndDate(rs.getDate("edt"));
					lesson.setTotalHours(rs.getInt("tot_hr"));
					lesson.setDayHours(rs.getInt("day_hr"));

					return lesson;
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

	public int update(Lesson lesson) {


		//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
		//=>java.sql.statement 구현체
		try (PreparedStatement stmt = con.prepareStatement("update lms_lesson set sdt = ?, edt = ?, tot_hr =?, day_hr = ?, conts = ? where lesson_id = ?")) {

			stmt.setDate(1,lesson.getStartDate());
			stmt.setDate(2, lesson.getEndDate());
			stmt.setInt(3, lesson.getTotalHours());
			stmt.setInt(4, lesson.getDayHours());
			stmt.setString(5,lesson.getContents());


			return stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int delete(int no) {


		//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
		//=>java.sql.statement 구현체
		try (PreparedStatement stmt = con.prepareStatement(
				"delete from lms_lesson where lesson_id = ?")) {

			stmt.setInt(1, no);

			return stmt.executeUpdate();
		}	catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}









