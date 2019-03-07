package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.util.ConnectionFactory;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

  // 외부에서 커넥션 객체를 주입 받는다.


  @Override
  public List<PhotoBoard> findAll() {
	  Connection con = ConnectionFactory.create();
	  
    try (
    		PreparedStatement stmt = con.prepareStatement(
        "select photo_id, titl, cdt, vw_cnt, lesson_id from lms_photo"
            + " order by photo_id desc")) {

      try (ResultSet rs = stmt.executeQuery()) {

        ArrayList<PhotoBoard> list = new ArrayList<>();
        while (rs.next()) {
          PhotoBoard photoBoard = new PhotoBoard();
          photoBoard.setNo(rs.getInt("photo_id"));
          photoBoard.setTitle(rs.getString("titl"));
          photoBoard.setCreatedDate(rs.getDate("cdt"));
          photoBoard.setViewCount(rs.getInt("vw_cnt"));
          photoBoard.setLessonNo(rs.getInt("lesson_id"));

          list.add(photoBoard);
        }
        return list;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void insert(PhotoBoard photoBoard) {//새로 리턴받은 커넥션은 사용해서 인서트한다.
	  Connection con = ConnectionFactory.create();//커넥션을 바깥에 선언해서 안닫히게 하는 방법이 있다.
	  //커넥션을 함부로 닫으면 안된다.
	  //자동 close 가 안되도록 한다.
	  //이유? 커넥션을 여러군데에서 사용해야 하므로
	  
    try ( //Connection con = ConnectionFactory.create();
    		PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo(titl,lesson_id) values(?,?)",
        Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getLessonNo());
      stmt.executeUpdate();
      
      try (ResultSet rs = stmt.getGeneratedKeys()) {
        rs.next();
        photoBoard.setNo(rs.getInt(1)); // 자동 생성된 PK 값을 파라미터로 받은 객체에 보관한다.
      }
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public PhotoBoard findByNo(int no) {
	  Connection con = ConnectionFactory.create();
	  
    try {
      // 조회수 증가시키기
      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_photo set vw_cnt = vw_cnt + 1 where photo_id = ?")) {
        stmt.setInt(1, no);
        stmt.executeUpdate();
      }

      try (PreparedStatement stmt = con.prepareStatement(
          "select photo_id, titl, cdt, vw_cnt, lesson_id from lms_photo"
          + " where photo_id = ?")) {

        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery()) {

          if (rs.next()) {
            PhotoBoard photoBoard = new PhotoBoard();
            photoBoard.setNo(rs.getInt("photo_id"));
            photoBoard.setTitle(rs.getString("titl"));
            photoBoard.setCreatedDate(rs.getDate("cdt"));
            photoBoard.setViewCount(rs.getInt("vw_cnt"));
            photoBoard.setLessonNo(rs.getInt("lesson_id"));
            return photoBoard;
            
          } else {
            return null;
          }
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  @Override
  public int update(PhotoBoard photoBoard) {
	  Connection con = ConnectionFactory.create();
	  
    try (
    		PreparedStatement stmt = con.prepareStatement(
        "update lms_photo set titl = ? where photo_id = ?")) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getNo());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  @Override
  public int delete(int no) {
	  Connection con = ConnectionFactory.create();
    try (
    		PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo where photo_id = ?")) {

      stmt.setInt(1, no);

      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
