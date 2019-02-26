package com.eomcs.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import com.eomcs.lms.context.ApplicaionContextListener;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;

//app 객체의 상태가 변경될 때 마다 보고 받는 옵저버가 되려면
//applicationcontextListeners 규격에 따라 작성해야 한다.
public class ApplicationInitializer implements ApplicaionContextListener {

	Connection con;

	@Override
	public void contextInitialized(Map<String, Object> context)  {//클래스 이름만 보더라도 무슨 예외인지 알게하기위해
		//받는쪽에서 그 예외가 어떤 예외인지 빨리 파악하기 위해서
		
		try {
			 con = DriverManager.getConnection(
				        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
			  LessonDaoImpl lessonDao = new LessonDaoImpl(con);
			  MemberDaoImpl memberDao = new MemberDaoImpl(con);
			  BoardDaoImpl boardDao = new BoardDaoImpl(con);
			  
			  
		} catch (Exception e) {
			throw new ApplicationContextException(e);
		}
	}

	@Override
	public void contextDestroyes(Map<String, Object> context) throws ApplicationContextException {
		
		try {
			con.close();
			//throw new Exception("오호라 일부러 발생시킨 예외");
		} catch (Exception e) {
			throw new ApplicationContextException(e);
		}
		
	}
}
