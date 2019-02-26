package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand implements Command {
  
  Scanner keyboard;
  List<Member> list;
  
  public MemberAddCommand(Scanner keyboard/*, List<Member> list*/) {
    this.keyboard = keyboard;
   // this.list = list;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
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
    
    //list.add(member);
    
    try {
        out.writeUTF("/board/add"); //서버에 보내기위해서 먼저 명령을 준다.
        out.flush();
        if (!in.readUTF().equals("OK"))
         // return;//에러여부를 판단할수 없으므로
        	throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");//여기서 예외를 던지면
        
        out.writeObject(member);
        out.flush();
        
        String status = in.readUTF();
        
        if (!status.equals("OK"))
        	throw new Exception("서버에서 저장 실패!");
          //System.out.println("게시글 저장 성공!");
        
          System.out.println("저장하였습니다.!");
        } catch (Exception e) {
        	System.out.printf("멤버 저장 오류! :%s\n",e.getMessage());//왜? 서버에서 해당 명령어를 처리하지 못했으므로
        	//서버에서 저장 실패새서 게시글 저장오류?
        }
    
    System.out.println("저장하였습니다.");
  }
}
