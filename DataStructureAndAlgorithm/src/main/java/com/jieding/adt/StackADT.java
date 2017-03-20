package com.jieding.adt;

/** 
* @ClassName: StackADT 
* @author JieDing dingjwilliams@gmail.com
* 
* @Description: Abstract Data Type
* 
* ADT Stack{
* 	A special List where insertion and deletion only happen at the top of the list.
* 
*  	Operation:
*  
*  	<%- general operation to the stack%>
* 	void clear()	Removes all of the elements from this list
*   int size() Returns the number of elements in this list
*   boolean isEmpty() Returns true if this list contains no elements.
*   
*   <%- obtain element or index%>
*   boolean contains(E e)  Returns true if this list contains the specified element
*   E peek() Looks at the object at the top of this stack without removing it from the stack.
*   int search(E e) Returns the 1-based position where an object is on this stack.
*   
*   <%- add/remove element operation%>
*   E pop()	Removes the object at the top of this stack and returns that object as the value of this function.
*   E push(E item) Pushes an item onto the top of this stack.
* }
*/
public interface StackADT<E> {
	
	/**
	 * Removes all of the elements from this list
	 */
	void clear();
	
	/**
	 * Returns the number of elements in this list
	 */
	int size();
	
	/**
	 * Returns true if this list contains no elements.
	 */
	boolean isEmpty();
	
	/**
	 * Returns true if this list contains the specified element
	 */
	boolean contains(E e);
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack
	 */
	E peek();
	
	/**
	 * Returns the 1-based position where an object is on this stack.
	 */
	int search(E e);
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 */
	E pop();
	
	/**
	 * Pushes an item onto the top of this stack.
	 */
	E push(E item);
}
