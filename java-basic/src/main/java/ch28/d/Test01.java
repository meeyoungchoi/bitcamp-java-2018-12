//annotation 반복사용
//=>@Repeatableㅇ르 사용하여 
package ch28.d;

@MyAnnotation
//@MyAnnotation//기본으로 애노테이션을 한 선언어ㅔ 중복해서 사용할 수 없다.
@MyAnnotation2
@MyAnnotation2//@Repeatable로 선언된 애노테이션인 경우 중복해서 사용할 수 있다.
@MyAnnotation2//@Repeatable로 선언된 애노테이션인 경우 중복해서 사용할 수 있다
public class Test01 {
	public static void main(String[] args) {
	}
}
