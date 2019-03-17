package com.eomcs.lms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

// Command 객체를 자동 생성하는 역할을 수행한다.
public class ApplicationContext {

	private static final Class<?> returnType = null;

	private static final String factoryMethod = null;

	private static final String bean = null;

	// 인스턴스를 생성할 클래스 정보
	ArrayList<Class<?>> classes = new ArrayList<>();

	// 생성한 인스턴스를 보관하는 저장소
	HashMap<String,Object> beanContainer = new HashMap<>();

	private Object paramValue;

	private Method otherFactoryMethod;

	public ApplicationContext(Class<?> configClass) throws Exception{
		//IoC 컨테이너와 관련된 설정 정보를 갖고 있는 클래스 정보를 받아서 초기화를 수행한다.

		//1.설정 정보를 갖고 있는 클래스의 인스턴스를 생성한다.
		Constructor<?> c = configClass.getConstructor();
		Object config = c.newInstance();

		//2) Bean 애노테이션이 붙은 메서드를 모두 찾는다.
		ArrayList<Method> factoryMethods = new ArrayList<>();
		Method[] methods = configClass.getMethods();
		for (Method m : methods) {
			//Bean beanAnno = m.getAnnotation(Bean.class);
			if (m.getAnnotation(Bean.class) != null)
				factoryMethods.add(m);
		}
		// 3) 팩토리 메서드를 호출하여 그 리턴 값을 빈 컨테이너에 보관한다.
		/*for (Method m : factoryMethods) {
			callFactoryMethod(config, m, factoryMethods);
		}*/

		//3) 
		while (factoryMethods.size() > 0) {
			Method m = factoryMethods.get(0);//메서드 목렝서 메서드를 
			callFactoryMethod(config, m, factoryMethods, "");//호출한다,
			factoryMethods.remove(m); //호출에 성공하든 실패하든 메서드 목록에서 제거한다.
		}
	}

	public ApplicationContext(String packageName, Map<String,Object> beans) throws Exception {

		// 외부에서 생성한 인스턴스가 파라미터로 넘어온다면 먼저 저장소에 보관한다.
		if (beans != null && beans.size() > 0) {
			Set<String> names = beans.keySet();
			for (String name : names) {
				addBean(name, beans.get(name));
			}
			//facotryMethod를 호출하여 그 결과를 빈컨테이너에 보관한다.
		}

		// 1) 패키지명으로 디렉토리 경로를 알아낸다.
		File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/"));

		// 2) 해당 패키지 폴더와 그 하위 폴더를 뒤져서 클래스 이름을 알아낸다.
		// => 인스턴스를 생성할 수 없는 인터페이스나 추상 클래스는 제외한다.
		// => 또한 중첩 클래스도 제외한다.
		findClasses(packageDir, packageName);

		// 3) Component 애노테이션이 붙은 클래스만 찾아서 인스턴스를 생성한다.



		//4) 인스턴스 생성을 완료한 후 작업을 수행한다.
		postProcess();
		// 저장소에 보관된 객체의 이름과 클래스명을 출력한다.
		System.out.println("-------------------------------");
		Set<String> names = beanContainer.keySet();
		for (String name : names) {
			System.out.printf("%s : %s\n", 
					name, beanContainer.get(name).getClass().getSimpleName());
		}
	}

	// 인스턴스를 추가할 때 호출한다.
	// 빈(bean) == 인스턴스 == 객체 
	//
	private void addBean(String name, Object bean) {
		if (name == null || name.length() == 0 || bean == null)
			return;
		beanContainer.put(name, bean);
	}

	//저장소에 보관된 인스턴스를 꺼낸다.
	public Object getBean(String name) {
		return beanContainer.get(name);//board/listcommad을가ㅕㅈ온다.
	}

	private void findClasses(File dir, String packageName) throws Exception {
		// 디렉토리를 뒤져서 클래스 파일(.class)이나 하위 디렉토리 목록을 알아낸다.
		File[] files = dir.listFiles((File pathname) -> {
			if (pathname.isDirectory())
				return true;

			if (pathname.getName().endsWith(".class")/* 자바 클래스 파일 */ &&
					!pathname.getName().contains("$")/* 중첩 클래스가 아닌 경우 */)
				return true;

			return false;
		});

		for (File f : files) {
			if (f.isFile()) {
				// 클래스 파일일 경우,
				// => 파라미터로 받은 패키지 명과 파일 이름을 합쳐서 클래스 이름을 만든다.
				//    예) com.eomcs.lms(패키지명) + . + ServerApp(파일명) = com.eomcs.lms.ServerApp
				String filename = f.getName();
				String className = packageName + "." + 
						filename.substring(0, filename.indexOf('.'));

				// => 클래스 이름으로 클래스 파일(.class)을 로딩한다.
				Class<?> clazz = Class.forName(className);

				// => 클래스 정보를 분석하여 중첩 클래스이거나 인터페이스, Enum 이면 무시한다.
				if (clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum())
					continue;

				// => 추상 클래스나 공개되지 않은 클래스(public이 아닌 클래스)도 무시한다.
				if (Modifier.isAbstract(clazz.getModifiers()) ||
						!Modifier.isPublic(clazz.getModifiers()))
					continue;

				// 즉 공개된(public) 일반 클래스인 경우 클래스 관리 목록에 추가한다. 
				classes.add(clazz);

			} else {
				// 디렉토리일 경우, 그 하위 디렉토리에서 다시 클래스를 찾는다.
				// => 하위 디렉토리에서 클래스를 찾을 때 사용할 패키지명을 준비한다.
				// => 파라미터로 받은 패키지 이름에 하위 디렉토리 이름을 붙이면 전체 패키지명이 된다.
				// => com.eomcs.lms(현재 패키지 이름) + . + dao(디렉토리 이름) = com.eomcs.lms.dao
				findClasses(f, packageName + "." + f.getName());
			}
		}
	}

	private void prepareComponent() throws Exception {
		for (Class<?> clazz : classes) {
			// 클래스에서 Component 애노테이션 정보를 추출한다.
			Component compAnno = clazz.getAnnotation(Component.class);

			if (compAnno == null) 
				continue;

			// Component 애노테이션이 붙은 클래스에 대해 인스턴스를 생성한다.
			Object obj = createInstance(clazz);

			if (obj != null) { // 제대로 생성했으면 빈컨테이너에 저장한다.
				// 빈컨테이너에 Command 객체를 저장할 때 key 값은 Componenet 애노테이션의 value() 값으로 한다.
				//만약 value 가 빈 문자열이라면 클래스 이름을 사용한다.
				//=>클래스에서 geName()메서드를 알아낸다.

				addBean(
						compAnno.value().length() > 0 ? compAnno.value() : clazz.getName(), //getName()을 호출하여 리턴 값을 키로 사용한다.
								obj);
			}

		}
	}


	private Object createInstance(Class<?> clazz) throws Exception {
		// 파라미터로 주어진 클래스 정보를 가지고 인스턴스를 생성한다.
		// => 기본 생성자를 알아낸다.
		try { 
			Constructor<?> defaultConstructor = clazz.getConstructor();
			return defaultConstructor.newInstance();
		} catch (Exception e) {
			// 기본 생성자를 못 찾으면 예외 발생한다. 
			// 그냥 무시하고 다른 생성자를 찾아 인스턴스를 생성한다.
		}

		// => 기본 생성자가 없다면, 다른 생성자 목록을 얻는다.
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> c : constructors) {
			// => 생성자를 호출하려면 먼저 어떤 타입의 파라미터가 필요한지 알아야 한다.
			Class<?>[] paramTypes = c.getParameterTypes();

			// => 생성자가 요구하는 타입의 파라미터 값이 저장소에 있는지 찾아 본다.
			Object[] paramValues = getParameterValues(paramTypes);
			if (paramValues != null) { // 생성자가 요구하는 모든 파라미터 값을 찾았다면 
				// 생성자를 통해 인스턴스를 생성하여 리턴한다.
				return c.newInstance(paramValues);
			}
		}
		return null;
	}

	private Object[] getParameterValues(Class<?>[] paramTypes) {
		// 파라미터 타입에 해당하는 객체를 빈컨테이너에서 찾아 배열을 만들어 리턴한다.
		ArrayList<Object> values = new ArrayList<>();

		for (Class<?> type : paramTypes) {
			Object value = findBean(type);
			if (value != null) {
				values.add(value);
			}
		}

		if (values.size() == paramTypes.length) 
			// 파라미터의 타입 목록에 지정된 객체를 모두 찾았으면 배열로 리턴한다.  
			return values.toArray();
		else // 못 찾았으면 null을 리턴한다.
			return null;
	}

	private Object findBean(Class<?> type) {
		// 빈 컨테이너에서 특정 타입의 인스턴스를 찾기
		// => 먼저 빈 컨테이너에서 인스턴스 목록을 꺼낸다.
		Collection<Object> beans = beanContainer.values();
		for (Object bean : beans) {
			if (type.isInstance(bean))
				return bean;
		}
		return null;
	}

	//bean 생성을 완료한 후 작업 수행
	public void postProcess(){
		//RequestMappingHandler
		RequestMappingHandlerMapping handlerMapping = 
				new RequestMappingHandlerMapping();

		//빈 컨테이너에서 객체를 모두 꺼낸다.
		Collection<Object> beans = beanContainer.values();

		for (Object bean : beans) {
			//각 객체에 대해 @RequestMapping 메서드를 찾는다.
			Method[] methods = bean.getClass().getMethods();
			for (Method m : methods) {
				//System.out.println(m.getName());
				RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
				if (requestMapping == null) 
					continue;

				//RequestMapping이 붙은 메서드를 찾았으면 그 정보를 RequestMapp
				RequestMappingHandler handler = new RequestMappingHandler(bean,m);

				//그리고 이 요청을 처러하는 요청 핸든러(RequestMapping 애너테이션이 붙은 메서드)를 handlerMapping에 저장한다.
				handlerMapping.add(requestMapping.value(), handler);
				//System.out.println("==>" + requestMapping.value());
			}
		}

		//ServerApp에서 꺼낼 수 있도록 ReuqestMappingHandlerMapping객체를
		//빈 컨테이너에 저장해 둔다.
		beanContainer.put("handlerMapping", handlerMapping);
	}

	private Object callFactoryMethod(
			Object obj, 
			Method factoryMethod, 
			List<Method> factoryMethods,
			String indent) throws Exception {

		System.out.println(indent +"==>" + factoryMethod.getName());
		
		//1) m 메서드에서 파라미터를 호출할 때 사용할 파리미터 정보를 알아낸다.
		//예) m(BoardDao, MemberDao, TransactionManager)
		//파라미터 타입 배열 : {BoardDao.class, MemberDao.class, TransactionManager.class} 
		Class<?>[] paramTypes = factoryMethod.getParameterTypes(); 

		//파라미터 값을 담을 목록을 준비한다,
		//예) {new BoardDao(), new MemberDao(), new TransactionManager()}
		Object[] paramValues = new Object[paramTypes.length];

		for (int i = 0; i < paramTypes.length; i++) {
			//2) 빈 컨테이너에서 파리머터에 해당하는 값을 꺼낸다.
			/*Collection<Object> beans = beanContainer.values();
			for (Object bean : beans) {
				if (params)
			}*/
			Object paramValue = findBean(paramTypes[i]);//빈을 찾았다면
			if (bean != null) {
				paramValues[i] = paramValue;//추가한다.
				continue;
			}
			
			//3) 만약 빈 컨테이너에 파라미터에 해당하는 값이 없다면,
			//팩토리 메서드를 뒤져서 그 타입의 값을 리턴하는 메서드를 찾아 호출한다.
			//콜팩토리메서드가 뒤진다,
			Method otherFactoryMethod = findMethodByReturnType(
				factoryMethods, paramTypes[i]);
			if (factoryMethod == null) 
				//서버 소켓을 못찾았으면 더이상 파라미터 값이 필요없다.
				//그냥 호출 실패다
				//만약 파라미터 타입의 값을 만들어 줄 팩토리 메서드를 찾지 못했다면
				//4) 만약 해당 파라미터 타입의 값을 만들어주는 다른 팩토리 메서드가 없다면 팩터리 메서드 호출을 포기하낟,
				//이 메서드를 호출할 수 없다, 즉 호출을 포기한다.
				//현재 팩토리 메서드를 호출하지 못하낟.
				return null;
		}

		//v파라미터 값을 만들어줄 다른 팩토리 메서드를 찾았다면 그 메서드를 호출한다.
		//=>이때 재귀 호출을 사용한다.
		paramValue = callFactoryMethod(obj, otherFactoryMethod, factoryMethods, indent + "    ");
		if (paramValue == null) {
			//파라미터 값을 리턴해주는 팩토리 메서드를 찾긴 했지만 그 메서드 호출에 실패햏다면
			//그 파라미터 값을 준비하지 못했기 때문에 이때도 m메서드 호출을 포기한다.
			//그 파라미터 값이 없어서 메서드 호출에 실패했다면
			
			return null;
		}
		//m 메서드 호출을 포기하낟.
		//5) m 메서드 호출에 힐요한 모든 파라미터 값이 준비되었다면 메서드를 호출한다,
		if (paramTypes.length != paramValues.length) 
			return false;
		
		//팩토리 메서드 호출에 성공해따면 다음 다시 호출할 필요가 없기 때문에 메서드 목록에서 재거한다,
		factoryMethods.remove(factoryMethod);

		//즌비한 파라미터 값들을 가지고 팩터리 메서드를 호출한다,
		//m.invoke(obj, paramValues.toArray());
		//그리고 팩터리 메서드가 생성한 객체를 리턴하고 빈 컨테이너에 보관한다.
		Object bean = factoryMethod.invoke(obj, paramValues);

		
		//팩토리 메서드가 생성한 객체를 저장할 때 
		//애노테이션에 빈의 이름이 지정되어 있다면 그 이름을 사용하고
		//없다면 메서드 이름을 사용한다.
		Bean beanAnno = factoryMethod.getAnnotation(Bean.class);
		beanContainer.put(
				beanAnno.value().length() > 0 ? beanAnno.value() : factoryMethod.getName(),
						bean);
		System.out.println(indent + "    =>" +
						bean.getClass().getSimpleName() + " 객체가 보관됨!") ;

		
		//마지막 팩토리 메서드가 만든 객체를 리턴한다.
		return bean;
	}


	private Method findMethodByReturnType(
			List<Method> methods, Class<?> retunType) {
		for (Method m : methods) {
			if (m.getReturnType() == returnType) {
				return m;
			}
		}
		return null;
	}
}











