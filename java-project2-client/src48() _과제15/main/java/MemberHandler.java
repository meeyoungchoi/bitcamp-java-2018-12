import java.sql.Date;
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
	
	  Member[] members = new Member[LENGTH];//인스턴스 변수인 members배열
	  int memberIdx = 0;//인스턴스 변수인 members 배열의 memberIdx 인덱스
	  Scanner keyboard;
	  
	  public MemberHandler(Scanner keyboard) {
		  this.keyboard = keyboard;
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
		    
		    members[memberIdx] = member;
		    memberIdx++;
		    
		    System.out.println("저장하였습니다.");
		  }
	  
	 public void listMember() {
		    for (int j = 0; j < memberIdx; j++) {
		      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
		          members[j].getNo(), members[j].getName(), members[j].getEmail(), 
		          members[j].getTel(), members[j].getRegisteredDate());
		    }
		}
}
