//reflection api -인스턴스 생성하기
package ch27.c;

import java.lang.reflect.Constructor;

public class Test01 {
	public static void main(String[] args) throws Exception {
		
	//Class<?> clazz = Student.class;
	Class<?> clazz = Class.forName("ch27.c.Student");//위와
	
	//클래스 정보를 가지고 인스턴스 생성하기(de)
	//기본 생성자가 있을 때만 가능하다.
	//
	Student s1 = (Student) clazz.newInstance();
	
	//생성자를 통해 인스턴스를 생성하라
	//기본 생성자 꺼내기
	//파라미터가 없으면 기본 생성자 이다.
	@SuppressWarnings("unchecked")
	Constructor<Student> c1 = (Constructor<Student>)clazz.getConstructor();
	Student s2 = (Student) c1.newInstance();
	
	//파라미터를 받는 생성자 꺼내기
	@SuppressWarnings("unchecked")
	Constructor<Student> c2 = 
			(Constructor<Student>)clazz.getConstructor(String.class, String.class);
	
	//파라미터를 받는 생성자를 실행할 때는 파리미터 값을 생성자에 넘겨줘야 한다.
	//생성자를 가지고 인스턴스를 생성하는 방법
	Student s3 = c2.newInstance("홍길동", "hong@test.com");
	System.out.println(s3);
	}
}
