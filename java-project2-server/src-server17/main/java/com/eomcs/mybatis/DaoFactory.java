package com.eomcs.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DaoFactory {
	SqlSessionFactory sqlSessionFactory;

	public DaoFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
/*	public static<T> T create(Class<T> type) {
		return Proxy.newProxyInstance(
				type.getClassLoader(), 
				new Class[] {type}, 
				daoInvocationHandler);
	}*/
	
	@SuppressWarnings("unchecked")
	public <T> T create(Class<T> type) {
		return (T) Proxy.newProxyInstance(
				type.getClassLoader(), 
				new Class[] {type}, 
				invocationHandler);
	}


	InvocationHandler invocationHandler = 
			(Object proxy, Method method, Object[] args) ->{
			//dao인터페이스의 메서드를 호출할 떄 마다 이 메서드가 호출될 것이다.
			//이 메서드에서 할 일은 매퍼 파일에서 적절한 sql을 찾아 실행하는 것이다.

			//1. 실행할 sql 아이디를 준비하기
			//	sql 아이디= 인터페이스명.메서드명
			//인터페이스 이름을 알아내야 한다.
			//파라미터로 받은 프록시 객체로부터 인터페이스 이름을 알아낸다.
			//System.out.println(proxy.getClass().getInterfaces()[0].getName());
			//System.out.println(proxy.getClass().getInterfaces()[0].getSimpleName());
			//System.out.println(method.getName());
			/*String.format("%s.%s",
					proxy.getClass().getInterfaces()[0].getSimpleName(),
					method.getName());
			 *?
			 */
			String sqlId =String.format("%s.%s",
					proxy.getClass().getInterfaces()[0].getName(),
					method.getName());

			//2. 메서드의 리턴 타입을 알아낸다.
			Class<?> returnType = method.getReturnType();//메서드 객체가 이씅면 리턴타ㅣㅇㅂㅇ을 알아낼수 있다.

			//3.sql문을 실행할 sqlSession 객체를 준비한다.

			try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

				//System.out.println(sqlId);//이것을 sqlId로 사용할 것이다.
				System.out.println(sqlId +"의 sql을 실행한다.");

				//4. 리턴 타입에 따라 적절한 sqlSession의 메서드를 호출한다.
				if (returnType == List.class) {
					if (args == null) //즉 파라미터가 없는 dao의 메서드를 호출한다면 파라미터 없는 메서드를 호출한다면
						//파라미터 없이 실행해야 힌다.
						return sqlSession.selectList(sqlId);
					else 
						return sqlSession.selectList(sqlId, args[0]);
					//return sqlSession.selectList(sqlId);
				} else if (returnType == int.class) {
					if (args == null) 
						return sqlSession.update(sqlId);
					else
						return sqlSession.update(sqlId,args[0]);//0;
				} else {
					if (args == null)
						return sqlSession.selectList(sqlId);
					else
						return sqlSession.selectOne(sqlId, args[0] );//파라미터를 한개만 전달할 수 있다.
				}
			} 
			};
}




		
	


