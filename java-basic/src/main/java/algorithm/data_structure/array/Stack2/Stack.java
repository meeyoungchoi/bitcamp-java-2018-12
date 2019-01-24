package algorithm.data_structure.array.Stack2;

public class Stack<E> {
	public static final int DEFAULT_SIZE = 5;
	
	Object[] list;
	int size;
	
	public Stack() {
		list = new Object[DEFAULT_SIZE];
	}
	public void push(E value) {
		//맨 마지막에 추가한다.
		//배열의 크기가 작다면 확장해야 한다.
		if (size == list.length) {
			Object[] arr = new Object[list.length + (list.length >>1)];
			for (int i = 0; i < list.length; i++) {
				arr[i] = list[i];
				}
			list = arr;
			}
		list[size++] = value;
	}
	
	@SuppressWarnings("unchecked")
	public Object E() {
		if (size == 0) 
			return null;
		
		return (E) list[--size];
	}

	public boolean empty() {
		return size == 0;
	}
	
	
	public int size() {
		return this.size;
	}
}
