package com.jieding.algorithms;

import com.jieding.adt.StackADT;
import com.jieding.datastructure.MyDoublyLinkedStack;

/** 
* @ClassName: Stack_ParenthesesMatch 
* @author JieDing dingjwilliams@gmail.com
* 
* @Description: an example to test if symbols sequence is balanced
* every right brace, bracket, and parenthesis must correspond to its left counterpart
* i.e. The sequence [()] is legal , but [(]) is wrong
*/
public class Stack_BalancingSymbols {
	static StackADT<String> stack =null;
	/**
	 * the static method to check if the input symbols sequence is legal
	 */
	public static boolean sequenceLegal(String sequence){
		stack = new MyDoublyLinkedStack<String>();
		checkSequenceValid(sequence);
		return symbolsMatched(sequence);
	}

	private static boolean symbolsMatched(String sequence) {
		
		for(int i=0;i<sequence.length();i++){
			String s = sequence.substring(i,i+1);
			if("([{".contains(s)){
				stack.push(s);
			}else{
				if(stack.isEmpty())
					return false;
				else{
					rightMatchesLeft(s,stack.peek());
				}
			}
		}
		return stack.isEmpty();
	}

	private static void rightMatchesLeft(String s, String peek) {
		if(s.equals(")") && peek.equals("("))
			stack.pop();
		else if(s.equals("]") && peek.equals("["))
			stack.pop();
		else if(s.equals("}") && peek.equals("{"))
			stack.pop();		
	}
	/**
	 * the input sequence can only obtain (, ), [, ], {, or }
	 */
	private static void checkSequenceValid(String sequence) {
		// TODO Auto-generated method stub
		for(int i=0;i<sequence.length();i++){
			String s = sequence.substring(i,i+1);
			if(!"([{)]}".contains(s))
				throw new IllegalArgumentException(
						"illegal sequence, it can only contain (, ), [, ], {, or }");
		}
			
	}
}
