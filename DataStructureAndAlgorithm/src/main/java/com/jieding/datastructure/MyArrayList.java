package com.jieding.datastructure;

import com.jieding.adt.ListADT;


public class MyArrayList<E> implements ListADT<E>{
	
	private E[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayList (){
		this(DEFAULT_CAPACITY);
	}
	public MyArrayList(int capacity){
		if(capacity<=0)
			throw new IllegalArgumentException();
		this.size = 0;
		elements = (E[]) new Object[capacity];
	}
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0;i<size();i++)
			elements[i] = null;
		this.size = 0;
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
		if(e == null){
			for(int i=0; i<size(); i++){
				if(elements[i] == null)
					return true;
			}
			return false;
		}
		else{
			for(int i=0; i<size(); i++){
				if(e.equals(elements[i]))
					return true;
			}
			return false;
		}
	}
	
	public E get(int index) {
		checkListBounds(index);
		return elements[index];
	}

	private void checkListBounds(int index) {
		// TODO Auto-generated method stub
		if(index<0 || index>=size())
			throw new IndexOutOfBoundsException();
	}
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		if(e == null){
			for(int i=0; i<size(); i++){
				if(elements[i] == null)
					return i;
			}
			return -1;
		}
		else{
			for(int i=0; i<size(); i++){
				if(e.equals(elements[i]))
					return i;
			}
			return -1;
		}
	}

	public boolean add(E e) {
		// TODO Auto-generated method stub
		ensureCapacity();
		elements[size++] = e; 
		return true;
	}

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if(size()>=elements.length){
			E[] newElements = (E[]) new Object[2*elements.length+1];
			System.arraycopy(elements, 0, newElements, 0, size());
			elements = newElements;
		}
	}
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(index<0 || index>size())
			throw new IndexOutOfBoundsException();
		ensureCapacity();
		System.arraycopy(elements, index, elements, index+1, size-index);
		elements[index] = element;
		size++;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		checkListBounds(index);
		E removed = elements[index];
		fastRemove(index);
		return removed;
	}

	private void fastRemove(int index) {
		// TODO Auto-generated method stub
		int movedNum = size()-index-1;
		if(movedNum>0){
			System.arraycopy(elements, index+1, elements, index, movedNum);
		}
		elements[--size] = null;
			
	}
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		if(e == null){
			for(int i=0; i<size(); i++){
				if(elements[i] == null){
					fastRemove(i);
					return true;
				}
					
			}
			return false;
		}
		else{
			for(int i=0; i<size(); i++){
				if(e.equals(elements[i])){
					fastRemove(i);
					return true;
				}
			}
			return false;
		}
	}

	public void set(int index, E newValue) {
		// TODO Auto-generated method stub
		checkListBounds(index);
		elements[index] = newValue;
	}

	
}
 