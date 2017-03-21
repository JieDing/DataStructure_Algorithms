package com.jieding.algorithms;

import com.jieding.adt.StackADT;
import com.jieding.datastructure.MyArrayStack;

/**
 * @ClassName: Recursion_Hanoi.java 
 * @author JieDing dingjwilliams@gmail.com
 *
 * @Description: simulate a Hanoi game  
*/
public class Recursion_Hanoi {
	
	public StackADT<Integer> A;
	public StackADT<Integer> B;
	public StackADT<Integer> C;
	private static final int DEFAULT_CAPACITY = 3;
	public int currentCapacity = 0;
	
	/**
	 * default num of disk is 3
	 */
	public Recursion_Hanoi(){
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * set the disk numbers by entering Integer argument
	 */
	public Recursion_Hanoi(int capacity){
		if(capacity<1)
			throw new IllegalArgumentException("please enter an Integer greater than 0");
		A = new MyArrayStack<Integer>(capacity);
		B = new MyArrayStack<Integer>(capacity);
		C = new MyArrayStack<Integer>(capacity);
		this.currentCapacity = capacity;
		init(A,capacity);
	}
	public void recursionSolution(int num, StackADT<Integer> start,StackADT<Integer> spare,StackADT<Integer> des){
		if(num ==1)
			move(start,1,des);
		else{
			recursionSolution(num-1, start, des ,spare);
			move(start,num,des);
			recursionSolution(num-1, spare, start, des);
		}
	}
	private String attachStrToStack(StackADT<Integer> target, String s){
		
		if(target == A)
			s = "A";
		else if(target == B)
			s = "B";
		else if(target == C)
			s = "C";	
		return s;
	}
	private void move(StackADT<Integer> start, int i, StackADT<Integer> des) {
		// TODO Auto-generated method stub
		String strS = null;
		String strD = null;

		strS = attachStrToStack(start,strS);
		strD = attachStrToStack(des,strD);
		
	
		System.out.println("move "+ i +" from "+ strS+ " to "+ strD);
		des.push(start.pop());

	}
	public void printAllElements(){
		System.out.println("------------------------------");
		if(A.isEmpty()){
			System.out.println("A got no elements to present");
		}
		else{
			System.out.println("A got elements: ");
			for(int i=0; i<currentCapacity; i++)
				System.out.println(A.pop());
			System.out.println();
		}
		if(B.isEmpty()){
			System.out.println("B got no elements to present");
		}
		else{
			System.out.println("B got elements: ");
			for(int i=0; i<currentCapacity; i++)
				System.out.println(B.pop());
			System.out.println();
		}
		if(C.isEmpty()){
			System.out.println("C got no elements to present");
		}
		else{
			System.out.println("C got elements: ");
			for(int i=0; i<currentCapacity; i++)
				System.out.println(C.pop());
			System.out.println();
		}
	}
	private void init(StackADT<Integer> stack, int capacity){
		for(int i = capacity; i>=1; i--){
			stack.push(i);
		}
	}
}
