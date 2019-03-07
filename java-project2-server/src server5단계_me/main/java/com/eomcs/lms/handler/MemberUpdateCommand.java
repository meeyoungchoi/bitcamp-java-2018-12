package com.eomcs.lms.handler;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand extends AbstractCommand {
  

  MemberDao memberDao;
  
  public MemberUpdateCommand( MemberDao memberDao) {
    
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute(Response response) throws Exception {
	 
	  Member member = new Member();
	  member.setNo(response.requestInt("번호?"));
      member.setName(response.requestString("이름(%s)?"));
      member.setPassword(response.requestString("암호(%s)?"));
      member.setPhoto(response.requestString("사진(%s)?"));
      member.setTel(response.requestString("전화(%s)?"));
      
  
      
      memberDao.update(member);
      response.println("변경했습니다.");
      
    
  }
}
