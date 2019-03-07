//select 결과 값을 맵 객체에 받기

package ch26.d;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {
	public static void main(String[] args) throws Exception {

		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/d/mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//select 문에서 컬럼 값을 자바 인스턴스의 프로퍼티와 맞추기 위해
		//별명을 부여하는 방식은 매우 번거롭다.
		//특히 컬럼 개수가 많은 경우 더더욱 번거롭다.
		//이를 해결하기 위해 mybatis는 컬럼의 이름과 프로퍼티 이름을 미리 설정해두는 문법을 제공한다.
		//<resultMap></reslutMap>
		//select결과를 뱁
		Map<Object,Object> map = sqlSession.selectOne("board.select6");
		System.out.println(map);
		System.out.println(map.get("board_id"));
		System.out.println(map.get("title"));
		System.out.println(map.get("contents"));
		System.out.println(map.get("created_date"));
		System.out.println(map.get("view_count"));
		System.out.println("--------------------------------------------------------------------------------");

		List<Map<?,?>> list = sqlSession.selectList("board.select7");
		for (Map<?,?> m: list) {
			System.out.println(m);
		}



	}

}
