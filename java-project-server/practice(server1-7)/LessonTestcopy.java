//7단계 - 서버 실행 테스트
package practice;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.eomcs.lms.domain.Lesson;

public class LessonTestcopy {

	ObjectOutputStream out;
	ObjectInputStream in;

	public LessonTestcopy(ObjectOutputStream out, ObjectInputStream in) {
		this.out = out;
		this.in = in;
	}

	public void test(LessonTestcopy obj) throws Exception {
		add(new Lesson(1, "javaprogramming"));
		add(new Lesson(2, "노드 프로그래밍"));

		detail(1);

		update(new Lesson(1, "javaprogramming22222"));

		detail(1);

		delete(2);

		list();
	}
	private void delete() {
		

	}

	private static void update(Lesson lesson) {
		// TODO Auto-generated method stub

	}



	private void add(Lesson lesson) throws Exception {
		out.writeUTF("/lesson/add");
		out.flush();
		if (in.readUTF().equals("ok"))
			return;

		out.writeObject(lesson);
		out.flush();
		System.out.println(in.readUTF());

		String status = in.readUTF();

		if (status.equals("OK"))
			System.out.println("데이터 추가 성공!");
		else
			System.out.println("데이터 추가 실패!");
	}

	private void list() throws Exception {
		out.writeUTF("/lesson/list");
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
		List<Lesson> lessons  = (List<Lesson>) in.readObject();//얘가 리턴한다 리스트를
		for (Lesson l : lessons) {
			System.out.println(l);
		}
	}

	private void detail() throws Exception {
		out.writeUTF("/lesson/update");
		//out.writeObject(lesson);
		out.flush();
		if (in.readUTF().equals("ok"))
			return;

		String status = in.readUTF();

		if (status.equals("OK"))
			System.out.println("데이터 변경 성공!");
		else
			System.out.println("데이터 변경 실패!");
	}

	private void quit() throws Exception {
		out.writeUTF("종료함");
		out.flush();
		System.out.println(in.readUTF());
	}
}

