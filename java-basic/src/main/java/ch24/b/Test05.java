//스레드 그룹에 소속된 스레드들
package ch24.b;

public class Test05 {

	public static void main(String[] args) {
		//스레드 그룹에 소속된 스레드 목록 알아내기
		//
		Thread currThread = Thread.currentThread();
		ThreadGroup group = currThread.getThreadGroup();
		
		
		//"main" 스레드 그룹의 부모
		ThreadGroup parentGroup = group.getParent();
		System.out.println(parentGroup.getName() + "(TG)");
		
		//SYSTEM 스레드 그룹의 부모 스레드 그룹
		ThreadGroup parentParentGroup = parentGroup.getParent();
		System.out.println(parentParentGroup);//null. system의 상위 스레드 그룹은 없다.
	}
	
	//jvm의 스레드 계층도:
	//system(TG)
	// =>main(TG)
	//   =>main(T)
	
	

}
