package com.eomcs.lms.util;

import java.lang.reflect.Array;

import org.w3c.dom.Node;

public class LinkedList<E>  {

	private Node<E> first ;//head
	private Node<E> last;//tail
	private int size;
	
	public E[] toArray(E[] a) {
		E[] arr = (E[]) Array.newInstance(a.getClass().getComponentType(), size);	//?	
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			arr[i] = node.value;
			node = node.next;
		}
		return arr;
	}

	public void add(E obj) {
		Node<E> prev	 = last;//?
		last = new Node<>(prev, obj, null);//?
		if (prev == null)
			first	= last;
		else
			prev.next = last;//새로운 노드가 만들어진다?
	
		size++;//노드의 수를 증가시킨다?
	}


	public E get(int index) {
		if (index <0 || index >= size)
		return null;
		
		Node<E> node = first;
		
		for (int i = 1; i <= index; i++) {
			node = node.next;//?
		}
		
		return node.value;
	}

	public Object set(int index, E obj) {
		if (index <0 || index >= size)
			return null;
		
		Node<E> node = first;
		
		for (int i = 1; i <= index; i++) {
			node = node.next;
		}
		
		E oldValue = node.value;
		node.value = obj;//?
			
		return oldValue;
	}

	public E remove(int index) {
		if (index < 0 || index >= size)
			return null;
		
		Node<E> node = first;
		
		for (int i = 1; i <= index; i++) {
			node = node.next;
		}
		if (first == last) {//?
			first = last = null;
		} else if (node == first) {//?
			first = node.next;
		} else if (node == last) {//?
			last = node.prev;
		} else {
			node.prev.next = node.next;//?
		}
		E oldValue = node.value;
		
		node.value = null;
		node.next = null;
		node.prev = null;
		
		size--;
		
		return oldValue;
	}

	public int size() {
		
		return size;
	}
	
	private static class Node<E> {
		E value;
		Node<E> prev;
		Node<E> next;
		
		Node(Node<E> prev, E value, Node<E> next) {//?
			this.prev = prev;//이전노드가 없으므로 null?
			this.value = value;//현재 노드에 value(값)을 넣어준다?
			this.next = next;//현재 노드의 next가 다음 node를 가리킨다?
			
		}
	}
}	
	/*public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("eee");
		list.add("fff");
		
		print(list);
		
		System.out.println(list.set(0, "xxx"));
		System.out.println(list.set(2, "xxx"));
		System.out.println(list.set(3, "xxx"));
		
		print(list);
	}

	private static void print(LinkedList l1) {
		System.out.println("===========================");
		for (int i = 0; i <l1.size(); i++) {
			System.out.println(l1.get(i));
		}
		System.out.println("=============================");
	}*/

