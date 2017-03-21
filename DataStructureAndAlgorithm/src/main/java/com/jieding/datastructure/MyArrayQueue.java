package com.jieding.datastructure;

import com.jieding.adt.QueueADT;

public class MyArrayQueue<E> implements QueueADT<E> {
	
	private E[] elements;
	private int size;
	private final static int DEFAULT_CAPACITY = 10;
	
	public MyArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public MyArrayQueue(int capacity){
		if (capacity<1)
			throw new IllegalArgumentException("please enter a postive integer greater than 0");
		this.size = 0;
		elements = (E[]) new Object[capacity];
	}
	
	
	public void clear() {
		// TODO Auto-generated method stub
		
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
		return false;
	}

	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	public int search(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean enqueue(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

}
