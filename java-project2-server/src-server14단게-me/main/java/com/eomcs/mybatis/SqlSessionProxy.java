package com.eomcs.mybatis;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

//sqlSession객체의 작업 대행
//closet()호출될때,
//트랜잭션이 시작된 상태라면 close()를 무시하고
//트잭션이 시작된 상태가 아니라면 close()정장적으로 수행한다.
public class SqlSessionProxy implements SqlSession{
	//트랜잭션 상태냐 아니냐
	boolean useTransaction;
	SqlSession original;
	
	public SqlSessionProxy(SqlSession original) {
		this(original, false);//생서앚가 호춣되었을 때 다른 생성자를 호출할 수 ㅣㅇㅆ다. 트랜잭션을 사용하지 않겠다.(false)
;	}
	
	public SqlSessionProxy(SqlSession original, boolean useTransaction) {
		this.original = original;
		this.useTransaction = useTransaction;
	}

	//다른 메서드는 원래의 기능 그대로 두고,
	//close()에 대해서만 다음과 같이 변경한다.
	public void close() {
		//트랜잭션을 시작한 상태라면 트랜잭션을 종료할 때까지 공유되는 SqlSession을 닫아서는 안된다.
		//만약 트랜잭션이 사용중이라면 클로즈 하지않고 그냥 리턴한다.
		//트랜잭션을 사용하징 않을때만 정상저긍로close한다.
		if (useTransaction) 
			return;
		original.close();
	}
	
	//트랜잭션 사용 여부 설정
	public void setUseTransaction(boolean use) {
		this.useTransaction = use;
	}

	public <T> T selectOne(String statement) {
		return original.selectOne(statement);
	}

	public <T> T selectOne(String statement, Object parameter) {
		return original.selectOne(statement, parameter);
	}

	public <E> List<E> selectList(String statement) {
		return original.selectList(statement);
	}

	public <E> List<E> selectList(String statement, Object parameter) {
		return original.selectList(statement, parameter);
	}

	public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
		return original.selectList(statement, parameter, rowBounds);
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		return original.selectMap(statement, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
		return original.selectMap(statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		return original.selectMap(statement, parameter, mapKey, rowBounds);
	}

	public <T> Cursor<T> selectCursor(String statement) {
		return original.selectCursor(statement);
	}

	public <T> Cursor<T> selectCursor(String statement, Object parameter) {
		return original.selectCursor(statement, parameter);
	}

	public <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds) {
		return original.selectCursor(statement, parameter, rowBounds);
	}

	@SuppressWarnings("rawtypes")
	public void select(String statement, Object parameter, ResultHandler handler) {
		original.select(statement, parameter, handler);
	}

	@SuppressWarnings("rawtypes")
	public void select(String statement, ResultHandler handler) {
		original.select(statement, handler);
	}

	public void select(String statement, Object parameter, RowBounds rowBounds, @SuppressWarnings("rawtypes") ResultHandler handler) {
		original.select(statement, parameter, rowBounds, handler);
	}

	public int insert(String statement) {
		return original.insert(statement);
	}

	public int insert(String statement, Object parameter) {
		return original.insert(statement, parameter);
	}

	public int update(String statement) {
		return original.update(statement);
	}

	public int update(String statement, Object parameter) {
		return original.update(statement, parameter);
	}

	public int delete(String statement) {
		return original.delete(statement);
	}

	public int delete(String statement, Object parameter) {
		return original.delete(statement, parameter);
	}

	public void commit() {
		original.commit();
	}

	public void commit(boolean force) {
		original.commit(force);
	}

	public void rollback() {
		original.rollback();
	}

	public void rollback(boolean force) {
		original.rollback(force);
	}

	public List<BatchResult> flushStatements() {
		return original.flushStatements();
	}

	

	public void clearCache() {
		original.clearCache();
	}

	public Configuration getConfiguration() {
		return original.getConfiguration();
	}

	public <T> T getMapper(Class<T> type) {
		return original.getMapper(type);
	}

	public Connection getConnection() {
		return original.getConnection();
	}

}
