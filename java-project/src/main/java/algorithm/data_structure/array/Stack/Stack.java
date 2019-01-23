package algorithm.data_structure.array.Stack;

public class Stack {
	public static final int DEFAULT_SIZE = 5;
	
	Object[] list;
	int size;
	
	public Stack() {
		list = new Object[DEFAULT_SIZE];
	}
	public void push(Object value) {
		//맨 마지막에 추가한다.
		//배열의 크기가 작다면 확장해야 한다.
		if (size == list.length) {
			Object[] arr = new Object[list.length + ]
	public Object[] toArray() {
		Object[] list = new Object[this.size];
		for (int i = 0; i < this.size; i++) {
			list[i] = this.list[i];
		}
		return list;
	}
			
	public Object pop(Object value) {
		//맨 마지막 값을 꺼내 리턴한다.
		//배열의 크기가 작다면 확장해야 한다.
		if (size == 0)
			return null;

		size-- 
		return list[size];
	}
	
	private void increase() {
		if (this.size == list.length) {
			int originSize = list.length;
			int newSize = originSize + (originSize >> 1);
			Object[] temp = new Object[newSize];
			for (int i = 0; i < this.list.length; i++) {
				temp[i] = this.list[i];
			}
			list = temp;
		} 		
	}
	public boolean empty() {
		
		return false;
		
		
	}
	
	
	public int size() {
		return this.size;
	}
}
