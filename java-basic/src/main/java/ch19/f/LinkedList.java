//특정 클래스에 의해서만 사용되는 클래스가 있다면 그 클래스 안에 정의하라
package ch19.f;

//Array 클래스는 LInkedLIst크
//그래서 패키지 멤버 클래스에서 
//
//
public class LinkedList {
	
	public static final int FORWARD = 1;
	public static final int REVERSE = 2;

	
	protected Node head;
	protected Node tail;
	protected int size;
	

	public LinkedList() {
		head = new Node();
		tail = head;
		size = 0;
	}
	//LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에
	//ArrayList 처럼 한 번에 메모리를 준비할 필요가 없다.
	//그러나 값 이외에 다음 노드와 이전 노드의 주소를  담기 위해 추가로 메모리를 사용한다.
	public void add(Object value) {
		tail.value = value;
		
		//새 노드를 준비한다.
		Node node = new Node();
		
		//마지막 노드의 다음으로 새 노드를 가리키게 한다.
		tail.next = node;
		
		// 새 노드의 이전으로 마지막 노드를 가리키제 한다.
		node.prev = tail;
		
		//tail이 새로 추가된 노드를 가리키게 한다.
		tail = node;
		
		//항목 개수를 증가시킨다.
		size++;
		
		
	}
	
	public int size() {
		
		return size;
		
	}
	
	//ArrayList와 달리 해당 인덱스를 찾아 가려면 링크를 따라가야 하기 때문에
	//조회 속도가 느리다.
	public Object get(int index) {
		if (index < 0 || index >= size)
			return null;
		
		Node cursor = head;
		
		//해당 인덱스로 이동한다.
		for (int i = 1; i <= index; i++ ) {
			cursor = cursor.next; //cursor로 찾아가서서 커서의 넥스트 항목의 주소를 커서 레처펀스 변수에 저장하라
		}
		//cursor가 가리키는 노드의 주소를 리턴?
		//=>노드의 값을 리턴
		return cursor.value;
	}
	
	public Object[] toArray(int direction) {
	
		//Array클래스는 LINKED
		//
		//
		// 이제Array 클래스는 남이 아니다.
		//그래서 LinkedLIst의 멤버를 사용할 수 있다.
		//Array 클래스가 non-static 멤버를 사용할 수있다.
		Array helper = new Array();//LinkedList 객체 주소를 넘겨줄 필요가 없다.
		
		if (direction == FORWARD) {
			//그래야만 Array 객체는 생성자에서 넘겨 받은 Linkedlist의 데이터를 꺼낸다
			return helper.copy();
		} else {
			return helper.reverseCopy();
		}
	}
	
	public Object set(int index, Object value) {
		if (index < 0 || index >= size )
			return null;
		
		Node cursor = head;
		
		//교체할 값이 들어있는 노드로 이동한다.
		for (int i =1; i <= index; i++ ) {
			cursor = cursor.next;//
		}
		
		//변경 전에 이전 값을 보관한다.
		Object old = cursor.value;
		
		//
		cursor.value = value;
		
		//이전 값을 리턴한다. 쓰든 안쓰든 호출하는 사람이 알아서 할 일이다.
		//다만 변경 전 값을 활용할 경우
		return old;
	}
	
	//값을 삽입하는 경우에는 ArrayList방식보다 효율적이다.
	//삽입 위치에 있는 노드를 찾은 후에 새 노드를 앞,뒤 노드에 연결하면 된다.
	public int insert(int index, Object value) {
		if (index < 0 || index >= size) 
			return -1;
		
		//새 노드를 만들어 값을 담는다.
		Node node = new Node(value);
		
		//삽입할 위치에 있느 원래 노드를 찾는다.
		Node cursor = head;
		
		for (int i =1; i <= index; i++) {
			cursor = cursor.next;
		}
		
		//새 노드가 찾은 노드를 가리키게 한다.
		node.next = cursor;
		
		//찾은 노드의 이전 노드 주소를 새 노드의 이전 노드 주소로 설정한다.
		node.prev = cursor.prev;
		
		//찾은 노드의 이전 노드로 새 노드를 가리키게 한다.
		cursor.prev = node;
		

		//Node p = node.prev;
		//p.next = node;
		//800.prev.next =
		//200.next = 800
		
		if (node.prev != null) {
			//이전 노드의 다음 노드로 새 노드를 가리키게 한다.
			node.prev.next = node;
		} else {
			//맨 앞에 노드를 추가할 때는 head를 변경해야 한다.
			head = node;
		}
		
		
		size++;
		
		return 0;
	}
	
	public Object remove(int index) {
		if (index < 0 || index >= size) 
			return null;
		
		//index 위치에 있는 노드를 찾는다.
		Node cursor = head;
		for (int i = 1; i <= index; i++ ) {
			//cursor = 300;
			cursor = cursor.next;
			
		}
		
		if (cursor.prev != null) {
				cursor.prev.next = cursor.next;
		} else {
			//
			head = cursor.next;
		}
		
	

		
		//찾은 노드의 다음 노드가 이전 노드를 가리키게 한다.
		cursor.next.prev = cursor.prev;
		
		//가비지 컬렉터를 효과적으로 계산할수 있도록 
		//가비지가 된 객체는 다른 객체를 가리키지 않도록 한다.
		Object old = cursor.value;
		cursor.value = null;
		cursor.prev = null;
		cursor.next = null;
		
		//크리글 
		size--;
		
		//호출한 쪽에서 필요하면 사용하고 
		return old;
	}
	//중첩클래스는 크게 static이냐    non
	//특정 인스턴스를 사용하지 않느느다면  static nested class 로 선언하라
	//그러나 바깥 클래스의 특정 인스턴스를 사용한다면 그 인스턴스에 종속 되기 때문에
	//   non-static nested class 로 선언하라
	//다음  Array 클래스는 linkedlist의 특정 인스턴스의 값을 사용해야 하기 떄문에
	//non-static 클래스로 선언한다.
	//내부에서만 사용할 클래스라면 비공개로 처리하라
	public class Array {
		//이제  Array  클래스는 
		//즉 인스턴스 필드나 메서드 처럼 특정 인스턴스에 대해 주소를 받는다는 것이다.
		//따라서 바깥 클래스의 인스턴스를 마음대로 사용할 수 있다. 그냥 인스턴스 메서드라 생각하라
		//LinkedList list; <==이 코드 필요없다.
		/*
		 * 같은 인스턴스 멤버기 떄문에 생성자에서 인스턴스 주소를 받을 필요가 없다.
		public Array(LinkedList list) {
			this.list = list;
		}
		*/
		//입력된 순서대로 배열을 만든다.
		public Object[] copy() {
			//바깥 클래스의 인스턴스 주소는 다음과 같이 사용해야 한다.
			//바깥 클래스명.this.인스턴스멤버
			//만약 바깥 클래스의 인스턴스 멤버명이 내부 클래스의 멤버 이름과 충돌하지 않는다면 
			//바깥 클래스명. this를 생략해도 된다.
			//
			Object[] arr = new Object[LinkedList.this.size()];//list의 사이즈 만큼 빈 배열 준비
			for (int i = 0; i < size(); i++ ) {
				arr[i] = get(i);
			}
			
			return arr;
		}

		//입력된 순서의 역순으로 배열을 만든다.
		public Object[] reverseCopy() {
			// 다음과 같이 내부 멤버에 같은 이름이 없다면 바깥 클래스의 인스턴스 멤버를 사용할 떄
			//LinkedList.this를 생략해도 된다.
			//그냥 Linkedlist의 메서드라 생각하고 작성하라
			Object[] arr = new Object[size()];
			//값을 뒤집겠다.
			for (int i = size(), j = 0;  i >= 0; i--, j++) {
				arr[j] = get(i);
			}
			return arr;
		}
	}
}
