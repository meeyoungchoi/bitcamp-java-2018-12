package ch19.f;

public class Node {
	
	
	public Object value;
	public Node prev;
	public Node next;
	
	public Node() {//기본생성자
		
	}
	
	
	public Node(Object value) {
		this.value = value;
	}

	
	public Node(Object value, Node prev, Node next) {
		this(value);
		this.prev = prev;
		this.next = next;
	}

}
