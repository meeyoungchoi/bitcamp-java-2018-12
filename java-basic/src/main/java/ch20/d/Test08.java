//hashTable에서 Iterator를 얻은후 값을 변경할 때 -실행오류 발생
package ch20.d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class Test08 {
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
		

		Hashtable<String, Student> map = new Hashtable<>();
		map.put("aaa", new Student("홍길동", 20));
		map.put("bbb", new Student("임꺽정", 30));
		map.put("ccc",new Student("유관순", 25 ));
	
		Set<String> keySet = map.keySet();
		
		//Set에서 값을 꺼내기 위해 Iterator의 도움을 받는다.
		Iterator<String> iterator = keySet.iterator();
		
		System.out.println(iterator.next());
		
		
		map.put("bba", new Student("bba",20));
		map.put("bbc", new Student("bbc",20));
		
		//Iterator를 사용하는 중에 Set의 값을 변경하면
		//더이상 이터레이터는 유효하지 않게 된다.
		//따라서 다음과 같이 이터레이터를 사요하려하면 실행오류가 발생한다.
		//ConcurrentModificationException
		//해결방법
		//값을 변경하면 다시 이터레이터를 얻어야 한다.
		//변경된 상태에서 이터레이터를 계속 쓰면 안된다.ConcurrentModificationException
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		
		}
	}

/*
 * HashMap과 HashTable의 비교
 * 
 * 
 * */

