package com.jieding.datastructure;

import com.jieding.adt.QueueADT;

public class MyDoublyLinkedQueue<E> implements QueueADT<E> {
	
	private Node headNode;
	private Node tailNode;
	private int size;
	
	public MyDoublyLinkedQueue(){
		headNode = new Node(null,null,null);
		tailNode = new Node(headNode,null,null);
		headNode.next = tailNode;
		this.size = 0;
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		for(Node n=headNode; n!=null;){
			Node next = n.next;
			n.prev = null;
			n.next = null;
			n.element = null;
			n = next;
		}
		headNode = null;
		tailNode = null;
		size = 0;
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return false;
		if(e==null) throw new IllegalArgumentException("please enter non-null element");
		for(Node n=headNode.next; n.next!=null; n=n.next){
			if(e.equals(n.element))
				return true;
		}
		return false;
	}

	public E peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		return headNode.next.element;
	}
	/**
	 * return 1-based index of the specific element
	 * return 0 if the queue is empty
	 * return -1 if the element is not existed
	 */
	public int search(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return 0;
		int i=1;
		for(Node n=headNode.next; n.next!=null; n=n.next, i++){
			if(e.equals(n.element))
				return i;
		}
		return -1;
	}

	public boolean enqueue(E e) {
		// TODO Auto-generated method stub
		Node n = new Node(tailNode.prev, tailNode, e);
		tailNode.prev.next = n;
		tailNode.prev = n;
		size++;
		return true;
	}

	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		Node firstNode = headNode.next;
		E element = firstNode.element;
		firstNode.next.prev = headNode;
		headNode.next = firstNode.next;
		size--;
		return element;
	}
	class Node{
		Node prev;
		Node next;
		E element;
		Node (Node prev, Node next, E element){
			this.prev = prev;
			this.next = next;
			this.element = element;
		}
	}
}
