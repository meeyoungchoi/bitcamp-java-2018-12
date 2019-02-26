import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.domain.Member;//import문을 사용해서 Member클래스라는 클래스 명을 명시하면 MemberHandler 클래스에서 Member 클래스의
//단순명을 사용하여 참조할수 있다.

/**
 * ### 과제 2: 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라. 

- MemberHandler.java
    - `App.java` 에서 회원관리와 관련된 변수와 메서드를 `MemberHandler` 클래스로 옮긴다.
 * */
public class MemberHandler {
	  static Scanner keyboard = new Scanner(System.in);//클래스 변수
	  static final int LENGTH = 10;//클래스변수
	
	  static Member[] members = new Member[LENGTH];//클래스 변수 static이 붙은 Member타입의 members배열
	  static int memberIdx = 0;//클래스 변수
	
	  
	
	public static void addMember() {//같은 클래스에서 접근하므로 public을 붙인다.
		    Member member = new Member();
		    
		    System.out.print("번호? ");
		    member.no = Integer.parseInt(keyboard.nextLine());
		    
		    System.out.print("이름? ");
		    member.name = keyboard.nextLine();
		    
		    System.out.print("이메일? ");
		    member.email = keyboard.nextLine();
		    
		    System.out.print("암호? ");
		    member.password = keyboard.nextLine();
		  
		    System.out.print("사진? ");
		    member.photo = keyboard.nextLine();
		  
		    System.out.print("전화? ");
		    member.tel = keyboard.nextLine();
		  
		    member.registeredDate = new Date(System.currentTimeMillis()); 
		    
		    members[memberIdx] = member;
		    memberIdx++;
		    
		    System.out.println("저장하였습니다.");
		  }
	  
	 public static void listMember() {
		    for (int j = 0; j < memberIdx; j++) {
		      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
		          members[j].no, members[j].name, members[j].email, 
		          members[j].tel, members[j].registeredDate);
		    }
		}
}
