package com.jieding.adt;
	
/** 
* @ClassName: ListADT 
* @author JieDing dingjwilliams@gmail.com
* 
* @Description: Abstract Data Type 
*  
* ADT List{
* 	Data:
* 	The ADT List is a general list of the form A0, A1, A2, . . ., AN−1.
*   we say that Ai follows (or succeeds) Ai−1 (i < N)and that Ai−1 precedes Ai (i > 0). 
*   The first element of the list is A0, and the last element is AN−1.	
*   
*   Operation:
*   
*   <%- general operation to the list%>
* 	void clear()	Removes all of the elements from this list
*   int size() Returns the number of elements in this list
* 	boolean contains(E e)  Returns true if this list contains the specified element
*   boolean isEmpty() Returns true if this list contains no elements.
*   
*   <%- obtain element or index%>
*   E get(int index) Returns the element at the specified position in this list
*   int indexOf(E e) Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
* 	
* 	<%- add/remove/set element operation%>
* 	boolean add(E e)   Appends the specified element to the end of this list
* 	void add(int index, E element) Inserts the specified element at the specified position in this list
* 	E remove(int index) Removes the element at the specified position in this list
* 	boolean remove(E e) Removes the first occurrence of the specified element from this list, if it is present
* 	void set(int index, E newValue) Replaces the element at the specified position in this list with the specified element
* 	
* }
*/
public interface ListADT<E>{
	
	/** 
	* Removes all of the elements from this list
	*/
	void clear();
	
	/** 
	* Returns the number of elements in this list
	*/
	int size();
	
	/** 
	* Returns true if this list contains the specified element
	*/
	boolean contains(E e);
	
	/** 
	* Returns true if this list contains no elements.
	*/
	boolean isEmpty();
	
	/** 
	* Returns the element at the specified position in this list
	*/
	E get(int index);
	
	/** 
	* Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	*/
	int indexOf(E e);
	
	/** 
	* Appends the specified element to the end of this list
	*/
	boolean add(E e);
	
	/** 
	* Inserts the specified element at the specified position in this list
	*/
	void add(int index, E element);
	
	/** 
	* Removes the element at the specified position in this list
	*/
	E remove(int index);
	
	/** 
	* Removes the first occurrence of the specified element from this list, if it is present
	*/
	boolean remove(E e);
	
	/**
	 * Replaces the element at the specified position in this list with the specified element
	 */
	void set(int index, E newValue);
}
