package com.jieding.algorithms;

import com.jieding.adt.StackADT;
import com.jieding.datastructure.MyDoublyLinkedStack;

public class Stack_DecimalToBinary {
	
	public static String decimalToBinary(int decimal){
		if(decimal<0)
			throw new IllegalArgumentException("enter a positive integer please");
		StackADT<Integer> stack = new MyDoublyLinkedStack<Integer>();
		while(decimal!=0){
			stack.push(decimal%2);
			decimal /= 2;
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	} 
}
