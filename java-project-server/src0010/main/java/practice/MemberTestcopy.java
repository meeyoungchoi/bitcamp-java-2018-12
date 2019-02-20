//7단계 - 서버 실행 테스트
package practice;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.eomcs.lms.domain.Member;

public class MemberTestcopy {

	ObjectOutputStream out;
	ObjectInputStream in;

	public MemberTestcopy(ObjectOutputStream out, ObjectInputStream in) {
		this.out = out;
		this.in = in;
	}
	
	public void test(MemberTestcopy obj) throws Exception {
		add(new Member(1, "홍길동"));
		add(new Member(2, "임꺽정"));

		detail(1);

		update(new Member(1, "홍길동x"));

		detail(1);

		delete(2);

		list();
	}
	private static void delete(int i) {
		// TODO Auto-generated method stub

	}

	private void update(Member member) {
		out.writeUTF("/member/add");
		out.writeObject(member);
		out.flush();
		if (in.readUTF().equals("ok"))
			return;

	}

	private static void detail(int i) {
		// TODO Auto-generated method stub

	}

	private void add(Member member) throws Exception {
		out.writeUTF("/member/add");
		out.writeObject(member);
		out.flush();
		if (in.readUTF().equals("ok"))
			return;
		System.out.println(in.readUTF());

		String status = in.readUTF();

		if (status.equals("OK"))
			System.out.println("데이터 추가 성공!");
		else
			System.out.println("데이터 추가 실패!");
	}

	private void list() throws Exception {
		out.writeUTF("/member/list");
		out.flush();

		if (in.readUTF().equals("ok"))
			return;
		
		String status = in.readUTF();

		if (!status.equals("ok")) {
			System.out.println("데이터 목록 가져오기 실패!");
			return;
		}
		@SuppressWarnings("unchecked")
		//서버에 저장된 객체 목록을 받아서 출력
		List<Member> members  = (List<Member>) in.readObject();//얘가 리턴한다 리스트를
		for (Member m : members) {
			System.out.println(m);
		}
	}

	private void quit() throws Exception {
		out.writeUTF("종료함");
		out.flush();
		System.out.println(in.readUTF());
	}
}

