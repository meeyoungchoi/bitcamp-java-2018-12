package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;//import문을 사용해서 Member클래스라는 클래스 명을 명시하면 MemberHandler 클래스에서 Member 클래스의
//단순명을 사용하여 참조할수 있다.

/**
 * ### 과제 2: 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라. 

- MemberHandler.java
    - `App.java` 에서 회원관리와 관련된 변수와 메서드를 `MemberHandler` 클래스로 옮긴다.
    
    13. MemberHandler.java    
    - 변수와 메서드를 인스턴스 멤버로 전환한다.
    
    14.    핸들러 객체의 필수 입력 값인 keyboard를 반드시 설정하게 만들라!
    	기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
    
    15. - BoardHandler.java
    - Board 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.
 * */
public class MemberHandler {
	  
	  static final int LENGTH = 10;//클래스변수
	
	  ArrayList<Member> list;//인스턴스 변수인 members배열
	  Scanner keyboard;
	  
	  public MemberHandler(Scanner keyboard) {
		  this.keyboard = keyboard;
		  this.list = new ArrayList<>(20);
	  }
	  
	  public void addMember() {//클래스 변수가 인스턴스 변수로 변경되었으므로 메서드도 인스턴스 메서드로 만들어줘야 한다.
		//그래야만 인스턴스 변수가 인스턴스 메서드에 접근할 수 있다.
		    Member member = new Member();
		    
		    System.out.print("번호? ");
		    member.setNo(Integer.parseInt(keyboard.nextLine()));
		    
		    System.out.print("이름? ");
		    member.setName(keyboard.nextLine());
		    
		    System.out.print("이메일? ");
		    member.setEmail(keyboard.nextLine());
		    
		    System.out.print("암호? ");
		    member.setPassword(keyboard.nextLine());
		    
		    System.out.print("사진? ");
		    member.setPhoto(keyboard.nextLine());
		  
		    System.out.print("전화? ");
		    member.setTel(keyboard.nextLine());
		  
		    member.setRegisteredDate(new Date(System.currentTimeMillis()));
		    
		   list.add(member);
		    
		    System.out.println("저장하였습니다.");
		  }
	  
	 public void listMember() {
		 //Object[] objs = list.toArray();
		 Member[] members = list.toArray(new Member[] {});
		 
		    for (/*Object obj : objs*/Member member : members) {
		    	//Member member = (Member) obj;//member레퍼런스가 가리키는 실제 Member 타입을 그대로 사용하고 싶다면
		    	//즉, obj에 저장된 Lesson 클래스를 그대로 사용하고 싶다면
		    	//형변환 해서 사용해라
		    	//즉 obj에 들어있는 주소가 원래 Member의 인스턴스이니 obj에 저장해라
		      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
		          member.getNo(), member.getName(), member.getEmail(), 
		          member.getTel(), member.getRegisteredDate());
		    }
		}

	public void detailMember() {
		System.out.println("번호?");
		int no = Integer.parseInt(keyboard.nextLine());
		
		int index = indexOfMember(no);
		if (index == -1) {
			System.out.println("번호에 해당하는 내용이 없습니다.");
		}
		
		Member member = list.get(index);
		System.out.printf("이름: %s\n",member.getName());
		System.out.printf("이메일: %s\n",member.getEmail());
		System.out.printf("비밀번호: %s\n",member.getPassword());
		System.out.printf("사진: %s\n",member.getPhoto());
		System.out.printf("전화번호: %s\n",member.getTel());
		System.out.printf("등록일: %s\n",member.getRegisteredDate());
		
		
	}

	private int indexOfMember(int no) {
		for (int i = 0; i < list.size(); i++) {
		Member m	= list.get(i);
		if (m.getNo() == no) {
			return i;
		} 
	}
		return -1;
		
	}

	public void updateMember() {
		System.out.printf("번호?");
		int no = Integer.parseInt(keyboard.nextLine());
		
		int index = indexOfMember(no);
		if (index == -1) {
			System.out.println("번호에 해당하는 내용이 없습니다.");
			return;
		}
		
		Member member = list.get(index);
		
		try {
			Member temp = member.clone();//new Member(); //?
			//temp.setName(member.getName());
			//temp.setEmail(member.getEmail());
			//temp.setPassword(member.getPassword());
			//temp.setPhoto(member.getPhoto());
			//temp.setTel(member.getTel());
			
			System.out.printf("이름(%s)\n",member.getName());
			String input = keyboard.nextLine();
			if (input.length() > 0)
				temp.setName(input);
			
			System.out.printf("이메일:(%s)\n",member.getEmail());
			if ((input = keyboard.nextLine()).length() > 0)
			temp.setEmail(input);
			
			System.out.printf("비밀번호:(%s)\n",member.getPassword());
			if ((input = keyboard.nextLine()).length() > 0)
				temp.setPassword(input);
			
			System.out.printf("사진:(%s)\n",member.getPhoto());
			if ((input = keyboard.nextLine()).length() > 0 )
				temp.setPhoto(input);
			
			System.out.printf("전화번호:(%s)\n",member.getTel());
			if ((input = keyboard.nextLine()).length() > 0)
				temp.setTel(input);
			
			System.out.printf("등록일:(%s)\n",member.getRegisteredDate());
			if ((keyboard.nextLine()).length() > 0 )
				temp.setRegisteredDate(Date.valueOf(input));
			
			list.set(index,temp);
			
			System.out.println("변경을 완료 하였습니다.");
			
		} catch (Exception e) {
			System.out.println("변경 중 오류가 발생했습니다.");
		}
		
	}

	public void deleteMember() {
		System.out.println("번호?");
int no = Integer.parseInt(keyboard.nextLine());
		
		int index = indexOfMember(no);
		if (index == -1) {
			System.out.println("번호에 해당하는 내용이 없습니다.");
			return;
		}
		
		list.remove(index);
		System.out.println("삭제 완료");
	}
}
