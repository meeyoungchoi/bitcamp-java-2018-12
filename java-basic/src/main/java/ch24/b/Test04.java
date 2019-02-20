//스레드 그룹의 부모 스레드 그룹
package ch24.b;

public class Test04 {

	public static void main(String[] args) {
		//스레드 그룹에 소속된 하위 스레드 구룹 목록을 알아내기
		//
		Thread currThread = Thread.currentThread();//main
		ThreadGroup group = currThread.getThreadGroup();//main
		System.out.println("main 스레드 그룹에 소속된  하위 스레드 그룹들:");
		
		System.out.println(group.getName() + "(TG)");
		
		//enumerate(스레드를 담을 배열, 하위 스레드 그룹에 소속된 것도 포함할 것인지 여부)
		Thread[] groupList = new Thread[10];
		int size = 0;
		size = group.enumerate(groupList, false);
		

		for (int i = 0; i < size; i++) {
			System.out.println(" => "+ groupList[i].getName() + "(TG)");
		}
	}
	
	//jvm의 스레드 계층도:
	//main(T)
	// => main(T)
	

}
