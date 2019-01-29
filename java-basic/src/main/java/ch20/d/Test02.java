//hashMap, hashTable
package ch20.d;

import java.util.HashMap;
import java.util.Hashtable;


public class Test02 {
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
		Hashtable<String, Student> table = new Hashtable<>();
		
		map.put("aaa", new Student("홍길동", 20));
		table.put("bbb", new Student("홍길동", 20));
		
		System.out.println(map.get("aaa"));
		System.out.println(map.get("aaa"));
		
		map.put(null, new Student("임꺽정", 30));
		System.out.println(map.get(null));
		
		//hashtable은 키로 null을 혀용하지 않는다.
		//map.put(null, new Student("임꺽정", 30));//Runtime 오류
		//System.out.println(table.get(null));
		
		map.put("ccc", null);
		System.out.println(table.get("ccc"));
		//
		
		

		
		
	}
}
