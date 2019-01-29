//hashMap에서 value목록 꺼내
package ch20.d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;


public class Test04 {
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
		Collection<Student> values = map.values();
		for (Student value : values) {
			System.out.println(value);
		}
		
		
		

		
		
	}
}
