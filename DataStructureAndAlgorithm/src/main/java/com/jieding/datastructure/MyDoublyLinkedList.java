package com.jieding.datastructure;

import com.jieding.adt.ListADT;

public class MyDoublyLinkedList<E> implements ListADT<E> {
	
	private Node headNode;
	private Node tailNode;
	private int size;
	
	public MyDoublyLinkedList(){
		this.headNode = new Node(null,null,null);
		this.tailNode = new Node(headNode,null,null);
		headNode.next = tailNode;
		size = 0;
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		for(Node n=headNode; n.next!=null;){
			Node next = n.next;
			n.prev = null;
			n.next = null;
			n.value = null;
			n = next;
		}
		headNode = null;
		tailNode.prev = null;
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
		if(e ==null){
			for(Node n = headNode.next; n.next != null; n = n.next){
				if(n.value == null)
					return true;
			}
			return false;
		}else{
			for(Node n = headNode.next; n.next != null; n = n.next){
				if(e.equals(n.value))
					return true;
			}
			return false;
		}
	}
	/**
	 * obtain the element at the 1-based index.
	 * the index range is from 1 to size()
	 */
	public E get(int index) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		checkIndexBounds(index);
		return fastGetNodeByIndex(index).value;
	}
	
	private Node fastGetNodeByIndex(int index) {
		// TODO Auto-generated method stub
		Node n = null;
		int i =0;
		if(index<size()/2){
			for(i=0, n=headNode;i<index;i++){
				n = n.next;
			}
		}
		else{
			for(i=size()+1, n=tailNode;i>index;i--){
				n = n.prev;
			}
		}
		
		return n;
	}

	private void checkIndexBounds(int index) {
		// TODO Auto-generated method stub
		if(index<1 || index>size())
			throw new IndexOutOfBoundsException();
	}
	/**
	 * return the 1-based index of element e
	 * return -1 if the element is not existed
	 */
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return -1;
		if(e ==null){
			int i=1;
			for(Node n = headNode.next; n.next != null; n = n.next, i++){
				if(n.value == null)
					return i;
			}
			return -1;
		}else{
			int i=1;
			for(Node n = headNode.next; n.next != null; n = n.next, i++){
				if(e.equals(n.value))
					return i;
			}
			return -1;
		}
	}

	public boolean add(E e) {
		// TODO Auto-generated method stub
		add(size(),e);
		return true;
	}
	/**
	 * add the element at the 1-based index.
	 * i.e. if index=0, the element will be inserted preceding the first element.
	 * 		if index=size, the element will be inserted following the last element.
	 * the index range is from 0 to size()
	 */
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(index<0 || index>size())
			throw new IndexOutOfBoundsException();
		Node n = fastGetNodeByIndex(index);
		
		Node newNode = new Node(n,n.next,element);
		
		n.next.prev = newNode;
		n.next = newNode;
		
		size++;
		
	}

	public E remove(int index) {
		if(isEmpty()) return null;
		checkIndexBounds(index);
		Node n = fastGetNodeByIndex(index);
		E value = n.value;
		n.prev.next = n.next;
		n.next.prev = n.prev;
		n.prev = null;
		n.next = null;
		n.value = null;
		n = null;
		size--;
		return value;
	}

	public boolean remove(E e) {
		if(isEmpty()) return false;
		if(e == null){
			for(Node n=headNode.next; n.next!=null; n=n.next){
				if(n.value == null){
					n.prev.next = n.next;
					n.next.prev = n.prev;
					n.prev = null;
					n.next = null;
					n.value = null;
					n = null;
					size--;
					return true;
				}
			}
			return false;
		}else{
			for(Node n=headNode.next; n.next!=null; n=n.next){
				if(e.equals(n.value)){
					n.prev.next = n.next;
					n.next.prev = n.prev;
					n.prev = null;
					n.next = null;
					n.value = null;
					n = null;
					size--;
					return true;
				}
			}
			return false;
		}
	}

	public void set(int index, E newValue) {
		checkIndexBounds(index);
		fastGetNodeByIndex(index).value = newValue;
		
	}
	
	class Node{
		Node prev;
		Node next;
		E value;
		
		Node (Node prev, Node next, E value){
			this.prev = prev;
			this.next = next;
			this.value = value;
		}
	} 

}
