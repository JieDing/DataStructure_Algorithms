package com.jieding.test;

import junit.framework.TestCase;

import com.jieding.adt.TreeADT;
import com.jieding.datastructure.MyDoublyLinkedTree;

public class MyLinkedTreeTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testClear() {
		String path = "/abc/cde/fff";
		path = path.substring(path.indexOf("/")+1);
		path = path.substring(path.indexOf("/")+1);
		System.out.println("\t"+path);
		//String nodeName = path.substring(0,path.indexOf("/"));
		//System.out.println(nodeName);
	}

	public void testSize() {
		fail("Not yet implemented");
	}

	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	public void testHeight() {
		fail("Not yet implemented");
	}

	public void testContains() {
		fail("Not yet implemented");
	}

	public void testPreOrder() {
		fail("Not yet implemented");
	}

	public void testInOrder() {
		fail("Not yet implemented");
	}

	public void testPostOrder() {
		fail("Not yet implemented");
	}

	public void testLevelOrder() {
		fail("Not yet implemented");
	}

	public void testInsert() {
		MyDoublyLinkedTree<String> tree = new MyDoublyLinkedTree<String>();
		tree.insert("/", "root");
		//tree.
	}

	public void testRemove() {
		fail("Not yet implemented");
	}

}
