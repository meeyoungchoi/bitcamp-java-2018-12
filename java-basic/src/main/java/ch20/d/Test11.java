//hashMap에서 value목록 꺼내2
package ch20.d;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;


public class Test11 {
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

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + age;
				result = prime * result + ((name == null) ? 0 : name.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Student other = (Student) obj;
				if (age != other.age)
					return false;
				if (name == null) {
					if (other.name != null)
						return false;
				} else if (!name.equals(other.name))
					return false;
				return true;
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
		
		
	}
}
