package com.jieding.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.jieding.datastructure.MyDoublyLinkedStack;

public class MyDoublyLinkedStackTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testMyDoublyLinkedStack() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		Assert.assertEquals(0, as.size());
	}


	public void testClear() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		as.push("abc");
		as.push("bcd");
		as.push("cde");
		as.clear();
		Assert.assertEquals(0, as.size());
		Assert.assertEquals(true, as.isEmpty());
	}

	public void testSize() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		as.push("abc");
		as.push("bcd");
		as.push("cde");
		//as.clear();
		Assert.assertEquals(3, as.size());
	}

	public void testIsEmpty() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		Assert.assertEquals(true, as.isEmpty());
	}

	public void testContains() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(true, as.contains("abc"));
		Assert.assertEquals(true, as.contains(null));
		Assert.assertEquals(false, as.contains("cde"));
	}

	public void testPeek() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(null, as.peek());
		Assert.assertEquals(true, as.contains(null));
		Assert.assertEquals(false, as.contains("cde"));
	}

	public void testSearch() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(3, as.search(null));
		Assert.assertEquals(2, as.search("bcd"));
		Assert.assertEquals(1, as.search("abc"));
		Assert.assertEquals(-1, as.search("aabc"));
	}

	public void testPop() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(null, as.pop());
		Assert.assertEquals(false, as.contains(null));
		Assert.assertEquals(2, as.size());
		Assert.assertEquals(true, as.contains("bcd"));
		Assert.assertEquals("bcd", as.pop());
		Assert.assertEquals(false, as.contains("bcd"));
		Assert.assertEquals(1, as.size());
	}

	public void testPush() {
		MyDoublyLinkedStack<String> as = new MyDoublyLinkedStack<String>();
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(null, as.peek());
		Assert.assertEquals(true, as.contains(null));
		Assert.assertEquals(3, as.size());
		Assert.assertEquals(null, as.pop());
		Assert.assertEquals("bcd", as.pop());
		Assert.assertEquals(false, as.contains("bcd"));
		Assert.assertEquals(1, as.size());
	}

}
