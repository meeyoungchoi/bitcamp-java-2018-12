//hashMap에서 key, value목록 함께 꺼내기
package ch20.d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;


public class Test05 {
	public static void main(String[] args) {
		class Student {
			String name;
			int age;
			
			public Student(String name, int age) {
				this.name = name;
				this.age = age;
				
			}

			@Override
			public String toString() {
				return "Student [name=" + name + ", age=" + age + "]";
			}
			
		}
		

		HashMap<String, Student> map = new HashMap<>();
		map.put("aaa", new Student("홍길동", 20));
		map.put("bbb", new Student("임꺽정", 30));
		map.put("ccc",new Student("유관순", 25 ));
	
		//value 목록 꺼내기(키 알필요 없고 값만 꺼낼때)
		//엔트리셋 이라는 집합 안에는 엔트리가 여러개 들어있다.
		Set<Entry<String,Student>> entrySet = map.entrySet();
		for (Entry<String,Student> value : entrySet) {
			System.out.printf("%s==>%s\n",entry.getValue(), entry.getKey() );
		}
		
		
		

		
		
	}
}
