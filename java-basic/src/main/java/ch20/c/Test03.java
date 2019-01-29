//Set:인터페이스
//java.util.set 인터페이스를 구현한 클래스 사용법 -add(), hashCode(), equals()
package ch20.c;

import java.util.HashSet;
import java.util.Iterator;

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

			@Override
			public int hashCode() {//데이터를 저장할 위치를 잡을때
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
		
		
		HashSet<Student> set = new HashSet<>();
		
		//
		set.add(new Student("aaa", 20));
		set.add(new Student("bbb", 30));
		set.add(new Student("ccc", 40));
		
		//Set은 집합의 특성을 따른다.
		//그래서 같은 값을 중복해서 넣을 수 없다.
		//
		//
		//현재 student 로컬 클래스는 equals()와 hashCode()를 오버라이딩 하였다.
		//따라서 인스턴스는 다르지만 equals()의 결과가 
		//즉, 
		//
		//해시셋에서 값을 저장할 때 그 위치는 해시코드의 리턴값으로 결정한다.
		//나눈 나머지 가지고 이쪽 배열에 저장할지 저쪽 배열에 저장할지를 결정한다.
		set.add(new Student("aaa", 20));
		set.add(new Student("bbb", 30));
		
		//=>null을 넣을 수 있다. 단 중복해서 넣을 수 없다.
		set.add(null);
		set.add(null);
		
		//Set에
		//
		//
		Iterator<Student> iterator = set.iterator(); 
		//hash코드에따라서 입력위치가 달라지므로 순서대로 나오지 않는다.
		//순서대로 뽑으려면 list라는 인터페이스를 구현한 어레이리스트 스택 리스트 를 사용해야 한다.
		while (iterator.hasNext()) {
			//Student s = iterator.next();
			//System.out.println(s) =>내부적으로 이 객체에 대해서 toString을 호출한다.
			System.out.println(iterator.next());
		}
		
		//HashSet의 특징
		//출력 결과를 보면 입력 순서로 꺼낼수 없다.
		//이유?
		//저장할때 각 인스턴스에 대해 hashCode()의 리턴 값으로 위치를 정하기 때문이다.
		//
		
		System.out.println("=============================================");
		
		Object[] values = set.toArray();
		for (Object value : values) {
			System.out.println(value);
		}
		System.out.println("--------------------------------------------------");
		
		//입력한 값의 타입으로 배열을 받고 싶다면
		//파라미터로 넘겨 준 배열이 값을 담을 만큼 크지 않다면, 새 배열을 만들어 리턴한다.
		//Student [] values2 = set.toArray(temp);
		//System.out.println(temp == values2);
		Student[] values2 = set.toArray(new Student[0]);
		for (Student value : values2) {
			System.out.println(value);
		}
		
	
		
		
	}
}
