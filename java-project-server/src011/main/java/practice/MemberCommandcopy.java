//7단계 - 클라이언트에서 요청한 멤버 명령을 처리한다.
package practice;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.eomcs.lms.domain.Member;

public class MemberCommandcopy {

	static ArrayList<Member> members = new ArrayList<>();

	static ObjectInputStream in;
	static ObjectOutputStream out;

	public static void service(String request) throws Exception {

		switch (request) {//1:1로 매핑하는 것이므로 
		case "/member/add"://명령어를 받고
			add();
			break;
		case "/member/list":
			list();
			break;
		case "/member/update":
			update();
			break;
		case "/member/delete":
			delete();
			break;
		case "/member/detail":
			detail();
			break;
		default:
			out.writeUTF("FAIL");

		}
		out.flush();

	}

	static void add() throws Exception{
		out.writeUTF("ok");
		out.flush();
		//out.writeObject(member);
		members.add((Member)in.readObject());
		out.writeUTF("OK");



	}

	static void list(Member member) throws Exception {
		out.writeUTF("ok");
		out.flush();
		out.writeUTF("/member/list");//응답결과로 어레이리스트를 보낸다.

		String status = in.readUTF();

		if (status.equals("ok"))
			System.out.println("데이터 성공");
		System.out.println("데이터 실패");

	}

	static void detail(int no) throws Exception {
		out.writeUTF("ok");
		out.flush();
		out.writeUTF("/member/detail");
		out.writeInt(no);
		out.flush();

		String status = in.readUTF();

		if (status.equals("ok")) {
			System.out.println("데이터 가져오기 실패");
		}

		Member member = (Member) in.readObject();
		System.out.println(member);


	}

	static void update(Member member) throws Exception {
		out.writeUTF("ok");
		out.flush();
		out.writeUTF("/member/update");
		out.writeObject(member);
		out.flush();

		String status = in.readUTF();

		if (status.equals("ok")) 
			System.out.println("데이터 변경 성공");
		else 
			System.out.println("데이터 변경 실패");


		System.out.println(in.readUTF());
	}

	static void delete(int no) throws Exception {
		out.writeUTF("quit");
		out.writeInt(no);
		out.flush();

		String status = in.readUTF();

		if (status.equals("ok")) 
			System.out.println("데이터 삭제 성공");
		else 
			System.out.println("데이터 삭제 실패");



		System.out.println(in.readUTF());
	}

	static void detail() throws Exception {
		int no = in.readInt();

		for (Member m : members) {
			if (m.getNo() == no) {
				out.writeUTF("OK");
				out.writeObject(m);
				out.flush();
				return;
			}
		}

		out.writeUTF("FAIL");
	}

	static void update() throws Exception {
		Member member = (Member) in.readObject();

		int index = 0;
		for (Member m : members) {
			if (m.getNo() == member.getNo()) {
				members.set(index, member);
				out.writeUTF("OK");
				return;
			}
		}

		out.writeUTF("FAIL");
	}

	static void delete() throws Exception {
		int no = in.readInt();

		int index = 0;
		for (Member m : members) {
			if (m.getNo() == no) {
				members.remove(index);
				out.writeUTF("OK");
				return;
			}
		}

		out.writeUTF("FAIL");
	}

	static  void list() throws Exception {
		out.writeUTF("ok");
		out.writeObject(members);
	}
}
