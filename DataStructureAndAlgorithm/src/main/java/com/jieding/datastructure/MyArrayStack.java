package com.jieding.datastructure;

import com.jieding.adt.StackADT;

public class MyArrayStack<E> implements StackADT<E> {
	
	private E[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayStack(){
		this(DEFAULT_CAPACITY);
	}
	public MyArrayStack(int capacity){
		if(capacity<=0)
			throw new IllegalArgumentException();
		this.size = 0;
		elements = (E[]) new Object[capacity];
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0; i<size(); i++)
			elements[i] = null;
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
			for(int i=0; i<size(); i++){
				if(elements[i] == null)
					return true;
			}
			return false;
		}else{
			for(int i=0; i<size(); i++){
				if(e.equals(elements[i]))
					return true;
			}
			return false;
		}
	}
	
	public E peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		return elements[size()-1];
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
			for(int i=0;i<size();i++){
				if(elements[i] == null)
					return i+1;
			}
			return -1;
		}else{
			for(int i=0;i<size();i++){
				if(e.equals(elements[i]))
					return i+1;
			}
			return -1;
		}
	}

	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		E top  = elements[size()-1];
		elements[--size] = null;
		return top;
	}

	public E push(E item) {
		// TODO Auto-generated method stub
		ensureCapacity();
		elements[size++] = item;
		return item;
	}
	private void ensureCapacity() {
		if(size()>=elements.length){
			E[] newElements = (E[]) new Object[2*size+1];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}

}
