package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

public class MemberDetailCommand implements Command {
  
  Scanner keyboard;
  List<Member> list;
  
  public MemberDetailCommand(Scanner keyboard/*, List<Member> list*/) {
    this.keyboard = keyboard;
   // this.list = list;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

   /* int index = indexOfMember(no);
    if (index == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }

    Member member = list.get(index);
*/
    
    try {
    	out.writeUTF("/member/detail");
	    out.flush();
	    if (!in.readUTF().equals("OK"))
	      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
	    
	    out.writeInt(no);
	    out.flush();
	    
	    String status = in.readUTF();
	    
	    if (!status.equals("OK")) 
	    	throw new Exception ("서버에서 멤버목록 가져오기 실패");
	    
	    
	    Member member = (Member) in.readObject();
	    System.out.println(member);
    
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
  } catch (Exception e) {
	  System.out.printf("멤버 상세정보 출력오류 : %s\n",e.getMessage());
	  }
  }

  private int indexOfMember(int no) {
    for (int i = 0; i < list.size(); i++) {
      Member m = list.get(i);
      if (m.getNo() == no)
        return i;
    }
    return -1;
  }
}
