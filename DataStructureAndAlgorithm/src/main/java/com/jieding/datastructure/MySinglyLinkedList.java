package com.jieding.datastructure;

import com.jieding.adt.ListADT;

public class MySinglyLinkedList<E> implements ListADT<E> {
	
	private Node headNode;
	private Node tailNode;
	private int size;
	
	public MySinglyLinkedList(){
		headNode = new Node(null,null);
		tailNode = new Node(null,null);
		headNode.next = tailNode;
		size = 0;
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		for(Node node = headNode; node.next!=null;){
			Node nextNode = node.next;
			node.next = null;
			node.element = null;
			node = nextNode;
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
		return size==0;
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return false;
		if(e ==null){
			for(Node n = headNode.next; n.next!=null; n = n.next){
				if(n.element == null)
					return true;
			}
			return false;
		}else{
			for(Node n = headNode.next; n.next!=null; n = n.next){
				if(e.equals(n.element))
					return true;
			}
			return false;
		}
	}
	/**
	 * return the element of the 1-based index
	 * index range is from 1 to list's size
	 */
	public E get(int index) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		checkListBounds(index);
		return fastGetNodeByIndex(index).element;
	}
	private Node fastGetNodeByIndex(int index){
		
		Node n=headNode;
		for(int i=0; i<index;i++){
			n = n.next;
		}
		return n;
	}
	private void checkListBounds(int index) {
		// TODO Auto-generated method stub
		if(index<1 || index>size())
			throw new IndexOutOfBoundsException();
	}
	/**
	 * return the 1-based position of the specific node
	 * return -1 if the node is not existed
	 */
	public int indexOf(E e) {
		if(isEmpty()) return -1;
		if(e ==null){
			int i=1;
			for(Node n = headNode.next; n.next!=null; n = n.next, i++){
				if(n.element == null)
					return i;
			}
			return -1;
		}else{
			int i=1;
			for(Node n = headNode.next; n.next!=null; n = n.next, i++){
				if(e.equals(n.element))
					return i;
			}
			return -1;
		}
	}

	public boolean add(E e) {
		add(size(),e);
		return true;
	}
	/**
	 * add an element at the 1-based index
	 * index range is from 0 to list's size
	 * i.e. if the index is 0, the element will be inserted preceding the first element
	 * 		if the index is size, the element will be inserted following the last element
	 */
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		Node n = fastGetNodeByIndex(index);
		Node newNode = new Node(n.next,element);
		n.next = newNode;
		size++;	
	}
	/**
	 * remove the element on the 1-based index 
	 * the index range is from 1 to list's size
	 */
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkListBounds(index);
		Node n = fastGetNodeByIndex(index);
		E element = n.element;
		Node prev = fastGetNodeByIndex(index-1);
		prev.next = n.next;
		n.next = null;
		n.element = null;
		n =null;
		size--;
		return element;
	}

	public boolean remove(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return false;
		if(e ==null){
			int i=1;
			for(Node n = headNode.next; n.next!=null; n = n.next, i++){
				if(n.element == null){
					Node prev = fastGetNodeByIndex(i-1);
					prev.next = n.next;
					n.next = null;
					n.element = null;
					n =null;
					size--;
					return true;
				}
			}
			return false;
		}else{
			int i=1;
			for(Node n = headNode.next; n.next!=null; n = n.next, i++){
				if(e.equals(n.element)){
					Node prev = fastGetNodeByIndex(i-1);
					prev.next = n.next;
					n.next = null;
					n.element = null;
					n =null;
					size--;
					return true;
				}	
			}
			return false;
		}
		
	}

	public void set(int index, E newElement) {
		// TODO Auto-generated method stub
		checkListBounds(index);
		fastGetNodeByIndex(index).element = newElement;
	}
	
	class Node{
		Node next;
		E element;
		Node(Node next, E element){
			this.next = next;
			this.element = element;
		}
	}
	
}
