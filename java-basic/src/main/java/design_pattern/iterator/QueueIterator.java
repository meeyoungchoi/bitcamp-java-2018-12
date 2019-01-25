package design_pattern.iterator;

public class QueueIterator<E> implements Iterator<E> {
	//이 클래스는 queue에서 값을 꺼내주는 일을 전문적으로 하는 객체이다.
	//이런 일을 하는 객체를 이터레이터라 부른다.
	//오로지 어레이리스트 에서만 꺼낸다.
	Queue<E> list;
	int index = 0;
	public QueueIterator(Queue<E> list) {
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		return index  < list.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		return (E) list.get(index++);
	}

}
