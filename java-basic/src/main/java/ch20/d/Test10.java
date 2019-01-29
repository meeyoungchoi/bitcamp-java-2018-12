//hashMap에서 value목록 꺼내2
package ch20.d;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;


public class Test10 {
	public static void main(String[] args) {
		class Key {
			int major;
			int minor;
			
			public Key(int major, int minor) {
				this.major = major;
				this.minor = minor;
			}

			@Override
			public String toString() {
				return "Key [major=" + major + ", minor=" + minor + "]";
			}
			
		}
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
		Key k1 = new Key(100, 1);
		Key k2 = new Key(100, 2);
		Key k3 = new Key(100, 3);

		Hashtable<Key, Student> map = new Hashtable<>();
		map.put(k1, new Student("홍길동", 20));
		map.put(k2, new Student("임꺽정", 30));
		map.put(k3,new Student("유관순", 25 ));
		
		System.out.println(map.get(k1));
		System.out.println(map.get(k2));
		System.out.println(map.get(k3));
		
		
		Key k4 = new Key(100, 2);
		System.out.println(map.get(k4));
		
		System.out.println(k2 == k4);
		System.out.println(k2.hashCode() == k4.hashCode());
		System.out.println(k2.equals(k4));
		
		//저장할때,
		//key 객체의 hashCode() 리턴 값으로 위치를 계산하여 저장한다.
		//
		//값을 꺼낼 때
		//=>key 객체의   hashCOde()의 
		//
		//
		//결론,
		//k2와 k4는 비록 인스턴스가 다르더라도 인스턴스 필드의 값은 같지만,
		//그러나 해시코드가 다르기 때문에 위치 계산 결과가 달라진다.
		//또한, equals()의 리턴값이 false이기 때문에 다른 키로 인식한다.
		//=> 그래서 k2로 저장한 값을 k4로 꺼낼수 없다.
		//
		//해결책
		//인스턴스가 다르더라도 인스턴스 필드의 갓ㅂ이 같을 때는
		//해시코드의 리턴값이 같게 하라
		//또한 equals()의 리턴값이 true가 되게 하라!
		
		
		
		
		

		
		
	}
}
