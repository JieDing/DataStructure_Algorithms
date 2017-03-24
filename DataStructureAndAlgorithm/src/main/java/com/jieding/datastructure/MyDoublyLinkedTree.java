package com.jieding.datastructure;

import com.jieding.adt.TreeADT;

public class MyDoublyLinkedTree<E> implements TreeADT<E> {
	
	private Node rootNode;
	private int size;
	
	public MyDoublyLinkedTree(){
		rootNode = new Node(null,null,null,null);
		
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
		absPath = checkPath(absPath);
		Node parent = findNodeByPath(absPath);
		
		if(parent == null){
			if(rootNode.element == null){
				rootNode.element = element;
				size++;
				return true;
			}else{
				Node rootFirstChild = new Node(null,null,rootNode.firstChild,rootNode.element);
				rootFirstChild.parent = rootNode;
				rootNode.element = element;
				rootNode.firstChild = rootFirstChild;
				size++;
				return true;
			}
				
		}else{
			Node newNode = new Node(parent,null,null,element);
			if(parent.firstChild!=null){
				Node n = null;
				for(n =parent.firstChild;n.nextSibling!=null; ){
					
					n = n.nextSibling;
					if(n.element.toString().equals(element.toString()))
						throw new IllegalArgumentException("node "+ element +" already exists");
				}
				n.nextSibling = newNode;
			}
			else
				parent.firstChild = newNode;
			
			size++;
			return true;
		}
		
	}
	private Node findNodeByPath(String path){
		
		Node n = rootNode;
		
		if(path.equals("/"))
			return null;
		while(path.contains("/")){
			
			path = path.substring(path.indexOf("/")+1);
			String nodeName = null;
			if(path.contains("/")){
				nodeName= path.substring(0,path.indexOf("/"));
				path = path.substring(path.indexOf("/"));
			}
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
			
			if(n.element.toString().equals(nodeName))
				return n;
			n = n.nextSibling;
		}
		throw new IllegalArgumentException("node "+nodeName +" does not exist!!");
	}
	private String checkPath(String path) {
		if(path.equals("/"))
			return path;
		if (!path.startsWith("/"))
			throw new IllegalArgumentException("path must start with '/' ");
		if(path.endsWith("/"))
			path = path.substring(0,path.length()-1);
		return path;
	}
	private void checkNodeName(E element) {
		if (element.toString().contains("/"))
			throw new IllegalArgumentException("invalid node name, '/' is not allowed");
		
	}
	public E remove(String absPath) {
		// TODO Auto-generated method stub
		if(absPath.equals("/"))
			throw new IllegalArgumentException("'/' is not legal here");
		absPath = checkPath(absPath);
		Node n = findNodeByPath(absPath);
		
		if(n.firstChild== null){
			if(n.parent== null){
				E e = n.element;
				n.element =null;
				n = null;
				size--;
				return e;
			}else{
				E e = n.element;
				Node parent = n.parent;
				parent.firstChild = n.nextSibling;
				n.parent = null;
				n.nextSibling = null;
				n.element = null;
				n = null;
				size--;
				return e;
			}
			
		}else{
			
				E e = n.element;
				Node child = n.firstChild;
				n.element = child.element;
				n.firstChild = child.nextSibling;
				child.element = null;
				child.parent = null;
				child.nextSibling = null;
				child = null;
				size--;
				return e;
			
		}
		
	}
	public void printAllNodes(){
		printNodes(rootNode);
	}
	private int getHeightOfNode(Node n){
		int i=0;
		Node parent = n.parent;
		for(;parent!=null;){
			parent = parent.parent;
			i++;
		}
		return i;
	}
	private void printNodes(Node n){
		if(n != null){
			int height = getHeightOfNode(n);
			for(int i=0;i<height;i++)
				System.out.print("\t");
			System.out.println(n.element.toString());
			Node child = n.firstChild;
			Node sibling = n.nextSibling;
			
			printNodes(child);
			printNodes(sibling);
			
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
