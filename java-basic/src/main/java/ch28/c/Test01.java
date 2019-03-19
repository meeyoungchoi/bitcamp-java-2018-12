//annotation 사용범위
//=>@Target을 이용하여 애노테이션을 붙일 수 있는 위치를 지정할 수 있다.
package ch28.c;

@MyAnnotation //.클래스
//@MyAnnotation2 //
//@MyAnnotation3//
//@MyAnnotation4//로컬 변수
public class Test01 {
	
	//@MyAnnotation //.
	@MyAnnotation2 //필드
	//@MyAnnotation3//
	//@MyAnnotation4//로컬 변수
	int i;
	

	//@MyAnnotation //.
	@MyAnnotation2 //필드
	//@MyAnnotation3//
	//@MyAnnotation4//로컬 변수
	static int j;
	
	//@MyAnnotation //.
	//@MyAnnotation2 //
	@MyAnnotation3//메서드
	//@MyAnnotation4//로컬 변수
	public static void main(String[] args) {
		//@MyAnnotation //.
		//@MyAnnotation2 //
		//@MyAnnotation3//
		@MyAnnotation4//로컬 변수
		int local;
	}
}
