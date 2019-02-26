package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  

  MemberDao memberDao;
  
  public MemberUpdateCommand( MemberDao memberDao) {
    
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
	  try {
		  
		  Member member = new Member();
		  
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    member.setNo(Integer.parseInt(in.readLine()));

   
      
      if (memberDao.update(member) == 0) {
        System.out.println("해당 번호의 회원이 없습니다.");
        return;
      }
      
      Member temp = member.clone();
      
      out.printf("이름(%s)? ", member.getName());
      String input = in.readLine();
      if (input.length() > 0) 
        temp.setName(input);
      
      out.printf("이메일(%s)? ", member.getEmail());
      if ((input = in.readLine()).length() > 0)
        temp.setEmail(input);
      
      out.printf("암호(********)? ");
      if ((input = in.readLine()).length() > 0)
        temp.setPassword(input);
      
      out.printf("사진(%s)? ", member.getPhoto());
      if ((input = in.readLine()).length() > 0)
        temp.setPhoto(input);
      
      out.printf("전화(%s)? ", member.getTel());
      if ((input = in.readLine()).length() > 0)
        temp.setTel(input);
      
      memberDao.update(temp);
      System.out.println("변경했습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
