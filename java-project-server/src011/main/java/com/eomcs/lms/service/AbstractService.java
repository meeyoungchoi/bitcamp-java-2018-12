//11단계 - 데이터를 파일로 관리한다.
package com.eomcs.lms.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.domain.Board;

public abstract class AbstractService<E> {//서브클래스의 공통점을 뽑아서 공통점을 물려주기 위한 용도로 만들었다.
	//generalization
	//둘 사이를 서브클래스 수퍼클래스 관계로 바꾼다.
	//추상메서드: 서브클래스에게 구현을 강요한다.

	List<E> list;//제네릭: 타입을 변수화시킨다.

	ObjectInputStream in;
	ObjectOutputStream out;
	String filepath;

	/*public BoardService(ObjectInputStream in, ObjectOutputStream out) {
	    this.in = in;
	    this.out = out;
	  }*/

	public void init(ObjectInputStream in, ObjectOutputStream out) {
		this.in = in;
		this.out = out;
	}

	@SuppressWarnings("unchecked")
	public void loadData(String filepath) {
		this.filepath = filepath;

		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(this.filepath)))) {

			list = (List<E>) in.readObject();

		} catch (Exception e) {
			list = new ArrayList<E>();
			throw new RuntimeException("데이터  파일 로딩 오류!", e);
		}
	}

	public void saveData() throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(this.filepath)))) {

			out.writeObject(list);

		} catch (Exception e) {
			throw new Exception("데이터 파일 저장 오류!", e);
		}
	}

	public abstract  void execute(String request) throws Exception ;

		
		/*switch (request) {
		case "/board/add":
			add();
			break;
		case "/board/list":
			list();
			break;
		case "/board/detail":
			detail();
			break;
		case "/board/update":
			update();
			break;
		case "/board/delete":
			delete();
			break;  
		default:
			out.writeUTF("FAIL");
		}
		out.flush();*/
	

	

}


