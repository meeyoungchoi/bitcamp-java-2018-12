//hashMap에서 키 목록 꺼내기
package ch20.d;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;


public class Test03 {
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
	
		//
		//set에 담아서 키 목록을 리턴해준다.
		//셋 인터페이스를 구현한 어떤 클래스의 객체를 만들어서 거기에 키를 담아서 리턴한다.
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.printf("%s=> %s\n",key,map.get(key));
		}
		
		
		

		
		
	}
}
