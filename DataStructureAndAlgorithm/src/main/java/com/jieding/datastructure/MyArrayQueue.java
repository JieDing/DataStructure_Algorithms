package com.jieding.datastructure;

import com.jieding.adt.QueueADT;

public class MyArrayQueue<E> implements QueueADT<E> {
	
	private E[] elements;
	private final static int DEFAULT_CAPACITY = 10;
	//front points to the first element of the queue
	private int front;
	//rear points to the next valid bucket of the queue
	private int rear;
	
	public MyArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public MyArrayQueue(int capacity){
		if (capacity<1)
			throw new IllegalArgumentException("please enter a postive integer greater than 0");
		elements = (E[]) new Object[capacity];
		this.front = 0;
		this.rear = 0;
	}
	
	
	public void clear() {
		// TODO Auto-generated method stub
		int j =0;
		int i =0;
		for(i=front, j=1; i<elements.length;i++,j++)
			elements[i] = null;
		for(int n=0; n<size()-j; n++)
			elements[n] = null;
		front = rear = 0;
	}

	public int size() {
		// TODO Auto-generated method stub
		int size = (rear-front+elements.length)%elements.length;
		if(size==0 && elements[front]!=null) 
			size = elements.length;
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return false;
		
		
		int j =0;
		int i =0;
		for(i=front, j=1; i<elements.length;i++,j++){
			if(e.equals(elements[i]))
				return true;
		}
		for(int n=0; n<size()-j; n++){
			if(e.equals(elements[n]))
				return true;
		}
		return false;
		
	}

	public E peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		return elements[front];
	}
	/**
	 * return the 1-based index of the specific element
	 * return 0 if the list is empty
	 * return -1 if the specific element is not existed in the list
	 */
	public int search(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) return 0;

		
		int j =0;
		int i =0;
		for(i=front, j=1; i<elements.length;i++,j++){
			if(e.equals(elements[i]))
				return j;
		}
		int x = j+1;
		for(int n=0; n<size()-j; n++, x++){
			if(e.equals(elements[n]))
				return x;
		}
		return -1;
		
	}

	public boolean enqueue(E e) {
		// TODO Auto-generated method stub
		if(e == null) 
			throw new IllegalArgumentException("null is not allowed to insert");
		ensureCapacity();
		
		elements[rear++] = e;
		if(rear==elements.length)
			rear=0;
		//System.out.println(rear);
		return true;
	}

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if(size()>=elements.length){
			
			E[] newElements = (E[]) new Object[2*elements.length+1];
			int numMoved = elements.length-front;
			System.arraycopy(elements, front, newElements, 0, numMoved);
			System.arraycopy(elements, 0, newElements, numMoved, size()-numMoved);
			rear = elements.length;
			front = 0;
			elements = newElements;
		}
	}

	public E dequeue() {
		// TODO Auto-generated method stub
		E value = elements[front];
		if(front == elements.length)
			front = 0;
		elements[front++] = null;
		return value;
	}

}
