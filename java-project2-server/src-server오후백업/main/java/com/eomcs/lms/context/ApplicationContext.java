package com.eomcs.lms.context;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;

import com.eomcs.lms.handler.Command;

//Command 객체를 자동 생성하는 역할을 수행한다.
public class ApplicationContext {

	//인스턴스를 생성할 클래스 정보를 담겠다.
	ArrayList<Class<?>> classes = new ArrayList<>();

	//생성한 인스턴스를 보관하는 저장소
	HashMap<String, Object> beans = new HashMap<>();
	
	public ApplicationContext(String packageName) throws Exception {

		//1.패키지명으로 디렉토리 경로를 알아낸다.
		//File packageDir = Resources.getResourceAsFile("com/eomcs/lms");
		//File packageDir = Resources.getResourceAsFile(packageName);
		File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/"));//패키지 이름에서 .을 /로 바꾼후 그 바꾼 이름을 준다.
		//System.out.println(packageDir.getCanonicalPath());

		//2. 해당 패키지 폴더와 그 하위 폴더를 뒤져서 클래스 이름을 알아낸다.
		//=>인스턴스를 생성할 수 없는 인터페이스나 추상클래스는 제외한다.
		//=>또한 중첩 클래스도 제외한다.
		//findClasses(packageDir, packageName.replace(".", "/"));
		findClasses(packageDir, packageName);//p패키지 디렉토리에서 packageName이름으로 된 하위폴더로 간다.
		//packageDir:처음부터 lms까지 / 된 거가 들어간다.
		//packageName: com.eomcs.lms가 들어간다.
		for (Class<?> clazz : classes) {//ArrayLIST에서 CLASS타입 하나를 가져와서 그 클래스의 이름을 출력한다.
			System.out.println(clazz.getName());
		}
	}

	//패키지 이름 받기
	private void findClasses(File dir, String packageName) throws Exception {//파일 디렉토리와 하위 파일이름이 파라미터 값으로 findclasses 메서드에 들어간다.
		//이 메서드가 호출되면 디렉토리를 뒤져서 파일(.class)이나 하위 디렉토리 목록을 알아낸다.
		File[] files = dir.listFiles(new FileFilter() {//파일리스트가 들어있는 디렉토리에서 파일필터를 사용해서 .class 파일이나 하위 디렉토리 목록을 알아낸다.

			//@Override
			public boolean accept(File pathname) {//만약에 파일명이 디렉토리에 있다면
				//승인하면 리턴 목록에 포함된다.
				if (pathname.isDirectory()) 
					return true;

				//뒤에 확장자가 클래스이고 중간에 $를 포함하지 않는것만 뽑겠다.
				if (pathname.getName().endsWith(".class") && /*자바 클래스 파일*///만약 파일 이름이 .class로 끝난다면
						!pathname.getName().contains("$")/*중첩 클래스가 아닌 경우*/)//혹인 파일이름에 $가 없다면
					return true;

				return false;
			}});

		for (File f : files) {

			if (f.isFile()) {//만약 파일이 클래스 파일이라면
				//클래스 파일일 경우,
				//파라미터로 받은 패키지 명과 파일 이름을 합쳐서 클래스 이름을 만든다.
				//예) com.eomcs.lms(패키지명) + . + serverApp(파일명) => 최종적으로 com.eomcs.lms.ServerApp 이 만들어진다.
				String filename = f.getName();//파일의 이름을 가져온다.
				String className = packageName +"." + //패키지 이름과 파일이름에 0 부터 파일 이름의 . 전까지를 합쳐서 className으로 한다.
						f.getName().substring(0, filename.indexOf('.'));//0부터 파일이름에 .이 있는걸 찾아라
				//Helper.class에서 Helper 만 원한다. (0부터 .전까지만  짤라서 리턴한다.) =>endIndex the ending index, exclusive.즉 끝인덱스 미만의 위치까지만 출력한다.
				//클래스 이름으로 클래스 파일(.class)을 로딩한다.
				Class<?> clazz = Class.forName(className);//클래스 이름으로 .class파일을 로딩해서 clazz변수에 넣는다.

				//클래스를 로딩한 후 인스턴스를 생성할 수 있는 일반 클래스 인지 확인하여 
				//클래스 관리 목록에 추가한다.
				//즉, => 클래스 정보를 분석하여 중첩 클래스이거나 인터페이스 , Enum이면 무시한다.
				//만약 클래스 명이 로컬클래스이거나 인터페이스 이거나 이넘이면
				//로컬클래스:메서드 내에 정의된 클래스
				if (clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum())
					continue;

				//=> 추상 클래스나 공개되지 않은 클래스(public이 아닌 클래스) 도 무시한다..
				//클래스의 접근지시자가 abstract이거나 public이 
				//만약 boardaddcommand클래스라면 그 해당 클래스에 접근지시자 abstract가 있는지
				if (Modifier.isAbstract(clazz.getModifiers()) || //접근지시자: public ,abstract,...
						!Modifier.isPublic(clazz.getModifiers()))
					continue;

				//즉 공개된(public) 일반 클래스인 경우가 아니라면 클래스 관리 목록에 추가한다.
				classes.add(clazz);//해당 클래스명을 어레이리스트에 넣는다.

			} else {
				//디렉토리일 경우, 그 하위 디렉토리에서 다시 클래스를 찾는다.
				//=>하위 디렉토리에서 클래스를 찾을 때 사용할 패키지명을 준비한다.
				//파라미터로 받은 패키지 이름에 하위 디렉토리 이름을 붙이면 전체 패키지명이 된다.
				//=>com.eomcs.lms(현재 패키지 이름) + . + dao(디렉토리 이름) = com.eomcs.lms.dao
				//이렇게 만들기 위해 밑에 문장을 만들었다.

				//3.3) Command 인터페이스를 구현한 클래스만 찾아서 인스턴스를 생성한다.
				prepareCommand();
				//findClasses(f, packageName + "." + f.getName());//packageName: 하위 디렉토리에서 클래스를 찾을때 사용되는 패키지이름
			}
		}
	}

	private void prepareCommand() throws Exception {
		for (Class<?> clazz : classes) {
			System.out.println(clazz.getName());
			//클래스가 구현한 인터페이스의 목록을 꺼낸다.
			//클래스 또는 조상 클래스가 구현한 인터페이스의 목록을 알아낸다.
			List<Class<?>> interfaces = getAllInterfaces(clazz);//클래스가 어떤 인터페이스를 구현했는지를 알아낸다.
			//해당 클래스가 어떤 인터페이스를 구현했는지 즉 구현한 인터페이스를 인터페이스라는 이름의 List<Class<?>>에 넣는다.

			for (Class<?> i : interfaces) {
				//System.out.println("======================================================================");
				//System.out.println(i);

				if (i == Command.class) {//commaand.class: command 인터페스의 구현체인 경우
					//인터페이스 중에서 command 인터페이스의 구현체인 경우에만 클래스 이름을 출력한다.
					System.out.println(clazz.getName());//클래스의 이름을 출력한다.
					break;

				}
			}
		}
	}

	private List<Class<?>> getAllInterfaces(Class<?> clazz){
		ArrayList<Class<?>> list = new ArrayList<>();

		while (clazz != Object.class) {//현재 클래스가 오브젝트가 아닌면
			Class<?>[] interfaces = clazz.getInterfaces();//현재 크래스 인터페이슬 ㄹ가져온다.
			for (Class<?> i : interfaces)
				list.add(i);
			clazz = clazz.getSuperclass();//인터페이스가 그 클래스의 부모를 가리키게 한다.
		}
		return list;
	} 
}


