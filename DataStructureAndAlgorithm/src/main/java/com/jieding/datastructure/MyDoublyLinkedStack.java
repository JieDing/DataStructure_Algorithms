package com.jieding.datastructure;

import com.jieding.adt.StackADT;

public class MyDoublyLinkedStack<E> implements StackADT<E> {
	
	private Node headNode;
	private Node tailNode;
	private int size;
	
	public MyDoublyLinkedStack(){
		headNode = new Node(null,null,null);
		tailNode = new Node(headNode,null,null);
		headNode.next = tailNode;
		size = 0;
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		if(isEmpty()) return;
		for(Node n =headNode; n!=null;){
			Node next= n.next;
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
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return false;
		if(e == null){
			for(Node n = headNode.next; n.next !=null; n=n.next){
				if(n.element == null)
					return true;
			}
			return false;
		}else{
			for(Node n = headNode.next; n.next !=null; n= n.next){
				if(e.equals(n.element))
					return true;
			}
			return false;
		}
	}

	public E peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		return tailNode.prev.element;
	}
	/**
	 * Returns the 1-based position where an object is on this stack.
	 * if the stack is empty, return 0
	 * if the element is not existed, return -1
	 */
	public int search(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return 0;
		if(e == null){
			int i=1;
			for(Node n = headNode.next; n.next!=null; n= n.next,i++){
				if(n.element == null)
					return i;
			}
			return -1;
		}else{
			int i=1;
			for(Node n = headNode.next; n.next!=null; n=n.next,i++){
				if(e.equals(n.element))
					return i;
			}
			return -1;
		}
	}

	public E pop() {
		if(isEmpty()) return null;
		Node n = tailNode.prev;
		E element = n.element;	
		n.prev.next = tailNode;
		tailNode.prev = n.prev;
		
		n.prev = null;
		n.next = null;
		n.element = null;
		n = null;
		
		size--;
		
		return element;
	}

	public E push(E item) {
		// TODO Auto-generated method stub
		Node newNode = new Node(tailNode.prev,tailNode,item);
		tailNode.prev.next = newNode;
		tailNode.prev = newNode;
		size++;
		return item;
	}
	class Node{
		Node prev;
		Node next;
		E element;
		Node(Node prev, Node next, E element){
			this.prev = prev;
			this.next = next;
			this.element = element;
		}
	}

}
