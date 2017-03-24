package com.jieding.adt;

/**
 * @ClassName: TreeADT
 * @author JieDing dingjwilliams@gmail.com
 *
 * @Description: A tree is a collection of nodes. 
 * The collection can be empty; otherwise, a tree consists of a distinguished node r, called the root
 * and zero or more nonempty (sub)trees T1, T2, . . . , Tk,
 * each of whose roots are connected by a directed edge from r.
 * 
 * Operation:
 * 
 *  <%- general operation to the stack%>
 *  void clear() Removes all of the elements from the tree
 *  int size() Returns the number of elements of the tree
 *  boolean isEmpty() Returns true if the tree is empty
 *  
 *  <%- obtain element or orders%>
 *  String preOrder() Return the tree elements in the pre-order
 *  String inOrder() Return the tree elements in the in-order
 *  String postOrder() Return the tree elements in the post-order
 *  String levelOrder() Return the tree elements in the level-order
 *  
 *  <%- insertion and deletion operation%>
 *  boolean insert(String absPath, E value) insert a specific element under the absolute path
 *  void remove(E e) remove the specific element from the tree
*/
public interface TreeADT<E> {
	
	/**
	 * Removes all of the elements from the tree
	 */
	void clear();
	
	/**
	 * Returns true if the tree is empty
	 * 
	 */
	boolean isEmpty();

	/**
	 * Return the tree elements in the pre-order
	 * @return
	 */
	String preOrder();
	
	/**
	 * Return the tree elements in the in-order
	 * @return
	 */
	String inOrder();
	
	/**
	 * Return the tree elements in the post-order
	 * @return
	 */
	String postOrder();
	
	/**
	 * Return the tree elements in the level-order
	 * @return
	 */
	String levelOrder();
	
	/**
	 * insert an element under the absolute path 
	 * @param absPath must start with "/". It consists of the path splitter "/" and the node name.
	 *        The node name is a String which value is object.toString().
	 *        Thus, if we insert a user-built object to the tree, i.e. insert("/", new Employee()),
	 *        the node name would be new Employee().toString().
	 *        if the path is "/", we insert the specific element as the root node.
	 *        		when the root node does not exist, we directly store the element into the root node.
	 *        		when the root node already exists, we store the element into the root node and degrade
	 *        		the previous root node element as the first child of the new root node.
	 * @param element must be non-null. And element.toString() cannot contain path splitter (/).
	 * @return
	 */
	 
	boolean insert(String absPath, E element);
	
	/**
	 * remvoe a specific element from the tree.
	 * 		if the node is a leaf node, directly removes it.
	 * 		otherwise, the first child of the node will take its position.
	 * return null if the element is not existed
	 * @param e
	 */
	E remove(String absPath);
}
