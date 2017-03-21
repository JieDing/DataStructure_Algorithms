package com.jieding.adt;
	
/**
 * @ClassName: QueueADT 
 * @author JieDing dingjwilliams@gmail.com
 *
 * @Description: Abstract Data Type
 * 
 * ADT Queue{
 * 
 *  A special list where insertion happens at the end of the list (called the rear), and 
 *  deletion happens at the start of the list (known as the front).
 *  
 *  Operation:
 *  
 *  <%- general operation to the queue%>
 *  void clear()	Removes all of the elements from this list
*   int size() Returns the number of elements in this list
*   boolean isEmpty() Returns true if this list contains no elements.
*   
*   <%- obtain element or index%>
*   boolean contains(E e)  Returns true if this list contains the specified element
*   E peek() retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
*   int search(E e) Returns the 1-based position where an object is on this stack.
*   
*   <%- add/remove element operation%>
*   boolean enqueue(E e) insert an item  into this queue.
*   E dequeue() retrieves and removes the head of this queue.
 * }
*/
public interface QueueADT<E> {

	
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
	 *insert an item  into this queue.
	 */
	boolean enqueue(E e);
	
	/**
	 * E dequeue() retrieves and removes the head of this queue.
	 */
	 E dequeue();

}
