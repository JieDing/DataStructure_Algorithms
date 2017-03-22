package com.jieding.datastructure;

import com.jieding.adt.TreeADT;

public class MyDoublyLinkedTree<E> implements TreeADT<E> {
	
	private Node rootNode;
	private int size;
	private int tab;
	public MyDoublyLinkedTree(){
		rootNode = new Node(null,null,null,null);
		tab = 0;
		size = 0;
	}
	public void clear() {
		// TODO Auto-generated method stub
		if (isEmpty()) return;
		clearTraverse(rootNode);
		rootNode.element = null;
		rootNode.firstChild = null;
		rootNode = null;
		size =0;
	}
	private void clearTraverse(Node n){
		while(n!=null){
			Node f = n.firstChild;
			Node x = n.nextSibling;
			
			clearTraverse(f);
			clearTraverse(x);
			
			f.firstChild = null;
			f.nextSibling = null;
			f.element = null;
			f =null;
			x.firstChild = null;
			x.nextSibling = null;
			x.element = null;
			x = null;
		}
	}
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public String preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public String inOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public String postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public String levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(String absPath, E element) {
		// TODO Auto-generated method stub
		if (element ==null)
			throw new IllegalArgumentException("element must be non-null");
		checkNodeName(element);
		checkPath(absPath);
		Node parent = findNodeByPath(absPath);
		if(parent == null){
			if(rootNode.element == null){
				rootNode.element = element;
				size++;
				return true;
			}else{
				Node rootFirstChild = new Node(null,null,rootNode.firstChild,rootNode.element);
				rootNode.element = element;
				rootNode.firstChild = rootFirstChild;
				size++;
				return true;
			}
				
		}else{
			Node newNode = new Node(parent,null,null,element);
			if(parent.firstChild!=null){
				Node n = null;
				for(n =parent.firstChild;n.nextSibling!=null; )
					n = n.nextSibling;
	
				n.nextSibling = newNode;
			}
			size++;
			return true;
		}
		//add the element to the root position
		
		
		//return true;
	}
	private Node findNodeByPath(String path){
		
		Node n = rootNode;
		
		if(path.equals("/"))
			return null;
		while(path.contains("/")){
			
			path = path.substring(path.indexOf("/")+1);
			String nodeName = null;
			if(path.contains("/"))
				nodeName= path.substring(0,path.indexOf("/"));
			else nodeName = path;
			
			n = traverseNodesByLevel(n,nodeName);
			if(path.contains("/"))
				n = n.firstChild;				
		}
		
		return n;
	}
	private Node traverseNodesByLevel(Node n, String nodeName) {
		// TODO Auto-generated method stub
		while(n!=null){
			System.out.println("nodeName "+nodeName);
			System.out.println("n.elemet "+n.element.toString());
			if(n.element.toString().equals(nodeName))
				return n;
			n = n.nextSibling;
		}
		throw new IllegalArgumentException("node "+nodeName +" does not exist!!");
	}
	private void checkPath(String path) {
		if (!path.startsWith("/"))
			throw new IllegalArgumentException("path must start with '/' ");
	}
	private void checkNodeName(E element) {
		if (element.toString().contains("/"))
			throw new IllegalArgumentException("invalid node name, '/' is not allowed");
	}
	public void remove(String absPath, E element) {
		// TODO Auto-generated method stub
		
	}
	public void printAllNodes(){
		printNodes(rootNode);
	}
	private void printNodes(Node n){
		if(n != null){
			for(int i=0;i<tab;i++)
				System.out.print("\t");
			System.out.println(n.element.toString());
			Node child = n.firstChild;
			Node sibling = n.nextSibling;
			tab++;
			printNodes(child);
			printNodes(sibling);
			
			//System.out.println(n.nodeName);
		}
	}
	class Node{
		Node parent;
		Node firstChild;
		Node nextSibling;
		E element;
		public E getElement() {
			return element;
		}
		
		Node(Node parent, Node firstChild, Node nextSibling, E element){
			this.parent = parent;
			this.firstChild = firstChild;
			this.nextSibling = nextSibling;
			this.element = element;
			
		}
	}
}
