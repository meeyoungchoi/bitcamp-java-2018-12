package design_pattern.iterator;

public class LinkedListIterator<E> implements Iterator<E> {
	//이 클래스는 ArrayList에서 값을 꺼내주는 일을 전문적으로 하는 객체이다.
	//이런 일을 하는 객체를 이터레이터라 부른다.
	//오로지 어레이리스트 에서만 꺼낸다.
	LinkedList<E> list;
	int index = 0;
	public LinkedListIterator(LinkedList<E> list) {
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		return index  < list.size();
	}

	@Override
	public E next() {
		return list.get(index++);
	}

}
