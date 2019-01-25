package design_pattern.iterator;

public class StackIterator<E> implements Iterator<E> {
	//이 클래스는 Stack에서 값을 꺼내주는 일을 전문적으로 한다..
	//이런 일을 하는 객체를 이터레이터라 부른다.
	//
	Stack<E> stack;
	int index = 0;
	
	public StackIterator(Stack<E> stack) {
		this.stack = stack;
		//this.index = stack.size - 1;
	}
	
	@Override
	public boolean hasNext() {
		return index  < stack.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		int lastIndex = stack.size - 1;
		return (E) stack.list[lastIndex - (index++)];//뺴는 숫자가 커지므로 거꾸로 가게 된다.
																//더하면서 거꾸로 갈수 있다.
	}

}
