//java.util.ArrayList사용법-indexOf()
package ch20.a;

import java.util.ArrayList;
import java.util.Date;

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
		/*	@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + age;
				result = prime * result + ((name == null) ? 0 : name.hashCode());
				return result;
			}*/
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
		
		Student s1 = new Student("aaa",20);
		Student s2 = new Student("bbb", 40);
		Student s3 = new Student("ccc",40);
		Student s4 = new Student("bbb",30);
		
		System.out.println(s2 == s4);
		System.out.println(s2.equals(s4));
		System.out.println(s2.hashCode() == s4.hashCode());
	
		ArrayList<Student> list = new ArrayList<>();
		//add(value)는 
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		
		System.out.println(list);
		
		//contains(): 인스턴스가 다르더라도 equals()의 리턴값이 true라면
		//같은 값이 ㄴ목록에 있는 것으로 판단한다.
		//그 목록에 그런값을 포함하고있는가
		//기준:hashCOde의 리턴값,이퀄스
		//Student 클래스에서 equals()를 오버라이딩 하지 않는다면
		//list.contains(s4)
		
		//indexOf(값)
		//목록에 해당 값이 있는 인덱스를 알아낸다.
		//값을 비교할 때는 contains()와 마찬가지로 equals()의 리턴값이 true인 경우 같은 값으로 간주한다.
		System.out.println(list.indexOf(s2));
		System.out.println(list.indexOf(s4));
		System.out.println(list.indexOf(new Student("ccc", 30)));//못찾으면 -1
		
		
	}
	
}
