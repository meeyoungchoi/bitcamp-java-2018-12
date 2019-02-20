package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  List<Member> list;
  
  public MemberDeleteCommand(Scanner keyboard/*, List<Member> list*/) {
    this.keyboard = keyboard;
   // this.list = list;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    /*int index = indexOfMember(no);
    if (index == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);*/
    
    try {
        out.writeUTF("/member/delete");
        out.flush();
        if (!in.readUTF().equals("OK"))
          throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
        
        out.writeInt(no);
        out.flush();
        
        String status = in.readUTF();
        
        if (!status.equals("OK")) 
          throw new Exception("서버에서 게시글을 삭제하는데 실패!");
        
        System.out.println("회원글을 삭제했습니다.");
        
      } catch(Exception e) {
    	System.out.printf("게시글 삭제 오류!:%s\n",e.getMessage());
    }
    
  
  }
  
 /* private int indexOfMember(int no) {
    for (int i = 0; i < list.size(); i++) {
      Member m = list.get(i);
      if (m.getNo() == no)
        return i;
    }
    return -1;
  }*/
}
