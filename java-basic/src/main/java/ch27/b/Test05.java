//reflaction api - 메서드의 상세정보 꺼내기
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.apache.ibatis.javassist.Modifier;

import static java.lang.reflect.Modifier.*;

public class Test05 {

	public static void main(String[] args) throws Exception {

		Class<?> clazz = String.class;

		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.printf(/*"메서드명: %s\n",m.getName()*/"메서드명:  %s.%s\n",
					m.getDeclaringClass().getSimpleName(),m.getName());
			System.out.printf("파라미터: %d\n",m.getParameterCount());
			Parameter[] params = m.getParameters();
			for (Parameter p : params) {
				System.out.printf("  %s:%s\n",
						p.getName(),//파라미터명
						p.getType().getName()//파리미터 타입명
						//arg2:[C :배열
						);
			}
			System.out.println("리턴 타입:");
			System.out.printf("  %s\n",m.getReturnType().getName());
			m.getReturnType();
			//getReturnType(): 클래스 객체를 리턴한다.
			
			System.out.println("접근 제어:");
			int modifiers =  m.getModifiers();//메서드 한정자, 제한자
			//4바이트 int값에 모든 정보가 들어있다.
			//System.out.printf("public: %b\n" , (modifiers & Modifier.PUBLIC) == Modifier.PUBLIC );
			if (Modifier.isPublic(modifiers))//(modifiers & Modifier.PUBLIC) == Modifier.PUBLIC ) 이거를 하면 내부적으로는 Modifier.isPublic(modifiers)이렇게 검사한다.
					System.out.println("    public");
			else if ((modifiers & /*Modifier.*/PROTECTED) == Modifier.PROTECTED )
				System.out.println("     public");
			else if ((modifiers &/* Modifier.*/PRIVATE) == Modifier.PRIVATE )
				System.out.println("    public");
			else if ((modifiers & /*Modifier.*/PUBLIC) == Modifier.PUBLIC )
				System.out.println("     public");
			
			if ((modifiers & STATIC) != 0)
				System.out.println("    static");
			
			if ((modifiers & FINAL) != 0) 
				System.out.println("    final");
			System.out.println("-------------------------------------------------");
		}
	}
}
