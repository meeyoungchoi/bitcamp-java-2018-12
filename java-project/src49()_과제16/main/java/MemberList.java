import java.util.Arrays;

import com.eomcs.lms.domain.Member;

public class MemberList {
	static final int DEFAULT_CAPACITY = 10;//클래스변수

	 Member[] members;//인스턴스 변수인 members배열
	 int size = 0;
	 public MemberList() {
		 this.members = new Member[DEFAULT_CAPACITY];
	 }
	 
	 public MemberList(int initialCapacity) {
		 if (initialCapacity >DEFAULT_CAPACITY)
			 members = new Member[initialCapacity];
		 else  
			 members = new Member[DEFAULT_CAPACITY];
	 }
	 
	 public void add(Member member) {
		 if (size >= members.length) {
			 int oldCapacity = members.length;
			 int newCapacity = oldCapacity + (oldCapacity >> 1);
			 members = Arrays.copyOf(members, newCapacity);
		 }
		 
		 members[size++] = member;
		 
		 
	 }
	 
	 public Member[] toArray() {
		//return Arrays.copyOf(members, size);
		 
		 Member[] list = new Member[size];
		 
		 for (int i = 0; i < size; i++) {
			 list[i] = members[i];
		 }
		 
		 return list;
		 
	 }
	 
	
	 
}
